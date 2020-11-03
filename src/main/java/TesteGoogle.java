import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

	@Test
	public void teste() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		assertEquals("Google", driver.getTitle());
		driver.quit();
	}
}