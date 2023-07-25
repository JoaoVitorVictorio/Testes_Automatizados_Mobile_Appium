package br.com.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTest {

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); // Configurações do Appium
		desiredCapabilities.setCapability("platformName", "Android"); // Plataforma do dispositivo a ser testado (Android)
		desiredCapabilities.setCapability("deviceName", "emulador"); // Nome do dispositivo (emulador ou dispositivo real)
		desiredCapabilities.setCapability("automationName", "uiautomator2"); // Nome da automação a ser usada (uiautomator2)
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\JN\\Documents\\MEUS PROJETOS\\Projetos\\Pasta-de-estudo\\Testes-automatizados\\TestesAutomatizadosMobileAppium\\TestesAutomatizadosAppium\\src\\main\\resources\\CTAppium_1_2.apk");  // Caminho para o arquivo APK do aplicativo que será testado
		desiredCapabilities.setCapability("noReset", true); // Configuração para evitar reset do aplicativo antes de cada execução do teste
		desiredCapabilities.setCapability("fullReset", false); // Configuração para evitar reset completo do aplicativo entre as execuções do teste

		// Inicialização do driver do Appium para Android
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Localiza e exibe os elementos da classe "android.widget.TextView" presentes na tela
		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
		for (MobileElement elemento : elementosEncontrados) {
			System.out.println(elemento.getText());
		}

		// Clica no segundo elemento encontrado
		elementosEncontrados.get(1).click();

		// Localiza o campo de texto pelo atributo "AccessibilityId" com valor "nome"
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));

		// Insere o texto "Testando" no campo de texto
		campoNome.sendKeys("Testando");

		// Obtém o texto presente no campo de texto
		String text = campoNome.getText();

		// Verifica se o texto inserido é igual a "Testando" usando o Assert
		Assert.assertEquals("Testando", text);

		// Encerra o driver do Appium
		driver.quit();
	}
	
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); 
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulador"); 
		desiredCapabilities.setCapability("automationName", "uiautomator2"); 
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\JN\\Documents\\MEUS PROJETOS\\Projetos\\Pasta-de-estudo\\Testes-automatizados\\TestesAutomatizadosMobileAppium\\TestesAutomatizadosAppium\\src\\main\\resources\\CTAppium_1_2.apk");
		desiredCapabilities.setCapability("noReset", true); 
		desiredCapabilities.setCapability("fullReset", false); 
		
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Clicar formulário
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

		//Clicar no Combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		
		//Selecionar a opção desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		
		//Validar a opção selecionada
		String console = driver.findElement(By.xpath("//android.widget.Spinner[@content-desc='console']/android.widget.TextView")).getText();
		
		Assert.assertEquals("Nintendo Switch", console);

		driver.quit();
	}

}
