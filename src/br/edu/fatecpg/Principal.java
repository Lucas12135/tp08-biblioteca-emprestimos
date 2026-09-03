package br.edu.fatecpg;

import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<String> leitor = new ArrayList<>();
	static ArrayList<String> livros = new ArrayList<>();
	
	public static void main(String[] args) {
		int opcao;
		do {
			exibirCabecalho(); // <== METODO COMPARTILHADO (ponto de conflito)
			exibirMenu();
			
			System.out.print("Selecione uma opção: ");
			opcao = entrada.nextInt();
			entrada.nextLine();
			
			switch(opcao) {
			case 1: /* funcionalidade do Desenvolvedor A */ break;
			case 2: /* funcionalidade do Desenvolvedor B */ break;
			case 4:
				exibirEmprestimo();
			break;
				
			case 0: System.out.println("Encerrando..."); break;
			default: System.out.println("Opcao invalida!");
			}
		} while(opcao != 0);
		
		entrada.close();
	}
	
	public static void exibirCabecalho() {
		System.out.println("==============================");
		System.out.println("       NOME DO SISTEMA        ");
		System.out.println("==============================");
	}
	
	public static void exibirMenu() {
		System.out.println("4 - Emprestimo de Livro");
		System.out.println("5 - Devoluçao");
		System.out.println("6 - Relatório do Acervo");
		System.out.println("0 - Sair");
	}
	
	public static void exibirEmprestimo() {
		if(leitor.isEmpty()) {
			System.out.println("Não há nenhum aluno cadastrado");
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
		
		if(livros.contains(emprestimo)) {
			System.out.print("\nO livro " + emprestimo + " esta no acervo de livros, deseja pega-lo? ('y' para sim, 'n' para não): ");
			String confirm = entrada.nextLine();
			
			
			if ("y".equalsIgnoreCase(confirm)) {
				System.out.println("Livro emprestado com sucesso!");
				livros.remove(emprestimo);
			} else {
				System.out.println("Livro não foi emprestado.");
			}
			
		} else {
			System.out.println("Esse livro não existe no acervo de livros");
		}
	}
}