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
import javax.swing.SwingConstants;
import java.awt.Color;

public class Derrota extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel miniIcono;
	private JLabel TextoGanado;
	private JButton SeguirJugando;


	public Derrota() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/miniIconoV2.png"));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		miniIcono = new JLabel("");
		miniIcono.setIcon(new ImageIcon("imagenes/miniIconoV2.png"));
		miniIcono.setBounds(384, 219, 52, 44);
		contentPanel.add(miniIcono);

		TextoGanado = new JLabel("");
		TextoGanado.setHorizontalAlignment(SwingConstants.CENTER);
		TextoGanado.setIcon(new ImageIcon("C:\\Users\\1dami\\git\\GamblingWithKirk\\imagenes\\HasMuertoV2.png"));
		TextoGanado.setBounds(0, 0, 436, 144);
		contentPanel.add(TextoGanado);

		SeguirJugando = new JButton("");
		SeguirJugando.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SeguirJugando.setIcon(new ImageIcon("C:\\Users\\1dami\\git\\GamblingWithKirk\\imagenes\\contiarDespuesDeMorirV3.png"));
		SeguirJugando.setBounds(114, 168, 244, 44);
		contentPanel.add(SeguirJugando);

		
			

	}


	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
