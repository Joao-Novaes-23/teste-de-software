package br.edu.ifpe.jaboatao.ts.builders;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;

public class ClienteBuilder {
	//1- Criar o objeto privado.
	private Cliente cliente;
	//2- Criar um construtor privado para que seja instanciado
	//   apenas dentro desta classe.
	private ClienteBuilder() {}
	
	/*3-
	 * Criar o primeiro método publico. Será a porta de entrada da classe.
	 * Precisa ser static para instanciar a classe dentro dele, 
	 * sem precisar instanciar lá fora.*/
	public static ClienteBuilder umCliente() {
		//3.1 - Instanciar a classe.
		ClienteBuilder builder = new ClienteBuilder();
		//3.2- Instanciar o objeto utilizando a classe instanciada.
		builder.cliente = new Cliente("Cliente 01");
		//3.3- Por fim retornar a classe.
		return builder;
	}
	public ClienteBuilder comNome(String nome) {
		cliente.setNome(nome);
		return this;
	}
	//4- Este método retorna o objeto já instanciado  e povoado.
	//   Este será o ultimo metódo que será chamado.
	public Cliente agora() {
		return cliente;
	}
}
