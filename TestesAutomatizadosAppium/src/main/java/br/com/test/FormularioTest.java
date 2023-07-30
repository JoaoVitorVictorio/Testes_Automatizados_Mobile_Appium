package br.com.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.core.BaseTest;
import br.com.core.DriverFactory;
import br.com.pages.FormularioPage;
import br.com.pages.TelaInicialPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioTest extends BaseTest{

	AndroidDriver<MobileElement> driver;

	private TelaInicialPage telaInicialPage = new TelaInicialPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() {
		driver = DriverFactory.getDriver();

		telaInicialPage.selecionaOpcaoTelaInicial("Formulário");
	}

	@Test
	public void devePreencherCampoTexto() {
		page.escreveNome("João Teste");

		Assert.assertEquals("João Teste", page.getValidaNomeEscrito());
	}

	@Test
	public void deveInteragirCombo() {
		page.selecionaOpcaoCombo("Nintendo Switch");

		Assert.assertEquals("Nintendo Switch", page.getOpcaoComboSelecionada());
	}

	@Test
	public void deveInteragirSwitchCheckBox() {
		Assert.assertTrue(page.getIsMarcado("check"));
		Assert.assertFalse(page.getIsMarcado("switch"));

		page.clicarElemento("check");
		page.clicarElemento("switch");

		Assert.assertFalse(page.getIsMarcado("check"));
		Assert.assertTrue(page.getIsMarcado("switch"));
	}

	@Test
	public void deveRealizarCadastroComSucesso() {
		page.escreveNome("João Teste");

		page.selecionaOpcaoCombo("PS4");

		page.clicarElemento("check");
		page.clicarElemento("switch");

		page.clicarSalvar();

		Assert.assertEquals("Nome: João Teste", page.getNomeRelatorio("Nome: João Teste"));
		Assert.assertEquals("Console: ps4", page.getConsoleRelatorio("Console: ps4"));
		Assert.assertEquals("Switch: Off", page.getStatusElementoRelatorio("Switch: Off"));
		Assert.assertEquals("Checkbox: Marcado", page.getStatusElementoRelatorio("Checkbox: Marcado"));
	}

}
