package com.emersonluis.testedevotacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emersonluis.testedevotacao.datasourse.model.Associado;

public interface AssociadoRepository  extends JpaRepository<Associado, Long>{
	
}
