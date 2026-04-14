package ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.MenorDeEdadException;
import modelo.User;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import java.awt.Toolkit;

public class VentanaLogin extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoUsuario;
	private JPasswordField campoContrasena;
	private JTextField campoContrasenaVisible;
	private JButton btnLogin;
	private JLabel TextRespuesta;
	private LoginControlador cont;
	private JComboBox<?> comboBox;
	private JCheckBox mostrarContrasena;
	private User elusuario;
	private JTextField campoDNI;
	private JTextField campoFechaNacimiento;
	private JButton btnRegresar;

	public VentanaLogin(LoginControlador controlador, User elusuario) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/R.png"));
		this.cont=controlador;
		this.elusuario=elusuario;
		setTitle("Register");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setSize(1536, 864);
		this.setLocation(0, 0);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 24));
		campoUsuario.setBounds(658, 296, 206, 35);
		contentPane.add(campoUsuario);
		campoUsuario.setColumns(10);

		campoContrasena = new JPasswordField();
		campoContrasena.setFont(new Font("Tahoma", Font.PLAIN, 24));
		campoContrasena.setBounds(658, 342, 206, 35);
		contentPane.add(campoContrasena);

		campoContrasenaVisible = new JTextField();
		campoContrasenaVisible.setFont(new Font("Tahoma", Font.PLAIN, 16));
		campoContrasenaVisible.setBounds(campoContrasena.getBounds());
		campoContrasenaVisible.setVisible(false);
		contentPane.add(campoContrasenaVisible);

		mostrarContrasena = new JCheckBox("See Password");
		mostrarContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mostrarContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		mostrarContrasena.setBounds(870, 346, 196, 31);
		contentPane.add(mostrarContrasena);
		mostrarContrasena.addActionListener(this);

		JLabel TextUsuario = new JLabel("User:");
		TextUsuario.setFont(new Font("Tahoma", Font.PLAIN, 24));
		TextUsuario.setBounds(510, 293, 138, 40);
		contentPane.add(TextUsuario);

		JLabel TextContarseña = new JLabel("Password:");
		TextContarseña.setFont(new Font("Tahoma", Font.PLAIN, 24));
		TextContarseña.setBounds(510, 339, 138, 40);
		contentPane.add(TextContarseña);

		TextRespuesta = new JLabel("");
		TextRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		TextRespuesta.setBounds(354, 491, 274, 35);
		contentPane.add(TextRespuesta);

		JLabel TextRegistrar = new JLabel("Register");
		TextRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		TextRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 60));
		TextRegistrar.setBounds(584, 139, 354, 82);
		contentPane.add(TextRegistrar);

		ImageIcon lblimagen = new ImageIcon("imagenes/G.jpg");
		JLabel lblImagen = new JLabel(lblimagen);
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(599, 564, 325, 314);
		contentPane.add(lblImagen);

		JLabel TextBalance = new JLabel("Balance:");
		TextBalance.setFont(new Font("Tahoma", Font.PLAIN, 24));
		TextBalance.setBounds(510, 430, 138, 40);
		contentPane.add(TextBalance);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-- Select Import --","100","200","300","400","500","600","700","800","900","1000"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(658, 434, 206, 31);
		contentPane.add(comboBox);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogin.setBounds(640, 491, 241, 35);
		contentPane.add(btnLogin);

		JLabel TextDNI = new JLabel("DNI:");
		TextDNI.setFont(new Font("Tahoma", Font.PLAIN, 24));
		TextDNI.setBounds(510, 247, 138, 40);
		contentPane.add(TextDNI);

		campoDNI = new JTextField();
		campoDNI.setFont(new Font("Tahoma", Font.PLAIN, 24));
		campoDNI.setColumns(10);
		campoDNI.setBounds(658, 250, 206, 35);
		contentPane.add(campoDNI);

		JLabel TextFechaNacimiento = new JLabel("Birth Date:");
		TextFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 24));
		TextFechaNacimiento.setBounds(510, 389, 138, 40);
		contentPane.add(TextFechaNacimiento);

		campoFechaNacimiento = new JTextField();
		campoFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 24));
		campoFechaNacimiento.setColumns(10);
		campoFechaNacimiento.setBounds(658, 388, 206, 35);
		contentPane.add(campoFechaNacimiento);
		
		btnRegresar = new JButton("Go Back");
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegresar.setBounds(640, 536, 241, 35);
		contentPane.add(btnRegresar);
		
		btnLogin.addActionListener(this);
		btnRegresar.addActionListener(this);

		if (comboBox.getSelectedIndex() == 0) {
			TextRespuesta.setText("Selecciona un valor válido");
		} else {
			TextRespuesta.setText("");
		}
	}
	
	 public void comprobarMayorEdad(LocalDate fechaNacimiento) throws MenorDeEdadException {

	        LocalDate hoy = LocalDate.now();

	        LocalDate fechaMas18 = fechaNacimiento.plusYears(18);

	        if (fechaMas18.isAfter(hoy)) {
	            throw new MenorDeEdadException("El usuario es menor de edad");
	        }
	    }

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == mostrarContrasena) {
			if (mostrarContrasena.isSelected()) {
				// (char)0 significa "sin máscara", muestra el texto real
				campoContrasena.setEchoChar((char) 0); 
			} else {
				// Restablece el punto negro o asterisco
				campoContrasena.setEchoChar('●'); 
			}
		}

		if (e.getSource() == btnLogin) {

			if (campoDNI.equals("") || campoUsuario.equals("") || comboBox.getSelectedIndex() == 0  || campoContrasena.equals("") || campoFechaNacimiento.equals("")) {
				TextRespuesta.setText("Rellena todos los campos");
			} else if (campoDNI.getText().matches("^[0-9]{8}[A-Z]$")) {
				LocalDate fechas;
				String fecha = campoFechaNacimiento.getText();

				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				try {
					fechas = LocalDate.parse(fecha, formato);

		            comprobarMayorEdad(fechas);

		            JOptionPane.showMessageDialog(null, "Usuario válido, es mayor de edad");

		        } catch (DateTimeParseException ex) {
		            JOptionPane.showMessageDialog(null, "Formato incorrecto (dd/MM/yyyy)");

		        } catch (MenorDeEdadException ex) {
		            JOptionPane.showMessageDialog(null, ex.getMessage());
		        }
				
				fechas = LocalDate.parse(fecha, formato);
				int cantidad = 0;
				
				if (comboBox.getSelectedIndex() == 1) {
					cantidad = 100;
				} else if (comboBox.getSelectedIndex() == 2) {
					cantidad = 200;
				} else if (comboBox.getSelectedIndex() == 3) {
					cantidad = 300;
				} else if (comboBox.getSelectedIndex() == 4) {
					cantidad = 400;
				} else if (comboBox.getSelectedIndex() == 5) {
					cantidad = 500;
				} else if (comboBox.getSelectedIndex() == 6) {
					cantidad = 600;
				} else if (comboBox.getSelectedIndex() == 7) {
					cantidad = 700;
				} else if (comboBox.getSelectedIndex() == 8) {
					cantidad = 800;
				} else if (comboBox.getSelectedIndex() == 9) {
					cantidad = 900;
				} else if (comboBox.getSelectedIndex() == 10) {
					cantidad = 1000;
				}
				
				elusuario.setDni(campoDNI.getText());
				elusuario.setName(campoUsuario.getText());
				elusuario.setPassword(String.valueOf(campoContrasena.getPassword()));
				elusuario.setBalance(cantidad = 1000);
				elusuario.setDate_of_birth(fechas);
				
				cont.insertarUsuario(elusuario);
				TextRespuesta.setText("Datos correctos");

				VentanaInicial vl=new VentanaInicial(cont);
				vl.setVisible(true);
				this.dispose();
				// aquí llamar al controlador		    
			} else {
				 JOptionPane.showMessageDialog(null, "Formato incorrecto Ejem: (0000000A) ");
			}
		}
		

		if (e.getSource() == mostrarContrasena) {
			boolean mostrar = mostrarContrasena.isSelected();
			campoContrasenaVisible.setText(campoContrasena.getText());
			campoContrasenaVisible.setVisible(mostrar);
			campoContrasena.setVisible(!mostrar);
		}
		
		if (e.getSource() == btnRegresar) {
			VentanaInicial vl=new VentanaInicial(cont);
			vl.setVisible(true);
			this.dispose();
		}
	}
}
