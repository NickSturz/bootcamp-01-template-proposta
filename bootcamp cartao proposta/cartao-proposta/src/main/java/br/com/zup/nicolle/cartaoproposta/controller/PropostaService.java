package br.com.zup.nicolle.cartaoproposta.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.nicolle.cartaoproposta.enums.StatusDaProposta;
import br.com.zup.nicolle.cartaoproposta.feing.AnalisePropostaCliente;
import br.com.zup.nicolle.cartaoproposta.model.Proposta;
import br.com.zup.nicolle.cartaoproposta.repository.PropostaRepository;
import br.com.zup.nicolle.cartaoproposta.request.AnaliseRequest;
import br.com.zup.nicolle.cartaoproposta.request.NovaPropostaRequest;
import br.com.zup.nicolle.cartaoproposta.response.AnaliseResponse;
import br.com.zup.nicolle.cartaoproposta.response.PropostaResponse;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class PropostaService {
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	@Autowired
	AnalisePropostaCliente analisePropostaCliente;
	
	@Transactional
	public PropostaResponse criaProposta(NovaPropostaRequest request) {
		
		Proposta proposta = new Proposta(request);
		
		Optional<Proposta> omesmo = propostaRepository.findByDocumento(request.getDocumento());
    	if(omesmo.isPresent()) {
    		throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe proposta cadastrada para esse número de documento");
    	}
    	
    	//resultado do save é recolocado na mesma variável
    	proposta = propostaRepository.save(proposta);
		
		AnaliseResponse analiseResponse = analisePropostaCliente
				.solicitarAnalise(
						AnaliseRequest
						.builder()
						.idProposta(proposta.getId().toString())
						.nome(proposta.getNome())
						.documento(proposta.getDocumento())
						.build()
						);
		
		//ternario
		proposta.setStatus(
				analiseResponse.getResultadoSolicitacao().equals(AnaliseResponse.ResultadoSolicitacao.COM_RESTRICAO)
				?
						StatusDaProposta.NAO_ELEGIVEL
						:
							StatusDaProposta.ELEGIVEL
				
				);
	
		proposta = propostaRepository.save(proposta);
		log.info("oi {} oioi", proposta);
		return new PropostaResponse(proposta.getId().toString());
		
	}


}