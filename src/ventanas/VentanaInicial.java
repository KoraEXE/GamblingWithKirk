package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.Carta;
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

	public VentanaInicial(LoginControlador cont) {
		this.cont = cont;
		setTitle("Ventana Inicial");
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/Isr.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setExtendedState(JFrame.MAXIMIZED_BOTH); //pantalla completa
		setSize(2400, 1200); //para que se vea en el DESING (NO QUITAR)
		contentPane.setLayout(null);


		JLabel lblNewLabel = new JLabel("Casino");
		lblNewLabel.setBounds(950, 120, 800, 120);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 80));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		btnPlay = new JButton("Play");
		btnPlay.setBounds(1246, 556, 210, 60);
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnPlay);
		btnPlay.addActionListener(this);

		btnRegister = new JButton("Register");
		btnRegister.setBounds(1246, 467, 210, 60);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.addActionListener(this);
		contentPane.add(btnRegister);

		lblimagen = new ImageIcon("imagenes/D.jpg");
		JLabel lblImagen = new JLabel(new ImageIcon("imagenes/decepcioandoV3.png"));
		lblImagen.setBounds(0, 0, 765, 1062);
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblImagen);

		JLabel TextIniciarSesion = new JLabel("Iniciar Sesión:");
		TextIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		TextIniciarSesion.setBounds(1219, 404, 261, 52);
		TextIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(TextIniciarSesion);

		TextNombre = new JLabel("Nombre");
		TextNombre.setBounds(1030, 260, 158, 52);
		TextNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(TextNombre);

		TextContraseña = new JLabel("Contraseña");
		TextContraseña.setBounds(1030, 337, 158, 52);
		TextContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(TextContraseña);

		campoNombre = new JTextField();
		campoNombre.setBounds(1219, 264, 261, 52);
		campoNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(campoNombre);
		campoNombre.setColumns(10);

		campoContrasena = new JPasswordField();
		campoContrasena.setBounds(1219, 341, 261, 52);
		contentPane.add(campoContrasena);

		mostrarContrasena = new JCheckBox("See Password");
		mostrarContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mostrarContrasena.setBounds(1516, 341, 234, 48);
		mostrarContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(mostrarContrasena);
		mostrarContrasena.addActionListener(this);

		Hablar = new JLabel("");
		Hablar.setBounds(617, 63, 298, 73);
		Hablar.setHorizontalAlignment(SwingConstants.CENTER);
		Hablar.setFont(new Font("Microsoft YaHei Light", Font.ITALIC, 20));
		contentPane.add(Hablar);
		
		TextoExtra = new JLabel("Game developed by Kora, Martin, Enio and Aritz\r\n Try to dont lose all your money or soul");
		TextoExtra.setFont(new Font("Tahoma", Font.ITALIC, 16));
		TextoExtra.setBounds(1036, 627, 642, 142);
		contentPane.add(TextoExtra);
		
		nube = new JLabel("");
		nube.setIcon(new ImageIcon("imagenes/nube hablarV2.png"));
		nube.setBounds(617, 72, 298, 99);
		contentPane.add(nube);
		nube.setVisible(false);
		
		btnPlay.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	//cambiar la imagen del JLabel al pasar el mouse sobre el botón
		    	
		    	lblImagen.setIcon(new ImageIcon("imagenes/selecionandoV1.png"));
		        btnPlay.setText("LET'S WIN SOME MONEY");
		    	btnPlay.setBounds(1219, 555, 261, 60);
		    	nube.setVisible(false);
		    	Hablar.setText("");
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblImagen.setIcon(new ImageIcon("imagenes/decepcioandoV3.png"));
		    	btnPlay.setBounds(1246, 556, 210, 60);
		        btnPlay.setText("Play");		        
		    }
		});
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==btnRegister) {
			VentanaLogin vl=new VentanaLogin(cont);
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
			} else if (cont.comprobarUsuario(new User(campoNombre.getText(), new String(campoContrasena.getPassword())))) {
				dni = cont.obtenerDNI(new User(campoNombre.getText(), new String(campoContrasena.getPassword()))); //Obtiene el DNI del usuario para futuros usos
				elusuario.setDni(dni);
				elusuario.setName(usuario);
				elusuario.setPassword(String.valueOf(password));
				elusuario.setBalance(cont.obtenerDinero(new User(campoNombre.getText(), new String(campoContrasena.getPassword()))));
		

				Hablar.setText("Datos correctos");
				
				SelecionJuego v2=new SelecionJuego(cont, elusuario);		
				v2.setVisible(true);
				this.dispose();
			} else {
				nube.setVisible(true);
				Hablar.setText("Usuario no registrado");
			}
		}
	}
}
