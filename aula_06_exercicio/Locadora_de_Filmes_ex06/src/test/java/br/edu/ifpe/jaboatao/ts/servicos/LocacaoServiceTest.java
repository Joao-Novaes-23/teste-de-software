package br.edu.ifpe.jaboatao.ts.servicos;

import static br.edu.ifpe.jaboatao.ts.builders.FilmeBuilder.umFilme;
import static br.edu.ifpe.jaboatao.ts.builders.UsuarioBuilder.umUsuario;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.builders.UsuarioBuilder;
import br.edu.ifpe.jaboatao.ts.builders.FilmeBuilder;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.servicos.LocacaoService;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Filme;
import br.edu.ifpe.jaboatao.ts.exceptions.FilmesException;

public class LocacaoServiceTest 
{
	LocacaoService service;
	
	@BeforeEach
	public void setup()
	{
		service = new LocacaoService();
	}
	
	@Test
	@DisplayName("Questão 5.a - Valor total da locação para 2 filmes")
	public void teste01() throws FilmesException
	{
		// Cenário
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = Arrays.asList
								(
										FilmeBuilder.umFilme().agora(),
										FilmeBuilder.umFilme().agora()
								);
		// Ação
		Locacao locacao = service.alugarFilmes(usuario, filmes);
		
		// Verificação
		Assertions.assertTrue(locacao.getValorLocacao() == 60);
	}
	
	@Test
	@DisplayName("Questçao 5.b - Usuário nulo - Modo try-catch")
	public void teste02() throws FilmesException
	{
		// Cenário
		Usuario usuario = null;
		List<Filme> filmes = Arrays.asList
								(
										FilmeBuilder.umFilme().agora(),
										FilmeBuilder.umFilme().agora()
								);
		
		// Ação
		try
		{
			Locacao locacao = service.alugarFilmes(usuario, filmes);
			Assertions.fail("Deveria ter ocorrido uma exceção.");
		}
		catch (FilmesException e)
		{
			// Verificação
			Assertions.assertEquals("Exceção: usuário nulo.", e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Questão 5.b - Usuário nulo - Modo assertThrows")
	public void teste03() throws FilmesException
	{
		Usuario usuario = umUsuario().comNome(null).agora();
		List<Filme> filmes = Arrays.asList
								(
										FilmeBuilder.umFilme().agora(),
										FilmeBuilder.umFilme().agora()
								);
		
		// Ação
		FilmesException e = Assertions.assertThrows(FilmesException.class, () -> 
		{
			service.alugarFilmes(usuario, filmes);
		}, "Deveria ter ocorrido uma exceção.");
		
		// Validação
		Assertions.assertEquals("Exceção: usuário nulo.", e.getMessage());
	}
	
	@Test
	@DisplayName("Questão 5.c - Filme sem estoque - Modo try-catch")
	public void teste04() throws FilmesException
	{
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = Arrays.asList
								(
										FilmeBuilder.umFilmeSemEstoque().agora(),
										FilmeBuilder.umFilme().agora()
								);
		
		// Ação
		try
		{
			Locacao locacao = service.alugarFilmes(usuario, filmes);
			Assertions.fail("Deveria ter ocorrido uma exceção.");
		}
		catch (FilmesException e)
		{
			// Verificação
			Assertions.assertEquals("Exceção: Filme sem Estoque.", e.getMessage());
		}
	}
		
	@Test
	@DisplayName("Questão 5.c - Filme sem estoque - Modo assertThrows")
	public void teste05()
	{
		Usuario usuario = umUsuario().agora();
		List<Filme> filmes = Arrays.asList
								(
										FilmeBuilder.umFilme().comEstoque(0).agora(),
										FilmeBuilder.umFilme().agora()
								);
		// Ação
		FilmesException e = Assertions.assertThrows(FilmesException.class, () -> 
		{
			service.alugarFilmes(usuario, filmes);
		}, "Deveria ter ocorrido uma exceção.");
		
		// Valicação
		Assertions.assertEquals("Exceção: Filme sem Estoque.", e.getMessage());
	}
}























































