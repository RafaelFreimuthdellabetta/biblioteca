package com.betta.models;

import java.time.LocalDateTime;

public class Emprestimo {

	private Livro livro;
	
	private String nome;
	
	private LocalDateTime data;
	
	public Emprestimo(Livro livro, String nome) {
		this.livro = livro;
		this.nome = nome;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
}
