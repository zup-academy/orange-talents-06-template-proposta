package com.zup.proposta.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Bloqueio {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "codigo_proposta")
	private Proposta Proposta;
	
	private String iP;
	
	private LocalDateTime criacao;
	
	public Bloqueio() {
		// TODO Auto-generated constructor stub
	}
	
	public Bloqueio(Proposta proposta) {
		Proposta = proposta;
		this.criacao = LocalDateTime.now();
	}

	public Bloqueio(Proposta proposta, String iP) {
		super();
		Proposta = proposta;
		this.iP = iP;
		this.criacao = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public Proposta getProposta() {
		return Proposta;
	}

	public String getiP() {
		return iP;
	}

	public LocalDateTime getCriacao() {
		return criacao;
	}
	
	

}
