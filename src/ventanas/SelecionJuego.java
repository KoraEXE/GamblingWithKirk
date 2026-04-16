package ventanas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.Play_On_Table;
import modelo.Played;
import modelo.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class SelecionJuego extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton blackJack;
	private JButton stats;
	private JButton cerrarSesion;
	private JButton borrar;
	private JButton btnRuleta;
	private LoginControlador cont;
	private JLabel nombreJugador;
	private JLabel dineroJugador;
	private JLabel textoDIneroJugador;
	private JLabel textoNombreJugador;
	private User elusuario;
	private Play_On_Table table;
	private Played played;

	public SelecionJuego(LoginControlador controlador, User elusuario, Play_On_Table table, Played played) {

		cont = new LoginControlador();
		this.played = played;
		this.table=table;
		this.cont=controlador;
		this.elusuario = elusuario;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setSize(1536, 864);
		this.setLocation(0, 0);

		btnRuleta = new JButton("5. RULETA");
		btnRuleta.setBounds(81, 518, 271, 61);
		contentPanel.add(btnRuleta);
		this.btnRuleta.addActionListener(this);


		dineroJugador = new JLabel((String) null);
		dineroJugador.setForeground(new Color(0, 255, 64));
		dineroJugador.setHorizontalAlignment(SwingConstants.LEFT);
		dineroJugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		dineroJugador.setBounds(148, 59, 304, 44);
		contentPanel.add(dineroJugador);
		dineroJugador.setText(String.valueOf(elusuario.getBalance()));

		textoDIneroJugador = new JLabel("Dinero");
		textoDIneroJugador.setForeground(new Color(255, 255, 255));
		textoDIneroJugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textoDIneroJugador.setBounds(33, 59, 115, 44);
		contentPanel.add(textoDIneroJugador);

		nombreJugador = new JLabel("");
		nombreJugador.setForeground(new Color(255, 255, 255));
		nombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		nombreJugador.setHorizontalAlignment(SwingConstants.LEFT);
		nombreJugador.setBounds(148, 21, 304, 44);
		contentPanel.add(nombreJugador);
		nombreJugador.setText(elusuario.getName());

		textoNombreJugador = new JLabel("Jugador:");
		textoNombreJugador.setForeground(new Color(255, 255, 255));
		textoNombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textoNombreJugador.setBounds(23, 21, 115, 44);
		contentPanel.add(textoNombreJugador);
		{
			blackJack = new JButton("1. BLACK JACK");
			blackJack.setBounds(545, 494, 357, 71);
			contentPanel.add(blackJack);
			this.blackJack.addActionListener(this);
		}
		{
			stats = new JButton("2. STATS");
			stats.setBounds(387, 678, 193, 38);
			contentPanel.add(stats);
			this.stats.addActionListener(this);
		}
		{
			cerrarSesion = new JButton("3. CERRAR SESIÓN");
			cerrarSesion.setBounds(661, 678, 193, 38);
			contentPanel.add(cerrarSesion);
			cerrarSesion.addActionListener(this);
		}
		{
			borrar = new JButton("4. BORRAR");
			borrar.setBounds(937, 678, 193, 38);
			contentPanel.add(borrar);
			{
				JLabel fondoo = new JLabel("");
				fondoo.setIcon(new ImageIcon("imagenes/select game.jpg"));
				fondoo.setBounds(0, 0, 1522, 827);
				contentPanel.add(fondoo);
			}
			this.borrar.addActionListener(this);
		}



	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


		if(e.getSource()==cerrarSesion) {
			VentanaInicial vI=new VentanaInicial(cont);
			vI.setVisible(true);
			this.dispose();
		}

		if (e.getSource()==blackJack) {
			generadorDeCodigo();
			cont.insertarMesa(table);
			VentanaBlackJack vI=new VentanaBlackJack(cont, elusuario, table, played);
			vI.setVisible(true);
			this.dispose();
		}

		if (e.getSource()==stats) {
			VentanaEstadisticas vI=new VentanaEstadisticas(cont, elusuario, table, played);
			vI.setVisible(true);
			this.dispose();
		}

		if (e.getSource()==btnRuleta) {
			VentanaRuletaRusa vI=new VentanaRuletaRusa(cont, elusuario, table, played);
			vI.setVisible(true);
			this.dispose();
		}


		if (e.getSource()==borrar) {

			int respuesta =JOptionPane.showConfirmDialog(null,  "¿Estas seguro que quieres realizar esta accion?");
			if (respuesta == 2 ) { //no

			} else {
				cont.borrarUsuario(elusuario);
				VentanaInicial vI=new VentanaInicial(cont);
				vI.setVisible(true);
				this.dispose();
			}
		}
	}

	public void generadorDeCodigo() {
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String resultado = "";
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			int indice = random.nextInt(caracteres.length());
			resultado += caracteres.charAt(indice);
		}
		table.setId_table(resultado.toUpperCase());
	}
}

