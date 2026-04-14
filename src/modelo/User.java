package modelo;

import java.time.LocalDate;

public class User {
	private String dni;
	private String name;
	private String password;
	private LocalDate date_of_birth;
	private int vecesJugadas;
	private int maxCombo;
	private double balance;	
	
	public User(String dni, String name, String password, double balance, LocalDate date_of_birth) {
		this.dni = dni;
		this.name = name;
		this.password = password;
		this.balance = balance;
		this.date_of_birth = date_of_birth;
	}
	
	public User(int vecesJugadas, int vecesGanadas, int vecesPerdidas, int maxCombo, int total21s, double totalPerdido, double totalGanado) {
		this.vecesJugadas = vecesJugadas;
		this.maxCombo = maxCombo;
	}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public User(String dni, String name, String password) {
		this.dni = dni;
		this.name = name;
		this.password = password;
	}
	
	public User(String dni) {
		this.dni = dni;
	}
	
	public User() {
	}
	
	public int getVecesJugadas() {
		return vecesJugadas;
	}

	public void setVecesJugadas(int vecesJugadas) {
		this.vecesJugadas = vecesJugadas;
	}

	public int getMaxCombo() {
		return maxCombo;
	}

	public void setMaxCombo(int maxCombo) {
		this.maxCombo = maxCombo;
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
}
