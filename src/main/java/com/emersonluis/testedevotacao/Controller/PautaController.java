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

import com.emersonluis.testedevotacao.datasourse.model.Pauta;
import com.emersonluis.testedevotacao.repository.PautaRepository;
import com.emersonluis.testedevotacao.util.DataUtil;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@RestController
@Data
@Log4j2
@RequestMapping({"/pauta"})
public class PautaController {

	private final DataUtil dataUtil;
	
	private PautaRepository repository;
	
	public PautaController(PautaRepository pautaRepository) {
		this.dataUtil = new DataUtil();
		this.repository = pautaRepository;
	}
	
	@GetMapping
	public List<?> findAll(){
		log.info(dataUtil.formatLocalDataTimeToDatabaseStyle(LocalDateTime.now()));
	   return repository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable long id){
	   return repository.findById(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	
	
	@PostMapping
	public Pauta create(@RequestBody Pauta pauta){
		
	   return repository.save(pauta);
	   
	}
	
	
}
