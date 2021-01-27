package com.emersonluis.testedevotacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.emersonluis.testedevotacao.datasourse.model.Associado;

public interface AssociadoRepository  extends JpaRepository<Associado, Long>{

	public List<Associado> findByNomeContaining(@Param("nome")String nome);
	
}
