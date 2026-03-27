package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Victoria extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel miniIcono;
	private JLabel TextoGanado;
	private JButton SeguirJugando;
	private JButton PerderLaRacha;
	private JLabel Fondo;


	public Victoria() {
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
		TextoGanado.setIcon(new ImageIcon("imagenes\\HasGanado (1).png"));
		TextoGanado.setBounds(0, 0, 221, 263);
		contentPanel.add(TextoGanado);

		SeguirJugando = new JButton("");
		SeguirJugando.setIcon(new ImageIcon("imagenes\\SeguirGanandoV2 (1).png"));
		SeguirJugando.setBounds(231, 95, 188, 28);
		contentPanel.add(SeguirJugando);
		
		PerderLaRacha = new JButton("");
		PerderLaRacha.setIcon(new ImageIcon("imagenes\\PerderRacha.png"));
		PerderLaRacha.setBounds(231, 160, 188, 28);
		contentPanel.add(PerderLaRacha);
		this.PerderLaRacha.addActionListener(this);

		Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon("imagenes\\FondoDeVictoria.png"));
		Fondo.setBounds(0, 0, 436, 263);
		contentPanel.add(Fondo);

		
			

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//si se pulsa el boton de perder la racha se cierra la ventana y vuelve a la ventana de seleccion de juego
		if(e.getSource()==PerderLaRacha) {
			SelecionJuego sJ=new SelecionJuego();
			sJ.setVisible(true);
			this.dispose();
		}

	}
}
