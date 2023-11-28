package br.ifpe.jaboatao.ts.servicos;

import java.util.Date;
import java.util.List;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.exceptions.FilmesException;

public class LocacaoService {

	public Locacao alugarFilme(List<Filme> filmes, Usuario usuario) throws FilmesException {

		if (usuario.getNome() == "") {
			throw new FilmesException("Usuario com nome vazio.");
		}
		if (filmes == null || filmes.isEmpty()) {
			throw new FilmesException("Filme nulo.");
		}

		for (Filme filme : filmes) {
			if (filme.getEstoque() == 0) {
				throw new FilmesException("Filme sem estoque.");
			}
		}

		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		double valorTotal = 0;

		
		for (Filme filme : filmes) {
			valorTotal += filme.getValor();
		}
		
		if(filmes.size() == 2)
		{
			valorTotal *= 0.9;
		}
		else if(filmes.size() == 3)
		{
			valorTotal *= 0.85;
		}
		else if(filmes.size() == 4)
		{
			valorTotal *= 0.75;
		}
		else if(filmes.size() >= 5)
		{
			valorTotal *= 0.5;
		}

		locacao.setValorLocacao(valorTotal);

		return locacao;

	}
}































