package br.edu.ifpe.jaboatao.ts.servicos; // Mesmo pacote para acessar as variáveis e métodos default e protected.

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;  // Importar o JUnit: precisa adicionar as dependencies no arquivo pom.xml
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;
import br.edu.ifpe.jaboatao.ts.exceptions.LocacaoException;

@DisplayName("Testes em locacao")
public class LocacaoServiceTeste 
{
	
	
	@Test
	@DisplayName("Exception - Estoque vazio - Modo Try/catch")
	public void exception01()
	{
		// Cenário
		LocacaoService service = new LocacaoService();
		Cliente cliente = new Cliente("Cliente 01");
		List<Roupa> roupas = Arrays.asList(new Roupa("Roupa 01", "M", 0, 40.0));
		Locacao locacao = new Locacao();
		
		// Ação
		try 
		{
			locacao = service.alugarRoupas(cliente, roupas);
			Assertions.fail("Deveria ter ocorrido uma exceção.");
		} 
		catch (LocacaoException e) 
		{
			// Verificação    
			Assertions.assertEquals("Estoque vazio.", e.getMessage()); // Tem que ser a exata mesma mensagem.
		}
	}
	
	@Test
	@DisplayName("Exception - Estoque vazio - Modo assertThrows")
	public void exception02()
	{
		// Cenário
		LocacaoService service = new LocacaoService();
		Cliente cliente = new Cliente("Cliente 01");
		List<Roupa> roupas = Arrays.asList(new Roupa("Roupa 01", "M", 0, 40.0));
		Locacao locacao = new Locacao();
		
		// Ação
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () ->
		{
			service.alugarRoupas(cliente, roupas);
		}, "Deveria ter ocorrido uma exceção.");
		
		// Verificação
		Assertions.assertEquals("Estoque vazio.", e.getMessage());
	}
	
	@Test
	@DisplayName("Exception - Roupa nula - Modo Try/catch")
	public void exception03()
	{
		// Cenário
		LocacaoService service = new LocacaoService();
		Cliente cliente = new Cliente("Cliente 01");
		List<Roupa> roupas = null;
		Locacao locacao = new Locacao();
		
		// Ação
		try 
		{
			locacao = service.alugarRoupas(cliente, roupas);			// Poderia botar (cliente, null)
			Assertions.fail("Deveria ter ocorrido uma exceção.");
		} 
		catch (LocacaoException e) 
		{
			// Verificação    
			Assertions.assertEquals("Roupa nula.", e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Exception - Roupa nula - Modo assertThrows")
	public void exception04()
	{
		// Cenário
		LocacaoService service = new LocacaoService();
		Cliente cliente = new Cliente("Cliente 01");
		List<Roupa> roupas = Arrays.asList(new Roupa("Roupa 01", "M", 0, 40.0));
		Locacao locacao = new Locacao();
		
		// Ação
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () ->
		{
			service.alugarRoupas(cliente, null);
		}, "Deveria ter ocorrido uma exceção.");
		
		// Verificação
		Assertions.assertEquals("Roupa nula.", e.getMessage());
	}
	
	// Criar um novo teste.
	// No cenário deverá constar duas roupas, uma custando 40.0 e a outra 60.0
	// O teste deverá checar se o valor será exatamente R$100.00
	
	@Test
	@DisplayName("Preço de duas bicicletas")
	public void duasBikes()
	{
		// Cenário
		Locacao locacao = new Locacao();
		Cliente cliente = new Cliente("Cliente 01");
		List<Roupa> roupas = Arrays.asList(new Roupa("Roupa 01", "M", 3, 40.0),
										   new Roupa("Roupa 02", "G", 6, 60.0));
		LocacaoService service = new LocacaoService();
		
		// Ação
		try {
			locacao = service.alugarRoupas(cliente, roupas);
		} catch (LocacaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Verificação
		Assertions.assertEquals(locacao.getValorLocacao(), 100);
	}
}

































