package br.com.zup.proposta.proposta.dto;

import br.com.zup.proposta.proposta.model.enums.StatusProposta;

public class DadosAnalise {

	private String documento;
	private String nome;
	private Long propostaId;
	private StatusProposta statusProposta;

	public DadosAnalise() {
		super();
	}

	public DadosAnalise(String documento, String nome, Long propostaId, StatusProposta statusProposta) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.propostaId = propostaId;
		this.statusProposta = statusProposta;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public Long getPropostaId() {
		return propostaId;
	}

	public StatusProposta getStatusProposta() {
		return statusProposta;
	}

}
