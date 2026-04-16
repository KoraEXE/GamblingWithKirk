package ventanas;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.Play_On_Table;
import modelo.Played;
import modelo.User;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.ImageIcon;


public class VentanaRuletaRusa extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LoginControlador cont;
	private User elusuario;
	private JLabel lblTitle;
	private JLabel lblDato7;
	private JButton btnRevolver;
	private JButton btnBala2;
	private JButton btnBala1;
	private JButton btnBala6;
	private JButton btnBala4;
	private JButton btnBala5;
	private JButton btnBala3;
	private JLabel lblOne;
	private JLabel lblTwo;
	private JLabel lblThree;
	private JLabel lblFour;
	private JLabel lblFive;
	private JLabel lblSix;
	private int respuesta = 0;
	private Play_On_Table table;
	private Played played;


	public VentanaRuletaRusa(LoginControlador cont, User elusuario, Play_On_Table table, Played played) {
		this.table = table;
		this.played = played;
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

		lblTitle = new JLabel("TRY YOUR LUCK");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTitle.setBounds(573, 102, 374, 87);
		contentPane.add(lblTitle);

		lblDato7 = new JLabel("CHOOSE ONE");
		lblDato7.setHorizontalAlignment(SwingConstants.CENTER);
		lblDato7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDato7.setBounds(631, 542, 267, 25);
		contentPane.add(lblDato7);

		btnRevolver = new JButton("");
		btnRevolver.setEnabled(false);
		btnRevolver.setIcon(new ImageIcon("imagenes/revolverLast.jpg"));
		btnRevolver.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnRevolver.setBounds(518, 289, 483, 242);
		contentPane.add(btnRevolver);

		btnBala2 = new JButton("");
		btnBala2.setIcon(new ImageIcon("imagenes/municionLast 2.png"));
		btnBala2.setBounds(518, 587, 90, 227);
		contentPane.add(btnBala2);

		btnBala1 = new JButton("");
		btnBala1.setEnabled(true);
		btnBala1.setIcon(new ImageIcon("imagenes/municionLast 2.png"));
		btnBala1.setBounds(428, 587, 90, 227);
		contentPane.add(btnBala1);

		btnBala6 = new JButton("");
		btnBala6.setIcon(new ImageIcon("imagenes/municionLast 2.png"));
		btnBala6.setBounds(1002, 587, 90, 227);
		contentPane.add(btnBala6);

		btnBala4 = new JButton("");
		btnBala4.setIcon(new ImageIcon("imagenes/municionLast 2.png"));
		btnBala4.setBounds(820, 587, 90, 227);
		contentPane.add(btnBala4);

		btnBala5 = new JButton("");
		btnBala5.setIcon(new ImageIcon("imagenes/municionLast 2.png"));
		btnBala5.setBounds(911, 587, 90, 227);
		contentPane.add(btnBala5);

		btnBala3 = new JButton("");
		btnBala3.setIcon(new ImageIcon("imagenes/municionLast 2.png"));
		btnBala3.setBounds(610, 587, 90, 227);
		contentPane.add(btnBala3);

		lblOne = new JLabel("ONE");
		lblOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblOne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOne.setBounds(428, 560, 90, 25);
		contentPane.add(lblOne);

		lblTwo = new JLabel("TWO");
		lblTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTwo.setBounds(518, 560, 90, 25);
		contentPane.add(lblTwo);

		lblThree = new JLabel("THREE");
		lblThree.setHorizontalAlignment(SwingConstants.CENTER);
		lblThree.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThree.setBounds(610, 560, 90, 25);
		contentPane.add(lblThree);

		lblFour = new JLabel("FOUR");
		lblFour.setHorizontalAlignment(SwingConstants.CENTER);
		lblFour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFour.setBounds(820, 560, 90, 25);
		contentPane.add(lblFour);

		lblFive = new JLabel("FIVE");
		lblFive.setHorizontalAlignment(SwingConstants.CENTER);
		lblFive.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFive.setBounds(911, 560, 90, 25);
		contentPane.add(lblFive);

		lblSix = new JLabel("SIX");
		lblSix.setHorizontalAlignment(SwingConstants.CENTER);
		lblSix.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSix.setBounds(1002, 560, 90, 25);
		contentPane.add(lblSix);
		this.setSize(1536, 864);
		this.setLocation(0, 0);

		this.btnBala1.addActionListener(this);
		this.btnBala2.addActionListener(this);
		this.btnBala3.addActionListener(this);
		this.btnBala4.addActionListener(this);
		this.btnBala5.addActionListener(this);
		this.btnBala6.addActionListener(this);

		this.btnRevolver.addActionListener(this);
		cont.obtenerStadisticas(elusuario);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


		if(e.getSource()==btnBala1) {
			btnBala1.setEnabled(false);
			btnBala2.setEnabled(false);
			btnBala3.setEnabled(false);
			btnBala4.setEnabled(false);
			btnBala5.setEnabled(false);
			btnBala6.setEnabled(false);
			lblDato7.setText("Lets Play");
			lblDato7.setBounds(626, 241, 267, 25);
			btnRevolver.setEnabled(true);
			respuesta = 1;
		}

		if(e.getSource()==btnBala2) {
			btnBala1.setEnabled(false);
			btnBala2.setEnabled(false);
			btnBala3.setEnabled(false);
			btnBala4.setEnabled(false);
			btnBala5.setEnabled(false);
			btnBala6.setEnabled(false);
			lblDato7.setText("Lets Play");
			lblDato7.setBounds(626, 241, 267, 25);
			btnRevolver.setEnabled(true);
			respuesta = 2;
		}

		if(e.getSource()==btnBala3) {
			btnBala1.setEnabled(false);
			btnBala2.setEnabled(false);
			btnBala3.setEnabled(false);
			btnBala4.setEnabled(false);
			btnBala5.setEnabled(false);
			btnBala6.setEnabled(false);
			lblDato7.setText("Lets Play");
			lblDato7.setBounds(626, 241, 267, 25);
			btnRevolver.setEnabled(true);
			respuesta = 3;
		}

		if(e.getSource()==btnBala4) {
			btnBala1.setEnabled(false);
			btnBala2.setEnabled(false);
			btnBala3.setEnabled(false);
			btnBala4.setEnabled(false);
			btnBala5.setEnabled(false);
			btnBala6.setEnabled(false);
			lblDato7.setText("Lets Play");
			lblDato7.setBounds(626, 241, 267, 25);
			btnRevolver.setEnabled(true);
			respuesta = 4;
		}

		if(e.getSource()==btnBala5) {
			btnBala1.setEnabled(false);
			btnBala2.setEnabled(false);
			btnBala3.setEnabled(false);
			btnBala4.setEnabled(false);
			btnBala5.setEnabled(false);
			btnBala6.setEnabled(false);
			lblDato7.setText("Lets Play");
			lblDato7.setBounds(626, 241, 267, 25);
			btnRevolver.setEnabled(true);
			respuesta = 5;
		}

		if(e.getSource()==btnBala6) {
			btnBala1.setEnabled(false);
			btnBala2.setEnabled(false);
			btnBala3.setEnabled(false);
			btnBala4.setEnabled(false);
			btnBala5.setEnabled(false);
			btnBala6.setEnabled(false);
			lblDato7.setText("Lets Play");
			lblDato7.setBounds(626, 241, 267, 25);
			btnRevolver.setEnabled(true);
			respuesta = 6;
			
		}
		

		if(e.getSource()==btnRevolver) {
			int numeroR = (int)(Math.random() * 6) + 1;

			if (numeroR == respuesta) {

				btnRevolver.setIcon(new ImageIcon("imagenes/revolverGif.gif"));
				Timer timer = new Timer(1200, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						btnRevolver.setIcon(new ImageIcon("imagenes/revolverLast.jpg"));
						HasMuerto sJ=new HasMuerto(cont, elusuario);
						sJ.setVisible(true);
						accion();
						
					}
				});
				
				timer.setRepeats(false);
				timer.start();

			} else {
				btnRevolver.setIcon(new ImageIcon("imagenes/revolverGif.gif"));
				Timer timer = new Timer(260, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						btnRevolver.setIcon(new ImageIcon("imagenes/revolverLast.jpg"));
						SelecionJuego sJ=new SelecionJuego(cont, elusuario, table, played);
						sJ.setVisible(true);
						accion2();
					}				
				});	
				timer.setRepeats(false);
				timer.start();
				
			}
			
		}	
	}
	
	private void accion() {
		this.dispose();	
	}
	
	private void accion2() {
		this.dispose();	
		elusuario.setBalance(elusuario.getBalance()+100);
		cont.actualizarDinero(elusuario);
		JOptionPane.showMessageDialog(null, "Mira tu dinero");
		
	}
}
