package com.emersonluis.testedevotacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emersonluis.testedevotacao.datasourse.model.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Long>{

}
