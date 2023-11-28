package br.edu.ifpe.jaboatao.ts.servicos;

//br.edu.ifpe.jaboata.ts.servicos
import java.util.Date;
import java.util.List;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;
import br.edu.ifpe.jaboatao.ts.exceptions.FilmesExceptions;
import br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas;

public class LocacaoService {

	public Locacao alugarRoupa(Cliente cliente, List<Roupa> roupas) throws FilmesExceptions {
		if (roupas == null || roupas.isEmpty()) {
			throw new FilmesExceptions("Roupa nula.");
		}

		for (Roupa roupa : roupas) {

			if (roupa.getEstoque().equals(0)) {
				throw new FilmesExceptions("Roupa sem Estoque.");
			}
		}

		if (cliente.getNome() == null || cliente.getNome() == "") {
			throw new FilmesExceptions("Cliente com nome em branco.");
		}
		Locacao locacao = new Locacao();
		locacao.setRoupas(roupas);
		locacao.setCliente(cliente);
		locacao.setDataLocacao(new Date());
		Double valorTotal = 0.0;
		
//		for (Roupa roupa : roupas) {
//			valorTotal += roupa.getValor();
//		}
		for (var i = 0; i < roupas.size(); i++) {
			Roupa roupa = roupas.get(i);
			double valor = roupa.getValor();
			if (i == 2) {
				valor = valor * 0.75;
			}
			if (i == 3) {
				valor = valor * 0.5;
			}
			if (i == 4) {
				valor = valor * 0.25;
			}
			if (i == 5) {
				valor = valor * 0.0;
			}
			valorTotal +=valor;
		}
		locacao.setValorLocacao(valorTotal);

		// Definir a entrega para 3 dias depois.
		Date dataEntrega = ManipulandoDatas.novaDataComDiferencaDeDias(3);
		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// O m�todo salvar() ser� implementado com o avan�ar do curso.

		return locacao;
	}

}