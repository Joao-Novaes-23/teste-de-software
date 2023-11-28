package aula03;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroFacebookPage {

	WebDriver driver;

	// Construtor.
	public CadastroFacebookPage(WebDriver driver) {
		this.driver = driver;
	}

	// Método de entrada;
	public CadastroFacebookPage iniciarCadastro() {
		// Clicar no botão "Criar nova conta".
		driver.findElement(By.linkText("Criar nova conta")).click();
		return this;
	}

	public CadastroFacebookPage preencherNome(String nome) {
		driver.findElement(By.name("firstname")).sendKeys(nome);
		return this;
	}

	public CadastroFacebookPage preencherSobrenome(String sobrenome) {
		driver.findElement(By.name("lastname")).sendKeys(sobrenome);
		return this;
	}

	public CadastroFacebookPage preencherEmail(String email) {
		driver.findElement(By.name("reg_email__")).sendKeys(email);
		return this;
	}

	public CadastroFacebookPage preencherConfirmacaoDeEmail(String email) {
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(email);// email diferente.
		return this;
	}
	
	public CadastroFacebookPage preencherConfirmacaoDeEmail_WaitExplict(String email) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
		WebElement confirmaEmail = wait.until(ExpectedConditions.elementToBeClickable(By.name("reg_email_confirmation__")));
		confirmaEmail.sendKeys(email);
		
		return this;
	}
	
	public CadastroFacebookPage preencherConfirmacaoDeEmail_WaitFluent(String email) {
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(2))
				.pollingEvery(Duration.ofSeconds(1));//Frequencia de verificação;
				//.ignoring(NoSuchElementException.class);
		WebElement confirmEmail = 
				wait.until(ExpectedConditions.elementToBeClickable(By.name("reg_email_confirmation__")));
		confirmEmail.sendKeys(email);
		return this;
	}
	
	public CadastroFacebookPage preencherSenha(String senha) {
		driver.findElement(By.name("reg_passwd__")).sendKeys(senha);
		return this;
	}
	/**
	 * Função que seleciona o dia de nascimento. Utiliza o Index do combo.
	 * */
	public CadastroFacebookPage selecionarComboDia_ByIndex(Integer index) {
		// Dia:
		WebElement comboDia = driver.findElement(By.id("day"));
		Select selectDia = new Select(comboDia);
		selectDia.selectByIndex(index); // dia 02
		
		return this;
	}
	/**
	 * Função que seleciona o mês de nascimento. Utiliza o VisibleText do combo.
	 * */
	public CadastroFacebookPage selecionarComboMes_ByVisibleText(String visibleText) {
		//Mes
		WebElement comboMes = driver.findElement(By.id("month"));
		Select selectMes = new Select(comboMes);
		selectMes.selectByVisibleText(visibleText);
		
		return this;
	}
	/**
	 * Função que seleciona o ano de nascimento. Utiliza o value do combo.
	 * */

	public CadastroFacebookPage selecionarComboAno_ByValue(String value) {
		//Ano
		WebElement comboAno = driver.findElement(By.id("year"));
		Select selectAno = new Select(comboAno);
		selectAno.selectByValue(value);
		
		return this;
	}
	/**
	 * Método para seleção do Radio Gênero. Informe "Masculino", "Feminino", ou "Personalizado"*/
	public CadastroFacebookPage selecionarRadioGenero(String sexo) {
		String valor;
		switch (sexo) {
		case "Feminino": valor = "1"; break;
		case "Masculino": valor = "2"; break;
		case "Personalizado": valor = "-1"; break;
		default:
			throw new IllegalArgumentException("Sexo inesperado: " 
												+ sexo 
												+ " Informe 'Masculino', 'Feminino' ou 'Personalizado'.");
		}
		
		//Genero:
		List<WebElement> radios = driver.findElements(By.name("sex"));
		for (WebElement radio: radios) {
			if (radio.getAttribute("value").equals(valor)) {
				//if (!radio.isSelected()) {//Essencial para o checkbox.
					radio.click();
				//}
			}
		}
		
		return this;
	}
	//Ultimo método chamado.
	public void enviar(){
		driver.findElement(By.name("websubmit")).click();
	}
}
