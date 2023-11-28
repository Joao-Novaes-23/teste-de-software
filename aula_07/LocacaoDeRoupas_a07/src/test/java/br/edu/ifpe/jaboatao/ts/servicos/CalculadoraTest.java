package br.edu.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.exceptions.FilmesExceptions;

public class CalculadoraTest {
	private Calculadora calc;
	@BeforeEach
	public void setup() {
		calc = new Calculadora();
	}
	@Test
	public void somarDoisNumeros() {
		//Cenário
		int a = 4;
		int b = 2;
		
		//Ação
		int resultado = calc.somar(a,b);
		
		//Validação
		Assertions.assertEquals(6, resultado);
	}
	@Test
	public void subtrairDoisNumeros() {
		//Cenário
		int a = 5;
		int b = 3;
		
		//Ação
		int resultado = calc.subtrair(a,b);
		
		//Validação
		Assertions.assertEquals(2, resultado);
	}
	@Test
	public void dividirDoisNumeros() throws FilmesExceptions {
		double a = 6;
		double b = 3;
		
		//Ação
		double resultado = calc.dividir(a,b);
		
		//Validação
		Assertions.assertEquals(2, resultado);
	}
	@Test
	public void exceptionDivisao() {
		//Cenário
		double a = 6;
		double b = 0;
		
		try {
			//Ação
			double resultado = calc.dividir(a, b);
			Assertions.fail("Deveria ter ocorrido uma exceção.");
		} catch (Exception e) {
			//Verificacao
			Assertions.assertEquals("Exceção - Divisão por zero.", e.getMessage());
		}
		

	}
}
