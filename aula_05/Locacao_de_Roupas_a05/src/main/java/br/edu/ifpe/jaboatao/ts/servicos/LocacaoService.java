package br.edu.ifpe.jaboatao.ts.servicos;

//br.edu.ifpe.jaboata.ts.servicos
import java.util.Date;
import java.util.List;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;
import br.edu.ifpe.jaboatao.ts.exceptions.LocacaoException;
import br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas;

public class LocacaoService {

	public Locacao alugarRoupas(Cliente cliente, List<Roupa> roupas) throws LocacaoException
	{
		if (roupas == null || roupas.isEmpty())
		{
			throw new LocacaoException("Roupa nula.");
		}
		
		for (Roupa roupa : roupas) 
		{
			if (roupa.getEstoque().equals(0))
			{
				throw new LocacaoException("Estoque vazio.");
			}
		}
		
		
		Locacao locacao = new Locacao();
		locacao.setRoupas(roupas);
		locacao.setCliente(cliente);
		locacao.setDataLocacao(new Date());
		
		double valorTotal = 0;
		
		for (Roupa roupa : roupas) // Somando os valores para obter o valorTotal.
		{
			valorTotal += roupa.getValor();
		}
		
		locacao.setValorLocacao(valorTotal);

		// Definir a entrega para 3 dias depois.
		Date dataEntrega = ManipulandoDatas.novaDataComDiferencaDeDias(3);
		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// O método salvar() será implementado com o avançar do curso.

		return locacao;
	}
}