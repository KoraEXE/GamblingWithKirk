package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
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
	
	final String sqlInsPlayed = "INSERT INTO PLAYED VALUES (?,?,?,?,?,?,?)";
	final String sqlInsTablee = "INSERT INTO TABLEE VALUES (?,?)";

	final String SQLBORRAR = "DELETE FROM USERS WHERE DNI=?";
	final String sqlInsert = "INSERT INTO USERS VALUES (?,?,?,?,?,?,?)";
	final String sqlDinero = "SELECT BALANCE FROM USERS USERNAME = ? AND PASWORD = ?";
	final String sqlNombre = "SELECT USERNAME FROM USERS WHERE DNI = ?";
	final String SQL = "SELECT * FROM USERS WHERE USERNAME = ? AND PASWORD = ?";
	final String sqlDNI = "SELECT DNI FROM USERS WHERE USERNAME = ? AND PASWORD = ?"; //Para usarlo como ancla del usuario en el resto de ventanas hasta que decida des loggearse
	final String sqlObtenerStats = "SELECT TIMES_PLAYED, WINS, LOSSES, MAX_COMBO, TOTAL21S, TOTAL_LOSSES, TOTAL_WINS FROM USERS WHERE DNI = ?";
	final String sqlActualizarStats = "UPDATE USERS SET TIMES_PLAYED = ?, MAX_COMBO = ? WHERE DNI = ?";


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
	
	public boolean insertarJuego(Played played, User usuario, Play_On_Table table) {
		boolean bien = false;
		this.openConnection();
		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			LocalDateTime ahora = LocalDateTime.now();

	        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String fechaHora = ahora.format(formato);
			
			stmt = con.prepareStatement(sqlInsPlayed);
			stmt.setString(1, usuario.getDni());
			stmt.setString(2, table.getId_table());
			stmt.setDate(3, java.sql.Date.valueOf(fechaHora)); //Para pasar el String a LocalDate
			stmt.setString(4, played.getResult().name());

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
	
	public boolean insertarMesa(Play_On_Table table) {
		boolean bien = false;
		this.openConnection();
		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        String resultado = "";
	        Random random = new Random();

	        for (int i = 0; i < 10; i++) {
	            int indice = random.nextInt(caracteres.length());
	            resultado += caracteres.charAt(indice);
	        }
			stmt = con.prepareStatement(sqlInsTablee);
			stmt.setString(1, resultado.toUpperCase());
			stmt.setString(2,"BLACKJACK");

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
			stmt.setInt(5, 0);
			stmt.setInt(6, 0);
			stmt.setDouble(7, usuario.getBalance());

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
	
	public boolean actualuizarStadisticas(User usuario) {
	    boolean ok = false;
	    this.openConnection();

	    try {
	        stmt = con.prepareStatement(sqlActualizarStats);

	        stmt.setInt(1, usuario.getVecesJugadas());
	        stmt.setInt(2, usuario.getMaxCombo());
	        stmt.setString(3, usuario.getDni());
	        if (stmt.executeUpdate() > 0) {
	            ok = true;
	        }
	        stmt.close();
	        con.close();

	    } catch (SQLException e) {
	        System.out.println("Error al actualizar estadísticas: " + e.getMessage());
	    }

	    return ok;
	}

	public boolean obtenerStadisticas(User usuario) {
	    boolean ok = false;
	    this.openConnection();

	    try {
	        stmt = con.prepareStatement(sqlObtenerStats);
	        stmt.setString(1, usuario.getDni());
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            // 🔹 Guardas los datos en el objeto usuario
	            usuario.setVecesJugadas(rs.getInt("TIMES_PLAYED"));    	
	            usuario.setMaxCombo(rs.getInt("MAX_COMBO"));
	            ok = true;
	        }
	        rs.close();
	        stmt.close();
	        con.close();

	    } catch (SQLException e) {
	        System.out.println("Error al obtener estadísticas: " + e.getMessage());
	    }
	    return ok;
	}

	@Override
	public ArrayList<String> mostrarUsuario(User usuario) {
		// TODO Auto-generated method stub

		return null;
	}
}
