
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import steps.DSL;

public class TesteCampoTreinamento {
	
	WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializaTeste() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///" +  System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finalizaTeste() {
		driver.quit();
	}

	@Test
	public void testeTextField() {
		dsl.escreve("//*[@id=\"elementosForm:nome\"]", "Henrique");
		Assert.assertEquals("Henrique", dsl.obtemValorCampo("//*[@id=\"elementosForm:nome\"]"));
		dsl.escreve("//*[@id=\"elementosForm:sobrenome\"]", "Rezende Bulla");
		assertEquals("Rezende Bulla", dsl.obtemValorCampo("//*[@id=\"elementosForm:sobrenome\"]"));
	}
	
	@Test
	public void testeTextArea() {
		dsl.escreve("//*[@id=\"elementosForm:sugestoes\"]", "Henrique\\n Rezende\\n Bulla");
		assertEquals("Henrique\\n Rezende\\n Bulla", dsl.obtemValorCampo("//*[@id=\"elementosForm:sugestoes\"]"));
	}
	
	@Test
	public void testeRadioButton() {
		dsl.clicarNoElemento("elementosForm:sexo:0");
		assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
	}
	
	@Test
	public void testeCheckbox() {
		dsl.clicarNoElemento("elementosForm:comidaFavorita:2");
		assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));
	}
	
		
	@Test
	public void testeComboBox() {
		dsl.selecionaValorCombo("//*[@id=\"elementosForm:escolaridade\"]","Mestrado");
		Assert.assertEquals("Mestrado", dsl.verifcaValorCombo("//*[@id=\"elementosForm:escolaridade\"]"));
	}
	
	@Test
	public void verificarValoresComboBox() {		
		dsl.encontrarTamanhoDoCombo("//*[@id=\"elementosForm:escolaridade\"]");
		Assert.assertEquals(8, dsl.retornarTamanhoDoCombo("//*[@id=\"elementosForm:escolaridade\"]"));
		Assert.assertTrue(dsl.valorExisteNoCombo("//*[@id=\"elementosForm:escolaridade\"]","Mestrado"));
	}
	
	@Test
	public void verificarValoresComboMultiplo() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"elementosForm:esportes\"]"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
//		combo.deselectByVisibleText("O que eh esporte?");
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		
		int contador = 0;
		for(WebElement option: allSelectedOptions) {
			if(option.getText().equals("Natacao") || option.getText().equals("Corrida") || option.getText().equals("O que eh esporte?")){
				contador++;
			}
			if(contador == 3) {
				break;
			}
		}
		System.out.println(contador);
		Assert.assertEquals(contador, allSelectedOptions.size());
	}
	
	@Test
	public void deveinteragirComBotoes() {
		WebElement botao = driver.findElement(By.xpath("//*[@id=\"buttonSimple\"]"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
	@Test
	@Ignore
	public void deveinteragirComLinks() {
		driver.findElement(By.linkText("Voltar")).click();
	}
	
	
	@Test
	public void deveBuscarTextoNaPagina() {
		Assert.assertEquals("Campo de Treinamento",
				driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				driver.findElement(By.xpath("//*[@id=\"elementosForm\"]/span")).getText());
	}
	
}
