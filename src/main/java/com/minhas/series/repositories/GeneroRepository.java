package com.minhas.series.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhas.series.domain.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

}
