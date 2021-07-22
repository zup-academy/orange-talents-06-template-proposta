package com.zup.proposta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.proposta.modelo.Cartao;

public interface CartaoRespository extends JpaRepository<Cartao, Long>{

<<<<<<< HEAD
	Optional<Cartao> findCartaoById(String id);
=======
	Cartao findCartaoByIdProposta(Long id);
>>>>>>> 433f16d9e78ef5a99e6565233b73039aa64b8546

}
