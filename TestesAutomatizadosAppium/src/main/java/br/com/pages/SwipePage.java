package br.com.pages;

import org.openqa.selenium.By;

import br.com.core.BasePage;
import br.com.core.DriverFactory;
import io.appium.java_client.MobileElement;

public class SwipePage extends BasePage {

	public boolean existeElementoPorTexto(String texto) {
		return existeElementoPresente("//android.widget.TextView[@text='" + texto + "']");
	}

	public void swipeElementLeft(String opcao) {
		swipeElement(
				DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='" + opcao + "']/..")),
				0.1, 0.9);
	}

	public void swipeElementRight(String opcao) {
		swipeElement(
				DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='" + opcao + "']/..")),
				0.9, 0.1);
	}

	public void clicarBotaoMais() {
		MobileElement botao = DriverFactory.getDriver()
				.findElement(By.xpath("//android.widget.TextView[@text='(+)']/.."));
		botao.click();
	}
	
	public void clicarBotaoMenos() {
		MobileElement botao = DriverFactory.getDriver()
				.findElement(By.xpath("//android.widget.TextView[@text='(-)']/.."));
		botao.click();
	}
}
