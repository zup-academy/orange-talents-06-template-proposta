package br.com.zup.proposta.proposta.model.enums;

public enum StatusAnalise {

	COM_RESTRICAO, SEM_RESTRICAO;

	public StatusProposta retornarStatus() {
		return this == COM_RESTRICAO ? StatusProposta.NAO_ELEGIVEL : StatusProposta.ELEGIVEL;
	}
}
