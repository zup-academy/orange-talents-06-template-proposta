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
public class Aviso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = Shape.STRING)
	private LocalDateTime validoAte;

	@NotBlank
	private String destino;

	@NotNull
	@Valid
	@ManyToOne
	private Cartao cartao;

	public Aviso() {
		super();
	}

	public Aviso(String destino, LocalDateTime validoAte, Cartao cartao) {
		super();
		this.destino = destino;
		this.validoAte = validoAte;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public String getDestino() {
		return destino;
	}

	public LocalDateTime getValidoAte() {
		return validoAte;
	}

	public Cartao getCartao() {
		return cartao;
	}

}
