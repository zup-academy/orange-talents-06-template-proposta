package br.com.zup.proposta.proposta.dto;

import br.com.zup.proposta.proposta.model.Biometria;

public class BiometriaRequestDTO {

	private Long id;
	private String biometria;

	public BiometriaRequestDTO(Biometria biometria) {
		this.id = biometria.getId();
		this.biometria = biometria.getBiometria();
	}

	public Long getId() {
		return id;
	}

	public String getBiometria() {
		return biometria;
	}

}
