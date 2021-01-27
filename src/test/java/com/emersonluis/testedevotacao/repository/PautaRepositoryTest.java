package com.emersonluis.testedevotacao.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emersonluis.testedevotacao.datasourse.model.Pauta;

import lombok.Data;

@RunWith(SpringRunner.class)
@SpringBootTest
@Data
public class PautaRepositoryTest {

	@Autowired
	private PautaRepository repository;
	
	@Test
	public void TestarCadastroDaPautaConformeIdPorPauta() {
		Optional<Pauta> pauta = repository.findById((long) 7);
		assertThat(pauta.get().getPauta().equals("Buracos na Via"));
	}
	
	@Test
	public void TestarCadastroDePautaConformeIdPorIdAssociado() {
		Optional<Pauta> pauta = repository.findById((long) 7);
		assertThat(pauta.get().getIdContact().equals(1));
	}
	
	
	
	
}
