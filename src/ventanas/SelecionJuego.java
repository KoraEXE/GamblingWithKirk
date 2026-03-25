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
		
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(140, 25, 154, 66);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\1dami.TARTANGALH\\Desktop\\IMG Reto 3 eva Kasinoa\\SelecionJuego.png"));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel);
		}
		{
			blackJack = new JButton("1. BLACK JACK");
			blackJack.setBounds(140, 115, 154, 20);
			contentPanel.add(blackJack);
		}
		{
			stats = new JButton("2. STATS");
			stats.setBounds(140, 140, 154, 20);
			contentPanel.add(stats);
		}
		{
			cerrarSesion = new JButton("3. CERRAR SESIÓN");
			cerrarSesion.setBounds(140, 165, 154, 20);
			contentPanel.add(cerrarSesion);
			cerrarSesion.addActionListener(this);
		}
		{
			borrar = new JButton("4. BORRAR");
			borrar.setBounds(140, 190, 154, 20);
			contentPanel.add(borrar);
		}
		{
			pray = new JButton("5. PRAY");
			pray.setBounds(140, 215, 154, 20);
			contentPanel.add(pray);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\1dami.TARTANGALH\\Desktop\\IMG Reto 3 eva Kasinoa\\Jimbo2 ORIGINAL.jpg"));
			lblNewLabel_1.setBounds(10, 40, 120, 195);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\1dami.TARTANGALH\\Desktop\\IMG Reto 3 eva Kasinoa\\Jimbo1 ORIGINAL.jpg"));
			lblNewLabel_1.setBounds(306, 40, 120, 195);
			contentPanel.add(lblNewLabel_1);
		}

		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon("C:\\\\Users\\\\1dami.TARTANGALH\\\\Desktop\\\\IMG Reto 3 eva Kasinoa\\fondo2.png"));
		Fondo.setBounds(0, 0, 436, 263);
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
	}
}

