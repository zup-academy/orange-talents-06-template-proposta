package com.zup.proposta.controller.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zup.proposta.modelo.Proposta;
import com.zup.proposta.repository.PropostaRepository;

@Component
public class RecuperaPropostaBiometria {

	@Autowired
	private PropostaRepository propostaRepository;
	
	public Proposta recuperaProposta(String codigoCartao) {
		List<Proposta> propostaRecuperada = propostaRepository.findAll();
		if(!propostaRecuperada.isEmpty()) {
			for (Proposta proposta : propostaRecuperada) {
				if(proposta.getCartao()!=null && proposta.getCartao().equalsIgnoreCase(codigoCartao)) {
					return proposta;
				}
						
			}
		}	
		return null;
		
	}
}
