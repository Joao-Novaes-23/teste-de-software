package br.edu.ifpe.jaboatao.ts.servicos;

//br.edu.ifpe.jaboata.ts.servicos
import java.util.Date;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;
import br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas;

public class LocacaoService {

	public Locacao alugarRoupa(Cliente cliente, Roupa roupa) {
		Locacao locacao = new Locacao();
		locacao.setRoupa(roupa);
		locacao.setCliente(cliente);
		locacao.setDataLocacao(new Date());
		locacao.setValorLocacao(roupa.getValor());

		// Definir a entrega para 3 dias depois.
		Date dataEntrega = ManipulandoDatas.novaDataComDiferencaDeDias(3);
		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// O método salvar() será implementado com o avançar do curso.

		return locacao;
	}

	public static void main(String[] args) 
	{
		// Cenário
		LocacaoService service = new LocacaoService();
		Cliente cliente = new Cliente("Cliente 01");
		Roupa roupa = new Roupa("Roupa 01", "M", 2, 40.0);
		Locacao locacao = new Locacao();
		
		// Ação
		locacao = service.alugarRoupa(cliente, roupa);
		
		// Verificação
		System.out.println(locacao.getValorLocacao() == 40);
		System.out.println(ManipulandoDatas.boDatasIguais(locacao.getDataLocacao(), new Date()));
		System.out.println(ManipulandoDatas.boDatasIguais(locacao.getDataRetorno(), 
		ManipulandoDatas.novaDataComDiferencaDeDias(3)));
	}
}