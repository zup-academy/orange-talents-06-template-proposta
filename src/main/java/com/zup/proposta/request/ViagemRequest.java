package com.zup.proposta.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zup.proposta.feignCliente.dto.ViagemRequestFeign;

public class ViagemRequest {
	private String destino;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date validoAte = new Date();

	public String getDestino() {
		return destino;
	}
	
	public Date getValidoAte() {
		return validoAte;
	}

	public ViagemRequest(String destino, Date validoAte) {
		this.destino = destino;
		this.validoAte = validoAte;
	}

	public ViagemRequestFeign converteFeign() {
		return new ViagemRequestFeign(destino, validoAte);
	}


}
