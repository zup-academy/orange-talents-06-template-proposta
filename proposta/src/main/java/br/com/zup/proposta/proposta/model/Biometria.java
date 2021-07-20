package br.com.zup.proposta.proposta.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Biometria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String biometria;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = Shape.STRING)
	private LocalDateTime associadaEm;

	@ManyToOne
	private Cartao cartao;

	public Biometria() {
		super();
	}

	public Biometria(String biometria, LocalDateTime associadaEm, Cartao cartao) {
		super();
		this.biometria = biometria;
		this.associadaEm = associadaEm;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public String getBiometria() {
		return biometria;
	}
}
