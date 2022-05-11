package taalBank.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client implements Serializable{	
    private static final long serialVersionUID = 1L;
    public List<Account> accList = new ArrayList<>();
    
	public String name;
	public String cpf;
	public Account account;
	
	//Constructors
	public Client() {
		this.account = new Account("Verify");
		this.accList.add(account);
	}
	public Client(String name, String cpf) {
		this.name = name;
		this.cpf = cpf;
		this.account = new Account();
		this.accList.add(account);
	}
	public Client(String cpf) {
		this.cpf = cpf;
		this.account = new Account();
		this.accList.add(account);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//HashCode - Equals - ToString
	public int hashCode() {
		return Objects.hash(cpf);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(cpf, other.cpf);
	}
	public String toString() {
		return "Client [name=" + name + ", cpf=" + cpf + ", account=" + account + "]";
	}
	
}

