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
			case 1: /* Cadastro de livro */ break;
			case 2: /* Listagem do acervo */ break;
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
}