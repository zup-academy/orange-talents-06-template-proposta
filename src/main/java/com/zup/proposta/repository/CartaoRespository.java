package com.zup.proposta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.proposta.modelo.Cartao;

public interface CartaoRespository extends JpaRepository<Cartao, Long>{

	Optional<Cartao> findCartaoById(String id);

}
