package taalBank.Windows;

import java.io.Serializable;
import java.util.Scanner;

import taalBank.Classes.Account;
import taalBank.Classes.Client;
import taalBank.Filepersistence.FilePersistence;

public final class  WindowsClass implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static void lobby() {
		Scanner scr = new Scanner(System.in);
		System.out.printf("\n\t1 - Depositar \n\t2 - Accessar Conta\n\t3 - Abrir conta\n\t4 - Administrativo\n\n\t:");
		int choice = scr.nextInt();
		switch (choice) {
		case 1: {
			toDeposit();
			break;
		}
		case 2: {
			toLogIn();
			break;
		}
		case 3:{
			accCreate();
			break;
		}
		case 4:{
			WindowsClassMaster.passMaster();
			break;
		}
		default:
			System.err.println("Missing option: " + choice);
			lobby();		
		}
		scr.close();
	}
	
	private static void toDeposit() {

		Scanner scr = new Scanner(System.in);
		System.out.printf("\n\tValue\n\n\t:");
		float value = scr.nextInt();
		System.out.println("\n\tAccount\n\n\t:");
		String acc = scr.next().toString();
		
		Account temp = new Account("Verify");
		temp.accNumber = acc;
		if(Account.accList.contains(temp)) {
			int index = Account.accList.indexOf(temp);
			temp = Account.accList.get(index);
			temp.setBalance(value);
			Account.accList.set(index, temp);
			System.out.printf("\n\tDeposito efetuado com sucesso!");
			}else {
				System.err.println("\n\tConta não encontrada");
			}
		endProcess();
		scr.close();
	}
	
	private static void accCreate() {
		Scanner scr = new Scanner(System.in);
		System.out.printf("\n\n\tNome\n\n\t:");
		String name = scr.next().toString();
		System.out.printf("\n\n\tCPF\n\n\t:");
		String cpf = scr.next().toString();
		System.out.printf("\n\n\tSenha\n\n\t:");
		String pass = scr.next().toString();
		System.out.printf("\n\n\tRepita a senha\n\n\t:");
		String pass2 = scr.next().toString();
		
		if(!pass.equals(pass2)) {
			System.err.printf("\n\tAs senhas informadas não correspondem..");
			endProcess();
		}else {
			Client temp = new Client();
			temp.cpf = cpf;
			if(FilePersistence.clientList.contains(temp)) {
				System.out.printf("\n\tImpossível criar. CPF vinculado a uma outra conta");
				endProcess();
			}else {
				System.out.printf("\n\tConta Criada com sucesso!");
				Client newClient = new Client(name,cpf);
				newClient.account.setPassword(pass);
				FilePersistence.addClient(newClient);
				System.out.printf("\n\n\tSua Conta: %S",newClient.account.accNumber);
				lobby();
			}
			
		}
		scr.close();
	}

	private static void endProcess() {
		Scanner scr = new Scanner(System.in);
		System.out.print("\n\n\t1 - Realizar outra operação\n\t2 - Encerrar Sessão\n\n\t:");
		int choice = scr.nextInt();
		
		switch(choice) {
		case 1: {
			lobby();
			break;
		}
		case 2: {
			System.out.println("\n\n\tSessão encerrada!");
			System.exit(0);
			break;
		}
		default: {
			System.out.println("\n\n\tEntrada inválida, sessão sendo encerrada...");
			break;
		}
		}
		scr.close();
	}
	
	private static void toLogIn() {
		Scanner scr = new Scanner(System.in);
		System.out.printf("\n\n\tCPF\n\n\t:");
		String cpf = scr.next().toString();
		System.out.printf("\n\n\tConta\n\n\t:");
		String acc = scr.next().toString();
		System.out.printf("\n\n\tSenha\n\n\t:");
		String pass = scr.next().toString();
		
		Client cliente = new Client();
		cliente.cpf = cpf;
		
		Account conta= new Account("Verify");
		conta.accNumber = acc;
		
		if(FilePersistence.clientList.contains(cliente) ) {	
			if(Account.accList.contains(conta)) {
			 int index1 = FilePersistence.clientList.indexOf(cliente);
			 cliente = FilePersistence.clientList.get(index1);
			 int index2 = Account.accList.indexOf(conta);
			 conta = Account.accList.get(index2);
			 if((conta.getPassword()).equals(pass)) {
				 homePage(cliente);
			 }else {
				 System.err.println("Senha Incorreta!");
				 endProcess();
			 }
			 
			}else {
				System.err.println("Conta não encontrada");
				endProcess();
			}	
			}else {
				System.err.println("\n\tCliente não encontrado");
				endProcess();
			}
		scr.close();
	}
		
	private static void homePage(Client acc) {
		Scanner scr = new Scanner(System.in);
		System.out.printf("\n\tCliente: %s	\n\tAgência: 0852-7 \n\tConta: %s",acc.name, acc.account.accNumber);
		System.out.printf("\n\n\t1 - Realizar Transferência\n\t2 - Solicitar nova conta:\n\t3 - Listar Contas\n\t4 - Consultar Saldo\n\t5 - Saque\n\n\t:");
		int choice = scr.nextInt();
		
		switch(choice) {
		case 1:{
			toTransfer(acc);
			break;
		}
		case 2:{
			accCreateAdd(acc);
		}
		case 3:{
			accShow(acc);
		}
		case 4:{
			balanceCheck(acc);
		}
		case 5:{
			withdraw(acc);
		}
		}
		scr.close();
	}
		
	private static void balanceCheck(Client cliente) {
		System.out.printf("\n\tSaldo: %.2f", cliente.account.getBalance());
		homePage(cliente);
	}
	
	private static void accShow(Client cliente) {
		for(int i = 0; i < cliente.accList.size(); i++) {
			System.out.printf("\n\t0%d : Conta: %S                  Saldo: %.2f", i+1,cliente.accList.get(i).accNumber, cliente.accList.get(i).getBalance());		
		}
		Scanner scr = new Scanner(System.in);
		System.out.printf("\n\n\tDeseja Mudar de conta?\n\n\t1 - Sim\n\t2 - Não\n\n\t:");
		int choice = scr.nextInt();
		switch(choice) {
		case 1:{
			System.out.print("\n\tInforme o número da conta\n\n\t:");
			int index = scr.nextInt();
			if(index < cliente.accList.size()+1 && index > 0) {
				cliente.account = cliente.accList.get(index-1);
				System.out.printf("\n\tMudou com sucesso!\n");
				homePage(cliente);
			}else {
				System.err.printf("\n\tEntrada inválida!");
				homePage(cliente);
			}
		}
		case 2:{
			homePage(cliente);
		}
		}
		scr.close();
	}
	
	private static void accCreateAdd(Client cliente) {	
		cliente.accList.add(new Account());
		System.out.printf("\n\tConta criada com sucesso!");
		homePage(cliente);
	}
	
	private static void toTransfer(Client cliente) {
		Scanner scr = new Scanner(System.in);
		System.out.printf("\n\tCPF\n\n\t:");
		String cpf = scr.next();
		System.out.printf("\n\tConta\n\n\t:");
		String conta = scr.next();
		System.out.printf("\n\tValor\n\n\t:");
		Float valor = scr.nextFloat();
		
		if(cliente.account.getBalance() < valor) {
			System.err.printf("\n\tSaldo insuficiente");
			endProcess();
		}else {
			Client temp = new Client();
			temp.cpf = cpf;
			if(FilePersistence.clientList.contains(temp)) {
				int index = FilePersistence.clientList.indexOf(temp);
				temp = FilePersistence.clientList.get(index);
				Account temp2 = new Account("Verify");
				temp2.accNumber = conta;
				if(!temp.accList.contains(temp2)) {
					System.err.println("\n\tVerifique os dados e tente novamente");
					toTransfer(cliente);
				}else {
					System.out.printf("\n\tDono da conta: %S\n\n\t1 - Confirmar\n\t2 - Voltar\n\n\t :",temp.name);
					int choice = scr.nextInt();
					switch(choice) {
					case 1:{
						cliente.account.setBalance(-valor);
						temp.account.setBalance(valor);
						System.out.printf("\n\tTransferência Efetuada com sucesso!");
						endProcess();
					}
					case 2:{
						endProcess();
					}
					default:{
						System.out.printf("\n\tEntrada Inválida");
						endProcess();
					}
					}
				}
				
			}else {
				System.err.printf("\n\tConta Não encontrada");
				endProcess();
			}
			
		}
		scr.close();
	}
	
	private static void withdraw(Client cliente) {
		Scanner scr = new Scanner(System.in);
		System.out.printf("\n\tValor\n\n\t:");
		float valor = scr.nextFloat();
		
		if(cliente.account.getBalance() < valor) {
			System.err.printf("\n\tSaldo insuficiente");
			homePage(cliente);
		}else {
			cliente.account.setBalance(-valor);
			System.out.printf("\n\tSaque realizado com sucesso");
			endProcess();
		}
		scr.close();
	}


}//End
























	