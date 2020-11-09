package com.minhas.series.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhas.series.domain.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

}
