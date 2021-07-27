package com.zup.proposta.controller;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zup.proposta.controller.validation.AtualizaBloqueio;
import com.zup.proposta.controller.validation.AtualizaProposta;
import com.zup.proposta.controller.validation.RecuperaPropostaBiometria;
import com.zup.proposta.feignCliente.response.CartaoBloqueio;
import com.zup.proposta.modelo.Proposta;

@RestController
@RequestMapping("/cartoes")
public class CartaoAcessoController {

	@Autowired
	private RecuperaPropostaBiometria recuperaPropostaBiometria;

	@Autowired
	private AtualizaBloqueio atualizaBloqueio;
	
	

	@PostMapping("/{idCartao}")
	public ResponseEntity<?> cadastrar(@PathVariable String idCartao, @RequestBody @Valid CartaoBloqueio bloqueio,
			HttpServletResponse response) {
		try {
			Proposta proposta = recuperaPropostaBiometria.recuperaProposta(idCartao);
			if (!proposta.getStatus().equals("BLOQUEADO")) {
				
				atualizaBloqueio.insereDadosBloqueio(proposta, bloqueio);
				
			}

			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(proposta.getId())
					.toUri();
			return ResponseEntity.created(uri).body(proposta);

		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

}
