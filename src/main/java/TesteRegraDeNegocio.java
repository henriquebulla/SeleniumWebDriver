import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteRegraDeNegocio {
	WebDriver driver;
	
	@Before
	public void inicializaTeste() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///" +  System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void finalizaTeste() {
		driver.quit();
	}

	@Test
	public void nomeObrigatorio() {
		driver.findElement(By.xpath("//*[@id=\"elementosForm:cadastrar\"]")).click();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
	}
	
	@Test
	public void sobreNomeObrigatorio() {
		driver.findElement(By.xpath("//*[@id=\"elementosForm:nome\"]")).sendKeys("Henrique");
		driver.findElement(By.xpath("//*[@id=\"elementosForm:cadastrar\"]")).click();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
	}
	
	@Test
	public void generoObrigatorio() {
		driver.findElement(By.xpath("//*[@id=\"elementosForm:nome\"]")).sendKeys("Henrique");
		driver.findElement(By.xpath("//*[@id=\"elementosForm:sobrenome\"]")).sendKeys("Bulla");
		driver.findElement(By.xpath("//*[@id=\"elementosForm:cadastrar\"]")).click();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());		
	}
	
	@Test
	public void validarVegetariano() {
		driver.findElement(By.xpath("//*[@id=\"elementosForm:nome\"]")).sendKeys("Henrique");
		driver.findElement(By.xpath("//*[@id=\"elementosForm:sobrenome\"]")).sendKeys("Bulla");
		driver.findElement(By.xpath("//*[@id=\"elementosForm:sexo\"]/tbody/tr/td[1]/label")).click();
		driver.findElement(By.xpath("//*[@id=\"elementosForm:comidaFavorita\"]/tbody/tr/td[1]/label")).click();
		driver.findElement(By.xpath("//*[@id=\"elementosForm:comidaFavorita\"]/tbody/tr/td[4]/label")).click();
		driver.findElement(By.xpath("//*[@id=\"elementosForm:cadastrar\"]")).click();


		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
	}
		
}
