package modelo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

public class Baraja implements Serializable {

	public ArrayList<Carta> baraja = new ArrayList<>();
	public String RUTA = "baraja.dat";

	public ArrayList<Carta> getBaraja() {
		return baraja;
	}

	public void setBaraja(ArrayList<Carta> baraja) {
		this.baraja = baraja;
	}

	public String getRUTA() {
		return RUTA;
	}

	public void setRUTA(String rUTA) {
		RUTA = rUTA;
	}

	public Baraja(File f, ArrayList<Carta> baraja) {
		f = new File(RUTA);

		if (!f.exists()) {
			crearYGuardarBaraja(); //si no existe, la crea
		}

		cargarBaraja(baraja); //siempre la carga
		barajar();
	}

	public void crearYGuardarBaraja() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA));

			oos.writeObject(new Carta("UNO", new ImageIcon("imagenes/1-Picas.jpg")));
			oos.writeObject(new Carta("DOS", new ImageIcon("imagenes/2-Picas.jpg")));
			oos.writeObject(new Carta("TRES", new ImageIcon("imagenes/3-Picas.jpg")));
			oos.writeObject(new Carta("CUATRO", new ImageIcon("imagenes/4-Picas.jpg")));
			oos.writeObject(new Carta("CINCO", new ImageIcon("imagenes/5-Picas.jpg")));
			oos.writeObject(new Carta("SEIS", new ImageIcon("imagenes/6-Picas.jpg")));
			oos.writeObject(new Carta("SIETE", new ImageIcon("imagenes/7-Picas.jpg")));
			oos.writeObject(new Carta("OCHO", new ImageIcon("imagenes/8-Picas.jpg")));
			oos.writeObject(new Carta("NUEVE", new ImageIcon("imagenes/9-Picas.jpg")));
			oos.writeObject(new Carta("DIEZ", new ImageIcon("imagenes/10-Picas.jpg")));
			oos.writeObject(new Carta("J", new ImageIcon("imagenes/J-Picas.jpg")));
			oos.writeObject(new Carta("Q", new ImageIcon("imagenes/Q-Picas.jpg")));
			oos.writeObject(new Carta("K", new ImageIcon("imagenes/K-Picas.jpg")));

			oos.writeObject(new Carta("UNO", new ImageIcon("imagenes/1-Corazones.jpg")));
			oos.writeObject(new Carta("DOS", new ImageIcon("imagenes/2-Corazones.jpg")));
			oos.writeObject(new Carta("TRES", new ImageIcon("imagenes/3-Corazones.jpg")));
			oos.writeObject(new Carta("CUATRO", new ImageIcon("imagenes/4-Corazones.jpg")));
			oos.writeObject(new Carta("CINCO", new ImageIcon("imagenes/5-Corazones.jpg")));
			oos.writeObject(new Carta("SEIS", new ImageIcon("imagenes/6-Corazones.jpg")));
			oos.writeObject(new Carta("SIETE", new ImageIcon("imagenes/7-Corazones.jpg")));
			oos.writeObject(new Carta("OCHO", new ImageIcon("imagenes/8-Corazones.jpg")));
			oos.writeObject(new Carta("NUEVE", new ImageIcon("imagenes/9-Corazones.jpg")));
			oos.writeObject(new Carta("DIEZ", new ImageIcon("imagenes/10-Corazones.jpg")));
			oos.writeObject(new Carta("J", new ImageIcon("imagenes/J-Corazones.jpg")));
			oos.writeObject(new Carta("Q", new ImageIcon("imagenes/Q-Corazones.jpg")));
			oos.writeObject(new Carta("K", new ImageIcon("imagenes/K-Corazones.jpg")));

			oos.writeObject(new Carta("UNO", new ImageIcon("imagenes/1-Treboles.jpg")));
			oos.writeObject(new Carta("DOS", new ImageIcon("imagenes/2-Treboles.jpg")));
			oos.writeObject(new Carta("TRES", new ImageIcon("imagenes/3-Treboles.jpg")));
			oos.writeObject(new Carta("CUATRO", new ImageIcon("imagenes/4-Treboles.jpg")));
			oos.writeObject(new Carta("CINCO", new ImageIcon("imagenes/5-Treboles.jpg")));
			oos.writeObject(new Carta("SEIS", new ImageIcon("imagenes/6-Treboles.jpg")));
			oos.writeObject(new Carta("SIETE", new ImageIcon("imagenes/7-Treboles.jpg")));
			oos.writeObject(new Carta("OCHO", new ImageIcon("imagenes/8-Treboles.jpg")));
			oos.writeObject(new Carta("NUEVE", new ImageIcon("imagenes/9-Treboles.jpg")));
			oos.writeObject(new Carta("DIEZ", new ImageIcon("imagenes/10-Treboles.jpg")));
			oos.writeObject(new Carta("J", new ImageIcon("imagenes/J-Treboles.jpg")));
			oos.writeObject(new Carta("Q", new ImageIcon("imagenes/Q-Treboles.jpg")));
			oos.writeObject(new Carta("K", new ImageIcon("imagenes/K-Treboles.jpg")));

			oos.writeObject(new Carta("UNO", new ImageIcon("imagenes/1-Rombos.jpg")));
			oos.writeObject(new Carta("DOS", new ImageIcon("imagenes/2-Rombos.jpg")));
			oos.writeObject(new Carta("TRES", new ImageIcon("imagenes/3-Rombos.jpg")));
			oos.writeObject(new Carta("CUATRO", new ImageIcon("imagenes/4-Rombos.jpg")));
			oos.writeObject(new Carta("CINCO", new ImageIcon("imagenes/5-Rombos.jpg")));
			oos.writeObject(new Carta("SEIS", new ImageIcon("imagenes/6-Rombos.jpg")));
			oos.writeObject(new Carta("SIETE", new ImageIcon("imagenes/7-Rombos.jpg")));
			oos.writeObject(new Carta("OCHO", new ImageIcon("imagenes/8-Rombos.jpg")));
			oos.writeObject(new Carta("NUEVE", new ImageIcon("imagenes/9-Rombos.jpg")));
			oos.writeObject(new Carta("DIEZ", new ImageIcon("imagenes/10-Rombos.jpg")));
			oos.writeObject(new Carta("J", new ImageIcon("imagenes/J-Rombos.jpg")));
			oos.writeObject(new Carta("Q", new ImageIcon("imagenes/Q-Rombos.jpg")));
			oos.writeObject(new Carta("K", new ImageIcon("imagenes/K-rombos.jpg")));

			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarBaraja(ArrayList<Carta> baraja) {
		baraja.clear(); //Limpiar el arraylist (boom)

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA))) {

			boolean fin = false;

			while (!fin) {
				try {
					Carta c = (Carta) ois.readObject();
					baraja.add(c);
				} catch (EOFException e) {
					fin = true;
				}
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Carta getCarta(int i) {
		return baraja.get(i);
	}

	public void barajar() {
		Collections.shuffle(baraja);
	}
}
