package br.com.zup.proposta.proposta.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.zup.proposta.proposta.dto.DadosAnalise;
import br.com.zup.proposta.proposta.dto.DadosSolicitacao;

@FeignClient(name = "client", url = "http://localhost:9999/api/solicitacao")
public interface SolicitacaoClient {

	@PostMapping
	DadosAnalise dadosAnalise(DadosSolicitacao dadosSolicitacao);
}
