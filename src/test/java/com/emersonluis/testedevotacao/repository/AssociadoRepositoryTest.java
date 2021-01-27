package com.emersonluis.testedevotacao.repository;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emersonluis.testedevotacao.datasourse.model.Associado;


import lombok.Data;

@RunWith(SpringRunner.class)
@SpringBootTest
@Data
public class AssociadoRepositoryTest {

@Autowired
private AssociadoRepository repository;
	

	@Test
	public void TestarCadastroDeAssociadoConformeId() {
		Optional<Associado> associado = repository.findById((long) 3);
		assertThat(associado.get().getNome().equals("Emerson"));
	}
	
	@Test
	public void TetarBuscaPorNomeNoBancoDeDados() {
		List<Associado> associado = repository.findByNomeContaining("Emer");
		assertThat(associado.size()).isEqualTo(3);
	}
	
	
}
