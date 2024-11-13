import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteAlert {
	
	WebDriver driver;
	
	@Before
	public void inicializaTeste() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("www.google.com.br");
		//driver.get("file:///" +  System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void finalizaTeste() {
		driver.quit();
	}
	
	@Test
	public void deveinteragirComAlertSimples() {
		driver.findElement(By.xpath("//*[@id=\"alert\"]")).click();
		Alert alert =  driver.switchTo().alert();
		Assert.assertEquals("Alert Simples", alert.getText());
		String texto = alert.getText();
		alert.accept();
		
		driver.findElement(By.xpath("//*[@id=\"elementosForm:nome\"]")).sendKeys(texto);
		Assert.assertEquals("Alert Simples", driver.findElement(By.xpath("//*[@id=\"elementosForm:nome\"]")).getAttribute("value"));
	}
	
	@Test
	public void deveCancelarAlerta() {
		driver.findElement(By.xpath("//*[@id=\"confirm\"]")).click();
		Alert alert =  driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		alert.accept();
	}
	
	@Test
	public void deveInteragirComPrompt() {	
		driver.findElement(By.xpath("//*[@id=\"prompt\"]")).click();
		Alert alert =  driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("12345");
		alert.accept();
		Assert.assertEquals("Era 12345?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		
		
	}
	
	@Test
	public void desafioCadastrar() {	
		driver.findElement(By.xpath("//*[@id=\"elementosForm:nome\"]")).sendKeys("Henrique");
		driver.findElement(By.xpath("//*[@id=\"elementosForm:sobrenome\"]")).sendKeys("Bulla");
		driver.findElement(By.xpath("//*[@id=\"elementosForm:sexo\"]/tbody/tr/td[1]/label")).click();
		driver.findElement(By.xpath("//*[@id=\"elementosForm:comidaFavorita\"]/tbody/tr/td[3]/label")).click();
		
		//WebElement escolaridade = driver.findElement(By.xpath("//*[@id=\"elementosForm:escolaridade\"]"));
		 new Select(driver.findElement(By.xpath("//*[@id=\"elementosForm:escolaridade\"]")))
		.selectByVisibleText("Mestrado");
		
		WebElement esportes = driver.findElement(By.xpath("//*[@id=\"elementosForm:esportes\"]"));
		Select comboSelecao = new Select(esportes);
		comboSelecao.selectByVisibleText("Natacao");
		comboSelecao.selectByVisibleText("Corrida");
		
		driver.findElement(By.xpath("//*[@id=\"elementosForm:cadastrar\"]")).click();
		Assert.assertEquals("Cadastrado!", driver.findElement(By.xpath("//*[@id=\"resultado\"]/span")).getText());
		Assert.assertEquals("Nome: Henrique", driver.findElement(By.xpath("//*[@id=\"descNome\"]")).getText());
		Assert.assertEquals("Sobrenome: Bulla", driver.findElement(By.xpath("//*[@id=\"descSobrenome\"]")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.xpath("//*[@id=\"descSexo\"]")).getText());
		Assert.assertEquals("Comida: Pizza", driver.findElement(By.xpath("//*[@id=\"descComida\"]")).getText());
		Assert.assertEquals("Escolaridade: mestrado", driver.findElement(By.xpath("//*[@id=\"descEscolaridade\"]")).getText());
		Assert.assertEquals("Esportes: Natacao Corrida", driver.findElement(By.xpath("//*[@id=\"descEsportes\"]")).getText());
		
		
	}
	

}
