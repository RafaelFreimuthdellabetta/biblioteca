package com.betta.models;

import java.time.LocalDateTime;

public class Livro {

	private Integer id;
	
	private String titulo;
	
	private Autor autor;
	
	private boolean disponivel = true;
	
	private LocalDateTime dataCadastro;
	
	private LocalDateTime dataAtualizacao;

	public Livro(Integer id, String titulo, Autor autor) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.dataCadastro = LocalDateTime.now();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		return "Id=" + id + ", Título=" + titulo + ", Autor=" + autor;
	}
	
	
}
