package br.com.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTest {

	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulador");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
		desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);

		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("2");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("2");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_preview");
		
		Assert.assertEquals("4", el4.getText());
		
		driver.quit();
	}
}
