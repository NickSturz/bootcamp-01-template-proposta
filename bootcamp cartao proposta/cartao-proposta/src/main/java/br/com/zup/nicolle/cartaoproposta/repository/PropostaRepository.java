package br.com.zup.nicolle.cartaoproposta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.nicolle.cartaoproposta.model.Proposta;


@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long>{

	 Optional<Proposta> findByDocumento(String documento);

}
