package com.minhas.series.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.minhas.series.domain.Genero;
import com.minhas.series.domain.Serie;
import com.minhas.series.repositories.GeneroRepository;
import com.minhas.series.repositories.SerieRepository;

@Configuration
public class DBInitConfig {
	
	@Autowired
	private SerieRepository serieRepository;
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@Bean
	public void initDB() {
		Genero g1 = new Genero("Comedia");
		
		Serie s1 = new Serie("Cobra Kai", "Assistido", g1, "Serie mt boa");
		Serie s2 = new Serie("Lucifer", "Assistido", g1, "Serie boa demais");
		
		generoRepository.save(g1);
		serieRepository.saveAll(Arrays.asList(s1, s2));
	}

}
