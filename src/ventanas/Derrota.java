package ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.Play_On_Table;
import modelo.Played;
import modelo.User;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Derrota extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel miniIcono;
	private JLabel TextoGanado;
	private JButton SeguirJugando;
	private JButton PerderLaRacha;
	private JLabel Fondo;
	private JDialog VentanaBlackJack;
	private LoginControlador cont;
	private User elusuario;
	private Play_On_Table table;
	private Played played;

	public Derrota(JDialog VentanaBlackJack, User elusuario, Play_On_Table table, Played played) {
		super(VentanaBlackJack, "Derrota", true);
		
		this.VentanaBlackJack = VentanaBlackJack;
		this.elusuario = elusuario;
		this.table = table;
		setAlwaysOnTop(true);
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/miniIconoV2.png"));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);


		miniIcono = new JLabel("");
		miniIcono.setIcon(new ImageIcon("imagenes/miniIconoV2.png"));
		miniIcono.setBounds(384, 219, 52, 44);
		contentPanel.add(miniIcono);

		TextoGanado = new JLabel("");
		TextoGanado.setIcon(new ImageIcon("imagenes/hasPerdido.jpg"));
		TextoGanado.setBounds(0, 0, 253, 263);
		contentPanel.add(TextoGanado);

		SeguirJugando = new JButton("");
		SeguirJugando.setIcon(new ImageIcon("imagenes/SeguirGanandoV2 (1).png"));
		SeguirJugando.setBounds(260, 95, 159, 28);
		contentPanel.add(SeguirJugando);
		this.SeguirJugando.addActionListener(this);

		PerderLaRacha = new JButton("");
		PerderLaRacha.setIcon(new ImageIcon("imagenes/PerderRacha.png"));
		PerderLaRacha.setBounds(260, 160, 159, 28);
		contentPanel.add(PerderLaRacha);
		this.PerderLaRacha.addActionListener(this);

		Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon("imagenes/FondoDeVictoria.png"));
		Fondo.setBounds(0, 0, 436, 263);
		contentPanel.add(Fondo);

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//si se pulsa el boton de perder la racha se cierra la ventana y vuelve a la ventana de seleccion de juego

		if(e.getSource()==PerderLaRacha) {

			if (elusuario.getBalance() == 0) {
				VentanaBlackJack.dispose();
				this.dispose();
				VentanaRuletaRusa vI=new VentanaRuletaRusa(cont, elusuario, table, played);
				vI.setVisible(true);	
			} else {
				VentanaBlackJack.dispose();
				this.dispose();
				SelecionJuego sJ=new SelecionJuego(cont, elusuario, table, played);
				sJ.setVisible(true);
			}
		}
		if(e.getSource()==SeguirJugando) {

			if (elusuario.getBalance() == 0) {
					VentanaBlackJack.dispose();
					VentanaRuletaRusa vI=new VentanaRuletaRusa(cont, elusuario, table, played);
					vI.setVisible(true);
					this.dispose();
			} else {
				this.dispose();
			}


		}

	}
}
