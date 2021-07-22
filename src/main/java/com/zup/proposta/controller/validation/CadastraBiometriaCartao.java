package com.zup.proposta.controller.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.zup.proposta.controller.BiometriaController;
import com.zup.proposta.modelo.Biometria;
import com.zup.proposta.modelo.Cartao;
import com.zup.proposta.repository.BiometriaRepository;
import com.zup.proposta.request.BiometriaRequest;

@Component
public class CadastraBiometriaCartao {

	@Autowired
	private BiometriaRepository biometriaRepository;

	public Biometria cadastraBiometria(BiometriaRequest request, Cartao cartao) {
		String biometriaEncrip = encriptografarBiometria(request.getBiometria());
		System.out.println(">>>>" + biometriaEncrip);
		Biometria biometria = request.toModel(cartao, biometriaEncrip);
		Biometria biometriaSalva = biometriaRepository.save(biometria);
		return biometriaSalva;

	}

	private String encriptografarBiometria(String biometria) {
		return new BCryptPasswordEncoder().encode(biometria);
	}

}
