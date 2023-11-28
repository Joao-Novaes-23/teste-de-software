package br.edu.ifpe.jaboatao.ts.builders;

import br.ifpe.jaboatao.ts.entidades.Filme;

public class FilmeBuilder 
{
	private Filme filme;
	
	private FilmeBuilder() {
		
	}
	
	public static FilmeBuilder umFilme() 
	{
		FilmeBuilder builder = new FilmeBuilder();
		builder.filme = new Filme("Filme 01", 20, 30.0);
		return builder;
	}
	
	public static FilmeBuilder umFilmeSemEstoque()
	{
		FilmeBuilder builder = new FilmeBuilder();
		builder.filme = new Filme("filme 01", 0, 30.0);
		return builder;
	}
	
	public FilmeBuilder comEstoque(Integer estoque)
	{
		filme.setEstoque(estoque);
		return this;
	}
	
	public FilmeBuilder semEstoque()
	{
		filme.setEstoque(0);
		return this;
	}
	
	public Filme agora()
	{
		return filme;
	}
}























































