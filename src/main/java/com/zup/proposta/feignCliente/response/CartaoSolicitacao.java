package com.zup.proposta.feignCliente.response;

public class CartaoSolicitacao {
	private String documento;
	private String nome;
	private String idProposta;
	
	
	public String getDocumento() {
		return documento;
	}
	public String getNome() {
		return nome;
	}
	public String getIdProposta() {
		return idProposta;
	}
	
	public CartaoSolicitacao(String documento, String nome, String idProposta) {
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
		
	}
	
	
}
