package br.com.zup.proposta.proposta.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.zup.proposta.proposta.dto.DadosAnalise;
import br.com.zup.proposta.proposta.dto.DadosSolicitacao;

@FeignClient(name = "solicitacao", url = "http://localhost:9999")
public interface SolicitacaoClient {

	@RequestMapping(method = RequestMethod.POST, value = "/api/solicitacao")
	DadosAnalise dadosAnalise(@RequestBody DadosSolicitacao dadosSolicitacao);
}
