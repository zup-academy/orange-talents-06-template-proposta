package br.com.zup.proposta.proposta.dto;

public class CartaoRequestDTO {

	private String documento;

	private String nome;

	private Long idProposta;

	public CartaoRequestDTO() {
		super();
	}

	public CartaoRequestDTO(String documento, String nome, Long idProposta) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
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

}
