package br.com.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTest {
	
	AndroidDriver<MobileElement> driver;
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); // Configurações do Appium
		desiredCapabilities.setCapability("platformName", "Android"); // Plataforma do dispositivo a ser testado (Android)
		desiredCapabilities.setCapability("deviceName", "emulador"); // Nome do dispositivo (emulador ou dispositivo real)
		desiredCapabilities.setCapability("automationName", "uiautomator2"); // Nome da automação a ser usada (uiautomator2)
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\JN\\Documents\\MEUS PROJETOS\\Projetos\\Pasta-de-estudo\\Testes-automatizados\\TestesAutomatizadosMobileAppium\\TestesAutomatizadosAppium\\src\\main\\resources\\CTAppium_1_2.apk");  // Caminho para o arquivo APK do aplicativo que será testado
		desiredCapabilities.setCapability("noReset", true); // Configuração para evitar reset do aplicativo antes de cada execução do teste
		desiredCapabilities.setCapability("fullReset", false); // Configuração para evitar reset completo do aplicativo entre as execuções do teste

		// Inicialização do driver do Appium para Android
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		// Clicar formulário
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		// Localiza o campo de texto pelo atributo "AccessibilityId" com valor "nome"
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));

		// Insere o texto "Testando" no campo de texto
		campoNome.sendKeys("Testando");

		// Obtém o texto presente no campo de texto
		String text = campoNome.getText();

		// Verifica se o texto inserido é igual a "Testando" usando o Assert
		Assert.assertEquals("Testando", text);

		// Encerra o driver do Appium
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		//Clicar no Combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		
		//Selecionar a opção desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		
		//Validar a opção selecionada
		String console = driver.findElement(By.xpath("//android.widget.Spinner[@content-desc='console']/android.widget.TextView")).getText();
		
		Assert.assertEquals("Nintendo Switch", console);
	}
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		// Verificar se os elementos estão habilitados
		MobileElement check = driver.findElement(MobileBy.AccessibilityId("check"));
		MobileElement switcH = driver.findElement(MobileBy.AccessibilityId("switch"));
		
		Assert.assertTrue(check.getAttribute("checked").equals("false"));
		Assert.assertTrue(switcH.getAttribute("checked").equals("true"));
		
		// Clicar nos elementos
		check.click();
		switcH.click();
		
		// Verificar status alterados
		Assert.assertTrue(check.getAttribute("checked").equals("true"));
		Assert.assertTrue(switcH.getAttribute("checked").equals("false"));
	}
	
	@Test
	public void devePreencherFomularioPorCompleto() throws MalformedURLException {
		// Escrever o nome
		driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys("João Teste");
	
		// Selecionar o console
		driver.findElement(By.xpath("//android.widget.Spinner[@content-desc='console']")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
		
		// Verificar se os elementos estão habilitados
		driver.findElement(MobileBy.AccessibilityId("check")).click();
		driver.findElement(MobileBy.AccessibilityId("switch")).click();
		
		// Clicar em Salvar
		driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();

		// Verificar os status alterados
		String nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: João Teste']")).getText();
		Assert.assertEquals("Nome: João Teste", nome);
		
		String console = driver.findElement(By.xpath("//android.widget.TextView[@text='Console: ps4']")).getText();
		Assert.assertEquals("Console: ps4", console);
		
		String switcH = driver.findElement(By.xpath("//android.widget.TextView[@text='Switch: Off']")).getText();
		Assert.assertTrue(switcH.endsWith("Off"));
		
		String checkbox = driver.findElement(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']")).getText();
		Assert.assertTrue(checkbox.endsWith("Marcado"));
	}

}
