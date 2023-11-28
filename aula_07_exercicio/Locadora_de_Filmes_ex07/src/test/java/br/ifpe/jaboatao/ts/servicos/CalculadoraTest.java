package br.ifpe.jaboatao.ts.servicos;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.exceptions.FilmesException;

public class CalculadoraTest 
{
	private Calculadora calc;
	
	@BeforeEach
	public void setup()
	{
		calc = new Calculadora();
	}
	
	@Test
	public void testeSoma()
	{
		// Cenário
		List<Integer> nums = Arrays.asList(4, 5, 6);
		
		// Ação
		int resultado = calc.somar(nums);
		
		// Validação
		Assertions.assertEquals(resultado, 15);
	}
	
	@Test
	public void testeSubtracao()
	{
		// Cenário
		List<Integer> nums = Arrays.asList(10, 2, 5);
		
		// Ação
		int resultado = calc.subtrair(nums);
		
		// Validação
		Assertions.assertEquals(resultado, 3);
	}
	
	@Test
	public void testeMultiplicacao()
	{
		// Cenário
		List<Integer> nums = Arrays.asList(5, 7, 8);
		
		// Ação
		int resultado = calc.multiplicar(nums);
		
		// Validação
		Assertions.assertEquals(resultado, 280);
	}
	
	@Test
	public void testeDivisao() throws FilmesException
	{
		// Cenário
		List<Double> numes = Arrays.asList(3600.0, 60.0, 10.0);
		
		try
		{
			// Ação
			double resultado = calc.dividir(numes);
			
			// Verificação
			Assertions.assertEquals(resultado, 6.0);
		}
		catch (FilmesException e)
		{
			// Verificação
			Assertions.assertEquals("Exceção - Divisão por zero.", e.getMessage());
		}
	}
}





















































