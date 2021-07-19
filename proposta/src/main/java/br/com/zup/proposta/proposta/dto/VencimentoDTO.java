package br.com.zup.proposta.proposta.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.proposta.proposta.model.Cartao;
import br.com.zup.proposta.proposta.model.Vencimento;

public class VencimentoDTO {

	@NotNull
	private Integer dia;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = Shape.STRING)
	private LocalDateTime dataDeCriacao;

	public VencimentoDTO(@NotNull Integer dia, LocalDateTime dataDeCriacao) {
		super();
		this.dia = dia;
		this.dataDeCriacao = dataDeCriacao;
	}

	public Integer getDia() {
		return dia;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public Vencimento toModel(Cartao cartao) {
		return new Vencimento(dia, dataDeCriacao, cartao);
	}
}
