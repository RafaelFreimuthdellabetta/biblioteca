package com.betta.utils;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import com.betta.models.Biblioteca;
import com.betta.models.Livro;

public class Atendente {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Biblioteca biblioteca = new Populadores().abastecerBiblioteca();

		try {			
			boolean inicializarAtendimento = inicializarAtendimento(scanner);
			
			if (!inicializarAtendimento) {
				System.out.println("Agradecemos sua presenca. Volte sempre.");
				scanner.close();
				return;
			}
			
			quebraLinha();
			quebraLinha();
			quebraLinha();
			
			efetualAtendimento(scanner, biblioteca);
		}
		
		catch (InputMismatchException exception) {
			System.out.println("Desculpe, não entendi");
		}
	}

	private static void efetualAtendimento(Scanner scanner, Biblioteca biblioteca) {
		biblioteca.buscarLivrosDisponiveis().forEach(livroDisponivel -> {
			System.out.println(String.format("Id: %d - Título: %-35s - Autor: %s", 
											 livroDisponivel.getId(), 
											 livroDisponivel.getTitulo(),
											 livroDisponivel.getAutor().getNome()));
		});
		
		Livro livro = escolherLivro(scanner, biblioteca);
		
		efetuarReserva(scanner, biblioteca, livro);
		
		boolean encerrarEmprestimo = encerrarAtendimento(scanner);
		
		if (encerrarEmprestimo) {
			System.out.println("Agradecemos sua presenca. Volte sempre");
			scanner.close();
			return;
		}
		
		efetualAtendimento(scanner, biblioteca);
	}

	private static boolean encerrarAtendimento(Scanner scanner) {
		System.out.println("Deseja realizar empréstimo de outro Livro? (1 para sim ou 0 para não) ");
		int resposta = scanner.nextInt();
		
		if (resposta != 1 && resposta != 0) return encerrarAtendimento(scanner);
		
		return resposta == 0;
	}

	private static void efetuarReserva(Scanner scanner, Biblioteca biblioteca, Livro livro) {
		System.out.print("Por favor, informe seu nome para o empréstimo? ");
		String nome = scanner.next();
		
		biblioteca.realizarEmprestimo(nome, livro);
		
		System.out.println("Empréstimo realizado com sucesso...");
	}

	private static Livro escolherLivro(Scanner scanner, Biblioteca biblioteca) {
		quebraLinha();
		quebraLinha();
		
		System.out.print("Para selecionar o Livro, informe o ID: ");
		int idLivro = scanner.nextInt();
		
		Optional<Livro> livroOpt = 
				biblioteca.buscarLivrosDisponiveis().stream()
													.filter(l -> l.getId().equals(idLivro))
													.findFirst();
		
		if (livroOpt.isEmpty()) {
			System.out.println(String.format("\nDesculpe, não encontramos o Livro com Id: %d...", idLivro));
			return escolherLivro(scanner, biblioteca);
		}
		
		System.out.println(String.format("Livro selecionado: %s", livroOpt.get().toString()));
		
		return livroOpt.get();
	}

	private static void quebraLinha() {
		System.out.print("\n");
	}

	private static boolean inicializarAtendimento(Scanner scanner) {
		System.out.print("Seja bem vindo a nossa Biblioteca.\nGostaria de ver nossos livros disponíveis para Empréstimo? (Para sim digite 1 ou 0 para sair). ");
				
		int confirmacaoExibicaoLivros = scanner.nextInt();
		
		if (confirmacaoExibicaoLivros != 0 && confirmacaoExibicaoLivros != 1) {
			return inicializarAtendimento(scanner);
		}
		
		return confirmacaoExibicaoLivros == 1;
		
	}
}
