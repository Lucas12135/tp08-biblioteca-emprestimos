package br.edu.fatecpg;

import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
	
	static Scanner entrada = new Scanner(System.in);
	static ArrayList<String> livros = new ArrayList<>();
	static ArrayList<String> situacao = new ArrayList<>();
	static ArrayList<String> autor = new ArrayList<>();
	
	
	public static void main(String[] args) {

		int opcao;
		
		do {
			exibirCabecalho();
			exibirMenu();
			opcao = entrada.nextInt();
			
			switch(opcao) {
			case 1: CadastrarLivro(); break;
			case 2: ListarAcervo(); break;
			case 3: /* Busca por título */ break;
			case 0: System.out.println("Encerrando..."); break;
			default: System.out.println("Opcao invalida!");
			}
		} while(opcao != 0);
		
		entrada.close();
	}
	
	public static void exibirCabecalho() {
		System.out.println("┌────────────────────────────┐");
		System.out.println("│         BIBLIOTECA         │");
		System.out.println("└────────────────────────────┘");
	}
	
	public static void exibirMenu() {
		System.out.println("1 - Cadastrar Livro");
		System.out.println("2 - Listar Acervo");
		System.out.println("3 - Buscar por título");
		System.out.println("0 - Sair");
		System.out.print("Escolha: ");
	}
	
	public static void CadastrarLivro() {
		entrada.nextLine(); // Limpa o buffer da entrada
		
		String nome, nomeAutor;
		
		do {
			System.out.print("\nDigite o nome do Livro: ");
			nome = entrada.nextLine();
			if(nome == "") {
				System.out.println("Digite um nome!");
			} else if(livros.contains(nome)) {
				System.out.println("Esse livro já existe no acervo");
			} else {
				livros.add(nome);
			}
		} while (nome == "");
		
		do {
			System.out.print("\nDigite o nome do Autor: ");
			nomeAutor = entrada.nextLine();
			if(nomeAutor == "") {
				System.out.println("Digite um nome!");
			} else {
				autor.add(nomeAutor);
			}
		} while (nomeAutor == "");
		
		situacao.add("disponivel");
		System.out.println("\nLivro adicionado com Sucesso!");
	}
	
	public static void ListarAcervo() {
	    if (livros.isEmpty()) {
	        System.out.println("\nO acervo está vazio no momento.");
	        return;
	    }

	    System.out.println("\n┌────────────────────────────────────────────────────────────┐");
	    System.out.println("│                           ACERVO                           │");
	    System.out.println("├────────────────────────┬─────────────────────┬─────────────┤");
	    System.out.printf("│ %-22s │ %-19s │ %-11s │%n", "TÍTULO", "AUTOR", "STATUS");
	    System.out.println("├────────────────────────┼─────────────────────┼─────────────┤");

	    for (int i = 0; i < livros.size(); i++) {
	        System.out.printf("│ %-22.22s │ %-19.19s │ %-11s │%n", 
	            livros.get(i), 
	            autor.get(i), 
	            situacao.get(i)
	        );
	    }

	    System.out.println("└────────────────────────┴─────────────────────┴─────────────┘\n");
	}
}