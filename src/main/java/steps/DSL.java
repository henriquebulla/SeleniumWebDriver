package steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertEquals;

public class DSL {
	private WebDriver driver;

	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	public void escreve(String xpath_campo,String texto) {
		driver.findElement(By.xpath(xpath_campo)).sendKeys(texto);
	}
	
	public String obtemValorCampo(String xpath_campo) {
		return driver.findElement(By.xpath(xpath_campo)).getAttribute("value");
	}
	
	public void clicarNoElemento(String id_campo) {
		driver.findElement(By.xpath(id_campo)).click();
	}
	
	public boolean isRadioMarcado(String id_campo) {
		return driver.findElement(By.xpath(id_campo)).isSelected();
	}
	
	public void selecionaValorCombo(String xpath_campo, String valor) {
		WebElement element = driver.findElement(By.xpath(xpath_campo)); // Adiciona a instacia achada pelo FindElement para o objeto element
		Select combo = new Select(element); 
		combo.selectByVisibleText(valor);
	}
	public String verifcaValorCombo(String xpath_campo) {
		WebElement element = driver.findElement(By.xpath(xpath_campo)); 
		Select combo = new Select(element); 
		return combo.getFirstSelectedOption().getText();
	}
	
	public void encontrarTamanhoDoCombo(String xpath_campo) {
		WebElement element = driver.findElement(By.xpath(xpath_campo));
		Select combo = new Select(element); 
		List<WebElement> options = combo.getOptions();
	}
	
	public Number retornarTamanhoDoCombo(String xpath_campo) {
		WebElement element = driver.findElement(By.xpath(xpath_campo));
		Select combo = new Select(element); 
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	public boolean valorExisteNoCombo(String xpath_campo, String valor) {
		WebElement element = driver.findElement(By.xpath(xpath_campo));
		Select combo = new Select(element); 
		List<WebElement> options = combo.getOptions();
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals(valor)) {
				encontrou = true;
				break;
			}
		}
		return encontrou;
	}

	public void validarAlerta(String mensagemEsperada){
		Alert alert = driver.switchTo().alert();
		assertEquals(mensagemEsperada, alert.getText());
		alert.accept();
	}

	
}
