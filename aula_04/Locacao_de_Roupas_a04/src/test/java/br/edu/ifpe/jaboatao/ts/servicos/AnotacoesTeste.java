package br.edu.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//@TestMethodOrder(MethodOrderer.Random.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AnotacoesTeste 
{
	private static int var = 0;
	
	@BeforeEach
	public void metodoBeforeEach()
	{
		System.out.println("BeforeEach");
		var++;
		System.out.println(var);	
	}
	
	@AfterEach
	public void metodoAfterEach()
	{
		System.out.println("AfterEach");
		
	}
	
	@BeforeAll
	public static void metodoBeforeAll()
	{
		System.out.println("BeforeAll");
	}
	
	@AfterAll
	public static void metodoAfterAll()
	{
		System.out.println("AfterAll");
	}
	
	// Os métodos abaixo só são executados fora do método main() por causa do JUnit.
	@Test
	@DisplayName("3")
	@Order(3)
	public void metodoA()
	{
		System.out.println("Metodo A");
	}
	
	@Test
	@DisplayName("1")
	@Order(2)
	public void metodoB()
	{
		System.out.println("Metodo B");
	}
	
	@Test
	@DisplayName("2")
	@Order(1)
	public void metodoC()
	{
		System.out.println("Metodo C");
	}
	
	@Test
	@DisplayName("4")
	@Order(4)
	@Disabled
	public void metodoD()
	{
		System.out.println("Metodo D");
	}
	
	
}






























