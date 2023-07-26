package br.com.appium;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.core.BasePage;
import br.com.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioTest {

	AndroidDriver<MobileElement> driver;

	private BasePage basePage = new BasePage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		driver = DriverFactory.getDriver();

		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	}

	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		basePage.escrever(MobileBy.AccessibilityId("nome"), "Testando");
		
		String texto = basePage.obterTexto(MobileBy.AccessibilityId("nome"));

		Assert.assertEquals("Testando", texto);
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		basePage.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
		
		String texto = basePage.obterTexto(By.xpath("//android.widget.Spinner[@content-desc='console']/android.widget.TextView"));

		Assert.assertEquals("Nintendo Switch", texto);
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		Assert.assertTrue(basePage.isCheckMarcado(MobileBy.AccessibilityId("check")));
		Assert.assertFalse(basePage.isCheckMarcado(MobileBy.AccessibilityId("switch")));

		// Clicar nos elementos
		basePage.clicar(MobileBy.AccessibilityId("check"));
		basePage.clicar(MobileBy.AccessibilityId("switch"));
		

		// Verificar status alterados
		Assert.assertFalse(basePage.isCheckMarcado(MobileBy.AccessibilityId("check")));
		Assert.assertTrue(basePage.isCheckMarcado(MobileBy.AccessibilityId("switch")));
	}

	@Test
	public void deveRealizarCadastroComSucesso() throws MalformedURLException {
		basePage.escrever(MobileBy.AccessibilityId("nome"), "João Teste");

		basePage.selecionarCombo(By.xpath("//android.widget.Spinner[@content-desc='console']"), "PS4");

		basePage.clicar(MobileBy.AccessibilityId("check"));
		basePage.clicar(MobileBy.AccessibilityId("switch"));

		basePage.clicar(By.xpath("//android.widget.TextView[@text='SALVAR']"));

		String nome = basePage.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: João Teste']"));
		Assert.assertEquals("Nome: João Teste", nome);

		String console = basePage.obterTexto(By.xpath("//android.widget.TextView[@text='Console: ps4']"));
		Assert.assertEquals("Console: ps4", console);

		String switcH = basePage.obterTexto(By.xpath("//android.widget.TextView[@text='Switch: Off']"));
		Assert.assertTrue(switcH.endsWith("Off"));

		String checkbox = basePage.obterTexto(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']"));
		Assert.assertTrue(checkbox.endsWith("Marcado"));
	}

}
