package br.com.zup.nicolle.cartaoproposta.view;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.nicolle.cartaoproposta.controller.PropostaService;
import br.com.zup.nicolle.cartaoproposta.request.NovaPropostaRequest;
import br.com.zup.nicolle.cartaoproposta.response.PropostaResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/propostas")
@Slf4j
public class PropostaController {

	
	@Autowired
	PropostaService propostaService;
	
    @PostMapping
    public ResponseEntity<?> novaProposta(@RequestBody @Valid NovaPropostaRequest request, UriComponentsBuilder uri){
    	
    	    	
    	PropostaResponse propostaResponse = propostaService.criaProposta(request);
    	URI uriCreated = uri.path("/api/propostas/{id}").build(propostaResponse.getId());
    	
    	log.info("{}", propostaResponse);
    	
    	    	
		return ResponseEntity.created(uriCreated).build();
                
    }
}
