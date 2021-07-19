package br.com.zup.proposta.proposta.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.proposta.proposta.model.Cartao;
import br.com.zup.proposta.proposta.model.Carteira;

public class CarteiraDTO {

	@Email
	@NotBlank
	private String email;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = Shape.STRING)
	private LocalDateTime associadoEm;

	@NotBlank
	private String emissor;

	public CarteiraDTO(String email, LocalDateTime associadoEm, String emissor) {
		super();
		this.email = email;
		this.associadoEm = associadoEm;
		this.emissor = emissor;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getAssociadoEm() {
		return associadoEm;
	}

	public String getEmissor() {
		return emissor;
	}

	public Carteira toModel(Cartao cartao) {
		return new Carteira(email, associadoEm, emissor, cartao);
	}
}
