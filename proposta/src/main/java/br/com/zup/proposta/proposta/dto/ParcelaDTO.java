package br.com.zup.proposta.proposta.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.zup.proposta.proposta.model.Cartao;
import br.com.zup.proposta.proposta.model.Parcela;

public class ParcelaDTO {

	@NotNull
	private Integer quantidade;

	@NotNull
	private BigDecimal valor;

	public ParcelaDTO(Integer quantidade, BigDecimal valor) {
		super();
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
	public Parcela toModel(Cartao cartao) {
		return new Parcela(quantidade, valor, cartao);
	}
}
