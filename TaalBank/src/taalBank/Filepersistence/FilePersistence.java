package taalBank.Filepersistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import taalBank.Classes.Account;
import taalBank.Classes.Client;

public final class FilePersistence implements Serializable{
	private static final long serialVersionUID = 1L;
	public static List<Client> clientList = new ArrayList<>();
	
	public  FilePersistence() {
		dataLoad();
	}

	public static void addClient(Client c) {
		if (!clientList.contains(c))
		{
			clientList.add(c);
			dataSave();
		}else
			System.out.println("Client já cadastrado");
	}

	private static void dataSave() {
		try {
			FileOutputStream fos = new FileOutputStream("dados.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clientList);
			oos.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void dataLoad() {
		try 
		{
			FileInputStream fis = new FileInputStream("dados.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			clientList = (ArrayList<Client>) ois.readObject();
			ois.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

}
