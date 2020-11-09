package com.minhas.series.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minhas.series.domain.Serie;
import com.minhas.series.repositories.SerieRepository;

@CrossOrigin
@RestController
@RequestMapping("/series")
public class SerieController {
	
	@Autowired
	private SerieRepository serieRepository;
	
	@GetMapping
	public ResponseEntity<List<Serie>> findAll() {
		List<Serie> list = serieRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Serie> findOne(@PathVariable("id") Long id) {
		Optional<Serie> optional = serieRepository.findById(id);
		Serie obj = optional.get();
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody Serie obj) {
		serieRepository.save(obj);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody Serie serie) {
		Optional<Serie> optional = serieRepository.findById(id);
		Serie obj = optional.get();
		obj.setNome(serie.getNome());
		obj.setStatus(serie.getStatus());
		obj.setGenero(serie.getGenero());
		obj.setComentario(serie.getComentario());
		serieRepository.save(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		Optional<Serie> optional = serieRepository.findById(id);
		Serie obj = optional.get();
		serieRepository.delete(obj);
		return ResponseEntity.noContent().build();
	}

}
