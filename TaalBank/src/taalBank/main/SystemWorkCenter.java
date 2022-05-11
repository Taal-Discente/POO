package taalBank.main;

import java.io.Serializable;

import taalBank.Filepersistence.FilePersistence;
import taalBank.Windows.WindowsClass;

public class SystemWorkCenter implements Serializable{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		FilePersistence init = new FilePersistence();
		
		WindowsClass.lobby();
	}

}
	