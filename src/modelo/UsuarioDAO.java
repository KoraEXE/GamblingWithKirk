package modelo;

import java.util.ArrayList;

public interface UsuarioDAO {
	public boolean comprobarUsuario(User usuario);
	public int obtenerDinero(User usuario);
	public String obtenerDNI (User usuario);
	public String obtenerNombre (User usuario);
	public boolean insertarUsuario(User usuario);
	public boolean borrarUsuario(User usuario);
	public boolean actualizarDinero(User usuario);
	public boolean obtenerStadisticas(User usuario);
	public boolean actualuizarStadisticas(User usuario);
	public boolean insertarJuego(Played played, User usuario, Play_On_Table table);
	public boolean insertarMesa(Play_On_Table table);
	public ArrayList<Played> obtenerHistorial(User usuario);
	public boolean repetirDNI(User usuario);
	public boolean obtenerID_DEALER(Dealer dealer);
	public boolean insertarDealer(Dealer dealer);
}
