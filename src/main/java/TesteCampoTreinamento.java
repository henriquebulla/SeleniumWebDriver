

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
		driver.quit();
	}
	
		
	@Test
	public void testeComboBox() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" +  System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.xpath("//*[@id=\"elementosForm:escolaridade\"]")); // Adiciona a instacia achada pelo FindElement para o objeto element
		Select combo = new Select(element); 
//		combo.selectByIndex(3);
//		combo.selectByValue("superior");  //Seleciona pelo value disponivel no ispecionar elemento dentro do navegador
		combo.selectByVisibleText("Mestrado");
		Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());
		driver.quit();
	}
}
