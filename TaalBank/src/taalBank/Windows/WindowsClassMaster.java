package taalBank.Windows;

import java.util.Scanner;

import taalBank.Classes.Client;
import taalBank.Filepersistence.FilePersistence;

public class WindowsClassMaster {
	
	
private static void toList() {
	for(int i = 0; i < FilePersistence.clientList.size(); i++) {
		System.out.printf("\n\tCliente: %S          Qt Contas: %d            CPF: %S",FilePersistence.clientList.get(i).name, FilePersistence.clientList.get(i).accList.size(), FilePersistence.clientList.get(i).cpf);
	}
		System.out.println("\n");
		homeMaster();
	}
		
	private static void show(Client cliente) {
		for(int i = 0; i < cliente.accList.size(); i++) {
			System.out.printf("\n\t0%d : Conta: %S", i+1,cliente.accList.get(i).accNumber);		
		}
		Scanner scr = new Scanner(System.in);
		System.out.printf("\n\n\tDeseja Deletar conta?\n\n\t1 - Sim\n\t2 - Não\n\n\t:");
		int choice = scr.nextInt();
		switch(choice) {
		case 1:{
			System.out.print("\n\tinforme o número da conta\n\n\t:");
			int index = scr.nextInt();
			if(index < cliente.accList.size()+1 && index > 0) {
				cliente.accList.remove(index-1);
				System.out.printf("\n\tConta removida com sucesso!\n");
				homeMaster();
			}else {
				System.out.printf("\n\tEntrada inválida!");
				homeMaster();
			}
		}
		case 2:{
			System.out.printf("\n\tBusca Finalizada\n");
			homeMaster();
		}
		default:{
			System.err.println("\n\tEntrada inválida");
			homeMaster();
		}
		}
		scr.close();
	}
	
	private static void toSearch() {
		Scanner scr = new Scanner(System.in);
		System.out.printf("\n\tInforme o CPF\n\n\t:");
		String cpf = scr.next();
		
		if(findByCPF(cpf) == null) {
			System.err.printf("\n\tCPF não cadastrado\n");
			homeMaster();
		}else {
			Client temp = findByCPF(cpf);
			System.out.printf("\n\tCliente: %S\n\tCPF: %S\n\tQT Contas: %d\n\n\t1 - Remover Cliente\n\t2 - Vizualiar contas\n\n\t:",temp.name,temp.cpf,temp.accList.size());
			int choice = scr.nextInt();
			
			switch(choice) {
			case 1:{
				FilePersistence.clientList.remove(temp);
				System.out.println("\n\tCliente removido com sucesso");
				homeMaster();
			}
			case 2:{
				show(temp);
			}
			default:{
				System.out.println("Entrada inválida");
				homeMaster();
			}
			}
			scr.close();
		}
	}
	
	private static void homeMaster() {
		Scanner scr = new Scanner(System.in);
		System.out.print("\n\t1 - Buscar Cliente\n\t2 - Listar Clientes\n\t3 - Sair\n\n\t:");
		int choice = scr.nextInt();
		
		switch(choice) {
		case 1:{
			toSearch();
			break;
		}
		case 2:{
			toList();
			break;
		}
		case 3:{
			WindowsClass.lobby();
			break;
		}
		default:{
			System.err.printf("\n\tEntrada inválida");
			homeMaster();
			break;
		}
		}
		scr.close();
	}
	
	public static void passMaster() {

		Scanner scr = new Scanner(System.in);
		System.out.printf("\n\tCódigo de acesso\n\n\t:");
		String cod = scr.next();
		
		if(cod.equals("P00")) {
			homeMaster();
		}else {
			System.err.printf("\n\tCódigo Inválido\n");
			WindowsClass.lobby();
		}
		scr.close();
	}
	
	public static Client findByCPF(String cpf)
	{
		Client temp = new Client(cpf);
		
		if(FilePersistence.clientList.contains(temp)) {
			int index = FilePersistence.clientList.indexOf(temp);
			temp = FilePersistence.clientList.get(index);
			return temp;
		}
		else
			return null;
	}
}
