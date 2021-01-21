package br.com.zup.nicolle.cartaoproposta.healthcheck;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class PropostaHealthCheck implements HealthIndicator {
	
	//Como configurar melhor o Health???
	
	@Override
	public Health health() {
		 Map<String, Object> details = new HashMap<>();
	        details.put("descrição", "tentando um health");
	        
	        return Health.status(Status.UP).withDetails(details).build();
	}

}
