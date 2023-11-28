package br.edu.ifpe.jaboatao.ts.servicos;

import static br.edu.ifpe.jaboatao.ts.builders.ClienteBuilder.umCliente;
import static br.edu.ifpe.jaboatao.ts.builders.RoupaBuilder.umaRoupa;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.builders.RoupaBuilder;
import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;
import br.edu.ifpe.jaboatao.ts.exceptions.FilmesExceptions;

public class LocacaoServiceTest {
	LocacaoService service;
	@BeforeEach
	public void setup() {
		service = new LocacaoService();
	}
		
	@Test
	@DisplayName("Valor da locação para um roupa.")
	public void teste02() throws FilmesExceptions {
		//Cen�rio
		//LocacaoService service = new LocacaoService();
//		Cliente cliente = new Cliente("Cliente 01");
//		Cliente cliente = ClienteBuilder.umCliente().agora();
		Cliente cliente = umCliente().agora();
//		List<Roupa> roupas = Arrays.asList(new Roupa("Roupar 01", "G", 2, 30.0));
		List<Roupa> roupas = Arrays.asList(RoupaBuilder.umaRoupa().agora());
		
		//A��o
		Locacao locacao = service.alugarRoupa(cliente, roupas);
		
		//Verifica��o
		Assertions.assertTrue(locacao.getValorLocacao() == 30.0);
	}
	@Test
	@DisplayName("Valor da locação para 05 roupas.")
	public void teste03() throws FilmesExceptions {
		//Cen�rio
		//LocacaoService service = new LocacaoService();
		Cliente cliente = umCliente().agora();
		List<Roupa> roupas = 
//				Arrays.asList(
//						new Roupa("Roupar 01", "G", 2, 30.0),
//						new Roupa("Roupa 02", "G", 2, 30.0),
//						new Roupa("Roupa 03", "G", 2, 30.0),
//						new Roupa("Roupa 04", "G", 2, 30.0),
//						new Roupa("Roupa 05", "G", 2, 30.0)
//						);
		Arrays.asList(
				umaRoupa().agora(),
				umaRoupa().agora(),
				umaRoupa().agora(),
				umaRoupa().agora(),
				umaRoupa().agora()
				);
		
		//A��o
		Locacao locacao = service.alugarRoupa(cliente, roupas);
		
		//Verifica��o
		Assertions.assertEquals(150, locacao.getValorLocacao());
	}
	@Test
	@DisplayName("Exception - Roupa sem Estoque - Modo try-catch")
	public void exception01() {
		//Cenário
		Cliente cliente = umCliente().agora();
//		List<Roupa> roupas =Arrays.asList(new Roupa("Roupa 1", "P", 0, 30.0));
		List<Roupa> roupas =Arrays.asList(umaRoupa().semEstoque().agora());
		
		//Ação
		try {
			Locacao locacao = service.alugarRoupa(cliente, roupas);
			Assertions.fail("Deveria ter ocorrido uma exceção.");
		} catch (FilmesExceptions e) {
			//Verificacao
			Assertions.assertEquals("Roupa sem Estoque.", e.getMessage());
		}
	}
	@Test
	@DisplayName("Exception - Roupa sem Estoque - Modo assertThrows()")
	public void exception02() {
		//Cenário
//		Cliente cliente = new Cliente("Ana");
		Cliente cliente = umCliente().agora();
//		List<Roupa> roupas =Arrays.asList(new Roupa("Camisa", "M", 0, 50.0));
		List<Roupa> roupas =Arrays.asList(RoupaBuilder.umaRoupaSemEstoque().agora());
		//Ação
		FilmesExceptions e = Assertions.assertThrows(FilmesExceptions.class, () ->{
			service.alugarRoupa(cliente, roupas);
		},"Deveria ter ocorrido uma exceção.");
		
		//Validação
		Assertions.assertEquals("Roupa sem Estoque.", e.getMessage());
	}
	@Test
	@DisplayName("Exception - Cliente com nome em branco - Modo try-catch")
	public void exception03() {
		//Cenário
//		Cliente cliente = new Cliente("");
		Cliente cliente = umCliente().comNome("").agora();

//		List<Roupa> roupas =Arrays.asList(new Roupa("Roupa 1", "P", 10, 30.0));
		List<Roupa> roupas =Arrays.asList(RoupaBuilder.umaRoupa().agora());
		
		//Ação
		try {
			Locacao locacao = service.alugarRoupa(cliente, roupas);
			Assertions.fail("Deveria ter ocorrido uma exceção.");
		} catch (FilmesExceptions e) {
			//Verificacao
			Assertions.assertEquals("Cliente com nome em branco.", e.getMessage());
		}
	}
	@Test
	@DisplayName("Exception - Cliente com nome em branco - Modo assertThrows")
	public void exception04() {
		//Cenário
//		Cliente cliente = new Cliente();
		Cliente cliente = 
				umCliente()
				.comNome("")
				.agora();

//		List<Roupa> roupas =Arrays.asList(new Roupa("Camisa", "M", 100, 50.0));
		List<Roupa> roupas =Arrays.asList(RoupaBuilder.umaRoupa().agora());
		//Ação
		FilmesExceptions e = Assertions.assertThrows(FilmesExceptions.class, () ->{
			service.alugarRoupa(cliente, roupas);
		},"Deveria ter ocorrido uma exceção.");
		
		//Validação
		Assertions.assertEquals("Cliente com nome em branco.", e.getMessage());
	}
	@Test
	@DisplayName("Exception - Roupa nula - Modo try-catch")
	public void exception05() {
		//Cenário
//		Cliente cliente = new Cliente("Ana");
		Cliente cliente = umCliente().agora();

		List<Roupa> roupas = null;
		
		//Ação
		try {
			Locacao locacao = service.alugarRoupa(cliente, roupas);
			Assertions.fail("Deveria ter ocorrido uma exceção.");
		} catch (FilmesExceptions e) {
			//Verificacao
			Assertions.assertEquals("Roupa nula.", e.getMessage());
		}
	}
	@Test
	@DisplayName("Exception - Roupa Nula - Modo assertThrows")
	public void exception06() {
		//Cenário
//		Cliente cliente = new Cliente("Ana");
		Cliente cliente = umCliente().agora();

		//List<Roupa> roupas =null;
		//Ação
		FilmesExceptions e = Assertions.assertThrows(FilmesExceptions.class, () ->{
			service.alugarRoupa(cliente, null);
		},"Deveria ter ocorrido uma exceção.");
		
		//Validação
		Assertions.assertEquals("Roupa nula.", e.getMessage());
	}
}
