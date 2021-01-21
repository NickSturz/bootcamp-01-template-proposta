package br.com.zup.nicolle.cartaoproposta.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.zup.nicolle.cartaoproposta.request.AnaliseRequest;
import br.com.zup.nicolle.cartaoproposta.response.AnaliseResponse;

@FeignClient (url = "http://localhost:9999", name = "AnalisePropostaCliente")
public interface AnalisePropostaCliente {
	@PostMapping("/api/solicitacao")
    @ResponseBody
    AnaliseResponse solicitarAnalise(@RequestBody AnaliseRequest request);
}
