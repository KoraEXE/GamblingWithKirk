package testUnitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

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
}

