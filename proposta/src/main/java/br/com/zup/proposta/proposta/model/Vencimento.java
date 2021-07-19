package br.com.zup.proposta.proposta.model;

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
public class Vencimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Integer dia;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = Shape.STRING)
	private LocalDateTime dataDeCriacao;

	@NotNull
	@Valid
	@ManyToOne
	private Cartao cartao;

	public Vencimento() {
		super();
	}

	public Vencimento(Integer dia, LocalDateTime dataDeCriacao, Cartao cartao) {
		super();
		this.dia = dia;
		this.dataDeCriacao = dataDeCriacao;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public Integer getDia() {
		return dia;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public Cartao getCartao() {
		return cartao;
	}

}
