package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import juego.BlackJack;
import modelo.Baraja;
import modelo.Carta;
import modelo.Play_On_Table;
import modelo.Played;
import modelo.Result;
import modelo.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class VentanaBlackJack extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel Carta3;
	private JLabel Carta2;
	private JLabel ComboIcon;
	private JLabel CartaNueva;
	private JLabel Carta1;
	private JLabel Crupier1;
	private JLabel NuevoCrupier;
	private JButton BotonPedir;
	private JButton BotonParar;
	private JLabel TextSuma;
	private JLabel SumaTotal;
	private JLabel TextoApostar;
	private JTextField Apuesta;
	private JButton botonJugar;
	private JLabel TextSumaCrupier;
	private JLabel SumaTotalCrupier1;
	private int cantidad;
	private JLabel NoMostrar1;
	private JLabel NoMostrar2;
	private JLabel TextoInfo;
	private JLabel sumaTotalReal;
	private JLabel Crupier2;
	private BlackJack juego;
	private User elusuario;
	private JLabel nombreJugador;
	private JLabel dineroJugador;
	private JLabel textoDIneroJugador;
	private JLabel textoNombreJugador;
	private JLabel TextNombreCrupier;
	private LoginControlador cont;
	private Play_On_Table table;
	private Played played;
	private int racha = 0;
	private int rachaReal = 0;
	private boolean n21s = false;

	//Stats para mostrar
	private int vecesJugadas = 0; //realizado
	private int maxCombo = 0;

	public VentanaBlackJack(LoginControlador cont, User elusuario, Play_On_Table table, Played played) {
		played = new Played();
		cont = new LoginControlador();
		this.table = table;
		this.played = played;
		this.cont = cont;
		this.elusuario = elusuario;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setSize(1536, 864);
		this.setLocation(0, 0);

		dineroJugador = new JLabel((String) null);
		dineroJugador.setHorizontalAlignment(SwingConstants.LEFT);
		dineroJugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		dineroJugador.setBounds(148, 131, 304, 44);
		contentPanel.add(dineroJugador);
		dineroJugador.setText(String.valueOf(elusuario.getBalance()));

		textoDIneroJugador = new JLabel("Dinero");
		textoDIneroJugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textoDIneroJugador.setBounds(23, 131, 115, 44);
		contentPanel.add(textoDIneroJugador);

		nombreJugador = new JLabel("");
		nombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		nombreJugador.setHorizontalAlignment(SwingConstants.LEFT);
		nombreJugador.setBounds(148, 76, 304, 44);
		contentPanel.add(nombreJugador);
		nombreJugador.setText(elusuario.getName());

		textoNombreJugador = new JLabel("Jugador:");
		textoNombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textoNombreJugador.setBounds(23, 76, 115, 44);
		contentPanel.add(textoNombreJugador);

		Crupier2 = new JLabel("");
		Crupier2.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		Crupier2.setBounds(695, 115, 113, 151);
		contentPanel.add(Crupier2);
		Crupier2.setVisible(false);

		sumaTotalReal = new JLabel("0");
		sumaTotalReal.setHorizontalAlignment(SwingConstants.CENTER);
		sumaTotalReal.setFont(new Font("Tahoma", Font.BOLD, 20));
		sumaTotalReal.setBounds(846, 383, 39, 31);
		contentPanel.add(sumaTotalReal);
		sumaTotalReal.setVisible(false);

		NoMostrar2 = new JLabel("");
		NoMostrar2.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		NoMostrar2.setBounds(878, 53, 113, 151);
		contentPanel.add(NoMostrar2);

		NuevoCrupier = new JLabel("");
		NuevoCrupier.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		NuevoCrupier.setBounds(878, 53, 113, 151);
		contentPanel.add(NuevoCrupier);

		NoMostrar1 = new JLabel("");
		NoMostrar1.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		NoMostrar1.setBounds(643, 53, 113, 151);
		contentPanel.add(NoMostrar1);

		Carta3 = new JLabel("");
		Carta3.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		Carta3.setBounds(742, 608, 113, 151);
		contentPanel.add(Carta3);
		Carta3.setVisible(false);

		Carta2 = new JLabel("");
		Carta2.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		Carta2.setBounds(695, 542, 113, 151);
		contentPanel.add(Carta2);
		Carta2.setVisible(false);
		{
			JLabel ComboText = new JLabel("Combo:");
			ComboText.setBounds(23, 35, 82, 30);
			ComboText.setFont(new Font("Tahoma", Font.BOLD, 18));
			contentPanel.add(ComboText);
		}

		ComboIcon = new JLabel("?");
		ComboIcon.setHorizontalAlignment(SwingConstants.CENTER);
		ComboIcon.setBounds(103, 12, 68, 69);
		ComboIcon.setFont(new Font("Tahoma", Font.PLAIN, 58));
		contentPanel.add(ComboIcon);

		CartaNueva = new JLabel("");
		CartaNueva.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		CartaNueva.setBounds(878, 466, 113, 151);
		contentPanel.add(CartaNueva);

		Carta1 = new JLabel("");
		Carta1.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		Carta1.setBounds(643, 466, 113, 151);
		contentPanel.add(Carta1);

		Crupier1 = new JLabel("");
		Crupier1.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		Crupier1.setBounds(643, 53, 113, 151);
		contentPanel.add(Crupier1);

		BotonPedir = new JButton("Pedir");
		BotonPedir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BotonPedir.setBounds(376, 588, 113, 43);
		contentPanel.add(BotonPedir);
		BotonPedir.setEnabled(false);

		BotonParar = new JButton("Parar");
		BotonParar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BotonParar.setBounds(515, 588, 113, 43);
		contentPanel.add(BotonParar);
		BotonParar.setEnabled(false);

		TextSuma = new JLabel("Suma Total:");
		TextSuma.setHorizontalAlignment(SwingConstants.RIGHT);
		TextSuma.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TextSuma.setBounds(678, 425, 166, 31);
		contentPanel.add(TextSuma);

		SumaTotal = new JLabel("0");
		SumaTotal.setHorizontalAlignment(SwingConstants.CENTER);
		SumaTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		SumaTotal.setBounds(846, 424, 39, 31);
		contentPanel.add(SumaTotal);

		TextoApostar = new JLabel("Cuanto quieres apostar?");
		TextoApostar.setHorizontalAlignment(SwingConstants.CENTER);
		TextoApostar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TextoApostar.setBounds(354, 476, 294, 31);
		contentPanel.add(TextoApostar);

		Apuesta = new JTextField();
		Apuesta.setHorizontalAlignment(SwingConstants.CENTER);
		Apuesta.setText("Introduce la apuesta");
		Apuesta.setBounds(417, 517, 171, 20);
		contentPanel.add(Apuesta);
		Apuesta.setColumns(10);

		botonJugar = new JButton("JUGAR");
		botonJugar.setBounds(427, 542, 147, 36);
		contentPanel.add(botonJugar);


		TextSumaCrupier = new JLabel("Suma Total Crupier:");
		TextSumaCrupier.setHorizontalAlignment(SwingConstants.RIGHT);
		TextSumaCrupier.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TextSumaCrupier.setBounds(678, 384, 166, 31);
		contentPanel.add(TextSumaCrupier);

		SumaTotalCrupier1 = new JLabel("0");
		SumaTotalCrupier1.setHorizontalAlignment(SwingConstants.CENTER);
		SumaTotalCrupier1.setFont(new Font("Tahoma", Font.BOLD, 20));
		SumaTotalCrupier1.setBounds(846, 383, 39, 31);
		contentPanel.add(SumaTotalCrupier1);

		TextoInfo = new JLabel("");
		TextoInfo.setHorizontalAlignment(SwingConstants.CENTER);
		TextoInfo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TextoInfo.setBounds(487, 276, 749, 98);
		contentPanel.add(TextoInfo);
		
		TextNombreCrupier = new JLabel("Crupier:");
		TextNombreCrupier.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TextNombreCrupier.setBounds(1127, 53, 166, 28);
		contentPanel.add(TextNombreCrupier);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		this.setLocation(0, 0);
		botonJugar.addActionListener(this);
		BotonPedir.addActionListener(this);
		BotonParar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int contadorCartas = 0;
		int sumaT = 0; //suma total
		int sumaTC= 0; //suma total crupier
		String sumaF = "0"; //suma final
		String sumaFC = "0";//suma final crupier
		int contadordecartas = 0;


		//Para las stats


		int numCartasArray =0;
		File f = new File("baraja.dat");
		ArrayList<Carta> totalBaraja = new ArrayList<>();
		Carta carta = new Carta();
		BlackJack bkj = new BlackJack();
		TextoInfo.setText("");

		bkj.iniciarJuego(f, totalBaraja );

		if (e.getSource() == botonJugar) {
			
			obtnerDatosStats();

			//Hacer que obtenga los datos de la base de datos

			vecesJugadas ++;

			//añadir a la base de datos

			//resetear las cartas
			Crupier1.setIcon(new ImageIcon("imagenes/trasera.jpg"));
			Carta1.setIcon(new ImageIcon("imagenes/trasera.jpg"));
			CartaNueva.setIcon(new ImageIcon("imagenes/trasera.jpg"));
			Crupier2.setIcon(new ImageIcon("imagenes/trasera.jpg"));
			Crupier2.setVisible(false);
			Carta2.setVisible(false);
			Carta3.setVisible(false);
			NoMostrar1.setVisible(true);
			NoMostrar2.setVisible(true);

			//reset contador
			SumaTotalCrupier1.setVisible(true);
			sumaTotalReal.setVisible(false);

			try {			
				cantidad = Integer.parseInt(Apuesta.getText());	
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Introduce una cantidad valida");
				return;
			}

			if (cantidad <= 0) {
				JOptionPane.showMessageDialog(null, "La cantidad no puede ser 0 o negativo");
			} else if (elusuario.getBalance() < cantidad) {
				JOptionPane.showMessageDialog(null, "No tiene esa cantidad de dinero");
			} else if (elusuario.getBalance() >= cantidad) {

				elusuario.setBalance(elusuario.getBalance() - cantidad);
				dineroJugador.setText(String.valueOf(elusuario.getBalance()));
				TextoApostar.setText("¡Buena suerte!");
				BotonPedir.setEnabled(true);
				BotonParar.setEnabled(true);
				botonJugar.setEnabled(false);

				//Para el jugador
				do {
					bkj.apostar(f, carta, totalBaraja);
					System.out.println(numCartasArray);

					if (contadorCartas == 2) {
						sumaT = 0;
					}

					// Traductor de cartas 
					sumaT = bkj.traductorDeCartas(totalBaraja, bkj, sumaT);
					if (contadorCartas == 2) {
						sumaFC = Integer.toString(sumaT);
						SumaTotalCrupier1.setText(sumaFC);
						System.out.println("Carta obtenida para el Crupier: " + totalBaraja.get(bkj.randomCarta).getNumero());
						System.out.println("Valor de la suma del crupier: " + sumaFC);

					} else if (contadorCartas == 3) {
						sumaFC = Integer.toString(sumaT);
						System.out.println("Carta obtenida para el Crupier: " + totalBaraja.get(bkj.randomCarta).getNumero());
						sumaTotalReal.setText(sumaFC);
						System.out.println("Valor de la suma del crupier: " + sumaFC);

						//dar la vuelta a cartas
					} else {
						sumaF =Integer.toString(sumaT); //lo pasa a String
						SumaTotal.setText(sumaF);
						System.out.println("Carta obtenida: " + totalBaraja.get(bkj.randomCarta).getNumero());
						System.out.println("Valor de la suma: " + sumaF);
					}

					contadorCartas++;

					if (contadorCartas == 1) {
						Carta1.setIcon(totalBaraja.get(bkj.randomCarta).getImagen());
					} else if (contadorCartas == 2) {
						CartaNueva.setIcon(totalBaraja.get(bkj.randomCarta).getImagen()); //Copia
						Carta2.setIcon(totalBaraja.get(bkj.randomCarta).getImagen()); //Aun no es visible 
					} else if (contadorCartas == 3) {
						Crupier1.setIcon(totalBaraja.get(bkj.randomCarta).getImagen());
					} else if (contadorCartas == 4) {
						NuevoCrupier.setIcon(totalBaraja.get(bkj.randomCarta).getImagen()); //Copia
						NuevoCrupier.setVisible(true);
						Crupier2.setIcon(totalBaraja.get(bkj.randomCarta).getImagen()); //Aun no es visible 
					}



				} while (contadorCartas != 4);

				NoMostrar1.setVisible(false);
				contadordecartas = contadorCartas;

				//consultar todas las cartas de fich f baraja.dat
				System.out.println(contadorCartas);

			}
		}

		if (e.getSource() == BotonPedir) {
			bkj.apostar(f, carta, totalBaraja);
			System.out.println("Se pide");
			bkj.apostar(f, carta, totalBaraja);
			System.out.println(numCartasArray);
			sumaF = SumaTotal.getText();
			sumaT = Integer.parseInt(sumaF);


			sumaT = bkj.traductorDeCartas(totalBaraja, bkj, sumaT);
			sumaF = Integer.toString(sumaT);
			SumaTotal.setText(sumaF);
			System.out.println("Carta obtenida: " + totalBaraja.get(bkj.randomCarta).getNumero());


			if ((sumaT = Integer.parseInt(sumaF)) > 21) {
				terminarRonda("PERDER");
			}
			if (Carta2.isVisible() == false) {
				Carta2.setVisible(true);				
				CartaNueva.setIcon(totalBaraja.get(bkj.randomCarta).getImagen());
				contadordecartas++;
			} else if (Carta2.isVisible() == true) {
				Carta3.setVisible(true);
				CartaNueva.setIcon(totalBaraja.get(bkj.randomCarta).getImagen());
			}
		}

		if (e.getSource() == BotonParar) {
			//ATENCION BOTON PARAR AL SER EL MAS PROBLEATICO POR ARRAY
			bkj.apostar(f, carta, totalBaraja);
			System.out.println("Se para");
			NoMostrar2.setVisible(false);
			sumaFC = sumaTotalReal.getText();
			sumaT = Integer.parseInt(sumaFC);
			sumaF = SumaTotal.getText();
			SumaTotalCrupier1.setVisible(false);
			sumaTotalReal.setVisible(true);


			if (Integer.parseInt(sumaF) > Integer.parseInt(sumaFC)) {
				sumaT = bkj.traductorDeCartas(totalBaraja, bkj, sumaT);
				sumaFC = Integer.toString(sumaT);
				sumaTotalReal.setText(sumaFC);
				System.out.println("Carta obtenida para el Crupier: " + totalBaraja.get(bkj.randomCarta).getNumero());
				NuevoCrupier.setIcon(totalBaraja.get(bkj.randomCarta).getImagen());	
				Crupier2.setVisible(true);

				if (Integer.parseInt(sumaFC) > 21) {
					terminarRonda("GANAR");
					if (Integer.parseInt(sumaF) == 21 ){
						n21s = true;
					}
				} else if (Integer.parseInt(sumaF) > Integer.parseInt(sumaFC)) {
					terminarRonda("GANAR");
					if (Integer.parseInt(sumaF) == 21 ){
						n21s = true;
					}
				} else if (sumaF.equals(sumaFC)) {
					terminarRonda("EMPATE");
					if (Integer.parseInt(sumaF) == 21 ){
						n21s = true;
					}
				} else {
					terminarRonda("PERDER");
				}
			} else if (sumaF.equals(sumaFC)) {
				terminarRonda("EMPATE");
			} else if (Integer.parseInt(sumaF) < Integer.parseInt(sumaFC)) {
				terminarRonda("PERDER");
			}
		}
	}
	//Centraliza todo lo que pasa cuando acaba una partida en vez de repetir codigo (probad a ver que tal os va)//
	private void terminarRonda(String resultado) {
		BotonPedir.setEnabled(false);
		BotonParar.setEnabled(false);
		botonJugar.setEnabled(true);
		gestionRYD(resultado);

		//reset al dinero
		Apuesta.setText("Introduce la apuesta");

		if (resultado.equals("GANAR")) {
			
			TextoInfo.setText("¡Has ganado!");
			Victoria victoria = new Victoria(this, elusuario, table, played);
			victoria.setLocation(350, 400); //posición
			victoria.setVisible(true);

		} else if (resultado.equals("PERDER")) {

			TextoInfo.setText("¡Has perdido!");
			Derrota derrota = new Derrota(this, elusuario, table, played);
			derrota.setLocation(350, 400); //posición
			derrota.setVisible(true);


		} else {
			TextoInfo.setText("¡Empate!");
		}
	}

	private void gestionRYD(String resultado) { 


		//Gestion rachas y dinero
		//Aumenta 0,10 el multiplicador de dinero por cada victoria hasta un maximo de 0,1
		//Si ha sido blackjack aumentara un 0,25 en vez de 0,10
		//Despues de 5 ganadas no se sumaran nada mas
		
		if (resultado.equals("GANAR")) {
		} else if (resultado.equals("PERDER")) {
			
		}
			
		if (resultado.equals("GANAR")) {

			if (n21s) {
				elusuario.setBalance(elusuario.getBalance() + cantidad * (1.5 + 0.2 * racha + 0.50)); //aumenta si es por hacer 21
				int cantidadRedon = (int) Math.round(cantidad);
				played.setApuestaEnJuego(cantidadRedon);
			} else {
				elusuario.setBalance(elusuario.getBalance() + cantidad * (1.5 + 0.2 * racha));
				
				int cantidadRedon = (int) Math.round(cantidad);
				played.setApuestaEnJuego(cantidadRedon);
			}
			
			played.setResult(Result.WIN);
			cont.insertarJuego(played, elusuario, table);
			
			rachaReal ++; //para la pagina web	
			maxCombo = rachaReal;

			if (racha <= 4) { 
				racha ++;
			}
			
			ComboIcon.setText(String.valueOf(rachaReal));
		} else if (resultado.equals("EMPATE")) { 			
				elusuario.setBalance(elusuario.getBalance() + cantidad);
				played.setResult(Result.DRAW);
				cont.insertarJuego(played, elusuario, table);
				
			ComboIcon.setText(String.valueOf(rachaReal));
		} else if (resultado.equals("PERDER")) {	
			played.setApuestaEnJuego(-cantidad);
			racha = 0;
			rachaReal = 0;
			ComboIcon.setText(String.valueOf(racha));
			ComboIcon.setText(String.valueOf(rachaReal));
			played.setResult(Result.LOSE);
			cont.insertarJuego(played, elusuario, table);
			
			System.out.println();
		}

		dineroJugador.setText(String.valueOf(elusuario.getBalance()));
		System.out.println(elusuario.getBalance());
		actualizarDatosStats();
		cont.actualizarDinero(elusuario);
	}

	private void obtnerDatosStats() { 
		cont.obtenerStadisticas(elusuario);
		vecesJugadas = elusuario.getVecesJugadas();
		maxCombo = elusuario.getMaxCombo();
		
	}
	
	private void actualizarDatosStats() {
		elusuario.setVecesJugadas(vecesJugadas);
		elusuario.setMaxCombo(maxCombo);
		cont.actualuizarStadisticas(elusuario);

	}
}