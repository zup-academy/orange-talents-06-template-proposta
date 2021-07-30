package com.zup.proposta.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Aviso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "codigo_proposta")
	private Proposta proposta;
	
	private String user;
	private String ip;
	private LocalDate validoAte;
	
	private LocalDateTime criacao;
	
	public Aviso() {
		// TODO Auto-generated constructor stub
	}

	public Aviso(Proposta proposta, String user, String ip) {
		this.proposta = proposta;
		this.user = user;
		this.ip = ip;
		this.criacao = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public Proposta getProposta() {
		return proposta;
	}

	public String getUser() {
		return user;
	}

	public String getIp() {
		return ip;
	}

	public LocalDate getValidoAte() {
		return validoAte;
	}

	public LocalDateTime getCriacao() {
		return criacao;
	}

	
	
	
}
