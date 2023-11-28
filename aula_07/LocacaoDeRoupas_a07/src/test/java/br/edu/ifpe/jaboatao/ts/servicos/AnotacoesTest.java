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
@DisplayName("Anotações")
//@TestMethodOrder(MethodOrderer.Random.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AnotacoesTest {
	//declarar a variavel global;
	static int cont = 0;
	
	@BeforeEach
	public void antes() {
		//incrementar a variavel e em seguida imprimir.
		//Obs: Utilizamos o @BeforeEach para evitar repetição de linhas de código.
		cont++;
		System.out.println(cont);
		
		System.out.println("@BeforeEach");
	}
	@AfterEach
	public void depois() {
		System.out.println("@AfterEach");
	}
	@BeforeAll
	public static void antesDeTudo() {
		System.out.println("@BeforeAll");
	}
	@AfterAll
	public static void depoisDeTudo() {
		System.out.println("@AfterAll");
	}
	
	@Test
	@DisplayName("C")
	@Order(1)
	@Disabled
	public void metodoA() {

		
		System.out.println("Metodo A");
	}
	@Test
	@DisplayName("B")
	@Order(3)
	public void metodoB() {

		
		System.out.println("Metodo B");
	}
	@Test
	@DisplayName("A")
	@Order(1)
	public void metodoC() {

		
		System.out.println("Metodo C");
	}
}
