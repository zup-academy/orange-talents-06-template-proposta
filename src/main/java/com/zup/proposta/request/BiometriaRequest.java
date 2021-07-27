package com.zup.proposta.request;

import javax.validation.constraints.NotBlank;

import com.zup.proposta.modelo.Biometria;
import com.zup.proposta.modelo.Proposta;

import br.com.zup.ecommerce.validator.ExistsId;

public class BiometriaRequest {

	@NotBlank
	// @ExistsId(domainClass = Biometria.class, fieldName = "codigo_proposta",
	// message = "Cartão deve existir no sistema")
	private String codigo_proposta;
	@NotBlank
	private String biometria;

	public BiometriaRequest(@NotBlank String id_cartao, @NotBlank String biometria) {

		this.codigo_proposta = id_cartao;
		this.biometria = biometria;
	}

	public String getId_cartao() {
		return codigo_proposta;
	}

	public String getBiometria() {
		return biometria;
	}

	public Biometria toModel(Proposta proposta, String biometriaEncode) {
		return new Biometria(proposta, biometriaEncode);
	}

}
