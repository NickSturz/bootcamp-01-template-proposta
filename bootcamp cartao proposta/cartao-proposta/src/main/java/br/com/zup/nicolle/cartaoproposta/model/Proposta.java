package br.com.zup.nicolle.cartaoproposta.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.GenericGenerator;

import br.com.zup.nicolle.cartaoproposta.enums.StatusDaProposta;
import br.com.zup.nicolle.cartaoproposta.request.NovaPropostaRequest;
import br.com.zup.nicolle.cartaoproposta.validators.CPFCNPJ;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
public class Proposta {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private @NotBlank @CPFCNPJ String documento;
    private @Email@ NotBlank String email;
    private @NotBlank String nome;
    private @NotBlank String endereco;
    private  @Positive @NotNull BigDecimal salario;
    private StatusDaProposta status;
    
    public Proposta(NovaPropostaRequest request) {
		this.documento = request.getDocumento();
		this.email = request.getEmail();
		this.nome = request.getNome();
		this.endereco = request.getEndereco();
		this.salario = request.getSalario();
		
	}
    
  
}
