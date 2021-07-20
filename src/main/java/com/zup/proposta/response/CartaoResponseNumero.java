package com.zup.proposta.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zup.proposta.modelo.Cartao;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaoResponseNumero {
	private String id;
	
	private String idProposta;
	
	public String getId() {
		return id;
	}
	
	public String getIdProposta() {
		return idProposta;
	}

	public Cartao toModel() {
		Long idPropostaL = Long.parseLong(idProposta);
		return new Cartao(idPropostaL, id);
	}

}
