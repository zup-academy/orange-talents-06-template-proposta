package com.zup.proposta.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.proposta.controller.validation.CadastraBiometriaCartao;
import com.zup.proposta.modelo.Biometria;
import com.zup.proposta.modelo.Cartao;
import com.zup.proposta.repository.BiometriaRepository;
import com.zup.proposta.repository.CartaoRespository;
import com.zup.proposta.request.BiometriaRequest;

@RestController
@RequestMapping("/biometrias")
public class BiometriaController {

	@Autowired
	private BiometriaRepository biometriaRepository;

	@Autowired
	private CartaoRespository cartaoRespository;
	
	@Autowired
	private CadastraBiometriaCartao cadastraBiometriaCartao;

	@GetMapping
	public List<Biometria> listarTodos() {
		return biometriaRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Biometria> cadastrar(@Valid @RequestBody BiometriaRequest request) {
		Cartao cartao;
		try {
			cartao = recuperaCartao(request.getId_cartao());
			if (!request.getBiometria().isBlank()) {
				Biometria biometria = cadastraBiometriaCartao.cadastraBiometria(request, cartao);
				return ResponseEntity.ok(biometria);
				
			}
			

		} catch (Exception NoSuchElementException) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.badRequest().build();
	}

	private Cartao recuperaCartao(String id) {
		Optional<Cartao> cartaoRecuperado = cartaoRespository.findCartaoById(id);
		Cartao cartao = cartaoRecuperado.get();
		return cartao;

	}
	
	

}
