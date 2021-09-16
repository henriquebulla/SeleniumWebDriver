import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFramesEJanelas {
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
	public void interagirComFrame() {	
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Frame OK!",texto);
		alert.accept();
		
		driver.switchTo().defaultContent();//muda o foco para pagina principal
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);	
	}
	
	@Test
	public void deveInteragirComJanelas() {
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo");
		driver.close();
		driver.switchTo().window("");
		String texto = driver.findElement(By.tagName("textarea")).getText();
		driver.findElement(By.tagName("textarea")).sendKeys("E agora?");
	}
	
	@Test
	public void deveInteragirComPopUp() {
		driver.findElement(By.id("buttonPopUpHard")).click();
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);//getWindowHandles pega o Id das janelas aberta
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo");
		driver.close();
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("E agora?");
	}
}
