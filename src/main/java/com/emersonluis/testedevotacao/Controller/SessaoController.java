package com.emersonluis.testedevotacao.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emersonluis.testedevotacao.datasourse.model.Sessao;
import com.emersonluis.testedevotacao.repository.SessaoRepository;
import com.emersonluis.testedevotacao.util.DataUtil;

import lombok.Data;
import lombok.extern.log4j.Log4j2;


@RestController
@Data
@Log4j2
@RequestMapping("/sessao")
public class SessaoController {

	private final DataUtil dataUtil;
	
	private SessaoRepository repository;
	
	public SessaoController(SessaoRepository sessaoRepository) {
		this.dataUtil = new DataUtil();
		this.repository = sessaoRepository;
	}
	
	@GetMapping
	public List<?> findAll(){		
		log.info(dataUtil.formatLocalDataTimeToDatabaseStyle(LocalDateTime.now()));
	   return repository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable long id){
		log.info(dataUtil.formatLocalDataTimeToDatabaseStyle(LocalDateTime.now()));
	   return repository.findById(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Sessao create(@RequestBody Sessao sessao) {

			return repository.save(sessao);

	}

}
