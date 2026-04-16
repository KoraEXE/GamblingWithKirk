package modelo;

import java.sql.CallableStatement;
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
	
	final String sqlIdDealer = "SELECT * FROM DEALER WHERE ID_DEALER = ?"; //Para leer el dealer
	
	final String sqlInsPlayed = "INSERT INTO PLAYED VALUES (?,?,?,?,?)";
	final String sqlInsTablee = "INSERT INTO TABLEE VALUES (?,?)";
	
	final String SQLBORRAR = "DELETE FROM USERS WHERE DNI=?";
	final String SQLBORRAR2 = "DELETE FROM PLAYED WHERE DNI = '123'";
	final String sqlInsert = "INSERT INTO USERS VALUES (?,?,?,?,?,?,?)";
	final String sqlDinero = "SELECT BALANCE FROM USERS USERNAME = ? AND PASWORD = ?";
	final String sqlNombre = "SELECT USERNAME FROM USERS WHERE DNI = ?";
	final String SQL = "SELECT * FROM USERS WHERE USERNAME = ? AND PASWORD = ?";
	final String SQLDNI = "SELECT * FROM USERS WHERE DNI = ?";
	final String sqlDNI = "SELECT DNI FROM USERS WHERE USERNAME = ? AND PASWORD = ?"; //Para usarlo como ancla del usuario en el resto de ventanas hasta que decida deslogearse
	final String sqlObtenerStats = "SELECT TIMES_PLAYED, MAX_COMBO FROM USERS WHERE DNI = ?";
	final String sqlObtenerHistorial = "SELECT U.TIMES_PLAYED, U.MAX_COMBO, P.GAME_DATE, P.BET, P.RESULT " + "FROM USERS U " + "JOIN PLAYED P ON U.DNI = P.DNI " + "WHERE U.DNI = ?";
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
	
	public boolean insertarDealer(Dealer dealer) {
		boolean bien = false;
		this.openConnection();
	    try {
	        CallableStatement stmt = con.prepareCall("{CALL add_dealers(?, ?, ?)}");

	        stmt.setString(1, dealer.getID_Dealer());
	        stmt.setString(2, dealer.getName());
	        stmt.setDouble(3, 1000.00);

	        if (stmt.executeUpdate() > 0) {
				bien = true;
			}

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return bien;
	}
	
	public boolean insertarJuego(Played played, User usuario, Play_On_Table table) {
		
		boolean bien = false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(sqlInsPlayed);
			stmt.setString(1, usuario.getDni());
			stmt.setString(2, table.getId_table());
			stmt.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
			stmt.setInt(4, played.getApuestaEnJuego());
			stmt.setString(5, played.getResult().name());

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
			stmt = con.prepareStatement(sqlInsTablee);
			stmt.setString(1, table.getId_table());
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
			stmt = con.prepareStatement(sqlDNI);
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
	
	public boolean obtenerID_DEALER(Dealer dealer) {
		boolean existe = false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(sqlIdDealer);
			stmt.setString(1, dealer.getID_Dealer());
			ResultSet resultado = stmt.executeQuery();
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
	
	public boolean repetirDNI(User usuario) {
		boolean existe = false;
		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLDNI);
			stmt.setString(1, usuario.getDni());
			ResultSet resultado = stmt.executeQuery();
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
	
	public ArrayList<Played> obtenerHistorial(User usuario) {
	    ArrayList<Played> lista = new ArrayList<>();
	    this.openConnection();

	    try {
	        stmt = con.prepareStatement(sqlObtenerHistorial);
	        stmt.setString(1, usuario.getDni());
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Played p = new Played();

	            p.setDate(rs.getTimestamp("GAME_DATE"));
	            p.setApuestaEnJuego(rs.getInt("BET"));
	            p.setResult(Result.valueOf(rs.getString("RESULT")));

	            lista.add(p);
	        }
	        rs.close();
	        stmt.close();
	        con.close();

	    } catch (SQLException e) {
	        System.out.println("Error: " + e.getMessage());
	    }

	    return lista;
	}

	@Override
	public ArrayList<String> mostrarUsuario(User usuario) {
		// TODO Auto-generated method stub

		return null;
	}
}
