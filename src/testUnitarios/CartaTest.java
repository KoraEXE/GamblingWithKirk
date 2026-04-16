package testUnitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;
import modelo.Carta;

public class CartaTest {

	@Test
	void testSetImagen() {
		ImageIcon img = new ImageIcon();
		Carta carta = new Carta();
		carta.setImagen(img);

		assertEquals(img, carta.getImagen());
	}

	@Test
	void testSetNumero_NoSeSeteaCorrectamente() {
		Carta carta = new Carta();

		carta.setNumero("DOS");
		assertNull(carta.getNumero());
	}
	@Test
	void testSetNumeroNoValido() {
		Carta carta = new Carta();

		carta.setNumero("INVALIDO");

		boolean resultado = carta.getNumero() != null;

		assertFalse(resultado);
	}

	@Test
	void testSetNumeroConNullLanzaExcepcion() {

		Carta carta = new Carta();

		assertThrows(NullPointerException.class, () -> {
			carta.setNumero(null);
		});

	}
}
/*public class CartaMockitoTest {

    @Test
    void testSetImagenConMock() {
        ImageIcon mockImagen = mock(ImageIcon.class);

        Carta carta = new Carta();
        carta.setImagen(mockImagen);

        assertEquals(mockImagen, carta.getImagen());
    }
}*/
