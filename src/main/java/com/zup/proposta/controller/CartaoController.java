package com.zup.proposta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.proposta.feignCliente.AccountsController;
import com.zup.proposta.feignCliente.CartaoResponse;
import com.zup.proposta.feignCliente.CartaoSolicitacao;
import com.zup.proposta.feignCliente.CartoesClient;
import com.zup.proposta.response.CartaoResponseNumero;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

	@Autowired
	CartoesClient cartaoCliente;

	@Autowired
	AccountsController accountsController;

	private String statusDevolutiva;

	@PostMapping
	public String validaCartao(@RequestBody CartaoSolicitacao request) {
		CartaoResponse responseCartao = cartaoCliente.getSolicitacao(request);
		statusDevolutiva = responseCartao.getResultadoSolicitacao();
		System.out.println(responseCartao.getResultadoSolicitacao());
		// return ResponseEntity.ok(responseCartao);
		return statusDevolutiva;
	}

	@GetMapping("/{idProposta}")
	public CartaoResponseNumero recuperaNumeroCartao(@PathVariable String idProposta) {

		CartaoResponseNumero numeroCartao = accountsController.getNumeroCartao(idProposta);

		System.out.println(numeroCartao);
		return numeroCartao;
	}

}
