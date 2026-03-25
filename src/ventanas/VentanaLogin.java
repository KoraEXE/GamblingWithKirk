package ventanas;

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
	private JLabel lblNewLabel_1;
	private LoginControlador cont;
	private JComboBox comboBox;
	private JCheckBox mostrarContrasena;

	public VentanaLogin(LoginControlador controlador) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1dami.TARTANGALH\\Desktop\\IMG Reto 3 eva Kasinoa\\R.png"));
		this.cont=controlador;
		setTitle("Register");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		campoUsuario.setBounds(160, 86, 118, 19);
		contentPane.add(campoUsuario);
		campoUsuario.setColumns(10);

		campoContrasena = new JPasswordField();
		campoContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		campoContrasena.setBounds(160, 127, 118, 19);
		contentPane.add(campoContrasena);

		campoContrasenaVisible = new JTextField();
		campoContrasenaVisible.setFont(new Font("Tahoma", Font.PLAIN, 16));
		campoContrasenaVisible.setBounds(campoContrasena.getBounds());
		campoContrasenaVisible.setVisible(false);
		contentPane.add(campoContrasenaVisible);

		mostrarContrasena = new JCheckBox("See Password");
		mostrarContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		mostrarContrasena.setBounds(155, 152, 123, 15);
		contentPane.add(mostrarContrasena);
		mostrarContrasena.addActionListener(this);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(160, 209, 85, 21);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(this);

		JLabel lblNewLabel = new JLabel("User:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(57, 88, 97, 16);
		contentPane.add(lblNewLabel);

		JLabel Contarseña = new JLabel("Password:");
		Contarseña.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Contarseña.setBounds(57, 129, 97, 16);
		contentPane.add(Contarseña);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(78, 240, 274, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Register");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(160, 25, 92, 19);
		contentPane.add(lblNewLabel_2);

		ImageIcon lblimagen = new ImageIcon("C:\\Users\\1dami.TARTANGALH\\Desktop\\IMG Reto 3 eva Kasinoa/G.jpg");
		JLabel lblImagen = new JLabel(lblimagen);
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(288, 63, 138, 148);
		contentPane.add(lblImagen);

		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBalance.setBounds(57, 173, 97, 16);
		contentPane.add(lblBalance);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-- Select Import --","100","200","300","400","500","600","700","800","900","1000"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(160, 173, 118, 20);
		contentPane.add(comboBox);
		if (comboBox.getSelectedIndex() == 0) {
			lblNewLabel_1.setText("Selecciona un valor válido");
		} else {
			lblNewLabel_1.setText("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLogin) {

			String usuario = campoUsuario.getText();
			String password = campoContrasena.isVisible() ?/*Cambiar lambda*/ campoContrasena.getText() : campoContrasenaVisible.getText();

			if (usuario.equals("") || password.equals("") || comboBox.getSelectedIndex() == 0) {
				lblNewLabel_1.setText("Rellena todos los campos");
			} else {
				lblNewLabel_1.setText("Datos correctos");
				VentanaLogin vl=new VentanaLogin(cont);
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
