package br.edu.ifpe.jaboatao.ts.servicos; // Mesmo pacote para ter acesso às variáveis e métodos default e protected.

import java.util.Date;

import org.junit.jupiter.api.Assertions;  // Importar o JUnit: precisa adicionar as dependencies no arquivo pom.xml
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;
import br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas;

public class LocacaoServiceTeste 
{
	@Test
	public void primeiroTeste() // Método onde os testes são executados e verificados.
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
}
