package br.com.zup.proposta.proposta.dto;

public class DadosSolicitacao {

	private String documento;
	
	private String nome;
	
	private Long propostaId;
	
	public DadosSolicitacao(String documento, String nome, Long propostaId) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.propostaId = propostaId;
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

}
