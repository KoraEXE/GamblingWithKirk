package controlador;

import modelo.ImplementacionBD;
import modelo.UsuarioDAO;
import ventanas.VentanaLogin;

public class LoginControlador {
	UsuarioDAO dao = new ImplementacionBD();

	public void visualizarPantalla() {
		VentanaLogin ven = new VentanaLogin(this); // cambiar VentanaLogin a la ventana inicial esto era una prueba
		ven.setVisible(true);	
	}
}
