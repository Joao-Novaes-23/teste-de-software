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
		Thread.sleep(3000);
		driver.quit();
	}
	@Test
	@Disabled
	public void teste01() {
		driver.navigate().to("http://www.google.com.br");
		Assertions.assertEquals("Google", driver.getTitle());
		
		
	}
	@Test
	@Disabled
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
	
	@Test
	public void curriculoLattes() throws InterruptedException
	{
		driver.get("https://buscatextual.cnpq.br/buscatextual/busca.do?metodo=apresentar");
		WebElement campoPesquisa = driver.findElement(By.name("textoBusca"));
		WebElement checkboxBuscarDemais = driver.findElement(By.name("buscarDemais"));
		// Verificar se o checkbox está marcado ou não antes de clicar
		if(!checkboxBuscarDemais.isSelected()) 
		{
		    // Se não estiver marcado, clicar para marcá-lo.
		    checkboxBuscarDemais.click();
		}		
		campoPesquisa.sendKeys("Carlos Rezende Brasil Neto");
		WebElement botaoSubmit = driver.findElement(By.id("botaoBuscaFiltros"));
		botaoSubmit.click();;
		Thread.sleep(3000);
		driver.findElement(By.linkText("Carlos Rezende Brasil Neto")).click();
		WebElement botaoAbrirCurriculo = driver.findElement(By.id("idbtnabrircurriculo"));
		botaoAbrirCurriculo.click();
		Thread.sleep(3000);
		// Localizar elemento pelo texto dentro de uma tag <span> usando XPath
		WebElement idLattes = driver.findElement(By.xpath("//span[contains(text(),'3589183971956347')]"));
		Thread.sleep(3000);
		
		Assertions.assertEquals(idLattes, "3589183971956347");
	}
}



















































