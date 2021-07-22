package com.zup.proposta.modelo;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
	@JoinColumn(name = "codigo_cartao")
	private Cartao cartao;

	private String biometria;
	private LocalDateTime criacao;


	public Biometria(Cartao cartao, String biometria) {
		this.cartao = cartao;
		this.biometria = biometria;
		this.criacao = LocalDateTime.now();
	}
	
	
	
	public LocalDateTime getCriacao() {
		return criacao;
	}

	public Long getId() {
		return id;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public String getBiometria() {
		return biometria;
	}
	
	
	
	

}
