package com.emersonluis.testedevotacao.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emersonluis.testedevotacao.datasourse.model.Sessao;

import lombok.Data;

@RunWith(SpringRunner.class)
@SpringBootTest
@Data
public class SessaoRepositoryTest {

	@Autowired
	private SessaoRepository repository;
	
	@Test
	public void TestarCadastroDeSessaoConformeRespostaForSim() {
		Optional<Sessao> sessao = repository.findById((long) 1);
		assertThat(sessao.get().getResposta().equals("Sim"));
	}
	
	@Test
	public void TestarCadastroDeSessaoConformeRespostaForNao() {
		Optional<Sessao> sessao = repository.findById((long) 3);
		assertThat(sessao.get().getResposta().equals("Nao"));
	}
	
}
