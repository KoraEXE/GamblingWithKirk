package ventanas;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;


public class VentanaEstadisticas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LoginControlador cont;
	private User elusuario;
	
	public VentanaEstadisticas(LoginControlador controlador, User elusuario) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/R.png"));
		this.cont=controlador;
		this.elusuario=elusuario;
		setTitle("Stats");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("STATS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTitulo.setBounds(573, 86, 374, 87);
		contentPane.add(lblTitulo);
		
		JLabel lblDato1 = new JLabel("Veces que has Jugado:");
		lblDato1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDato1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato1.setBounds(417, 216, 267, 25);
		contentPane.add(lblDato1);
		
		JLabel lblDato2 = new JLabel("Veces que has ganado:");
		lblDato2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDato2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato2.setBounds(417, 252, 267, 25);
		contentPane.add(lblDato2);
		
		JLabel lblDato3 = new JLabel("Veces que has perdido:");
		lblDato3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDato3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato3.setBounds(417, 288, 267, 25);
		contentPane.add(lblDato3);
		
		JLabel lblDato4 = new JLabel("Racha maxima de combos:");
		lblDato4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDato4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato4.setBounds(417, 324, 267, 25);
		contentPane.add(lblDato4);
		
		JLabel lblDato5 = new JLabel("Numero total de 21s:");
		lblDato5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDato5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato5.setBounds(417, 360, 267, 25);
		contentPane.add(lblDato5);
		
		JLabel lblDato7 = new JLabel("Dinero total ganado:");
		lblDato7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDato7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato7.setBounds(417, 432, 267, 25);
		contentPane.add(lblDato7);
		
		JLabel lblDato6 = new JLabel("Dinero total perdido:");
		lblDato6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDato6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato6.setBounds(417, 396, 267, 25);
		contentPane.add(lblDato6);
		
		JLabel Dato1 = new JLabel("");
		Dato1.setHorizontalAlignment(SwingConstants.LEFT);
		Dato1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Dato1.setBounds(694, 216, 190, 25);
		contentPane.add(Dato1);
		
		JLabel Dato2 = new JLabel("");
		Dato2.setHorizontalAlignment(SwingConstants.LEFT);
		Dato2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Dato2.setBounds(694, 252, 190, 25);
		contentPane.add(Dato2);
		
		JLabel Dato3 = new JLabel("");
		Dato3.setHorizontalAlignment(SwingConstants.LEFT);
		Dato3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Dato3.setBounds(694, 288, 190, 25);
		contentPane.add(Dato3);
		
		JLabel Dato4 = new JLabel("");
		Dato4.setHorizontalAlignment(SwingConstants.LEFT);
		Dato4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Dato4.setBounds(694, 324, 190, 25);
		contentPane.add(Dato4);
		
		JLabel Dato5 = new JLabel("");
		Dato5.setHorizontalAlignment(SwingConstants.LEFT);
		Dato5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Dato5.setBounds(694, 360, 190, 25);
		contentPane.add(Dato5);
		
		JLabel Dato6 = new JLabel("");
		Dato6.setHorizontalAlignment(SwingConstants.LEFT);
		Dato6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Dato6.setBounds(694, 396, 190, 25);
		contentPane.add(Dato6);
		
		JLabel Dato7 = new JLabel("");
		Dato7.setHorizontalAlignment(SwingConstants.LEFT);
		Dato7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Dato7.setBounds(694, 432, 190, 25);
		contentPane.add(Dato7);
		this.setSize(1536, 864);
		this.setLocation(0, 0);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
