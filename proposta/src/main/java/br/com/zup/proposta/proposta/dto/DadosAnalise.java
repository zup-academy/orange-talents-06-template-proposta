package br.com.zup.proposta.proposta.dto;

import br.com.zup.proposta.proposta.model.enums.StatusProposta;

public class DadosAnalise {

	private String documento;
	private String nome;
	private Long idProposta;
	private StatusProposta statusProposta;

	public DadosAnalise() {
		super();
	}

	public DadosAnalise(String documento, String nome, Long idProposta, StatusProposta statusProposta) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
		this.statusProposta = statusProposta;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public Long getIdProposta() {
		return idProposta;
	}

	public StatusProposta getStatusProposta() {
		return statusProposta;
	}

}
