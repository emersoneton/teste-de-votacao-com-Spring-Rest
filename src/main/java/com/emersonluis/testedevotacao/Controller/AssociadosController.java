package com.emersonluis.testedevotacao.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emersonluis.testedevotacao.datasourse.model.Associado;
import com.emersonluis.testedevotacao.repository.AssociadoRepository;

import lombok.Data;

@RestController
@Data
@RequestMapping({"/associado"})
public class AssociadosController {

	private AssociadoRepository repository;
	
	public AssociadosController(AssociadoRepository associadoRepository) {
		this.repository = associadoRepository;
	}
	
	@GetMapping
	public List<?> findAll(){
	   return repository.findAll();
	}
	
	@PostMapping
	public Associado create(@RequestBody Associado contact){
	   return repository.save(contact);
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable long id){
	   return repository.findById(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Associado> update(@PathVariable("id") long id,
	                                      @RequestBody Associado contact) {
	   return repository.findById(id)
	           .map(record -> {
	               record.setNome(contact.getNome());
	               Associado updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable long id) {
	   return repository.findById(id)
	           .map(record -> {
	               repository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	
}
