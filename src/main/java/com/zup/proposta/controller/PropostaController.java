package com.zup.proposta.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zup.proposta.controller.validation.CriaProposta;
import com.zup.proposta.modelo.Proposta;
import com.zup.proposta.repository.PropostaRepository;
import com.zup.proposta.request.PropostaRequest;
import com.zup.proposta.response.PropostaResponse;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

	@Autowired
	private PropostaRepository propostaRepository;

	@Autowired
	private CriaProposta criaProposta;

	@GetMapping
	public List<Proposta> listar() {
		return propostaRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<PropostaResponse> novaProposta(@Valid @RequestBody PropostaRequest request,
			HttpServletResponse response) {

		Proposta proposta = criaProposta.constroiProposta(request);

		PropostaResponse PropostaResponse = proposta.toConverteResponse();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(proposta.getId())
				.toUri();
		return ResponseEntity.created(uri).body(PropostaResponse);

	}

	@GetMapping("/{id}")
	public ResponseEntity<PropostaResponse> buscarPeloCodigo(@PathVariable Long id) {
		Optional<Proposta> propostaRecuperado = propostaRepository.findById(id);
		if (propostaRecuperado.isPresent()) {
			Proposta proposta = propostaRecuperado.get();
			PropostaResponse PropostaResponse = proposta.toConverteResponse();
			return ResponseEntity.ok(PropostaResponse);
		}
		return ResponseEntity.notFound().build();
	}

}
