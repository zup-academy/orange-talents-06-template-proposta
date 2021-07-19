package br.com.zup.proposta.proposta.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Bloqueio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss", shape = Shape.STRING)
	private LocalDateTime bloqueadoEm;

	@NotBlank
	private String sistemaResponsavel;

	@NotNull
	private boolean ativo;

	@NotNull
	@ManyToOne
	@Valid
	private Cartao cartao;

	public Bloqueio() {
		super();
	}

	public Bloqueio(LocalDateTime bloqueadoEm, String sistemaResponsavel, boolean ativo, Cartao cartao) {
		super();
		this.bloqueadoEm = bloqueadoEm;
		this.sistemaResponsavel = sistemaResponsavel;
		this.ativo = ativo;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getBloqueadoEm() {
		return bloqueadoEm;
	}

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public Cartao getCartao() {
		return cartao;
	}
}
