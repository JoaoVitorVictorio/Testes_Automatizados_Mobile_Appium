package br.com.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	
	private static AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
			createDriver();
		}
		return driver;
	}
	
	private static void createDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); // Configurações do Appium
		desiredCapabilities.setCapability("platformName", "Android"); // Plataforma do dispositivo a ser testado (Android)
		desiredCapabilities.setCapability("deviceName", "emulador"); // Nome do dispositivo (emulador ou dispositivo real)
		desiredCapabilities.setCapability("automationName", "uiautomator2"); // Nome da automação a ser usada (uiautomator2)
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\JN\\Documents\\MEUS PROJETOS\\Projetos\\Pasta-de-estudo\\Testes-automatizados\\TestesAutomatizadosMobileAppium\\TestesAutomatizadosAppium\\src\\main\\resources\\CTAppium_1_2.apk");  // Caminho para o arquivo APK do aplicativo que será testado
		desiredCapabilities.setCapability("noReset", true); // Configuração para evitar reset do aplicativo antes de cada execução do teste
		desiredCapabilities.setCapability("fullReset", false); // Configuração para evitar reset completo do aplicativo entre as execuções do teste

		// Inicialização do driver do Appium para Android
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
					desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
