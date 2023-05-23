package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.ChromeHelper;
import helpers.ScreenShotHelper;

public class AutenticarUsuarioTest {

	@Test
	public void test() {
		
		//acessar a página de autenticação de usuários
		WebDriver driver = ChromeHelper.create("http://appcontascoti-001-site1.dtempurl.com/");
		
		//preencher o email do usuário
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("thalita_guimaraesrj20@gmail.com");
				
		//preencher a senha do usuário
		driver.findElement(By.xpath("//*[@id=\"Senha\"]")).sendKeys("thalita2022");
		
		//clicar no botão de autenticação
        driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[3]/input")).click();
		
		//gerar uma evidência de teste
		ScreenShotHelper.create(driver, "Evidência - Autenticar Usuário.png");
		
		//verificando se o usuário foi redirecionado
		//para a página de acesso restrito do sistema
		assertEquals("http://appcontascoti-001-site1.dtempurl.com/Home/Index", driver.getCurrentUrl());
		
		//fechar o navegador
		driver.close();
	}

}
