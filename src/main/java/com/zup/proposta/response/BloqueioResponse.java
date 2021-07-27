package com.zup.proposta.response;

import java.time.LocalDateTime;

import com.zup.proposta.modelo.Bloqueio;
import com.zup.proposta.modelo.Proposta;

public class BloqueioResponse {
	private Long id;
	private String resultado;
	private String cartao;
	private LocalDateTime criacao;
	

	public Long getId() {
		return id;
	}

	public String getResultado() {
		return resultado;
	}

	public String getCartao() {
		return cartao;
	}
	
	public LocalDateTime getCriacao() {
		return criacao;
	}
	
	
	public BloqueioResponse(Proposta proposta, LocalDateTime criacao, Long id) {
		this.id = id;
		this.resultado = proposta.getStatus();
		this.cartao = proposta.getCartao();
		this.criacao = criacao;
	}

}
