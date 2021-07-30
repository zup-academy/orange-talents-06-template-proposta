package com.zup.proposta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.proposta.modelo.Proposta;

public interface PropostaRepository extends JpaRepository<Proposta, Long>{


	List<Proposta> findPropostaByElegivelAndCartao(String string, Object object);


	

}
