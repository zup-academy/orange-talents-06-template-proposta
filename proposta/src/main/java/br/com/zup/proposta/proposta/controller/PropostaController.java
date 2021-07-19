package br.com.zup.proposta.proposta.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.proposta.proposta.dto.CartaoDTO;
import br.com.zup.proposta.proposta.dto.PropostaDTO;
import br.com.zup.proposta.proposta.interfaces.CartaoClient;
import br.com.zup.proposta.proposta.model.Proposta;
import br.com.zup.proposta.proposta.model.enums.StatusProposta;
import br.com.zup.proposta.proposta.repository.PropostaRepository;

@RestController
@RequestMapping(value = "/proposta")
public class PropostaController {

	private final Logger logger = LoggerFactory.getLogger(Proposta.class);

	private final PropostaRepository propostaRepository;
	
	private final CartaoClient cartaoClient;
	
	public PropostaController(PropostaRepository propostaRepository, CartaoClient cartaoClient) {
		super();
		this.propostaRepository = propostaRepository;
		this.cartaoClient = cartaoClient;
	}

	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody @Valid PropostaDTO dto, UriComponentsBuilder builder) {

		if (verificarDocumento(dto.getDocumento())) {
			logger.error("Erro ao inserir proposta com o CPF/CNPJ={}", dto.getDocumento());
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
		}

		Proposta proposta = dto.toModel();
		propostaRepository.save(proposta);
		logger.info("Cadastrada com sucesso a proposta com o CPF/CNPJ={}", proposta.getDocumento());
		
		return ResponseEntity.created(builder.path("proposta/{id}").buildAndExpand(proposta.getId()).toUri()).build();
	}
	
	@Scheduled(fixedDelayString = "5000")
	@Transactional
	public void inserirCartao() {
		List<Proposta> propostas = propostaRepository.findByStatus(StatusProposta.ELEGIVEL);
		
		while(propostas.size()>0){
			Proposta proposta = propostas.get(0);
			CartaoDTO cartaoDto = cartaoClient.cartaoDto(proposta.toCartaoRequestDTO());
			proposta.toCartaoDTO(cartaoDto.toModel(proposta));
			
			propostaRepository.save(proposta);
			propostas.remove(0);
		}
		
		logger.info("Fim de tudo");
	}
	
	private boolean verificarDocumento(String documento) {
		return propostaRepository.findByDocumento(documento).isPresent();
	}
}
