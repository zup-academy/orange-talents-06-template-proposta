package com.zup.proposta.response;

public class PropostaResponse {

	private Long id;
	private String documento;
	private String email;
	private String nome;
	private String elegivel;
	private String idCartao;

	public PropostaResponse() {
		// TODO Auto-generated constructor stub
	}

	public PropostaResponse(Long id, String documento, String email, String nome, String elegivel, String idCartao) {

		this.id = id;
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.elegivel = elegivel;
		this.idCartao = validaCartao(idCartao);
	}
	
	private String validaCartao(String idCartao) {
		if(idCartao==null) return  "Cartão não associado";
		else return idCartao;
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

	public String getElegivel() {
		return elegivel;
	}

	public String getIdCartao() {
		return idCartao;
	}

}
