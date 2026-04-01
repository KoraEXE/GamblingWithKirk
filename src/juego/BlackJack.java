package juego;
import java.util.ArrayList;

import modelo.*;

public class BlackJack {
	private int cantidad;
	private ArrayList<Carta> baraja = new ArrayList<>();
	boolean juegoActivo = false;
	
	// -Jugador y cartas-
		//ramdomizar la selecion de cartas para el jugador. 
		//El numero que aparece es el numero de la carta (posicion) y se le quita de la baraja para que no se repita
		//El segundo numero es toda la baraja (52 cartas -1) 

	//Luego se le reparten 2 cartas al crupier que al igual que a las anteriores cartas se le es quita del fichero/arraylist

	// -Posicion de las cartas y a la hora de repartir-
		//La primera carta que se reparte esta boca arriba, mientras que la segunda esta boca abajo
	
	// -Casauticas AS-
		//El As siempre valdra 11 a menos a que el jugador supere los 21 con As. Y es por eso que se le cambiara el valor a 1.
	
	// -Casauticas Dividir-
		//Si las primeras dos cartas son identicas, tienes la opcion de poder dividirlas. Doblas la apuesta, y jugaras doble mano de forma independiente. 
		//Donde puedes ganar, empatar y perdaer por ambas partes
		//Si se repite que se puede volver repetir (diremos que las mesas estan ocupadas
	
	// -Casauticas Doblar-
		//Si en tus primeras cartas obtienes un 9/10/11 puedes doblar, solamente se te dara una carta mas y terminas y doblaras la apuesta
		//Se le avisara al usuario con antelacion que sera su ultima carta
	
	// -Casauticas Renirese-
		//Si te rindes pierdes automaticamente
	
	// -Extras, racha-
		//Aumenta 0,10 el multiplicador de dinero por cada victoria hasta un maximo de 0,1
		//Si ha sido blackjack aumentara un 0,25 en vez de 0,10
		//Despues de 5 ganadas no se sumaran nada mas
		//Si has perdido puedes mantener la racha pagando 1/12 de tu dinero

	public void apostar() {
		int apuesta = cantidad;

		if (apuesta > 0) {
			juegoActivo = true;
			
			

		} else {
			juegoActivo = false;
		}
	} 


}
