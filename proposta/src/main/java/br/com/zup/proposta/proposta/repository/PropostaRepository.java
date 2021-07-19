package br.com.zup.proposta.proposta.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.proposta.proposta.model.Proposta;
import br.com.zup.proposta.proposta.model.enums.StatusProposta;

public interface PropostaRepository extends JpaRepository<Proposta, Long>{
	
	@Transactional(readOnly = true)
	Optional<Proposta> findByDocumento(String documento);
	
	List<Proposta> findByStatus(StatusProposta status);
}
