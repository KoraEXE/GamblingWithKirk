package modelo;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class Carta implements Serializable {
	private String numero; //Los numeros posibles son 1,2,3,4,5,6,7,8,9,10 y 11. El as puede ser 1 u 11 dependiendo del valor.
	private ImageIcon imagen;
	
	public Carta (String numero, ImageIcon imagen) {
		this.numero = numero;
		this.imagen = imagen;
	}
	
	public Carta () {
	}

	public String getNumero() { //Solo se setea porque el numero ya esta dfinido para no liarnos
		return numero;
	}
	
	public String setNumero() { //Este es solo para el AS para cambiar su valor dependiendo si la mano se supera o no
		return numero;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setNumero(String numero) {
		if(numero.compareTo("AS")==1||numero.compareTo("DOS")==2||numero.compareTo("TRES")==3||numero.compareTo("CUATRO")==4||
		   numero.compareTo("CINCO")==5||numero.compareTo("SEIS")==6||numero.compareTo("SIETE")==7||numero.compareTo("OCHO")==8||
		   numero.compareTo("NUEVE")==9||numero.compareTo("DIEZ")==10||numero.compareTo("J")==10||numero.compareTo("Q")==10||numero.compareTo("K")==10) {
			this.numero = numero;
		}
	}
	
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
}
