package br.com.zup.proposta.proposta.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Renegociacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Integer quantidade;

	@NotNull
	private BigDecimal valor;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = Shape.STRING)
	private LocalDateTime dataDeCriacao;

	@NotNull
	@Valid
	@ManyToOne
	private Cartao cartao;

	public Renegociacao() {
		super();
	}

	public Renegociacao(Integer quantidade, BigDecimal valor, LocalDateTime dataDeCriacao, Cartao cartao) {
		super();
		this.quantidade = quantidade;
		this.valor = valor;
		this.dataDeCriacao = dataDeCriacao;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
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

	public Cartao getCartao() {
		return cartao;
	}

}
