package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.Carta;
import modelo.Dealer;
import modelo.Play_On_Table;
import modelo.Played;
import modelo.User;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox; 

//Prueba
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;

public class VentanaInicial extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LoginControlador cont;
	private JButton btnPlay;
	private JButton btnRegister;
	private JLabel TextNombre;
	private JLabel TextContraseña;
	private JTextField campoNombre;
	private JPasswordField campoContrasena;
	private JCheckBox mostrarContrasena;
	private JLabel Hablar;
	private JLabel TextoExtra;
	private ImageIcon lblimagen;
	private JLabel nube;
	private User elusuario = new User();
	private Dealer dealer = new Dealer();
	private Play_On_Table table = new Play_On_Table();
	private Played played = new Played();
	private JLabel lblNewLabel_1;
	private JButton btnAdmin;

	public VentanaInicial(LoginControlador cont) {
		
		cont = new LoginControlador();
		this.cont = cont;
		setTitle("Ventana Inicial");
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/Isr.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(2400, 1200); //para que se vea en el DESING (NO QUITAR)
		this.setExtendedState(6); //pantalla completa 
		contentPane.setLayout(null);
		
		btnAdmin = new JButton("Admin");
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdmin.setBounds(50, 753, 210, 60);
		contentPane.add(btnAdmin);
		btnAdmin.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("Casino");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(730, 122, 800, 120);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 80));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		btnPlay = new JButton("Play");
		btnPlay.setBounds(1045, 557, 210, 60);
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnPlay);
		btnPlay.addActionListener(this);

		btnRegister = new JButton("Register");
		btnRegister.setBounds(1045, 487, 210, 60);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.addActionListener(this);
		contentPane.add(btnRegister);

		lblimagen = new ImageIcon("imagenes/D.jpg");
		JLabel lblImagen = new JLabel(new ImageIcon("imagenes/decepcioandoV3.png"));
		lblImagen.setBounds(72, 0, 765, 1062);
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblImagen);

		JLabel TextIniciarSesion = new JLabel("Iniciar Sesión:");
		TextIniciarSesion.setForeground(new Color(255, 255, 255));
		TextIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		TextIniciarSesion.setBounds(1015, 425, 261, 52);
		TextIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(TextIniciarSesion);

		TextNombre = new JLabel("Nombre");
		TextNombre.setForeground(new Color(255, 255, 255));
		TextNombre.setBounds(847, 264, 158, 52);
		TextNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(TextNombre);

		TextContraseña = new JLabel("Contraseña");
		TextContraseña.setForeground(new Color(255, 255, 255));
		TextContraseña.setBounds(847, 341, 158, 52);
		TextContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(TextContraseña);

		campoNombre = new JTextField();
		campoNombre.setBounds(1015, 264, 261, 52);
		campoNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(campoNombre);
		campoNombre.setColumns(10);

		campoContrasena = new JPasswordField();
		campoContrasena.setBounds(1015, 341, 261, 52);
		contentPane.add(campoContrasena);

		mostrarContrasena = new JCheckBox("See Password");
		mostrarContrasena.setBackground(new Color(240, 240, 240));
		mostrarContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mostrarContrasena.setBounds(1282, 343, 234, 48);
		mostrarContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(mostrarContrasena);
		mostrarContrasena.addActionListener(this);

		Hablar = new JLabel("");
		Hablar.setForeground(new Color(255, 255, 255));
		Hablar.setBounds(617, 63, 298, 73);
		Hablar.setHorizontalAlignment(SwingConstants.CENTER);
		Hablar.setFont(new Font("Microsoft YaHei Light", Font.ITALIC, 20));
		contentPane.add(Hablar);

		TextoExtra = new JLabel("Game developed by Kora, Martin, Enio and Aritz\r\n Try to dont lose all your money or soul");
		TextoExtra.setForeground(new Color(255, 255, 255));
		TextoExtra.setFont(new Font("Tahoma", Font.ITALIC, 16));
		TextoExtra.setBounds(822, 727, 642, 142);
		contentPane.add(TextoExtra);

		nube = new JLabel("");
		nube.setIcon(new ImageIcon("imagenes/nube hablarV2.png"));
		nube.setBounds(617, 72, 298, 99);
		contentPane.add(nube);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("imagenes/main page.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel_1);
		nube.setVisible(false);

		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//cambiar la imagen del JLabel al pasar el mouse sobre el botón

				lblImagen.setIcon(new ImageIcon("imagenes/selecionandoV1.png"));
				btnPlay.setText("LET'S WIN SOME MONEY");
				btnPlay.setBounds(1018, 557, 261, 60);
				nube.setVisible(false);
				Hablar.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblImagen.setIcon(new ImageIcon("imagenes/decepcioandoV3.png"));
				btnPlay.setBounds(1045, 557, 210, 60);
				btnPlay.setText("Play");		        
			}
		});
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource()==btnAdmin) {
			VentanaAdmin vl=new VentanaAdmin(cont, dealer);
			vl.setVisible(true);
			this.dispose();
		}

		if(e.getSource()==btnRegister) {
			VentanaLogin vl=new VentanaLogin(cont, elusuario);
			vl.setVisible(true);
			this.dispose();
		}
		if (e.getSource() == mostrarContrasena) {
			if (mostrarContrasena.isSelected()) {
				// (char)0 significa "sin máscara", muestra el texto real
				campoContrasena.setEchoChar((char) 0); 
			} else {
				// Restablece el punto negro o asterisco
				campoContrasena.setEchoChar('●'); 
			}
		}

		if (e.getSource() == btnPlay) {
			String dni;
			String usuario = campoNombre.getText();
			char[] password = null;
			if (campoContrasena.isVisible()) {
				password = campoContrasena.getPassword();
			}
			if (usuario.equals("") || password.equals("")) {
				nube.setVisible(true);
				Hablar.setText("Rellena todos los campos");
			} else {

			
				password = campoContrasena.getPassword();
				elusuario.setName(usuario);
				elusuario.setPassword(String.valueOf(password));


				if (cont.comprobarUsuario(elusuario)) {
					
					dni = cont.obtenerDNI(elusuario); //Obtiene el DNI del usuario para futuros usos
					elusuario.setDni(dni);					
					elusuario.setBalance(cont.obtenerDinero(elusuario));
					Hablar.setText("Datos correctos");
					SelecionJuego v2=new SelecionJuego(cont, elusuario, table, played);		
					v2.setVisible(true);
					this.dispose();
				} else {
					nube.setVisible(true);
					Hablar.setText("Usuario no registrado");
				}
			}
		}
	}
}

