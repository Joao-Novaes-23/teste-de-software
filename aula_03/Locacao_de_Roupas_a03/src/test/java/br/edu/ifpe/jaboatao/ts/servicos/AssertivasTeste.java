package br.edu.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;

@DisplayName("Testando Assertivas.")
public class AssertivasTeste 
{
	@Test
	@DisplayName("Teste assertTrue.")
	public void teste()
	{
		Assertions.assertTrue(true);
		Assertions.assertFalse(false);
	}
	
	@Test
	@DisplayName("Teste assertEquals.") // Comparação usando o método equals.
	public void teste2()
	{
		// Se no final colocar um parâmetro extra, e ele for uma string, é a mensagem de erro que aparecerá.
		Assertions.assertEquals(1, 1, "1 deveria ser igual a 1"); 
		Assertions.assertEquals(1.11, 1.11);
		Assertions.assertEquals(Math.PI, 3.14, 0.01); // O terceiro parâmetro são as casas decimais levadas em conta.
		Assertions.assertEquals("casa", "casa");	  // Case sensitive.
		Assertions.assertNotEquals("Casa", "casa");
		Assertions.assertTrue("casa".equalsIgnoreCase("CASA"));	// Ignora se a letra é maiúscula ou minúscula.
		
		Cliente cliente1 = new Cliente("Cliente 01");
		Cliente cliente2 = new Cliente("Cliente 01");
		
		// Para passar no teste, é preciso que o método equals esteja implementado na classe Cliente.
		Assertions.assertEquals(cliente1, cliente2);  
		
		
	}
	
	@Test
	@DisplayName("Teste assertSame.")
	public void teste3()
	{
		Cliente cliente1 = new Cliente("Cliente 13"); // Os testes são independentes, então ter objetos com o mesmo
		Cliente cliente2 = cliente1; 				  // nome não interfere nos testes acima (teste2()).
		Cliente cliente3 = new Cliente("Cliente 13");
		
		// Verifica se os objetos são a mesma instância.
		Assertions.assertSame(cliente1, cliente2);
		Assertions.assertNotSame(cliente1, cliente3);
	}
	
	@Test
	@DisplayName("Teste assertNull.")
	public void teste4()
	{
		Cliente cliente1 = new Cliente("Cliente 01");
		Cliente cliente2 = null;
		
		Assertions.assertNull(cliente2);		// Passa se o parâmetro for nulo.
		Assertions.assertNotNull(cliente1);		// Passa se o não parâmetro for nulo.
	}
	
	@Test
	@DisplayName("Teste assertAll.")
	public void teste5()
	{
		Assertions.assertAll // Múltiplos erros podem aparecer de uma vez através do assertAll().
		(
				() -> Assertions.assertEquals(1, 1, "Um deveria ser igual a um."),
				() -> Assertions.assertEquals("casa", "casa", "A resposta é 'casa'."),
				() -> Assertions.assertTrue(true, "Era esperado 'true'.")
		);
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	