package br.ifpe.jaboatao.ts.servicos;

import java.util.List;

import br.ifpe.jaboatao.ts.exceptions.FilmesException;

public class Calculadora 
{
	public int somar(List<Integer> nums)
	{
		int resultado = 0;
		
		for(int num : nums)
		{
			resultado += num;
		}
		
		return resultado;
	}
	
	public int subtrair(List<Integer> nums)
	{
		int resultado = nums.get(0);
		
		int indice = 0;
		for(int num : nums)
		{
			if (indice > 0)
			{
				resultado -= num;
			}
			
			indice++;
		}
		
		return resultado;
	}
	
	public int multiplicar(List<Integer> nums)
	{
		int resultado = 1;
		
		for(int num : nums)
		{
			resultado *= num;
		}
		
		return resultado;
	}
	
	public double dividir(List<Double> numes) throws FilmesException
	{
		double resultado = numes.get(0);
		
		int indice = 0;
		for(Double nume : numes)
		{
			if (indice > 0)
			{
				if (nume == 0)
				{
					throw new FilmesException("Exceção - Divisão por zero.");
				}
				else 
				{
					resultado /= nume;
				}
			}
	
			indice++;
		}
		
		return resultado;
	}
}












































