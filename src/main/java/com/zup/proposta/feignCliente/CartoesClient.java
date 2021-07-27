package com.zup.proposta.feignCliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zup.proposta.feignCliente.response.CartaoResponse;
import com.zup.proposta.feignCliente.response.CartaoSolicitacao;

@FeignClient(name = "solicitacao", url = "http://localhost:9999/api")
public interface CartoesClient {

	@RequestMapping(method = RequestMethod.POST, value = "/solicitacao", consumes = "application/json")
	CartaoResponse getSolicitacao(CartaoSolicitacao cartao);

}
