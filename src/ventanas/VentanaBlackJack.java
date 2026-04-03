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
	private JButton btnAaaaaaaa;
	
	public VentanaBlackJack() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Crupier2 = new JLabel("");
		Crupier2.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		Crupier2.setBounds(826, 237, 113, 151);
		contentPanel.add(Crupier2);
		Crupier2.setVisible(false);

		sumaTotalReal = new JLabel("0");
		sumaTotalReal.setHorizontalAlignment(SwingConstants.CENTER);
		sumaTotalReal.setFont(new Font("Tahoma", Font.BOLD, 20));
		sumaTotalReal.setBounds(924, 499, 39, 31);
		contentPanel.add(sumaTotalReal);
		sumaTotalReal.setVisible(false);

		NoMostrar2 = new JLabel("");
		NoMostrar2.setIcon(new ImageIcon("D:\\eclipse-workspace\\GamblingWithKirk\\imagenes\\trasera.jpg"));
		NoMostrar2.setBounds(1018, 190, 113, 151);
		contentPanel.add(NoMostrar2);

		NuevoCrupier = new JLabel("");
		NuevoCrupier.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		NuevoCrupier.setBounds(1018, 190, 113, 151);
		contentPanel.add(NuevoCrupier);

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

		SumaTotal = new JLabel("0");
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

		SumaTotalCrupier1 = new JLabel("0");
		SumaTotalCrupier1.setHorizontalAlignment(SwingConstants.CENTER);
		SumaTotalCrupier1.setFont(new Font("Tahoma", Font.BOLD, 20));
		SumaTotalCrupier1.setBounds(924, 499, 39, 31);
		contentPanel.add(SumaTotalCrupier1);

		TextoInfo = new JLabel("");
		TextoInfo.setHorizontalAlignment(SwingConstants.CENTER);
		TextoInfo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		TextoInfo.setBounds(577, 371, 749, 98);
		contentPanel.add(TextoInfo);
		
		 btnAaaaaaaa = new JButton("AAAAAAAA");
		btnAaaaaaaa.setBounds(191, 583, 147, 36);
		contentPanel.add(btnAaaaaaaa);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		this.setLocation(0, 0);
		botonJugar.addActionListener(this);
		BotonPedir.addActionListener(this);
		BotonParar.addActionListener(this);
		btnAaaaaaaa.addActionListener(this);
		
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
		int numCartasArray =0;
		File f = new File("baraja.dat");
		ArrayList<Carta> totalBaraja = new ArrayList<>();
		Carta carta = new Carta();
		BlackJack bkj = new BlackJack();
		TextoInfo.setText("");
		
		if (e.getSource() == btnAaaaaaaa) {
			for (int i = 0; i < totalBaraja.size(); i++) {
				System.out.println("Carta " + (i + 1) + ": " + totalBaraja.get(i).getNumero());
			}
		}
		
		
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
			System.out.println("Se pide");
			bkj.apostar(f, carta, totalBaraja, numCartasArray);
			System.out.println(numCartasArray);
			sumaF = SumaTotal.getText();
			sumaT = Integer.parseInt(sumaF);
			
			
			sumaT = bkj.traductorDeCartas(totalBaraja, bkj, sumaT);
			sumaF = Integer.toString(sumaT);
			SumaTotal.setText(sumaF);
			System.out.println("Carta obtenida: " + totalBaraja.get(bkj.randomCarta).getNumero());
			

			if ((sumaT = Integer.parseInt(sumaF)) > 21) {
				BotonPedir.setEnabled(false);
				BotonParar.setEnabled(false);
				TextoInfo.setText("¡Has perdido!");
				Derrota vD=new Derrota();
				vD.setVisible(true);
				botonJugar.setEnabled(true);
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
				Carta2.setVisible(true);
				NuevoCrupier.setIcon(totalBaraja.get(bkj.randomCarta).getImagen());				
				
				if (Integer.parseInt(sumaF) > Integer.parseInt(sumaFC)) {
					BotonPedir.setEnabled(false);
					BotonParar.setEnabled(false);
					TextoInfo.setText("¡Has ganado!");
					Victoria vV = new Victoria();
					vV.setVisible(true);
					botonJugar.setEnabled(true);
				} else if (sumaF.equals(sumaFC)) {
					TextoInfo.setText("¡Empate!");
					botonJugar.setEnabled(true);
				} else {
					TextoInfo.setText("¡Has perdido!");
					Derrota vD=new Derrota();
					vD.setVisible(true);
					botonJugar.setEnabled(true);
				}
			} else if (sumaF.equals(sumaFC)) {
				TextoInfo.setText("¡Empate!");
				botonJugar.setEnabled(true);
			} else {
				TextoInfo.setText("¡Has perdido!");
				Derrota vD=new Derrota();
				vD.setVisible(true);
				botonJugar.setEnabled(true);
			}
		}
	}
}