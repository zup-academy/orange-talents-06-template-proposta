package com.zup.proposta.controller.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zup.proposta.feignCliente.AccountsController;
import com.zup.proposta.feignCliente.dto.ViagemFeign;
import com.zup.proposta.feignCliente.dto.ViagemResponseFeign;
import com.zup.proposta.modelo.Aviso;
import com.zup.proposta.modelo.Proposta;
import com.zup.proposta.modelo.ViagemRequest;
import com.zup.proposta.repository.AvisoRepository;

@Component
public class AvisoViagemValidation {

	@Autowired
	private AccountsController accountsController;

	@Autowired
	private AvisoRepository avisoRepository;

	private String statusDevolutiva;

	public Aviso RegistraAvisoViagem(Proposta proposta, String ip, String user) {
		Aviso aviso = new Aviso(proposta, ip, user);
		Aviso avisoSalvo =  avisoRepository.save(aviso);
		return avisoSalvo;
	}

	public String ValidaAvisoViagem(ViagemRequest viagemRequest, String id) {
		try {
			ViagemFeign viagemFeign = viagemRequest.convertFeig();
			ViagemResponseFeign responseFeign = accountsController.postAvisoViagem(id, viagemFeign);
			statusDevolutiva = responseFeign.getResultado();
			return statusDevolutiva;
		} catch (Exception e) {
			return statusDevolutiva = "Falha";
		}
	}
}
