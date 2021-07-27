package com.zup.proposta.controller.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zup.proposta.controller.CartaoController;
import com.zup.proposta.feignCliente.response.CartaoSolicitacao;
import com.zup.proposta.modelo.Proposta;

@Component
public class ValidaPropostaCliente {

	@Autowired
	private CartaoController cartaoController;

	public String validaDevolutiva(Proposta proposta) {
		String idProposta = proposta.getId().toString();
		CartaoSolicitacao cartao = new CartaoSolicitacao(proposta.getDocumento(), proposta.getNome(), idProposta);
		String statusDevolutiva = cartaoController.validaCartao(cartao);		
		
		if (statusDevolutiva.equals("SEM_RESTRICAO")) {
			return "ELEGIVEL";
		}
		return "NAO_ELEGIVEL";
	}

}
