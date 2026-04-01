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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class SelecionJuego extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton blackJack;
	private JButton stats;
	private JButton cerrarSesion;
	private JButton borrar;
	private JButton pray;

	public SelecionJuego() { 
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);
		this.setLocation(0, 0);
		
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(661, 0, 581, 387);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\koraw\\git\\GamblingWithKirk\\imagenes\\SelecionaJuego V1.png"));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel);
		}
		{
			blackJack = new JButton("1. BLACK JACK");
			blackJack.setBounds(773, 469, 357, 71);
			contentPanel.add(blackJack);
			this.blackJack.addActionListener(this);
		}
		{
			stats = new JButton("2. STATS");
			stats.setBounds(773, 551, 357, 71);
			contentPanel.add(stats);
		}
		{
			cerrarSesion = new JButton("3. CERRAR SESIÓN");
			cerrarSesion.setBounds(773, 633, 357, 71);
			contentPanel.add(cerrarSesion);
			cerrarSesion.addActionListener(this);
		}
		{
			borrar = new JButton("4. BORRAR");
			borrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			borrar.setBounds(773, 715, 357, 71);
			contentPanel.add(borrar);
		}
		{
			pray = new JButton("5. PRAY");
			pray.setBounds(773, 797, 357, 71);
			contentPanel.add(pray);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\koraw\\git\\GamblingWithKirk\\imagenes\\Balatro2.png"));
			lblNewLabel_1.setBounds(0, 0, 661, 1041);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\koraw\\git\\GamblingWithKirk\\imagenes\\Balatro1.png"));
			lblNewLabel_1.setBounds(1243, 0, 661, 1041);
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
			VentanaInicial vI=new VentanaInicial();
			vI.setVisible(true);
			this.dispose();
		}
		
		if (e.getSource()==blackJack) {
			VentanaBlackJack vI=new VentanaBlackJack();
			vI.setVisible(true);
			this.dispose();
		}
	}
}

