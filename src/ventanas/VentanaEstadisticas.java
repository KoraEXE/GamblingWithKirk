package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controlador.LoginControlador;
import modelo.Play_On_Table;
import modelo.Played;
import modelo.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;


public class VentanaEstadisticas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LoginControlador cont;
	private User elusuario;
	private JButton btnVolver;
	private Play_On_Table table;
	private Played played;
	private JTable table_1;
	private JLabel lblTitle;
	private JLabel Texto1;
	private JLabel Texto2;
	private JLabel Texto3;
	private JLabel texto4;
	private JLabel texto5;
	private JLabel texto6;


	public VentanaEstadisticas(LoginControlador cont, User elusuario, Play_On_Table table, Played played) {

		cont = new LoginControlador();
		this.cont=cont;
		this.elusuario = elusuario;
		this.table = table;
		this.played = played;

		setTitle("Stats");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1536, 864);

		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		cont.obtenerStadisticas(elusuario);

		table_1 = new JTable();
		JScrollPane scroll = new JScrollPane(table_1);
		scroll.setBounds(460, 113, 600, 200);
		contentPane.add(scroll);

		ArrayList<Played> lista = cont.obtenerHistorial(elusuario);

		DefaultTableModel modelo = new DefaultTableModel(
				new String[]{"Fecha", "Apuesta", "Resultado"}, 0
				);

		for (Played p : lista) {
			modelo.addRow(new Object[]{
					p.getDate(),
					p.getApuestaEnJuego(),
					p.getResult()
			});
		}

		table_1.setModel(modelo);

		btnVolver = new JButton("RETURN");
		btnVolver.setBounds(675, 532, 169, 43);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);

		lblTitle = new JLabel("STATS");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitle.setBounds(634, 67, 252, 35);
		contentPane.add(lblTitle);

		Texto1 = new JLabel("Max Combo:");
		Texto1.setHorizontalAlignment(SwingConstants.LEFT);
		Texto1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Texto1.setBounds(460, 334, 143, 35);
		contentPane.add(Texto1);

		Texto2 = new JLabel("Veces Jugadas:");
		Texto2.setHorizontalAlignment(SwingConstants.LEFT);
		Texto2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Texto2.setBounds(460, 402, 143, 35);
		contentPane.add(Texto2);

		Texto3 = new JLabel("Dinero actual:");
		Texto3.setHorizontalAlignment(SwingConstants.LEFT);
		Texto3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Texto3.setBounds(460, 470, 143, 35);
		contentPane.add(Texto3);

		texto4 = new JLabel("");
		texto4.setHorizontalAlignment(SwingConstants.LEFT);
		texto4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		texto4.setBounds(616, 334, 270, 35);
		contentPane.add(texto4);

		texto5 = new JLabel("");
		texto5.setHorizontalAlignment(SwingConstants.LEFT);
		texto5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		texto5.setBounds(616, 402, 270, 35);
		contentPane.add(texto5);

		texto6 = new JLabel("");
		texto6.setHorizontalAlignment(SwingConstants.LEFT);
		texto6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		texto6.setBounds(616, 470, 270, 35);
		contentPane.add(texto6);
		
		cont.obtenerStadisticas(elusuario);
		cont.actualizarDinero(elusuario);
		texto4.setText(String.valueOf(elusuario.getMaxCombo()));
		texto5.setText(String.valueOf(elusuario.getVecesJugadas()));
		texto6.setText(String.valueOf(elusuario.getBalance()));
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ArrayList<Played> lista = cont.obtenerHistorial(elusuario);
		DefaultTableModel modelo = new DefaultTableModel(
				new String[]{"Fecha", "Apuesta", "Resultado"}, 0
				);

		for (Played p : lista) {
			modelo.addRow(new Object[]{
					p.getDate(),
					p.getApuestaEnJuego(),
					p.getResult()
			});
		}

		table_1.setModel(modelo);


		

		if(e.getSource()==btnVolver) {
			this.dispose();
			SelecionJuego sJ=new SelecionJuego(cont, elusuario, table, played);
			sJ.setVisible(true);
		}

	}
}
