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

	public SelecionJuego() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(100, 25, 247, 70);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\1dami\\Downloads\\SelecionJuego.png"));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnNewButton = new JButton("1. BLACK JACK");
			btnNewButton.setBounds(150, 115, 148, 20);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("2. STATS");
			btnNewButton_1.setBounds(150, 140, 148, 20);
			contentPanel.add(btnNewButton_1);
		}
		{
			JButton btnNewButton_2 = new JButton("3. CERRAR SESIÓN");
			btnNewButton_2.setBounds(150, 165, 148, 20);
			contentPanel.add(btnNewButton_2);
		}
		{
			JButton btnNewButton_3 = new JButton("4. BORRAR");
			btnNewButton_3.setBounds(150, 190, 148, 20);
			contentPanel.add(btnNewButton_3);
		}
		{
			JButton btnNewButton_4 = new JButton("5. PRAY");
			btnNewButton_4.setBounds(150, 215, 148, 20);
			contentPanel.add(btnNewButton_4);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\1dami\\Downloads\\Jimbo2 ORIGINAL.jpg"));
			lblNewLabel_1.setBounds(20, 45, 120, 195);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\1dami\\Downloads\\Jimbo1 ORIGINAL.jpg"));
			lblNewLabel_1.setBounds(308, 45, 120, 195);
			contentPanel.add(lblNewLabel_1);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
