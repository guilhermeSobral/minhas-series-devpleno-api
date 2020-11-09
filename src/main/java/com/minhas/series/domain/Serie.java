package com.minhas.series.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Serie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;	
	private String status;
	
	@ManyToOne
	private Genero genero;
	
	@Column(columnDefinition = "TEXT")
	private String comentario;	
	
	@Deprecated
	public Serie() { }

	public Serie(String nome, String status, Genero genero, String comentario) {
		this.nome = nome;
		this.status = status;
		this.genero = genero;
		this.comentario = comentario;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getStatus() {
		return status;
	}

	public Genero getGenero() {
		return genero;
	}

	public String getComentario() {
		return comentario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}	
}
