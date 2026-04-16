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
import javax.swing.JOptionPane;
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
import javax.swing.JDialog;

//Prueba
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Color;

public class VentanaAdmin extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LoginControlador cont;
	private JButton btnLogin;
	private JLabel TextNombre;
	private JTextField campoID_DEALER;
	private JButton btnAccion;
	private JLabel lblNewLabel;
	private JLabel textDealerId;
	private JTextField campoIdDealer;
	private JLabel textNombreDealer;
	private JTextField campoNombreDealer;
	private Dealer dealer;

	public VentanaAdmin(LoginControlador cont, Dealer dealer) {

		cont = new LoginControlador();
		this.dealer = dealer;
		this.cont = cont;
		setTitle("Ventana Inicial");
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/Isr.jpg"));
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		getContentPane().setLayout(new BorderLayout());
		this.setSize(1536, 864);
		this.setLocation(0, 0);
		contentPane.setLayout(null);

		JLabel lblAdminText = new JLabel("Admin");
		lblAdminText.setForeground(new Color(255, 255, 255));
		lblAdminText.setBounds(730, 122, 800, 120);
		lblAdminText.setFont(new Font("Tahoma", Font.PLAIN, 80));
		lblAdminText.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAdminText);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(1042, 388, 210, 60);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnLogin);
		btnLogin.addActionListener(this);

		JLabel TextIniciarSesion = new JLabel("Iniciar Sesión:");
		TextIniciarSesion.setForeground(new Color(255, 255, 255));
		TextIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		TextIniciarSesion.setBounds(1015, 326, 261, 52);
		TextIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(TextIniciarSesion);

		TextNombre = new JLabel("Dealer ID:");
		TextNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		TextNombre.setForeground(new Color(255, 255, 255));
		TextNombre.setBounds(830, 264, 158, 52);
		TextNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(TextNombre);

		campoID_DEALER = new JTextField();
		campoID_DEALER.setBounds(1015, 264, 261, 52);
		campoID_DEALER.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(campoID_DEALER);
		campoID_DEALER.setColumns(10);
		
		btnAccion = new JButton("Añadir Admin nuevo");
		btnAccion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAccion.setBounds(386, 450, 349, 60);
		contentPane.add(btnAccion);
		btnAccion.setVisible(false);
		
		textDealerId = new JLabel("New Dealer ID:");
		textDealerId.setHorizontalAlignment(SwingConstants.RIGHT);
		textDealerId.setForeground(Color.WHITE);
		textDealerId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textDealerId.setBounds(149, 231, 230, 52);
		contentPane.add(textDealerId);
		textDealerId.setVisible(false);
		
		campoIdDealer = new JTextField();
		campoIdDealer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		campoIdDealer.setColumns(10);
		campoIdDealer.setBounds(425, 235, 261, 52);
		contentPane.add(campoIdDealer);
		campoIdDealer.setVisible(false);
	
		
		textNombreDealer = new JLabel("New Dealer Name:");
		textNombreDealer.setHorizontalAlignment(SwingConstants.RIGHT);
		textNombreDealer.setForeground(Color.WHITE);
		textNombreDealer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNombreDealer.setBounds(149, 304, 230, 52);
		contentPane.add(textNombreDealer);
		textNombreDealer.setVisible(false);
		
		campoNombreDealer = new JTextField();
		campoNombreDealer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		campoNombreDealer.setColumns(10);
		campoNombreDealer.setBounds(425, 304, 261, 52);
		contentPane.add(campoNombreDealer);
		campoNombreDealer.setVisible(false);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondoooo1.png"));
		lblNewLabel.setBounds(-48, 0, 1636, 845);
		contentPane.add(lblNewLabel);

	}		
	


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLogin) {
			dealer.setID_Dealer(campoID_DEALER.getText());
			if (cont.obtenerID_DEALER(dealer)) {
				btnAccion.setVisible(true);
				campoNombreDealer.setVisible(true);
				campoIdDealer.setVisible(true);
				textNombreDealer.setVisible(true);
				textDealerId.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "ID incorrecto");
			}
		}	
		
		if (e.getSource() == btnAccion) {
			String id = "";
			if (campoIdDealer.getText().matches("^[0-9]{4}[A-Z]{2}")) {
				id = "DEAL" + campoIdDealer.getText().toUpperCase();
			}
			dealer.setID_Dealer(id);
			if (!cont.obtenerID_DEALER(dealer)) {
				btnAccion.setVisible(true);
				campoNombreDealer.setVisible(true);
				campoIdDealer.setVisible(true);
				textNombreDealer.setVisible(true);
				textDealerId.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "ID incorrecto");
			}
		}	
		
		
		
	}
}

