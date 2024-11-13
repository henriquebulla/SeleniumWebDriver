package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.pt.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class StepsDefinitions {
    WebDriver driver;
    DSL dsl;

    @Dado("que o formulário foi aberto")
    public void que_o_formulario_foi_aberto() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        dsl = new DSL(driver);
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    @Quando("eu clico no botão de cadastrar")
    public void eu_clico_no_botao_de_cadastrar() {
        dsl.clicarNoElemento("//*[@id=\"elementosForm:cadastrar\"]");
    }

    @Quando("eu preencho o nome e clico no botão de cadastrar")
    public void eu_preencho_o_nome_e_clico_no_botao_de_cadastrar() {
        dsl.escreve("//*[@id=\"elementosForm:nome\"]", "Henrique");
        dsl.clicarNoElemento("//*[@id=\"elementosForm:cadastrar\"]");
    }

    @Quando("eu preencho o nome e o sobrenome e clico no botão de cadastrar")
    public void eu_preencho_o_nome_e_o_sobrenome_e_clico_no_botao_de_cadastrar() {
        dsl.escreve("//*[@id=\"elementosForm:nome\"]","Henrique");
        dsl.escreve("//*[@id=\"elementosForm:sobrenome\"]","Bulla");
        dsl.clicarNoElemento("//*[@id=\"elementosForm:cadastrar\"]");
    }

    @Quando("eu preencho o nome, sobrenome e seleciono as opções de sexo e comida")
    public void eu_preencho_o_nome_sobrenome_e_seleciono_as_opcoes_de_sexo_e_comida() {
        dsl.escreve("//*[@id=\"elementosForm:nome\"]","Henrique");
        dsl.escreve("//*[@id=\"elementosForm:sobrenome\"]","Bulla");
        dsl.clicarNoElemento("//*[@id=\"elementosForm:sexo\"]/tbody/tr/td[1]/label");
        dsl.clicarNoElemento("//*[@id=\"elementosForm:comidaFavorita\"]/tbody/tr/td[1]/label");
        dsl.clicarNoElemento("//*[@id=\"elementosForm:comidaFavorita\"]/tbody/tr/td[4]/label");
        dsl.clicarNoElemento("//*[@id=\"elementosForm:cadastrar\"]");
    }

    @Quando("^eu preencho o campo de nome com \"([^\"]*)\" e o sobrenome com \"([^\"]*)\"$")
    public void euPreenchoOCampoDeNomeComEOSobrenomeCom(String nome, String sobrenome){
        dsl.escreve("//*[@id=\"elementosForm:nome\"]", nome);
        dsl.escreve("//*[@id=\"elementosForm:sobrenome\"]", sobrenome);
    }

    @Então("^devo ver o alerta \"([^\"]*)\"$")
    public void devo_ver_o_alerta(String mensagemEsperada) {
        dsl.validarAlerta(mensagemEsperada);
        driver.quit();
    }

    @Então("^o campo de nome deve conter \"([^\"]*)\"$")
    public void oCampoDeNomeDeveConter(String nomeEsperado) {
        assertEquals(nomeEsperado, dsl.obtemValorCampo("//*[@id=\"elementosForm:nome\"]"));
    }

    @And("^o campo de sobrenome deve conter \"([^\"]*)\"$")
    public void oCampoDeSobrenomeDeveConter(String sobrenomeEsperado){
        assertEquals(sobrenomeEsperado, dsl.obtemValorCampo("//*[@id=\"elementosForm:sobrenome\"]"));
        driver.quit();
    }

    @When("^eu preencho o campo de sugestões com \"([^\"]*)\"$")
    public void euPreenchoOCampoDeSugestõesCom(String sugestoes) {
        dsl.escreve("//*[@id=\"elementosForm:sugestoes\"]", sugestoes);
    }

    @Then("^o campo de sugestões deve conter \"([^\"]*)\"$")
    public void oCampoDeSugestõesDeveConter(String sugestoesEsperadas) {
        assertEquals(sugestoesEsperadas, dsl.obtemValorCampo("//*[@id=\"elementosForm:sugestoes\"]"));
        driver.quit();
    }

    @When("^eu seleciono o rádio do sexo$")
    public void euSelecionoORádioDoSexo() {
        dsl.clicarNoElemento("//*[@id=\"elementosForm:sexo:0\"]");
    }


    @Then("^o botão de rádio para sexo deve estar selecionado$")
    public void oBotãoDeRádioParaSexoDeveEstarSelecionado() {
        assertTrue(dsl.isRadioMarcado("//*[@id=\"elementosForm:sexo:0\"]"));
        driver.quit();
    }


    @When("^eu seleciono o checkbox de comida favorita$")
    public void euSelecionoOCheckboxDeComidaFavorita() {
        dsl.clicarNoElemento("//*[@id=\"elementosForm:comidaFavorita:2\"]");
    }

    @Then("^o checkbox deve estar selecionado$")
    public void oCheckboxDeveEstarSelecionado() {
        assertTrue(dsl.isRadioMarcado("//*[@id=\"elementosForm:comidaFavorita:2\"]"));
        driver.quit();
    }

    @When("^eu seleciono a escolaridade como \"([^\"]*)\"$")
    public void euSelecionoAEscolaridadeComo(String escolaridade){
        dsl.selecionaValorCombo("//*[@id=\"elementosForm:escolaridade\"]", escolaridade);
    }


    @Then("^o combo box de escolaridade deve estar com \"([^\"]*)\"$")
    public void oComboBoxDeEscolaridadeDeveEstarCom(String escolaridadeEsperada){
        assertEquals(escolaridadeEsperada, dsl.verifcaValorCombo("//*[@id=\"elementosForm:escolaridade\"]"));
        driver.quit();
    }


    @Then("^o combo box de escolaridade deve conter (\\d+) opções$")
    public void oComboBoxDeEscolaridadeDeveConterOpções(int quantidadeEsperada){
        assertEquals(quantidadeEsperada, dsl.retornarTamanhoDoCombo("//*[@id=\"elementosForm:escolaridade\"]"));
    }

    @And("^o combo box de escolaridade deve conter a opção \"([^\"]*)\"$")
    public void oComboBoxDeEscolaridadeDeveConterAOpção(String opcao){
        assertTrue(dsl.valorExisteNoCombo("//*[@id=\"elementosForm:escolaridade\"]", opcao));
        driver.quit();
    }


    @When("^eu seleciono os esportes \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\"$")
    public void euSelecionoOsEsportesE(String esporte1, String esporte2, String esporte3) throws Throwable {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"elementosForm:esportes\"]"));
        Select combo = new Select(element);
        combo.selectByVisibleText(esporte1);
        combo.selectByVisibleText(esporte2);
        combo.selectByVisibleText(esporte3);
    }

    @Then("^os esportes selecionados devem conter \"([^\"]*)\", \"([^\"]*)\", e \"([^\"]*)\"$")
    public void osEsportesSelecionadosDevemConterE(String esporte1, String esporte2, String esporte3) throws Throwable {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"elementosForm:esportes\"]"));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        assertTrue(allSelectedOptions.stream().anyMatch(option -> option.getText().equals(esporte1)));
        assertTrue(allSelectedOptions.stream().anyMatch(option -> option.getText().equals(esporte2)));
        assertTrue(allSelectedOptions.stream().anyMatch(option -> option.getText().equals(esporte3)));
        driver.quit();
    }

    @When("^eu clico no botão simples$")
    public void euClicoNoBotãoSimples() {
        dsl.clicarNoElemento("//*[@id=\"buttonSimple\"]");
    }

    @Then("^o botão deve conter o texto \"([^\"]*)\"$")
    public void oBotãoDeveConterOTexto(String textoEsperado){
        String textoObtido = dsl.obtemValorCampo("//*[@id=\"buttonSimple\"]");
        assertEquals(textoEsperado, textoObtido);
        driver.quit();
    }

    @Then("^o título da página deve ser \"([^\"]*)\"$")
    public void oTítuloDaPáginaDeveSer(String tituloEsperado){
        assertEquals(tituloEsperado, driver.findElement(By.tagName("h3")).getText());
    }

    @And("^o texto da página deve conter \"([^\"]*)\"$")
    public void oTextoDaPáginaDeveConter(String textoEsperado){
        String textoAtual = driver.findElement(By.xpath("//*[@id=\"elementosForm\"]/span")).getText();
        assertEquals(textoEsperado, textoAtual);
        driver.quit();
    }
}
