package br.com.zup.proposta.proposta.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.proposta.proposta.model.Biometria;
import br.com.zup.proposta.proposta.model.Cartao;

public class BiometriaDTO {

	@NotNull
	@NotBlank
	private String biometria;
	
	public BiometriaDTO() {
		super();
	}

	public BiometriaDTO(String biometria) {
		super();
		this.biometria = biometria;
	}

	public Biometria toModel(Cartao cartao) {
		return new Biometria(biometria, LocalDateTime.now(), cartao);
	}

	public String getBiometria() {
		return biometria;
	}

}
