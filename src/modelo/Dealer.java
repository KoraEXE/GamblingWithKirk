package modelo;

public class Dealer {
	private String ID_Dealer;
	private String name;
	private double balance;
	
	public Dealer(String iD_Dealer, String name, double balance) {
		ID_Dealer = iD_Dealer;
		this.name = name;
		this.balance = balance;
	}
	
	public Dealer(String iD_Dealer) {
		ID_Dealer = iD_Dealer;
	}
	
	public Dealer() {
	}

	public String getID_Dealer() {
		return ID_Dealer;
	}

	public void setID_Dealer(String iD_Dealer) {
		ID_Dealer = iD_Dealer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Dealer [ID_Dealer=" + ID_Dealer + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
	
}
