package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.LoginControlador;
import modelo.Play_On_Table;
import modelo.Played;
import modelo.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import ventanas.VentanaBlackJack;
import javax.swing.JComboBox;
import javax.swing.JTable;


public class VentanaEstadisticas extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LoginControlador cont;
	private User elusuario;
	private JLabel lblTitulo;
	private JLabel lblDato1;
	private JLabel lblDato4;
	private JButton btnVolver;
	private Play_On_Table table;
	private Played played;
	private JTable table_1;
	private JLabel lblTitle;
	
	
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
	    btnVolver.setBounds(672, 468, 169, 43);
	    btnVolver.addActionListener(this);
	    contentPane.add(btnVolver);
	    
	    lblTitle = new JLabel("STATS");
	    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
	    lblTitle.setBounds(634, 67, 252, 35);
	    contentPane.add(lblTitle);
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
