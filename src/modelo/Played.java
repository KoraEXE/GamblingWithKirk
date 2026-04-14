package modelo;

import java.time.LocalDate;

public class Played{
	private String dni;
	private String idMesa;
	private int apuestaEnJuego;
	private Result Result;
	private LocalDate date;
	
	public Played(String dni, String idMesa, int apuestaEnJuego, modelo.Result result, LocalDate date) {
		super();
		this.dni = dni;
		this.idMesa = idMesa;
		this.apuestaEnJuego = apuestaEnJuego;
		Result = result;
		this.date = date;
	}
	
	public Played(String dni, String idMesa, int apuestaEnJuego, LocalDate date) {
		super();
		this.dni = dni;
		this.idMesa = idMesa;
		this.apuestaEnJuego = apuestaEnJuego;
		this.date = date;
	}
	
	public Played() {
		
	}

	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getIdMesa() {
		return idMesa;
	}



	public void setIdMesa(String idMesa) {
		this.idMesa = idMesa;
	}



	public int getApuestaEnJuego() {
		return apuestaEnJuego;
	}



	public void setApuestaEnJuego(int apuestaEnJuego) {
		this.apuestaEnJuego = apuestaEnJuego;
	}



	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Result getResult() {
		return Result;
	}
	public void setResult(Result result) {
		Result = result;
	}
	
	@Override
	public String toString() {
		return "Played [date=" + date + ", Result=" + Result + "]";
	}



}
