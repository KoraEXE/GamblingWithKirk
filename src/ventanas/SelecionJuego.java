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

public class SelecionJuego extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton blackJack;
	private JButton stats;
	private JButton cerrarSesion;
	private JButton borrar;
	private JButton pray;
	private LoginControlador cont;
	private JLabel nombreJugador;
	private JLabel dineroJugador;
	private JLabel textoDIneroJugador;
	private JLabel textoNombreJugador;
	private User elusuario;
	private Play_On_Table table;
	private Played played;

	public SelecionJuego(LoginControlador controlador, User elusuario, Play_On_Table table, Played played) {
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
		
		
		dineroJugador = new JLabel((String) null);
		dineroJugador.setHorizontalAlignment(SwingConstants.LEFT);
		dineroJugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		dineroJugador.setBounds(148, 76, 304, 44);
		contentPanel.add(dineroJugador);
		dineroJugador.setText(String.valueOf(elusuario.getBalance()));
		
		textoDIneroJugador = new JLabel("Dinero");
		textoDIneroJugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textoDIneroJugador.setBounds(23, 76, 115, 44);
		contentPanel.add(textoDIneroJugador);
		
		nombreJugador = new JLabel("");
		nombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		nombreJugador.setHorizontalAlignment(SwingConstants.LEFT);
		nombreJugador.setBounds(148, 21, 304, 44);
		contentPanel.add(nombreJugador);
		nombreJugador.setText(elusuario.getName());
		
		textoNombreJugador = new JLabel("Jugador:");
		textoNombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textoNombreJugador.setBounds(23, 21, 115, 44);
		contentPanel.add(textoNombreJugador);
		
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(470, 0, 581, 387);
			lblNewLabel.setIcon(new ImageIcon("imagenes/SelecionaJuego V1.png"));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel);
		}
		{
			blackJack = new JButton("1. BLACK JACK");
			blackJack.setBounds(582, 397, 357, 71);
			contentPanel.add(blackJack);
			this.blackJack.addActionListener(this);
		}
		{
			stats = new JButton("2. STATS");
			stats.setBounds(582, 478, 357, 71);
			contentPanel.add(stats);
			this.stats.addActionListener(this);
		}
		{
			cerrarSesion = new JButton("3. CERRAR SESIÓN");
			cerrarSesion.setBounds(582, 559, 357, 71);
			contentPanel.add(cerrarSesion);
			cerrarSesion.addActionListener(this);
		}
		{
			borrar = new JButton("4. BORRAR");
			borrar.setBounds(582, 640, 357, 71);
			contentPanel.add(borrar);
			this.borrar.addActionListener(this);
		}
		{
			pray = new JButton("5. PRAY");
			pray.setBounds(582, 721, 357, 71);
			contentPanel.add(pray);
			this.pray.addActionListener(this);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("imagenes/Balatro2.png"));
			lblNewLabel_1.setBounds(0, 0, 572, 827);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("imagenes/Balatro1.png"));
			lblNewLabel_1.setBounds(949, 0, 573, 827);
			contentPanel.add(lblNewLabel_1);
		}

		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon("imagenes/fondo2.png"));
		Fondo.setBounds(0, 0, 1904, 1041);
		contentPanel.add(Fondo);
		
		

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
}

