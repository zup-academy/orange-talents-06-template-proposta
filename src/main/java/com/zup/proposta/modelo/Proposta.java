package com.zup.proposta.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.zup.proposta.response.PropostaResponse;

@Entity
public class Proposta {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String documento;
	private String email;
    private String nome; 
    private String endereco;
    private BigDecimal salario;
    private String elegivel;
    
    public Proposta() {
		// TODO Auto-generated constructor stub
	}

	public Proposta(String documento, String email, String nome, String endereco, BigDecimal salario) {
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}
    
	public String getElegivel() {
		return elegivel;
	}
	
	public void setElegivel(String elegivel) {
		this.elegivel = elegivel;
	}

	public PropostaResponse toConverteResponse(String idCartao) {
		return new PropostaResponse(id, documento, email, nome, elegivel, idCartao);
	}
	
	public PropostaResponse toConverteResponse() {
		return new PropostaResponse(id, documento, email, nome, elegivel);
	}
    
}
