package com.emersonluis.cursomc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emersonluis.testedevotacao.datasourse.model.Associado;
import com.emersonluis.testedevotacao.repository.AssociadoRepository;

import lombok.Data;

@RunWith(SpringRunner.class)
@SpringBootTest
@Data
class TestedevotacaoApplicationTests {

	private AssociadoRepository repository;
	
	@Test
	public void TestarCadastroDeAssociado() {
		Optional<Associado> associado= repository.findById((long) 3);
		assertThat(associado.get().getNome().equals("Emerson"));
	}

}
