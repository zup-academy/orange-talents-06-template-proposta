package com.zup.proposta.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaoResponseNumero {
	// numero do cartão
	private String id;
	private String idProposta;

	public String getId() {
		return id;
	}

	public String getIdProposta() {
		return idProposta;
	}

}
