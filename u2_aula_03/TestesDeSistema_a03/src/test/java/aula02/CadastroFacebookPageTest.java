package aula02;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroFacebookPageTest {

	@Test
	public void cadastro() {
		WebDriver driver = new ChromeDriver();
		//Configurar uma pausa implicita na navegação.(máx de 10s)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.facebook.com.br");
		//Instanciar a classe de cadastro.
		CadastroFacebookPage facebook = new CadastroFacebookPage(driver);
		facebook
			.iniciarCadastro()
			.preencherNome("Carlos")
			.preencherSobrenome("Brasil")
			.preencherEmail("a@b.com")
			.preencherConfirmacaoDeEmail("a@bb.com")
			.preencherSenha("123")
			.selecionarComboDia_ByIndex(1)
			.selecionarComboMes_ByVisibleText("fev")
			.selecionarComboAno_ByValue("2000")
			.selecionarRadioGenero("Masculino")
			.enviar();
		
	}
}
