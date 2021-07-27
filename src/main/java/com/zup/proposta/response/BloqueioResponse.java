package com.zup.proposta.response;

public class BloqueioResponse {

	private String resultado;
	private String cartao;

	public String getResultado() {
		return resultado;
	}

	public String getCartao() {
		return cartao;
	}

	public BloqueioResponse(String resultado, String cartao) {
		this.resultado = resultado;
		this.cartao = cartao;
	}

}
