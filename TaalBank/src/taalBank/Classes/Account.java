package taalBank.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	public static List<Account> accList = new ArrayList<>();
	
	public String accNumber;
	private Float balance;
	boolean status = false;
	private String password;
	
	//Constructors
	public Account() {
		this.balance = 0f;
		this.status = true;
		this.accNumber = numberGenerator();
		Account.accList.add(this);
		
	}
	public Account(String verify) {
		
	}
	
	//HashCode - Equals - ToString
	public int hashCode() {
		return Objects.hash(accNumber);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accNumber, other.accNumber);
	}
	public String toString() {
		return "Account [accNumber=" + accNumber + ", balance=" + balance + ", status=" + status + "]";
	}
	
	
	//Getters e Setters
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float value) {
		this.balance += value;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	private static String numberGenerator() {
		Random rdm = new Random();
		return "" + rdm.nextInt(999) + "." + rdm.nextInt(999) + "-" + rdm.nextInt(99);
	}

}
