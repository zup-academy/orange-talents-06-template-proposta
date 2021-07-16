package br.com.zup.proposta.proposta.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.zup.proposta.proposta.dto.PropostaDTO;
import br.com.zup.proposta.proposta.interfaces.SolicitacaoClient;
import br.com.zup.proposta.proposta.model.DadosAnalise;
import br.com.zup.proposta.proposta.model.DadosSolicitacao;
import br.com.zup.proposta.proposta.model.Proposta;
import br.com.zup.proposta.proposta.model.enums.StatusProposta;
import br.com.zup.proposta.proposta.repository.PropostaRepository;
import feign.FeignException;

@RestController
@RequestMapping(value = "/proposta")
public class PropostaController {

	private final Logger logger = LoggerFactory.getLogger(Proposta.class);

	private final PropostaRepository propostaRepository;
	
	private final SolicitacaoClient solicitacaoClient;
	
	public PropostaController(PropostaRepository propostaRepository, SolicitacaoClient solicitacaoClient) {
		super();
		this.propostaRepository = propostaRepository;
		this.solicitacaoClient = solicitacaoClient;
	}

	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody @Valid PropostaDTO dto, UriComponentsBuilder builder) {
		Proposta proposta = dto.toModel();

		if (verificarDocumento(dto.getDocumento())) {
			logger.error("Erro ao inserir proposta com o CPF/CNPJ={}", dto.getDocumento());
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
		}

		propostaRepository.save(proposta);
		
		try {
			DadosSolicitacao dadosSolicitacao = new DadosSolicitacao(proposta.getDocumento(), proposta.getNome(), proposta.getId());
			DadosAnalise dadosAnalise = solicitacaoClient.dadosAnalise(dadosSolicitacao);
			proposta.atualizarStatusProposta(StatusProposta.ELEGIVEL);			
		} catch (FeignException fe) {
			proposta.atualizarStatusProposta(StatusProposta.NAO_ELEGIVEL);
		}
		
		logger.info("Cadastrada com sucesso a proposta com o CPF/CNPJ={}", proposta.getDocumento());
		URI uri = builder.path("/proposta/{id}").build(proposta.getId());
		return ResponseEntity.created(uri).build();
	}

	private boolean verificarDocumento(String documento) {
		return propostaRepository.findByDocumento(documento).isPresent();
	}
}
