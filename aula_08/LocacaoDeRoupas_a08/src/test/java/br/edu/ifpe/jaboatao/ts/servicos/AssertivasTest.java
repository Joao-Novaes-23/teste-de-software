package br.edu.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;

public class AssertivasTest {

	@Test
	public void assertTrue() {
		Assertions.assertTrue(true);
		Assertions.assertFalse(false);
	}
	@Test
	public void assertEquals() {
		//Inteiros
		Assertions.assertEquals(1, 1,"Erro de comparação.");
		Assertions.assertNotEquals(1, 2);
		//Decimais
		Assertions.assertEquals(0.52, 0.522, 0.01);
		//Texto
		Assertions.assertEquals("casa", "casa");
		Assertions.assertTrue("casa".equalsIgnoreCase("Casa"));
		//Objetos
		Cliente cliente01 = new Cliente("Cliente 01");
		Cliente cliente02 = new Cliente("Cliente 01");
		Assertions.assertEquals(cliente01, cliente02);
	}
	@Test
	public void assertSame() {
		Cliente cliente01 = new Cliente("Cliente 01");
		Cliente cliente02 = new Cliente("Cliente 01");
		Cliente cliente03 = cliente02;
		Assertions.assertSame(cliente02, cliente03);
		Assertions.assertNotSame(cliente01,cliente02);
	}
	@Test
	public void assertNull() {
		Cliente cliente01 = null;
		Cliente cliente02 = new Cliente("Cliente 01");
		Assertions.assertNull(cliente01);
		Assertions.assertNotNull(cliente02);
		Assertions.assertTrue(cliente01 == null);
		Assertions.assertEquals(cliente01, null);
	}
}
