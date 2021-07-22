package com.zup.proposta.request;

import javax.validation.constraints.NotBlank;

import com.zup.proposta.modelo.Biometria;
import com.zup.proposta.modelo.Cartao;

public class BiometriaRequest {
	
	@NotBlank
	private String id_cartao;
	@NotBlank
	private String biometria;
	
	public BiometriaRequest(@NotBlank String id_cartao, @NotBlank String biometria) {
		super();
		this.id_cartao = id_cartao;
		this.biometria = biometria;
	}
	public String getId_cartao() {
		return id_cartao;
	}
	public String getBiometria() {
		return biometria;
	}
	public Biometria toModel(Cartao cartao, String encriptografia) {
		return new Biometria(cartao, encriptografia);
	}
	
	
}
