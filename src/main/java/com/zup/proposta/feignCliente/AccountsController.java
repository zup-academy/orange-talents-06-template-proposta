package com.zup.proposta.feignCliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zup.proposta.feignCliente.response.CartaoBloqueio;
import com.zup.proposta.feignCliente.response.CartaoBloqueioResponse;
import com.zup.proposta.response.CartaoResponseNumero;

@FeignClient(name = "cartoes", url = "http://localhost:8888/api")
public interface AccountsController {

	@RequestMapping(method = RequestMethod.GET, value = "/cartoes?idProposta={idProposta}")
	CartaoResponseNumero getNumeroCartao(@PathVariable("idProposta") String idProposta);

	@RequestMapping(method = RequestMethod.POST, value = "/cartoes/{id}/bloqueios")
	CartaoBloqueioResponse postBloqueioCartao(@PathVariable("id") String id, @RequestBody CartaoBloqueio bloqueio);

}
