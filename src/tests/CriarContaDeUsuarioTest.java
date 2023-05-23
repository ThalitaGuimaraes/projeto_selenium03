package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;
import helpers.ChromeHelper;
import helpers.ScreenShotHelper;

public class CriarContaDeUsuarioTest {
	
	@Test
	public void test() {
		WebDriver driver = ChromeHelper.create("http://appcontascoti-001-site1.dtempurl.com/Account/Register");
		
		Faker faker = new Faker();
		
		// preenchendo o nome do usuário
		String nome = faker.name().name();
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys(nome);
		
		// preenchendo o email do usuário
		String email = faker.internet().emailAddress();
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(email);
		
		// preenchendo a senha e confirmação da senha do usuário
		String senha = faker.internet().password(8, 10, true, true, true);
		driver.findElement(By.xpath("//*[@id=\"Senha\"]")).sendKeys(senha);
		driver.findElement(By.xpath("//*[@id=\"SenhaConfirmacao\"]")).sendKeys(senha);
		
		// clicar no botão de cadastro
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[5]/input")).click();
		
		// gerando a evidência de teste
		ScreenShotHelper.create(driver, "Evidência - Criar Conta de Usuário.png");
		
		// capturando e comparando a mensagem exibida pelo sistema
		String mensagem = driver.findElement(By.xpath("/html/body/div[1]")).getText();
		assertEquals("Sucesso! Parabéns, sua conta foi cadastrada com sucesso.", mensagem);
		
		// fechar o navegador
		driver.close();
	}
}
