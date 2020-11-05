

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCampoTreinamento {

	@Test
	public void testeTextField() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" +  System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.xpath("//*[@id=\"elementosForm:nome\"]")).sendKeys("Henrique");
		assertEquals("Henrique", driver.findElement(By.xpath("//*[@id=\"elementosForm:nome\"]")).getAttribute("value"));
		
		driver.findElement(By.xpath("//*[@id=\"elementosForm:sobrenome\"]")).sendKeys("Rezende Bulla");
		assertEquals("Rezende Bulla", driver.findElement(By.xpath("//*[@id=\"elementosForm:sobrenome\"]")).getAttribute("value"));
		
		driver.quit();
		
	}
	
	@Test
	public void testeTextArea() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" +  System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.xpath("//*[@id=\"elementosForm:sugestoes\"]")).sendKeys("Henrique\n Rezende\n Bulla");
		assertEquals("Henrique\n Rezende\n Bulla", driver.findElement(By.xpath("//*[@id=\"elementosForm:sugestoes\"]")).getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void testeRadioButton() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" +  System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.quit();
	}
	
	@Test
	public void testeCheckbox() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" +  System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		//driver.quit();
	}
	
	@Test
	public void testeParaGit() {}
	
}
