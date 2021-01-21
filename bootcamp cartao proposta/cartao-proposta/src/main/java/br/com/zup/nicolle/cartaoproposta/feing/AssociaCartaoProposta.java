package br.com.zup.nicolle.cartaoproposta.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.zup.nicolle.cartaoproposta.response.AnaliseResponse;

@FeignClient (url = "http://localhost:8888/api", name = "AssociaCartaoProposta")
@RequestMapping
public interface AssociaCartaoProposta {
	
//	@GetMapping("/contas")
//	CartaoRequest getCartaoByProposta(@RequestParam Long idProposta) {
//		
//	};
	
	
	


}
