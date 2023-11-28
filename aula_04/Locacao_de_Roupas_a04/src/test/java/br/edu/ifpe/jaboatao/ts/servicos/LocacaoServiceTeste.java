package br.edu.ifpe.jaboatao.ts.servicos; // Mesmo pacote para acessar as variáveis e métodos default e protected.

import java.util.Date;

import org.junit.jupiter.api.Assertions;  // Importar o JUnit: precisa adicionar as dependencies no arquivo pom.xml
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;
import br.edu.ifpe.jaboatao.ts.exceptions.LocacaoException;
import br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas;

@DisplayName("Testes em locacao")
public class LocacaoServiceTeste 
{
	@Test
	@DisplayName("Primeiro Teste")
	public void primeiroTeste() throws LocacaoException // Método onde os testes são executados e verificados.
	{
		// Cenário
		LocacaoService service = new LocacaoService();
		Cliente cliente = new Cliente("Cliente 01");
		Roupa roupa = new Roupa("Roupa 01", "M", 2, 40.0);
		Locacao locacao = new Locacao();
		
		// Ação
		locacao = service.alugarRoupa(cliente, roupa);
		
		// Verificação
		Assertions.assertTrue(locacao.getValorLocacao() == 40);
		Assertions.assertTrue(ManipulandoDatas.boDatasIguais(locacao.getDataLocacao(), new Date()));
		Assertions.assertTrue(ManipulandoDatas.boDatasIguais(locacao.getDataRetorno(), 
		ManipulandoDatas.novaDataComDiferencaDeDias(3)));
	}
	
	@Test
	@DisplayName("Exception - Estoque vazio - Modo Try/catch")
	public void exception01()
	{
		// Cenário
		LocacaoService service = new LocacaoService();
		Cliente cliente = new Cliente("Cliente 01");
		Roupa roupa = new Roupa("Roupa 01", "M", 0, 40.0);
		Locacao locacao = new Locacao();
		
		// Ação
		try 
		{
			locacao = service.alugarRoupa(cliente, roupa);
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
		Roupa roupa = new Roupa("Roupa 01", "M", 0, 40.0);
		Locacao locacao = new Locacao();
		
		// Ação
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () ->
		{
			service.alugarRoupa(cliente, roupa);
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
		Roupa roupa = null;
		Locacao locacao = new Locacao();
		
		// Ação
		try 
		{
			locacao = service.alugarRoupa(cliente, roupa);			// Poderia botar (cliente, null)
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
		Roupa roupa = new Roupa("Roupa 01", "M", 0, 40.0);
		Locacao locacao = new Locacao();
		
		// Ação
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () ->
		{
			service.alugarRoupa(cliente, null);
		}, "Deveria ter ocorrido uma exceção.");
		
		// Verificação
		Assertions.assertEquals("Roupa nula.", e.getMessage());
	}
}

































