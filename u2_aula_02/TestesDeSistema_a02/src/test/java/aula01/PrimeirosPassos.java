package aula01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrimeirosPassos {
	WebDriver driver;
	@BeforeEach
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@AfterEach
	public void quid() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	@Disabled
	public void teste01() {
		driver.navigate().to("http://www.google.com.br");
		Assertions.assertEquals("Google", driver.getTitle());
		
		
	}
	@Test
	public void interagindoComElementos() throws InterruptedException {
		//Abrir o navegador na página do google.
		driver.get("http://www.google.com.br");
		//identificar o campo de pesquisa da página através de seu nome.
		WebElement campoPesquisa = driver.findElement(By.name("q"));
		//enviar para o campo de pesquisa o termo que queremos pesquisar.
		campoPesquisa.sendKeys("Campus Jaboatão");
		//dar o submit para que a pesquisa seja realizada.
		campoPesquisa.submit();
		//clicar no resultado correspondente à página do campus Jaboatão.
		driver.findElement(By.partialLinkText("Jaboatão")).click();
		Thread.sleep(3000);
		//já dentro do site do campus, clicar em "Todos os cursos"
		driver.findElement(By.linkText("Todos os Cursos")).click();
		//verificar se o título da página é realmente "Cursos"
		Assertions.assertEquals("Cursos", driver.findElement(By.className("page__title")).getText());
		
	}
	
}
