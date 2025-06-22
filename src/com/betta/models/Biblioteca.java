package com.betta.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {

	private List<Livro> livros;
	
	private List<Autor> autores;
	
	private List<Emprestimo> emprestimos;

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public void addAutores(List<Autor> autores) {
		if (this.autores == null) this.autores = new ArrayList<Autor>();
		
		this.autores.addAll(autores);
	}
	
	public void addLivros(List<Livro> livros) {
		if (this.livros == null) this.livros = new ArrayList<Livro>();
		
		this.livros.addAll(livros);
	}
	
	public List<Livro> buscarLivrosDisponiveis() {
		if (this.livros == null) this.livros = new ArrayList<Livro>();
		
		return this.livros.stream()
						  .filter(livro -> livro.isDisponivel())
						  .collect(Collectors.toList());
	}
	
	public void realizarEmprestimo(String nome, Livro livro) {
		if (!livro.isDisponivel()) throw new RuntimeException(String.format("O livro %s não está disponível para empréstimo", livro.getTitulo()));
		
		if (this.emprestimos == null) this.emprestimos = new ArrayList<Emprestimo>();
		
		livro.setDisponivel(false);
		livro.setDataAtualizacao(LocalDateTime.now());
		
		Emprestimo emprestimo = new Emprestimo(livro, nome);
		
		this.emprestimos.add(emprestimo);
	}
}
