package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;
import modelo.User;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Color;

public class HasMuerto extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel miniIcono;
	private JLabel TextoGanado;
	private JButton SeguirJugando;
	private LoginControlador cont;
	private User elusuario;


	public HasMuerto( LoginControlador cont, User elusuario) {
		this.cont = cont;
		this.elusuario = elusuario;
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/miniIconoV2.png"));
		setAlwaysOnTop(true);
		setUndecorated(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocation(150, 150);

		miniIcono = new JLabel("");
		miniIcono.setIcon(new ImageIcon("imagenes/miniIconoV2.png"));
		miniIcono.setBounds(384, 219, 52, 44);
		contentPanel.add(miniIcono);

		TextoGanado = new JLabel("");
		TextoGanado.setHorizontalAlignment(SwingConstants.CENTER);
		TextoGanado.setIcon(new ImageIcon("imagenes/HasMuertoV2.png"));
		TextoGanado.setBounds(0, 0, 436, 144);
		contentPanel.add(TextoGanado);

		SeguirJugando = new JButton("");
		SeguirJugando.setIcon(new ImageIcon("imagenes/contiarDespuesDeMorir.png"));
		SeguirJugando.setBounds(114, 168, 206, 44);
		contentPanel.add(SeguirJugando);
		this.SeguirJugando.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==SeguirJugando) {
			cont.borrarUsuario(elusuario);
			this.dispose();		
		}
		
		

	}
}
