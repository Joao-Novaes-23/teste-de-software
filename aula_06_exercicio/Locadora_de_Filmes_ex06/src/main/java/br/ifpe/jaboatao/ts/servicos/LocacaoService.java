package br.ifpe.jaboatao.ts.servicos;

import java.util.Date;
import java.util.List;

import br.edu.ifpe.jaboatao.ts.exceptions.FilmesException;
import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoService {
	
	public Locacao alugarFilmes(Usuario usuario, List<Filme> filmes) throws FilmesException {
		for (Filme filme : filmes) 
		{
			if (filme.getEstoque().equals(0)) 
			{
				throw new FilmesException("Exceção: Filme sem Estoque.");
			}
		}
		
		if (usuario == null || usuario.getNome() == null)
		{
			throw new FilmesException("Exceção: usuário nulo.");
		}
		
		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		
		Double valorTotal = 0.0;
		
		for (Filme filme: filmes)
		{
			valorTotal += filme.getValor();
		}
		
		locacao.setValorLocacao(valorTotal);

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = DataUtils.incrementarQntDias(1, dataEntrega);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//O m�todo salvar() ser� implementado com o avan�ar do curso.
		
		return locacao;
	}

	public static void main(String[] args) {
		System.out.println("Funcionando.");
	}
}