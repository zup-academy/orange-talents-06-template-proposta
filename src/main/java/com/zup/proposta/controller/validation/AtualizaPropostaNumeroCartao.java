package com.zup.proposta.controller.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zup.proposta.controller.CartaoController;
import com.zup.proposta.modelo.Cartao;
import com.zup.proposta.modelo.Proposta;
import com.zup.proposta.repository.CartaoRespository;
import com.zup.proposta.response.CartaoResponseNumero;

@Component
public class AtualizaPropostaNumeroCartao {
	
	@Autowired
	private CartaoController cartaoController;
	
	@Autowired
	private CartaoRespository cartaoRespository;
	
	public void consultaDadosCartao(String idProposta) {
		
		CartaoResponseNumero cartaoresponse = cartaoController.recuperaNumeroCartao(idProposta);
		Cartao cartaoModel = cartaoresponse.toModel();
		Cartao cartaoSalvo = cartaoRespository.save(cartaoModel);

		
	}
	
	public void validaStatusProposta(Proposta proposta) {
		if(proposta.getElegivel().equals("ELEGIVEL")) {
			String idProposta = proposta.getId().toString();
			consultaDadosCartao(idProposta);
		}
	}
	
	

}
