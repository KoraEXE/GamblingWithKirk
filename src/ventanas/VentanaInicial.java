package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JPasswordField campoContrasena;
	private JCheckBox mostrarContrasena;
	private JTextField campoContrasenaVisible;
	private JLabel lblNewLabel_4;


	public VentanaInicial() {
		setTitle("Ventana Inicial");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1dami.TARTANGALH\\Desktop\\IMG Reto 3 eva Kasinoa\\Isr.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Casino");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(143, 0, 156, 47);
		contentPane.add(lblNewLabel);

		btnPlay = new JButton("Play");
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPlay.setBounds(287, 85, 97, 32);
		contentPane.add(btnPlay);
		btnPlay.addActionListener(this);
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.addActionListener(this);
		btnRegister.setBounds(270, 145, 130, 32);
		contentPane.add(btnRegister);

		ImageIcon lblimagen = new ImageIcon("C:\\Users\\1dami.TARTANGALH\\Desktop\\IMG Reto 3 eva Kasinoa/D.jpg");
		JLabel lblImagen = new JLabel(lblimagen);
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(0, 40, 260, 194);
		contentPane.add(lblImagen);

		JLabel lblNewLabel_1 = new JLabel("Iniciar Sesión:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 239, 71, 13);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(91, 239, 61, 13);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Contraseña");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(261, 239, 71, 13);
		contentPane.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(142, 236, 96, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		campoContrasena = new JPasswordField();
		campoContrasena.setBounds(326, 236, 100, 19);
		contentPane.add(campoContrasena);
		
		mostrarContrasena = new JCheckBox("See Password");
		mostrarContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		mostrarContrasena.setBounds(277, 193, 123, 15);
		contentPane.add(mostrarContrasena);
		mostrarContrasena.addActionListener(this);

		campoContrasenaVisible = new JTextField();
		campoContrasenaVisible.setFont(new Font("Tahoma", Font.PLAIN, 16));
		campoContrasenaVisible.setBounds(campoContrasena.getBounds());
		campoContrasenaVisible.setVisible(false);
		contentPane.add(campoContrasenaVisible);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(287, 214, 139, 12);
		contentPane.add(lblNewLabel_4);
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
			boolean mostrar = mostrarContrasena.isSelected();
			campoContrasenaVisible.setText(campoContrasena.getText());
			campoContrasenaVisible.setVisible(mostrar);
			campoContrasena.setVisible(!mostrar);
		}
		if (e.getSource() == btnPlay) {

			String usuario = textField.getText();
			String password = campoContrasena.isVisible() ? campoContrasena.getText() : campoContrasenaVisible.getText();

			if (usuario.equals("") || password.equals("")) {
				lblNewLabel_4.setText("Rellena todos los campos");
			} else {
				lblNewLabel_4.setText("Datos correctos");
				// aquí llamar al controlador		    
			}
		}
	}
}