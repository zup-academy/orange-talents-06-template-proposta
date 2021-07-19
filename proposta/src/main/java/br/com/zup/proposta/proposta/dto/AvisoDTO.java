package br.com.zup.proposta.proposta.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.proposta.proposta.model.Aviso;
import br.com.zup.proposta.proposta.model.Cartao;

public class AvisoDTO {
	
	@NotBlank
	private String destino;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = Shape.STRING)
	private LocalDateTime validoAte;

	public AvisoDTO( String destino, LocalDateTime validoAte) {
		super();
		this.destino = destino;
		this.validoAte = validoAte;
	}

	public String getDestino() {
		return destino;
	}

	public LocalDateTime getValidoAte() {
		return validoAte;
	}
	
	public Aviso toModel(Cartao cartao) {
		return new Aviso(destino, validoAte, cartao);
	}
}
