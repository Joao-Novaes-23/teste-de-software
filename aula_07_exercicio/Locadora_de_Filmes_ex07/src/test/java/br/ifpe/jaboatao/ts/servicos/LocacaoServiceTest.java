package br.ifpe.jaboatao.ts.servicos;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.exceptions.FilmesException;

public class LocacaoServiceTest {

	@Test
	public void teste01() throws FilmesException {

		// Cen�rio
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usu�rio 01");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 01", 10, 11.0));

		// A��o
		Locacao locacao = service.alugarFilme(filmes, usuario);

		// VerificA��o
		Assertions.assertEquals(locacao.getValorLocacao(), 11.0);
	}

	@Test
	@Disabled
	@DisplayName("Exce��o - Filme sem estoque - Modo try/catch")
	public void excecao01() {
		// Cen�rio
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuário 01");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 01", 0, 11.0));
		// A��o
		try {
			Locacao locacao = service.alugarFilme(filmes, usuario);
			Assertions.fail("Deveria ter ocorrido uma Exce��o.");
		} catch (FilmesException e) {
			// VerificA��o
			Assertions.assertEquals("Filme sem estoque.", e.getMessage());
		}
	}

	@Test
	@Disabled
	@DisplayName("Exce��o - Filme sem estoque - Modo assertThrows()")
	public void excecao02() {
		// Cen�rio
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usu�rio 01");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 01", 0, 11.0));

		// A��o
		FilmesException filmesException = Assertions.assertThrows(FilmesException.class, () -> {
			service.alugarFilme(filmes, usuario);
		}, "Era esperado uma Exce��o.");
		// VerificA��o
		Assertions.assertEquals("Filme sem estoque.", filmesException.getMessage());
	}

	@Test
	@DisplayName("exce��o - Filme nulo - Modo try/catch")
	public void excecao03() {
		// Cen�rio
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 01");

		// A��o
		try {
			Locacao locacao = service.alugarFilme(null, usuario);
		} catch (FilmesException e) {
			// Verificacao
			Assertions.assertEquals("Filme nulo.", e.getMessage());
		}
	}

	@Test
	@DisplayName("exce��o - Filme nulo - Modo assertThrows()")
	public void excecao04() {
		// Cen�rio
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 01");

		// A��o
		FilmesException filmesException = Assertions.assertThrows(FilmesException.class, () -> {
			service.alugarFilme(null, usuario);
		}, "Era esperado uma exce��o.");
		// VerificA��o
		Assertions.assertEquals("Filme nulo.", filmesException.getMessage());
	}

	@Test
	@DisplayName("exce��o - Usuario com nome vazio - Modo try/catch")
	public void excecao05() {
		// Cen�rio
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 01", 0, 11.0));

		// A��o
		try {
			Locacao locacao = service.alugarFilme(filmes, usuario);
		} catch (FilmesException e) {
			// VerificA��o
			Assertions.assertEquals("Usuario com nome vazio.", e.getMessage());
		}
	}

	@Test
	@DisplayName("exce��o - Usuario com nome vazio - Modo assertThrows()")
	public void excecao06() {
		// Cen�rio
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 01", 0, 11.0));

		// A��o
		FilmesException filmesException = Assertions.assertThrows(FilmesException.class, () -> {
			service.alugarFilme(filmes, usuario);
		}, "Era esperado uma exce��o.");
		// VerificA��o
		Assertions.assertEquals("Usuario com nome vazio.", filmesException.getMessage());
	}

}
