package br.com.zup.proposta.proposta.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.proposta.proposta.model.Bloqueio;
import br.com.zup.proposta.proposta.model.Cartao;

public class BloqueioDTO {

	@JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss", shape = Shape.STRING)
	private LocalDateTime bloqueadoEm;

	@NotBlank
	private String sistemaResponsavel;

	@NotNull
	private boolean ativo;

	public BloqueioDTO(LocalDateTime bloqueadoEm, String sistemaResponsavel, boolean ativo) {
		super();
		this.bloqueadoEm = bloqueadoEm;
		this.sistemaResponsavel = sistemaResponsavel;
		this.ativo = ativo;
	}

	public LocalDateTime getBloqueadoEm() {
		return bloqueadoEm;
	}

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public Bloqueio toModel(Cartao cartao) {
		return new Bloqueio(bloqueadoEm, sistemaResponsavel, ativo, cartao);
	}
}
