package com.zup.proposta.controller.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zup.proposta.controller.CartaoController;
import com.zup.proposta.feignCliente.response.CartaoBloqueio;
import com.zup.proposta.modelo.Bloqueio;
import com.zup.proposta.modelo.Proposta;
import com.zup.proposta.repository.BloqueioRepository;

@Component
public class AtualizaBloqueio {
	@Autowired
	private CartaoController cartaoController;
	
	@Autowired
	private AtualizaProposta atualizaProposta;
	
	@Autowired
	private BloqueioRepository bloqueiRepository;
	
	public Bloqueio insereDadosBloqueio(Proposta proposta, CartaoBloqueio bloqueio) {
		String status = cartaoController.recuperaStatusBloqueio(proposta.getCartao(), bloqueio);
		System.err.println(status);
		atualizaProposta.AtualizaPropostaStatus(status, proposta);
		Bloqueio bloqueioModel = new Bloqueio(proposta);
		bloqueiRepository.save(bloqueioModel);
		return bloqueioModel;
	}
}
