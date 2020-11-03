

import static org.junit.Assert.assertEquals;

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
		driver.findElement(By.xpath("//*[@id=\"elementosForm:nome\"]")).sendKeys("HenriqueBulla");
		assertEquals("HenriqueBulla", driver.findElement(By.xpath("//*[@id=\"elementosForm:nome\"]")).getAttribute("value"));
		driver.quit();
		
	}
}
