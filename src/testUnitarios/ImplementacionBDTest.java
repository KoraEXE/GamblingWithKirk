package testUnitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import java.time.LocalDate;

import org.junit.Test;
import modelo.*;

public class ImplementacionBDTest {

	private final ImplementacionBD bd = new ImplementacionBD();

	@Test
	public void testObtenerDNIUsuarioNoExiste_assertEquals() {
		User u = new User();
		u.setName("usuario_fake");
		u.setPassword("pass_fake");

		String dni = bd.obtenerDNI(u);

		assertEquals("", dni);
	}

	@Test
	public void testComprobarUsuarioNoExiste_assertFalse() {
		User u = new User();
		u.setName("no_existe");
		u.setPassword("1234");

		boolean resultado = bd.comprobarUsuario(u);

		assertFalse(resultado);
	}
	@Test
	public void testObtenerNombreUsuarioNoExiste_assertNull() {
		User u = new User();
		u.setDni("00000000X");

		String nombre = bd.obtenerNombre(u);

		assertNull(nombre);
	}
	@Test
	public void testNullUser_assertThrows() {

		ImplementacionBD bd = new ImplementacionBD();

		assertThrows(NullPointerException.class, () -> {
			bd.comprobarUsuario(null);
		});
	}
	@Test
	public void testInsertarUsuario_assertEquals() {

		User u = new User();
		u.setDni("99999999A");
		u.setName("testUser");
		u.setPassword("1234");
		u.setDate_of_birth(LocalDate.of(2000, 1, 1));
		u.setBalance(100.0);

		boolean resultado = bd.insertarUsuario(u);

		assertEquals(true, resultado);
	}
}
@Test
public void testRepetirDNINoExiste_assertFalse() {

	User u = new User();
	u.setDni("11111111Z");

	boolean existe = bd.repetirDNI(u);

	assertFalse(existe);
}

@Test
public void testObtenerDineroUsuarioInvalido_assertNull() {

	User u = new User();
	u.setName("usuario_invalido");
	u.setPassword("wrong");

	Integer dinero = null;

	try {
		int resultado = bd.obtenerDinero(u);
		dinero = resultado; 
	} catch (Exception e) {
		dinero = null;
	}

	assertNull(dinero);
}

@Test
public void testInsertarJuegoNull_assertThrows() {

	assertThrows(NullPointerException.class, () -> {
		bd.insertarJuego(null, null, null);
	});
	}
}


