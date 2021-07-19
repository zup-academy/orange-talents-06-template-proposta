package br.com.zup.proposta.proposta.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Carteira {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Email
	@NotBlank
	private String email;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = Shape.STRING)
	private LocalDateTime associadoEm;

	@NotBlank
	private String emissor;

	@NotNull
	@Valid
	@ManyToOne
	private Cartao cartao;

	public Carteira() {
		super();
	}

	public Carteira(String email, LocalDateTime associadoEm, String emissor, Cartao cartao) {
		super();
		this.email = email;
		this.associadoEm = associadoEm;
		this.emissor = emissor;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getAssociadoEm() {
		return associadoEm;
	}

	public String getEmissor() {
		return emissor;
	}

	public Cartao getCartao() {
		return cartao;
	}

}
