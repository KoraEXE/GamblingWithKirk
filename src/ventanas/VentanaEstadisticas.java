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
import javax.swing.JButton;
import ventanas.VentanaBlackJack;


public class VentanaEstadisticas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LoginControlador cont;
	private User elusuario;
	private JLabel lblTitulo;
	private JLabel lblDato1;
	private JLabel lblDato2;
	private JLabel lblDato3;
	private JLabel lblDato4;
	private JLabel lblDato5;
	private JLabel lblDato6;
	private JLabel lblDato7;
	private JLabel Dato1;
	private JLabel Dato2;
	private JLabel Dato3;
	private JLabel Dato4;
	private JLabel Dato5;
	private JLabel Dato6;
	private JLabel Dato7;
	private JButton btnVolver;
	
	
	public VentanaEstadisticas(LoginControlador cont, User elusuario) {
		cont = new LoginControlador();
		this.cont = cont;
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/R.png"));
		this.elusuario=elusuario;
		setTitle("Stats");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel("STATS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTitulo.setBounds(573, 86, 374, 87);
		contentPane.add(lblTitulo);
		
		lblDato1 = new JLabel("Veces que has Jugado:");
		lblDato1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDato1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato1.setBounds(417, 216, 267, 25);
		contentPane.add(lblDato1);
		
		lblDato2 = new JLabel("Veces que has ganado:");
		lblDato2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDato2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato2.setBounds(417, 252, 267, 25);
		contentPane.add(lblDato2);
		
		lblDato3 = new JLabel("Veces que has perdido:");
		lblDato3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDato3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato3.setBounds(417, 288, 267, 25);
		contentPane.add(lblDato3);
		
		lblDato4 = new JLabel("Racha maxima de combos:");
		lblDato4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDato4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato4.setBounds(417, 324, 267, 25);
		contentPane.add(lblDato4);
		
		lblDato5 = new JLabel("Numero total de 21s:");
		lblDato5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDato5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato5.setBounds(417, 360, 267, 25);
		contentPane.add(lblDato5);
		
		lblDato7 = new JLabel("Dinero total ganado:");
		lblDato7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDato7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato7.setBounds(417, 432, 267, 25);
		contentPane.add(lblDato7);
		
		lblDato6 = new JLabel("Dinero total perdido:");
		lblDato6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDato6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDato6.setBounds(417, 396, 267, 25);
		contentPane.add(lblDato6);
		
		Dato1 = new JLabel("");
		Dato1.setHorizontalAlignment(SwingConstants.LEFT);
		Dato1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Dato1.setBounds(694, 216, 190, 25);
		contentPane.add(Dato1);
		
		
		Dato2 = new JLabel("");
		Dato2.setHorizontalAlignment(SwingConstants.LEFT);
		Dato2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Dato2.setBounds(694, 252, 190, 25);
		contentPane.add(Dato2);
		
		
		Dato3 = new JLabel("");
		Dato3.setHorizontalAlignment(SwingConstants.LEFT);
		Dato3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Dato3.setBounds(694, 288, 190, 25);
		contentPane.add(Dato3);
		
		
		Dato4 = new JLabel("");
		Dato4.setHorizontalAlignment(SwingConstants.LEFT);
		Dato4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Dato4.setBounds(694, 324, 190, 25);
		contentPane.add(Dato4);
		
		
		Dato5 = new JLabel("");
		Dato5.setHorizontalAlignment(SwingConstants.LEFT);
		Dato5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Dato5.setBounds(694, 360, 190, 25);
		contentPane.add(Dato5);
		
		
		Dato6 = new JLabel("");
		Dato6.setHorizontalAlignment(SwingConstants.LEFT);
		Dato6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Dato6.setBounds(694, 396, 190, 25);
		contentPane.add(Dato6);
		
		
		Dato7 = new JLabel("");
		Dato7.setHorizontalAlignment(SwingConstants.LEFT);
		Dato7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Dato7.setBounds(694, 432, 190, 25);
		contentPane.add(Dato7);
		
		
		JLabel Foto = new JLabel("Foto");
		Foto.setHorizontalAlignment(SwingConstants.CENTER);
		Foto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Foto.setBounds(634, 535, 252, 279);
		contentPane.add(Foto);
		
		btnVolver = new JButton("RETURN");
		btnVolver.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnVolver.setBounds(672, 468, 169, 43);
		contentPane.add(btnVolver);
		this.setSize(1536, 864);
		this.setLocation(0, 0);
		this.btnVolver.addActionListener(this);
		
		cont.obtenerStadisticas(elusuario);	
		Dato1.setText(String.valueOf(elusuario.getVecesJugadas()));
		Dato4.setText(String.valueOf(elusuario.getMaxCombo()));
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnVolver) {
			this.dispose();
			SelecionJuego sJ=new SelecionJuego(cont, elusuario);
			sJ.setVisible(true);
		}
		
	}
}
