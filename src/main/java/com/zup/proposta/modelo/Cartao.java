package com.zup.proposta.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jdk.jfr.Name;

@Entity
public class Cartao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private Long idProposta;
	
	private String id;

	public Cartao() {
		// TODO Auto-generated constructor stub
	}

	public Cartao(Long idProposta, String idCartao) {
		super();
		this.idProposta = idProposta;
		this.id = idCartao;
	}

	public Long getId() {
		return codigo;
	}

	public Long getIdProposta() {
		return idProposta;
	}

	public String getIdCartao() {
		return id;
	}

}
