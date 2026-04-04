package ventanas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
	private JComboBox comboBox;
	private JCheckBox mostrarContrasena;

	public VentanaLogin(LoginControlador controlador) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/R.png"));
		this.cont=controlador;
		setTitle("Register");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		this.setLocation(0, 0);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 24));
		campoUsuario.setBounds(852, 296, 206, 35);
		contentPane.add(campoUsuario);
		campoUsuario.setColumns(10);

		campoContrasena = new JPasswordField();
		campoContrasena.setFont(new Font("Tahoma", Font.PLAIN, 24));
		campoContrasena.setBounds(852, 342, 206, 35);
		contentPane.add(campoContrasena);

		campoContrasenaVisible = new JTextField();
		campoContrasenaVisible.setFont(new Font("Tahoma", Font.PLAIN, 16));
		campoContrasenaVisible.setBounds(campoContrasena.getBounds());
		campoContrasenaVisible.setVisible(false);
		contentPane.add(campoContrasenaVisible);

		mostrarContrasena = new JCheckBox("See Password");
		mostrarContrasena.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mostrarContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		mostrarContrasena.setBounds(1089, 342, 138, 31);
		contentPane.add(mostrarContrasena);
		mostrarContrasena.addActionListener(this);

		JLabel TextUsuario = new JLabel("User:");
		TextUsuario.setFont(new Font("Tahoma", Font.PLAIN, 24));
		TextUsuario.setBounds(697, 293, 138, 40);
		contentPane.add(TextUsuario);

		JLabel TextContarseña = new JLabel("Password:");
		TextContarseña.setFont(new Font("Tahoma", Font.PLAIN, 24));
		TextContarseña.setBounds(697, 339, 138, 40);
		contentPane.add(TextContarseña);

		TextRespuesta = new JLabel("");
		TextRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		TextRespuesta.setBounds(519, 454, 274, 35);
		contentPane.add(TextRespuesta);

		JLabel TextRegistrar = new JLabel("Register");
		TextRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		TextRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 60));
		TextRegistrar.setBounds(775, 162, 354, 82);
		contentPane.add(TextRegistrar);

		ImageIcon lblimagen = new ImageIcon("imagenes/G.jpg");
		JLabel lblImagen = new JLabel(lblimagen);
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(795, 499, 325, 314);
		contentPane.add(lblImagen);

		JLabel TextBalance = new JLabel("Balance:");
		TextBalance.setFont(new Font("Tahoma", Font.PLAIN, 24));
		TextBalance.setBounds(697, 390, 138, 40);
		contentPane.add(TextBalance);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-- Select Import --","100","200","300","400","500","600","700","800","900","1000"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(852, 388, 206, 31);
		contentPane.add(comboBox);
		
				btnLogin = new JButton("Login");
				btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
				btnLogin.setBounds(836, 454, 241, 35);
				contentPane.add(btnLogin);
				btnLogin.addActionListener(this);
		if (comboBox.getSelectedIndex() == 0) {
			TextRespuesta.setText("Selecciona un valor válido");
		} else {
			TextRespuesta.setText("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLogin) {

			String usuario = campoUsuario.getText();
			String password;
			if (campoContrasena.isVisible()) {
			    password = campoContrasena.getText();
			} else {
			    password = campoContrasenaVisible.getText();
			}


			if (usuario.equals("") || password.equals("") || comboBox.getSelectedIndex() == 0) {
				TextRespuesta.setText("Rellena todos los campos");
			} else {
				TextRespuesta.setText("Datos correctos");
				VentanaInicial vl=new VentanaInicial(cont);
				vl.setVisible(true);
				this.dispose();
				// aquí llamar al controlador		    
			} 
		}

		if (e.getSource() == mostrarContrasena) {
			boolean mostrar = mostrarContrasena.isSelected();
			campoContrasenaVisible.setText(campoContrasena.getText());
			campoContrasenaVisible.setVisible(mostrar);
			campoContrasena.setVisible(!mostrar);
		}
	}
}
