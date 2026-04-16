package controlador;

import java.util.ArrayList;

import modelo.Dealer;
import modelo.ImplementacionBD;
import modelo.Play_On_Table;
import modelo.Played;
import modelo.User;
import modelo.UsuarioDAO;
import ventanas.VentanaInicial;

public class LoginControlador {
	
	UsuarioDAO dao = new ImplementacionBD();

	public void visualizarPantalla() {
		VentanaInicial ven = new VentanaInicial(this);
		ven.setVisible(true);	
	}
	
	public boolean comprobarUsuario(User usuario) {
		return dao.comprobarUsuario(usuario);
	}
	
	public String obtenerDNI (User usuario) {
		return dao.obtenerDNI(usuario);
	}
	
	public String obtenerNombre(User usuario) {
		return dao.obtenerNombre(usuario);
	}
	
	public int obtenerDinero (User usuario) {
		return dao.obtenerDinero(usuario);
	}
	
	public boolean insertarUsuario (User usuario) {
		return dao.insertarUsuario(usuario);
	}
	
	public boolean borrarUsuario (User usuario) {
		return dao.borrarUsuario(usuario);
	}
	
	public boolean actualizarDinero (User usuario) {
		return dao.actualizarDinero(usuario);
	}
	
	public boolean obtenerStadisticas (User usuario) {
		return dao.obtenerStadisticas(usuario);
	}
	
	public boolean actualuizarStadisticas (User usuario) {
		return dao.actualuizarStadisticas(usuario);
	}
	
	public boolean insertarJuego (Played played, User usuario, Play_On_Table table) {
		return dao.insertarJuego(played, usuario, table);
	}
	
	public boolean insertarMesa (Play_On_Table table) {
		return dao.insertarMesa(table);
	}
	
	public ArrayList<Played> obtenerHistorial (User usuario) {
		return dao.obtenerHistorial(usuario);
	}
	
	public boolean repetirDNI (User usuario) {
		return dao.repetirDNI(usuario);
	}
	
	public boolean obtenerID_DEALER (Dealer dealer) {
		return dao.obtenerID_DEALER(dealer);
	}
	
	public boolean insertarDealer (Dealer dealer) {
		return dao.insertarDealer(dealer);
	}
}
