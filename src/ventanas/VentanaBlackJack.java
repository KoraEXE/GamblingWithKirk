package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private int cantidad;

	public VentanaBlackJack() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Carta3 = new JLabel("");
		Carta3.setIcon(new ImageIcon("C:\\Users\\koraw\\git\\GamblingWithKirk\\imagenes\\1-Treboles.jpg"));
		Carta3.setBounds(828, 645, 113, 151);
		contentPanel.add(Carta3);
		
		Carta2 = new JLabel("");
		Carta2.setIcon(new ImageIcon("C:\\Users\\koraw\\git\\GamblingWithKirk\\imagenes\\7-Picas.jpg"));
		Carta2.setBounds(803, 619, 113, 151);
		contentPanel.add(Carta2);
		{
			JLabel ComboText = new JLabel("Combo:");
			ComboText.setBounds(29, 35, 76, 22);
			ComboText.setFont(new Font("Tahoma", Font.BOLD, 18));
			contentPanel.add(ComboText);
		}
		
		ComboIcon = new JLabel("x3");
		ComboIcon.setHorizontalAlignment(SwingConstants.CENTER);
		ComboIcon.setBounds(103, 12, 68, 69);
		ComboIcon.setFont(new Font("Tahoma", Font.PLAIN, 58));
		contentPanel.add(ComboIcon);
		
		CartaNueva = new JLabel("");
		CartaNueva.setIcon(new ImageIcon("C:\\Users\\koraw\\git\\GamblingWithKirk\\imagenes\\2-Rombos.jpg"));
		CartaNueva.setBounds(1018, 597, 113, 151);
		contentPanel.add(CartaNueva);
		
		Carta1 = new JLabel("");
		Carta1.setIcon(new ImageIcon("C:\\Users\\koraw\\git\\GamblingWithKirk\\imagenes\\10-Treboles.jpg"));
		Carta1.setBounds(772, 597, 113, 151);
		contentPanel.add(Carta1);
		
		Crupier1 = new JLabel("");
		Crupier1.setIcon(new ImageIcon("C:\\Users\\koraw\\git\\GamblingWithKirk\\imagenes\\trasera.jpg"));
		Crupier1.setBounds(772, 190, 113, 151);
		contentPanel.add(Crupier1);
		
		Crupier2 = new JLabel("");
		Crupier2.setIcon(new ImageIcon("C:\\Users\\koraw\\git\\GamblingWithKirk\\imagenes\\trasera.jpg"));
		Crupier2.setBounds(1018, 190, 113, 151);
		contentPanel.add(Crupier2);
		
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
		TextSuma.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TextSuma.setBounds(807, 541, 109, 31);
		contentPanel.add(TextSuma);
		
		SumaTotal = new JLabel("20");
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
		botonJugar.setBounds(455, 781, 89, 23);
		contentPanel.add(botonJugar);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		this.setLocation(0, 0);
		botonJugar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == botonJugar) {
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
			} else {
				
			}
		}
		
		
	}
}
