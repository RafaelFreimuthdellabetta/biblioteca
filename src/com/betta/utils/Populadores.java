package com.betta.utils;

import java.time.LocalDate;
import java.util.List;

import com.betta.models.Autor;
import com.betta.models.Biblioteca;
import com.betta.models.Livro;

public class Populadores {

	public Biblioteca abastecerBiblioteca() {
		List<Autor> autores = popularAutores();
		List<Livro> livros = popularLivros(autores);
		
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.addAutores(autores);
		biblioteca.addLivros(livros);
		
		return biblioteca;
	}

	private List<Autor> popularAutores() {
		Autor william = new Autor(1L, "William Shakespeare", LocalDate.of(1564, 4, 23));
		Autor jane = new Autor(2L, "Jane Austen", LocalDate.of(1775, 12, 16));
		Autor george = new Autor(3L, "George Orwell", LocalDate.of(1903, 6, 25));
		Autor gabriel = new Autor(4L, "Gabriel García Márquez", LocalDate.of(1927, 3, 6));
		Autor jk = new Autor(5L, "J.K. Rowling", LocalDate.of(1965, 7, 31));
	
		return List.of(william, jane, george, gabriel, jk);
	}
	
	private List<Livro> popularLivros(List<Autor> autores) {
		Autor george = autores.get(2);
		Autor gabriel = autores.get(3);
		Autor william = autores.get(0);
		Autor jane = autores.get(1);
		Autor jk = autores.get(4);
		
		Livro george1984 = new Livro(1, "1984", george);
		Livro ahRevolucaoDosBichos = new Livro(2, "A Revolução dos Bichos", george);
		
		Livro cemAnosDeSolidao = new Livro(3, "Cem Anos de Solidão", gabriel);
		Livro ohAmorNosTempoDoColera = new Livro(4, "O Amor nos Tempos do Cólera", gabriel);
		
		Livro romeuEhJulieta = new Livro(5, "Romeu e Julieta", william);
		Livro orgulhoEhPreconceito = new Livro(6, "Orgulho e Preconceito", jane);
		
		Livro harryPotter = new Livro(7, "Harry Potter e a Pedra Filosofal", jk);
		
		return List.of(
				george1984, 
				ahRevolucaoDosBichos, 
				cemAnosDeSolidao, 
				ohAmorNosTempoDoColera,
				romeuEhJulieta,
				orgulhoEhPreconceito,
				harryPotter
		);
	}
}
