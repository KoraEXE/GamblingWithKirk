package modelo;

import java.time.LocalDate;

public class User {
	private String dni;
	private String name;
	private String password;
	private double balance;
	private LocalDate date_of_birth;
	
	public User(String dni, String name, String password, double balance, LocalDate date_of_birth) {
		this.dni = dni;
		this.name = name;
		this.password = password;
		this.balance = balance;
		this.date_of_birth = date_of_birth;
	}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public User(String dni) {
		this.dni = dni;
	}
	
	public User() {
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	@Override
	public String toString() {
		return "User [dni=" + dni + ", name=" + name + ", password=" + password + ", balance=" + balance
				+ ", date_of_birth=" + date_of_birth + "]";
	}
	
	
	
}
