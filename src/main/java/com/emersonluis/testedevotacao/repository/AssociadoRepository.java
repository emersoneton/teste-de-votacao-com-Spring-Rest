package com.emersonluis.testedevotacao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emersonluis.testedevotacao.datasourse.model.Associado;

public interface AssociadoRepository  extends JpaRepository<Associado, Long>{

	Optional<Associado> findById(int i);

	
}
