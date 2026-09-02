package br.edu.fatecpg;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int opcao;
		
		do {
			exibirCabecalho(); // <== METODO COMPARTILHADO (ponto de conflito)
			exibirMenu();
			opcao = entrada.nextInt();
			
			switch(opcao) {
			case 1: /* funcionalidade do Desenvolvedor A */ break;
			case 2: /* funcionalidade do Desenvolvedor B */ break;
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
		System.out.println("1 - ...");
		System.out.println("0 - Sair");
		System.out.print("Escolha: ");
	}
}