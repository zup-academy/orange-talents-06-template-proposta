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

import br.com.zup.proposta.proposta.dto.PropostaDTO;
import br.com.zup.proposta.proposta.model.Proposta;
import br.com.zup.proposta.proposta.repository.PropostaRepository;

@RestController
@RequestMapping(value = "/proposta")
public class PropostaController {

	private final PropostaRepository propostaRepository;

	public PropostaController(PropostaRepository propostaRepository) {
		super();
		this.propostaRepository = propostaRepository;
	}
	
	@PostMapping
	public ResponseEntity<Proposta> inserir(@RequestBody @Valid PropostaDTO dto, UriComponentsBuilder builder){
		Proposta proposta = dto.toModel();
		
		if(verificarDocumento(dto.getDocumento())) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
		}
		
		propostaRepository.save(proposta);
		
		URI uri = builder.path("/proposta/{id}").build(proposta.getId());
		return ResponseEntity.created(uri).build();
	}
	
	private boolean verificarDocumento(String documento) {
		return propostaRepository.findByDocumento(documento).isPresent();
	}
}
