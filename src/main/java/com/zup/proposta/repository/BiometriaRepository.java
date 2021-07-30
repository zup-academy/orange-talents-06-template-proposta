package com.zup.proposta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.proposta.modelo.Biometria;

@Repository
public interface BiometriaRepository extends JpaRepository<Biometria, Long>{

}
