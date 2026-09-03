package br.edu.fatecpg;

import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<String> leitor = new ArrayList<>();
	static ArrayList<String> livros = new ArrayList<>();
	static ArrayList<String> situacao = new ArrayList<>();
	static ArrayList<String> autor = new ArrayList<>();
	
	public static void main(String[] args) {
		int opcao;
		do {
			exibirCabecalho();
			exibirMenu();
			
			System.out.print("Selecione uma opção: ");
			opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch(opcao) {
			case 1: 
				CadastrarLivro(); 
			break;
			case 2: 
				ListarAcervo(); 
			break;
			case 3: 
				PesquisarLivro(); 
			break;
			case 4:
				exibirEmprestimo();
			break;
			case 5:
				exibirDevolucao();
			break;
			case 6:
				exibirRelatorio();
			break;
			case 7:
				CadastrarLeitor();
			break;
			case 0: 
				System.out.println("Encerrando..."); 
			break;
			default: 
				System.out.println("Opcao invalida!");
			break;
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
		System.out.println("4 - Emprestimo de Livro");
		System.out.println("5 - Devoluçao");
		System.out.println("6 - Relatório do Acervo");
		System.out.println("7 - Cadastrar Leitor");
		System.out.println("0 - Sair");
	}
	
	public static void CadastrarLeitor() {
		entrada.nextLine(); // Limpa o buffer da entrada
		
		System.out.println("Digite o nome do Leitor:");
		String nmLeitor = entrada.nextLine();
		if(nmLeitor == "") {
			System.out.println("Digite um nome!");
		} else {
			leitor.add(nmLeitor);
		}
	}
	
	public static void exibirEmprestimo() {
		if(leitor.isEmpty()) {
			System.out.println("Não há nenhum leitor cadastrado");
			return;
		}
		else if (livros.isEmpty()) {
			System.out.println("Não há livros no acervo");
			return;
		}
		else {
			System.out.println("Insira seu nome: ");
			String nome = entrada.nextLine();
			if (leitor.contains(nome)) {
				System.out.println("Nome valido, prossiga.\n");
			} else {
				System.out.println("Nome invalido.");
				return;
			}
		}
		
		System.out.print("\nDigite um livro que você deseja pegar: ");
		String emprestimo = entrada.nextLine();
		if (situacao.get(livros.indexOf(emprestimo)) == "emprestado") {
			System.out.println("Este livro não está disponivel para emprestimo.");
			return;
		}
		
		if(livros.contains(emprestimo)) {
			System.out.print("\nO livro " + emprestimo + ", do autor: " + autor.get(livros.indexOf(emprestimo)) + ", esta no acervo de livros, deseja pega-lo? ('y' para sim, 'n' para não): ");
			String confirm = entrada.nextLine();
			
			
			if ("y".equalsIgnoreCase(confirm)) {
				System.out.println("Livro emprestado com sucesso!");
				situacao.set(livros.indexOf(emprestimo), "emprestado");
			} else {
				System.out.println("Livro não foi emprestado.");
			}
			
		} else {
			System.out.println("Esse livro não existe no acervo de livros");
		}
	}
	
	public static void exibirDevolucao() {
		boolean existe = false;
		if(leitor.isEmpty()) {
			System.out.println("Não há nenhum leitor cadastrado");
			return;
		}
		
		if (livros.isEmpty()) {
			System.out.println("Não há livros no acervo");
			return;
		}
		
		System.out.println("Insira seu nome: ");
		String nome = entrada.nextLine();
		if (leitor.contains(nome)) {
			System.out.println("Nome valido, prossiga.\n");
		} else {
			System.out.println("Nome invalido.");
			return;
		}
		
		System.out.println("------------- Livros para Devolução -------------");
		for(var i = 0; i < livros.size(); i++) {
			if(situacao.get(i) == "emprestado") {
				existe = true;
				System.out.println("Livro: " + livros.get(i) + " | Autor: " + autor.get(i));
			}
		}
		
		if (!existe) {
			System.out.println("Não há livros para devolução.\n");
			return;
		}
		
		System.out.print("Você deseja devolver qual livro?: ");
		String devo = entrada.nextLine();
		
		if(livros.contains(devo) && situacao.get(livros.indexOf(devo)) == "emprestado") {
			System.out.print("\nVocê deseja devolver o livro " + devo + ", do autor: " + autor.get(livros.indexOf(devo)) + "? ('y' para sim, 'n' para não): ");
			String confirm = entrada.nextLine();
			
			if ("y".equalsIgnoreCase(confirm)) {
				System.out.println("Livro devolvido com sucesso!");
				situacao.set(livros.indexOf(devo), "disponivel");
			} else {
				System.out.println("Livro não foi devolvido.");
			}
		} else {
			System.out.println("Esse livro não existe e/ou não está disponivel para devolução.");
		}
	}
	
	public static void exibirRelatorio() {
		if (livros.isEmpty()) {
			System.out.println("Não há livros no acervo");
			return;
		}
		
		System.out.println("------------- Relatório de Situação do Acervo -------------");
		for(var i = 0; i < livros.size(); i++) {
			System.out.println("Livro: " + livros.get(i) + " | Autor: " + autor.get(i) + " | Disponibilidade: " + situacao.get(i).toUpperCase());
		}
		
		System.out.println("Quantidade de Livros: " + livros.size());
		
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

	    System.out.println("\n┌───────────────────────────────────────────────────────────────────┐");
	    System.out.println("│                             ACERVO                                │");
	    System.out.println("├──────┬────────────────────────┬─────────────────────┬─────────────┤");
	    System.out.printf("│ %-4s │ %-22s │ %-19s │ %-11s │%n", "ID", "TÍTULO", "AUTOR", "STATUS");
	    System.out.println("├──────┼────────────────────────┼─────────────────────┼─────────────┤");

	    for (int i = 0; i < livros.size(); i++) {
	        System.out.printf("│ %-4d │ %-22.22s │ %-19.19s │ %-11s │%n", 
	        	i,
	            livros.get(i), 
	            autor.get(i), 
	            situacao.get(i)
	        );
	    }

	    System.out.println("└──────┴────────────────────────┴─────────────────────┴─────────────┘\n");
	}
	
	public static void PesquisarLivro() {
	    entrada.nextLine(); // Limpa o buffer da entrada
	    
	    if(livros.isEmpty()) {
	    	System.out.println("\nO acervo está vazio no momento.");
	    	return;
	    }
	    
	    System.out.print("\nDigite o título para pesquisar: ");
	    String busca = entrada.nextLine().toLowerCase();

	    boolean encontrado = false;

	    System.out.println("\n--- RESULTADO DA BUSCA ---");

	    for (int i = 0; i < livros.size(); i++) {
	        if (livros.get(i).toLowerCase().contains(busca)) {
	            System.out.printf("ID: %d | Livro: %s | Autor: %s | Status: %s%n", 
	                i, livros.get(i), autor.get(i), situacao.get(i)
	            );
	            
	            encontrado = true;
	        }
	    }

	    if (!encontrado) {
	        System.out.println("Nenhum livro encontrado com esse título.");
	    }
	    
	    System.out.println("--------------------------\n");
	}
}