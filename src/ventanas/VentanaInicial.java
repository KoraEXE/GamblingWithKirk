package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.LoginControlador;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class VentanaInicial extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LoginControlador cont;
	private JButton btnPlay;
	private JButton btnRegister;


	public VentanaInicial() {
		setTitle("Ventana Inicial");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\1dami.TARTANGALH\\Desktop\\IMG Reto 3 eva Kasinoa\\Isr.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Casino");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(143, 0, 156, 47);
		contentPane.add(lblNewLabel);
		
		btnPlay = new JButton("Play");
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPlay.setBounds(287, 85, 97, 32);
		contentPane.add(btnPlay);
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.addActionListener(this);
		btnRegister.setBounds(270, 145, 130, 32);
		contentPane.add(btnRegister);
		
		ImageIcon lblimagen = new ImageIcon("C:\\Users\\1dami.TARTANGALH\\Desktop\\IMG Reto 3 eva Kasinoa/D.jpg");
		JLabel lblImagen = new JLabel(lblimagen);
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(0, 40, 260, 194);
		contentPane.add(lblImagen);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==btnRegister) {
			VentanaLogin vl=new VentanaLogin(cont);
			vl.setVisible(true);
			this.dispose();
		}
	}
}