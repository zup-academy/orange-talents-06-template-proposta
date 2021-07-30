package com.zup.proposta.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.proposta.modelo.Proposta;

public interface PropostaRepository extends JpaRepository<Proposta, Long>{

	List<Proposta> findPropostaByElegivel(String string);

	List<Proposta> findPropostaByElegivelAndCartao(String string, Object object);


	Optional<Proposta> findPropostaByCartao(String codigoCartao);

	

}
