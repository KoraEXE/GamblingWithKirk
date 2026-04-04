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

		final String SQL = "SELECT * FROM USERS WHERE USERNAME = ? AND PASWORD = ?";		
		final String sql1 = "SELECT * FROM USERS WHERE USERNAME = ?";
		final String sqlInsert = "INSERT INTO USERS VALUES (?,?)";
		final String SQLCONSULTA = "SELECT * FROM USERS";
		final String SQLBORRAR = "DELETE FROM USERS WHERE USERNAME=?";
		final String SQLMODIFICAR = "UPDATE USERS SET PASWORD=? WHERE USERNAME=?";

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

		@Override
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

		@Override
		public boolean insertarUsuario(User usuario) {
			// TODO Auto-generated method stub
			
			return false;
		}

		@Override
		public boolean borrarUsuario(User usuario) {
			// TODO Auto-generated method stub
			
			return false;
		}

		@Override
		public boolean modificarUsuario(User usuario) {
			// TODO Auto-generated method stub
			
			return false;
		}

		@Override
		public ArrayList<String> mostrarUsuario(User usuario) {
			// TODO Auto-generated method stub
			
			return null;
		}
}
