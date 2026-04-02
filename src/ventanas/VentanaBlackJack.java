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

import juego.BlackJack;
import modelo.Baraja;
import modelo.Carta;

import javax.swing.JLabel;
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
	private JLabel Crupier2;
	private JButton BotonPedir;
	private JButton BotonParar;
	private JLabel TextSuma;
	private JLabel SumaTotal;
	private JLabel TextoApostar;
	private JTextField Apuesta;
	private JButton botonJugar;
	private JLabel TextSumaCrupier;
	private JLabel SumaTotalCrupier;
	private int cantidad;
	private JLabel NoMostrar1;
	private JLabel NoMostrar2;
	private JLabel TextoInfo;

	public VentanaBlackJack() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		NoMostrar2 = new JLabel("");
		NoMostrar2.setIcon(new ImageIcon("D:\\eclipse-workspace\\GamblingWithKirk\\imagenes\\trasera.jpg"));
		NoMostrar2.setBounds(1018, 190, 113, 151);
		contentPanel.add(NoMostrar2);

		Crupier2 = new JLabel("");
		Crupier2.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		Crupier2.setBounds(1018, 190, 113, 151);
		contentPanel.add(Crupier2);

		NoMostrar1 = new JLabel("");
		NoMostrar1.setIcon(new ImageIcon("D:\\eclipse-workspace\\GamblingWithKirk\\imagenes\\trasera.jpg"));
		NoMostrar1.setBounds(772, 190, 113, 151);
		contentPanel.add(NoMostrar1);

		Carta3 = new JLabel("");
		Carta3.setIcon(new ImageIcon("D:\\eclipse-workspace\\GamblingWithKirk\\imagenes\\trasera.jpg"));
		Carta3.setBounds(850, 651, 113, 151);
		contentPanel.add(Carta3);
		Carta3.setVisible(false);

		Carta2 = new JLabel("");
		Carta2.setIcon(new ImageIcon("D:\\eclipse-workspace\\GamblingWithKirk\\imagenes\\trasera.jpg"));
		Carta2.setBounds(803, 619, 113, 151);
		contentPanel.add(Carta2);
		Carta2.setVisible(false);
		{
			JLabel ComboText = new JLabel("Combo:");
			ComboText.setBounds(29, 35, 76, 22);
			ComboText.setFont(new Font("Tahoma", Font.BOLD, 18));
			contentPanel.add(ComboText);
		}

		ComboIcon = new JLabel("x1");
		ComboIcon.setHorizontalAlignment(SwingConstants.CENTER);
		ComboIcon.setBounds(103, 12, 68, 69);
		ComboIcon.setFont(new Font("Tahoma", Font.PLAIN, 58));
		contentPanel.add(ComboIcon);

		CartaNueva = new JLabel("");
		CartaNueva.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		CartaNueva.setBounds(1018, 597, 113, 151);
		contentPanel.add(CartaNueva);

		Carta1 = new JLabel("");
		Carta1.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		Carta1.setBounds(772, 597, 113, 151);
		contentPanel.add(Carta1);

		Crupier1 = new JLabel("");
		Crupier1.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		Crupier1.setBounds(772, 190, 113, 151);
		contentPanel.add(Crupier1);

		BotonPedir = new JButton("Pedir");
		BotonPedir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BotonPedir.setBounds(772, 870, 113, 43);
		contentPanel.add(BotonPedir);
		BotonPedir.setEnabled(false);

		BotonParar = new JButton("Parar");
		BotonParar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BotonParar.setBounds(1018, 870, 113, 43);
		contentPanel.add(BotonParar);
		BotonParar.setEnabled(false);

		TextSuma = new JLabel("Suma Total:");
		TextSuma.setHorizontalAlignment(SwingConstants.RIGHT);
		TextSuma.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TextSuma.setBounds(750, 541, 166, 31);
		contentPanel.add(TextSuma);

		SumaTotal = new JLabel("");
		SumaTotal.setHorizontalAlignment(SwingConstants.CENTER);
		SumaTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		SumaTotal.setBounds(924, 541, 39, 31);
		contentPanel.add(SumaTotal);

		TextoApostar = new JLabel("Cuanto quieres apostar?");
		TextoApostar.setHorizontalAlignment(SwingConstants.CENTER);
		TextoApostar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TextoApostar.setBounds(356, 696, 294, 31);
		contentPanel.add(TextoApostar);

		Apuesta = new JTextField();
		Apuesta.setHorizontalAlignment(SwingConstants.CENTER);
		Apuesta.setText("Introduce la apuesta");
		Apuesta.setBounds(418, 750, 171, 20);
		contentPanel.add(Apuesta);
		Apuesta.setColumns(10);

		botonJugar = new JButton("JUGAR");
		botonJugar.setBounds(428, 781, 147, 36);
		contentPanel.add(botonJugar);
		

		TextSumaCrupier = new JLabel("Suma Total Crupier:");
		TextSumaCrupier.setHorizontalAlignment(SwingConstants.RIGHT);
		TextSumaCrupier.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TextSumaCrupier.setBounds(750, 499, 166, 31);
		contentPanel.add(TextSumaCrupier);

		SumaTotalCrupier = new JLabel("");
		SumaTotalCrupier.setHorizontalAlignment(SwingConstants.CENTER);
		SumaTotalCrupier.setFont(new Font("Tahoma", Font.BOLD, 20));
		SumaTotalCrupier.setBounds(924, 499, 39, 31);
		contentPanel.add(SumaTotalCrupier);
		
		TextoInfo = new JLabel("Suma Total Crupier:");
		TextoInfo.setHorizontalAlignment(SwingConstants.CENTER);
		TextoInfo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TextoInfo.setBounds(577, 371, 749, 98);
		contentPanel.add(TextoInfo);
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
		String sumaF = ""; //suma final
		String sumaFC = "";//suma final crupier
		int contadordecartas = 0;
		int numCartasArray =0;
		File f = new File("baraja.dat");
		ArrayList<Carta> totalBaraja = new ArrayList<>();
		Baraja baraja = new Baraja(f, totalBaraja);
		Carta carta = new Carta();
		BlackJack bkj = new BlackJack();
		boolean as = false;

		if (e.getSource() == botonJugar) {
			bkj.iniciarJuego(f, totalBaraja );
			try {
				cantidad = Integer.parseInt(Apuesta.getText());
			} catch (NumberFormatException ex) {
				TextoApostar.setText("Introduce una cantidad valida");
				return;
			}
			//Integer.parseInt(texto);

			if (cantidad > 0) {
				
				
				TextoApostar.setText("¡Buena suerte!");
				BotonPedir.setEnabled(true);
				BotonParar.setEnabled(true);
				botonJugar.setEnabled(false);

				//Para el jugador


				do {
					bkj.apostar(f, carta, totalBaraja, numCartasArray);

					if (contadorCartas == 2) {
						sumaT = 0;
					}

					// Traductor de cartas 
					sumaT = bkj.traductorDeCartas(totalBaraja, bkj, sumaT, as);
					
					if (sumaT > 21 && as == true) {
						sumaT = sumaT - 10;
						as = false;
					}

					if (contadorCartas == 2) {
						sumaFC = Integer.toString(sumaT);
						SumaTotalCrupier.setText(sumaFC);
						System.out.println("Carta obtenida para el Crupier: " + totalBaraja.get(bkj.randomCarta).getNumero());
						
					} else if (contadorCartas == 3) {
						sumaFC = Integer.toString(sumaT);
						System.out.println("Carta obtenida para el Crupier: " + totalBaraja.get(bkj.randomCarta).getNumero());

						//dar la vuelta a cartas
					} else {
						sumaF =Integer.toString(sumaT); //lo pasa a String
						SumaTotal.setText(sumaF);
						System.out.println("Carta obtenida: " + totalBaraja.get(bkj.randomCarta).getNumero());
					}

					contadorCartas++;

					if (contadorCartas == 1) {
						Carta1.setIcon(totalBaraja.get(bkj.randomCarta).getImagen());
					} else if (contadorCartas == 2) {
						CartaNueva.setIcon(totalBaraja.get(bkj.randomCarta).getImagen());
						Carta2.setIcon(totalBaraja.get(bkj.randomCarta).getImagen()); //Aun no es visible
					} else if (contadorCartas == 3) {
						Crupier1.setIcon(totalBaraja.get(bkj.randomCarta).getImagen());
					} else if (contadorCartas == 4) {
						Crupier2.setIcon(totalBaraja.get(bkj.randomCarta).getImagen());	
					}



				} while (contadorCartas != 4);

				NoMostrar1.setVisible(false);
				contadordecartas = contadorCartas;

				//consultar todas las cartas de fich f baraja.dat
				System.out.println(contadorCartas);

				if ((sumaT = Integer.parseInt(sumaF)) > 21) {
					BotonPedir.setEnabled(false);
				}				
			}
		}
		
		if (e.getSource() == BotonPedir) {
			bkj.apostar(f, carta, totalBaraja, numCartasArray);
			sumaF = SumaTotal.getText();
			sumaT = Integer.parseInt(sumaF);
			sumaT = bkj.traductorDeCartas(totalBaraja, bkj, sumaT, as);
			sumaF = Integer.toString(sumaT);
			SumaTotal.setText(sumaF);
			System.out.println("Carta obtenida: " + totalBaraja.get(bkj.randomCarta).getNumero());
			
			if ((sumaT = Integer.parseInt(sumaF)) > 21) {
				BotonPedir.setEnabled(false);
				TextoInfo.setText("¡Has perdido!");
				Derrota vD=new Derrota();
				vD.setVisible(true);
			}	
			if (Carta2.isVisible() == false) {
				Carta2.setVisible(true);
				Carta3.setIcon(totalBaraja.get(bkj.randomCarta).getImagen());
				CartaNueva.setIcon(totalBaraja.get(bkj.randomCarta).getImagen());
				contadordecartas++;
			} else if (Carta2.isVisible() == true) {
				Carta3.setVisible(true);
				CartaNueva.setIcon(totalBaraja.get(bkj.randomCarta).getImagen());
			}
		}
	}
}