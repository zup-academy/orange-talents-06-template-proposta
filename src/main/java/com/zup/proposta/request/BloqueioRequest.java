package com.zup.proposta.request;

import javax.validation.constraints.NotBlank;

public class BloqueioRequest {
	@NotBlank
	private String sistemaResponsavel;

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}

	public BloqueioRequest(String sistemaResponsavel) {
		this.sistemaResponsavel = sistemaResponsavel;
	}

}
