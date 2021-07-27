package com.zup.proposta.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Biometria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "codigo_proposta")
	private Proposta proposta;

	private String biometria;
	private LocalDateTime criacao;

	public Biometria() {
		// TODO Auto-generated constructor stub
	}

	public Biometria(Proposta proposta, String biometria) {
		this.proposta = proposta;
		this.biometria = biometria;
		this.criacao = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public Proposta getProposta() {
		return proposta;
	}

	public String getBiometria() {
		return biometria;
	}

	public LocalDateTime getCriacao() {
		return criacao;
	}

	

}
