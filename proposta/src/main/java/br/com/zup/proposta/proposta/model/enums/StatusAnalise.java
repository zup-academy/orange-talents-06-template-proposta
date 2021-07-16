package br.com.zup.proposta.proposta.model.enums;

public enum StatusAnalise {

	COM_RESTRICAO(StatusProposta.NAO_ELEGIVEL), SEM_RESTRICAO(StatusProposta.ELEGIVEL);

	private StatusProposta statusProposta;

	StatusAnalise(StatusProposta statusProposta) {
		this.statusProposta = statusProposta;
	}

	public StatusProposta getStatusProposta() {
		return statusProposta;
	}

}
