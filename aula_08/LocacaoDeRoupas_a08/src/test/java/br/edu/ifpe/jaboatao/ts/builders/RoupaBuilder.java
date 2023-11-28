package br.edu.ifpe.jaboatao.ts.builders;

import br.edu.ifpe.jaboatao.ts.entidades.Roupa;

public class RoupaBuilder {

	private Roupa roupa;
	
	private RoupaBuilder() {}
	
	public static RoupaBuilder umaRoupa() {
		RoupaBuilder builder = new RoupaBuilder();
		builder.roupa = new Roupa("Roupa 01", "M", 10, 30.0);
		return builder;
	}
	public static RoupaBuilder umaRoupaSemEstoque() {
		RoupaBuilder builder = new RoupaBuilder();
		builder.roupa = new Roupa("Roupa 01", "M", 0, 30.0);
		return builder;
	}
	public RoupaBuilder comEstoque(Integer estoque) {
		roupa.setEstoque(estoque);
		return this;
	}
	public RoupaBuilder comValor(double valor) {
		roupa.setValor(valor);
		return this;
	}
	public RoupaBuilder semEstoque() {
		roupa.setEstoque(0);
		return this;
	}
	public Roupa agora() {
		return roupa;
	}
}
