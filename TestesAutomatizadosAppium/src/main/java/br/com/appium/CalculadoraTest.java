package br.com.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculadoraTest {

	@Test
	public void deveInstalarAPK() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulador");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\JN\\Documents\\MEUS PROJETOS\\Projetos\\Pasta-de-estudo\\Testes-automatizados\\TestesAutomatizadosMobileAppium\\TestesAutomatizadosAppium\\src\\main\\resources\\CTAppium_1_2.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);

		driver.quit();
	}
}
