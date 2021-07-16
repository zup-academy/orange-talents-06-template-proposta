package br.com.zup.proposta.proposta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.proposta.proposta.model.Proposta;

public interface PropostaRepository extends JpaRepository<Proposta, Long>{
	
	@Transactional(readOnly = true)
	Optional<Proposta> findByDocumento(String documento);
}
