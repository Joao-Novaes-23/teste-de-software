package br.edu.ifpe.jaboatao.ts.servicos;

import br.edu.ifpe.jaboatao.ts.exceptions.FilmesExceptions;

public class Calculadora {

	public int somar(int a, int b) {
		return a+b;
	}

	public int subtrair(int a, int b) {
		return a-b;
	}
	
	public double dividir(double a, double b) throws FilmesExceptions {
		if (b == 0) {
			throw new FilmesExceptions("Exceção - Divisão por zero.");
		}
		return a/b;
	}
}
