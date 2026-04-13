package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ImplementacionBD implements UsuarioDAO{
	// Atributos
	private Connection con;
	private PreparedStatement stmt;

	// Los siguientes atributos se utilizan para recoger los valores del fich de
	// configuraci n
	private ResourceBundle configFile;
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String passwordBD;

	// Sentencias SQL
	final String sql1 = "SELECT * FROM USERS WHERE USERNAME = ?";
	final String SQLCONSULTA = "SELECT * FROM USERS";


	// Sentencias SQL EnProceso
	final String sqlModDinero = "UPDATE USERS SET BALANCE = ? WHERE DNI = ?";
	final String sqlNomUsuario = "SELECT USERNAME USERS WHERE DNI = ?";


	// Sentencias SQL Fucionales

	final String SQLBORRAR = "DELETE FROM USERS WHERE DNI=?";
	final String sqlInsert = "INSERT INTO USERS VALUES (?,?,?,?,?)";
	final String sqlDinero = "SELECT BALANCE FROM USERS USERNAME = ? AND PASWORD = ?";
	final String sqlNombre = "SELECT USERNAME FROM USERS WHERE DNI = ?";
	final String SQL = "SELECT * FROM USERS WHERE USERNAME = ? AND PASWORD = ?";
	final String sqlDNI = "SELECT DNI FROM USERS WHERE USERNAME = ? AND PASWORD = ?"; //Para usarlo como ancla del usuario en el resto de ventanas hasta que decida des loggearse


	// Para la conexi n utilizamos un fichero de configuaraci n, config que
	// guardamos en el paquete control:
	public ImplementacionBD() {
		this.configFile = ResourceBundle.getBundle("modelo.configClase");
		this.driverBD = this.configFile.getString("Driver");
		this.urlBD = this.configFile.getString("Conn");
		this.userBD = this.configFile.getString("DBUser");
		this.passwordBD = this.configFile.getString("DBPass");
	}

	private void openConnection() {
		try {
			con = DriverManager.getConnection(urlBD, this.userBD, this.passwordBD);
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}

	public boolean comprobarUsuario(User usuario) {
		boolean existe = false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, usuario.getName());
			stmt.setString(2, usuario.getPassword());
			ResultSet resultado = stmt.executeQuery();
			// Si hay un resultado, el usuario existe
			if (resultado.next()) {
				existe = true;
			}
			resultado.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al verificar credenciales: " + e.getMessage());
		}
		return existe;
	}

	public String obtenerDNI(User usuario) {
		String dni = "";
		this.openConnection();
		try {
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, usuario.getName());
			stmt.setString(2, usuario.getPassword());
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				dni = resultado.getString("DNI"); 
			}
			resultado.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al verificar credenciales: " + e.getMessage());
		}
		return dni;
	}

	public String obtenerNombre(User usuario) {
		String nombre = "";
		this.openConnection();
		try {
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, usuario.getDni());
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				nombre = resultado.getString("nombre"); 
			}
			resultado.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al verificar credenciales: " + e.getMessage());
		}
		return nombre;
	}


	public int obtenerDinero(User usuario) {
		int dinero = 0;
		this.openConnection();
		try {
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, usuario.getName());
			stmt.setString(2, usuario.getPassword());
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				dinero = resultado.getInt("BALANCE"); 
			}
			resultado.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al verificar credenciales: " + e.getMessage());
		}
		return dinero;
	}

	public boolean insertarUsuario(User usuario) {
		boolean bien = false;
		this.openConnection();
		 try {
				// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente

				stmt = con.prepareStatement(sqlInsert);
				stmt.setString(1, usuario.getDni());
				stmt.setString(2, usuario.getName());
				stmt.setString(3, usuario.getPassword());
				stmt.setDate(4, java.sql.Date.valueOf(usuario.getDate_of_birth())); //Para pasar el Date a LocalDate
				stmt.setDouble(5, usuario.getBalance());
				if (stmt.executeUpdate() > 0) {
					bien = true;
				}
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al verificar credenciales: " + e.getMessage());
			}  
		return bien;
	}

	public boolean borrarUsuario(User usuario) {
		boolean ok = false;	
		this.openConnection();
		try {
		stmt = con.prepareStatement(SQLBORRAR);
		stmt.setString(1, usuario.getDni());
		if (stmt.executeUpdate() > 0) {
			ok = true;
			
		}
		stmt.close();
		con.close();
	} catch (SQLException e) {
		System.out.println("Error al verificar credenciales: " + e.getMessage());
	}  
		
		return ok;
	}
	
	public boolean actualizarDinero(User usuario) {
		boolean ok = false;	
		this.openConnection();
		try {
		stmt = con.prepareStatement(sqlModDinero);
		stmt.setDouble(1, usuario.getBalance());
		stmt.setString(2, usuario.getDni());
		if (stmt.executeUpdate() > 0) {
			ok = true;
		}
		stmt.close();
		con.close();
	} catch (SQLException e) {
		System.out.println("Error al verificar credenciales: " + e.getMessage());
	}  
		
		return ok;
	}

	@Override
	public ArrayList<String> mostrarUsuario(User usuario) {
		// TODO Auto-generated method stub

		return null;
	}
}
