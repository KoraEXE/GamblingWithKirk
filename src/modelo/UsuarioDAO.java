package modelo;

import java.util.ArrayList;

public interface UsuarioDAO {
	public boolean comprobarUsuario(User usuario);
	public String obtenerDNI (User usuario);
	public boolean insertarUsuario(User usuario);
	public boolean borrarUsuario(User usuario);
	public boolean modificarUsuario(User usuario);
	public ArrayList<String> mostrarUsuario(User usuario);
	
}
