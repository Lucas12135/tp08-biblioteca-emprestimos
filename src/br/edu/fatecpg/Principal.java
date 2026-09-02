package br.edu.fatecpg;

import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int opcao;
		ArrayList<String> leitor = new ArrayList<>();
		ArrayList<String> livros = new ArrayList<>();
		
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
				System.out.print("\nDigite um livro que você deseja pegar: ");
				String emprestimo = entrada.nextLine();
				
				if(livros.contains(emprestimo)) {
					
				} else {
					System.out.println("Esse livro não existe no acervo");
				}
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
}