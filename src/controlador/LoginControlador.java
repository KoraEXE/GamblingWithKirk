package controlador;

import modelo.ImplementacionBD;
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
}
