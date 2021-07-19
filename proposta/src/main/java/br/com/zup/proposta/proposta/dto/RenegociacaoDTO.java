package br.com.zup.proposta.proposta.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.proposta.proposta.model.Cartao;
import br.com.zup.proposta.proposta.model.Renegociacao;

public class RenegociacaoDTO {

	@NotNull
	private Integer quantidade;

	@NotNull
	private BigDecimal valor;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = Shape.STRING)
	private LocalDateTime dataDeCriacao;

	public RenegociacaoDTO(Integer quantidade, BigDecimal valor, LocalDateTime dataDeCriacao) {
		super();
		this.quantidade = quantidade;
		this.valor = valor;
		this.dataDeCriacao = dataDeCriacao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public Renegociacao toModel(Cartao cartao) {
		return new Renegociacao(quantidade, valor, dataDeCriacao, cartao);
	}
}
