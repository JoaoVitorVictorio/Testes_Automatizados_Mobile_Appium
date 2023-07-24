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
		// Configurações do Appium
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		// Plataforma do dispositivo a ser testado (Android)
		desiredCapabilities.setCapability("platformName", "Android");
		// Nome do dispositivo (emulador ou dispositivo real)
		desiredCapabilities.setCapability("deviceName", "emulador");
		// Nome da automação a ser usada (uiautomator2)
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		// Caminho para o arquivo APK do aplicativo que será testado
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\JN\\Documents\\MEUS PROJETOS\\Projetos\\Pasta-de-estudo\\Testes-automatizados\\TestesAutomatizadosMobileAppium\\TestesAutomatizadosAppium\\src\\main\\resources\\CTAppium_1_2.apk");
		// Configuração para evitar reset do aplicativo antes de cada execução do teste
		desiredCapabilities.setCapability("noReset", true);
		// Configuração para evitar reset completo do aplicativo entre as execuções do teste
		desiredCapabilities.setCapability("fullReset", false);

		// Inicialização do driver do Appium para Android
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Localiza e exibe os elementos da classe "android.widget.TextView" presentes
		// na tela
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

}
