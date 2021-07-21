package com.zup.proposta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zup.proposta.feignCliente.CartaoSolicitacao;
import com.zup.proposta.modelo.Proposta;

@Component
public class ValidaPropostaCliente {

	@Autowired
	private CartaoController cartaoController;

	public String validaDevolutiva(Proposta proposta) {
		String idProposta = proposta.getId().toString();
		CartaoSolicitacao cartao = new CartaoSolicitacao(proposta.getDocumento(), proposta.getNome(), idProposta);
		String status = cartaoController.validaCartao(cartao);
		if (status.equals("COM_RESTRICAO"))
			return "NAO_ELEGIVEL";
		return "ELEGIVEL";
	}

}
