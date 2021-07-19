package br.com.zup.proposta.proposta.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Parcela {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Integer quantidade;

	@NotNull
	private BigDecimal valor;

	@NotNull
	@Valid
	@ManyToOne
	private Cartao cartao;

	public Parcela() {
		super();
	}

	public Parcela(Integer quantidade, BigDecimal valor, Cartao cartao) {
		super();
		this.quantidade = quantidade;
		this.valor = valor;
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

	public Cartao getCartao() {
		return cartao;
	}

}
