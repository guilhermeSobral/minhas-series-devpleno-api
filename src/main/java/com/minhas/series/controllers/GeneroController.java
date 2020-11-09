package com.minhas.series.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minhas.series.domain.Genero;
import com.minhas.series.repositories.GeneroRepository;

@CrossOrigin
@RestController
@RequestMapping("/generos")
public class GeneroController {
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@GetMapping
	public ResponseEntity<List<Genero>> findAll() {
		List<Genero> list = generoRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Genero> findOne(@PathVariable("id") Long id) {
		Optional<Genero> optional = generoRepository.findById(id);
		Genero genero = optional.get();
		return ResponseEntity.ok().body(genero);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody Genero genero) {
		generoRepository.save(genero);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody Genero genero) {
		Optional<Genero> optional = generoRepository.findById(id);
		Genero obj = optional.get();
		obj.setNome(genero.getNome());
		generoRepository.save(obj);
		return ResponseEntity.noContent().build();
	}

}
