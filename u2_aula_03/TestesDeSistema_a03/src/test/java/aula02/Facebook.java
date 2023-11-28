package aula02;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	@Test
	public void cadastro() throws InterruptedException {
		//Instanciar o driver e definir o navegador chrome.
		WebDriver driver = new ChromeDriver();
		//Definir a página que iremos acessar.
		driver.navigate().to("http://www.facebook.com.br");
		//Dar uma pausa de 3 segundos.
		Thread.sleep(3000);
		//Clicar no botão "Criar nova conta".
		driver.findElement(By.linkText("Criar nova conta")).click();
		Thread.sleep(3000);
		//Preencher o formulário.
		//Nome:
		driver.findElement(By.name("firstname")).sendKeys("Carlos");
		//Sobrenome:
		driver.findElement(By.name("lastname")).sendKeys("Brasil");
		//Email:
		driver.findElement(By.name("reg_email__")).sendKeys("a@b.com");
		//Confirmar email:
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("a@bb.com");//email diferente.
		//Senha:
		driver.findElement(By.name("reg_passwd__")).sendKeys("123");
		//Data de nascimento.
		//Dia:
		WebElement comboDia = driver.findElement(By.id("day"));
		Select selectDia = new Select(comboDia);
		selectDia.selectByIndex(1); // dia 02
		//Mes
		WebElement comboMes = driver.findElement(By.id("month"));
		Select selectMes = new Select(comboMes);
		selectMes.selectByVisibleText("abr");
		//Ano
		WebElement comboAno = driver.findElement(By.id("year"));
		Select selectAno = new Select(comboAno);
		selectAno.selectByValue("2000");
		//Genero:
		List<WebElement> radios = driver.findElements(By.name("sex"));
		for (WebElement radio: radios) {
			if (radio.getAttribute("value").equals("2")) {
				//if (!radio.isSelected()) {//Essencial para o checkbox.
					radio.click();
				//}
			}
		}
		//Clicar no botão para enviar o formulário.
		driver.findElement(By.name("websubmit")).click();
		//driver.findElement(By.linkText("Cadastre-se")).click();
		//Dar uma pausa de 3 segundos.
		Thread.sleep(3000);
		//Fechar todas as instancias.
		driver.quit();
	}
}
