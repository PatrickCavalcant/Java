package com.ifg.agenda;

//Classe ManipularAgenda - É a classe principal do programa

import java.util.Date;
import java.util.Scanner;

public class ManipularAgenda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ContatoDAO contatoDAO = new ContatoDAO();
		boolean Controlador = true;
		
		while(Controlador){
		// TODO Auto-generated method stub
		System.out.println("\nAgenda Virtual\n\n");
		System.out.println("1 - Para salvar um contato");
		System.out.println("2 - Para atualizar um contato");
		System.out.println("3 - Para remover um contato");
		System.out.println("4 - Para mostrar todos os contatos");
		System.out.println("5 - Para sair da Agenda Virtual\n\n");
		System.out.println("Digite a opção desejada: \n\n");
		
		Scanner ler = new Scanner(System.in);
		int opcao = ler.nextInt();
		 
		
		switch (opcao) {
		case 1:
			Contato contato = new Contato();
			 
			System.out.println("Digite o nome do contato: ");
			Scanner nomedig = new Scanner(System.in);
			String nome = nomedig.nextLine();
			contato.setNome(nome);
			 
			System.out.println("Digite a idade do contato: ");
			Scanner idadedig = new Scanner(System.in);
			int idade = idadedig.nextInt();
			contato.setIdade(idade);
			
			contato.setDataCadastro(new Date());
			 
			contatoDAO.save(contato);
			
			System.out.println("\nContato salvo com sucesso!\n");
			
		break;
		case 2:
			System.out.println("Digite o nome do contato que será atualizado: ");
			Scanner nomeatex = new Scanner(System.in);
			String name = nomeatex.nextLine();
			
			Contato contatoat = contatoDAO.getContatoByName(name);
			 
			System.out.println("Digite o novo nome do contato: ");
			Scanner nomeatdig = new Scanner(System.in);
			String nomeat = nomeatdig.nextLine();
			contatoat.setNome(nomeat);
			 
			System.out.println("Digite a nova idade do contato: ");
			Scanner idadeatdig = new Scanner(System.in);
			int idadeat = idadeatdig.nextInt();
			contatoat.setIdade(idadeat);
			
			contatoat.setDataCadastro(new Date());
			 
			contatoDAO.update(contatoat);
			
			System.out.println("\nContato atualizado com sucesso!\n");
		break;
		case 3:
			System.out.println("Digite o nome do contato que será removido: ");
			Scanner nomerdig = new Scanner(System.in);
			String nomer = nomerdig.nextLine();
			 
			contatoDAO.remove(nomer);
			
			System.out.println("\nContato removido com sucesso!\n");
		break;
		case 4:
			for(Contato c : contatoDAO.getContatos()){
				 System.out.println("Nome: " + c.getNome() + "     Idade: " + c.getIdade());
				 }
		break;
		case 5:
		Controlador = false;
		System.out.println("\nAgenda Virtual Finalizada\n");
		break;
		default:
		System.out.println("Opção Inválida!\n");
		}
		}
	}
}
