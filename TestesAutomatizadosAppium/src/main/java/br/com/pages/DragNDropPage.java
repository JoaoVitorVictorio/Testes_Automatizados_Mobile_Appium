package br.com.pages;

import java.util.List;

import org.openqa.selenium.By;

import br.com.core.BasePage;
import br.com.core.DriverFactory;
import io.appium.java_client.MobileElement;

public class DragNDropPage extends BasePage {

	public void arrastarESoltar(String origem, String destino) {
		DragNDrop(origem, destino);
	}

	public String[] obterLista() throws InterruptedException {
		delaySegundos(1);
		List<MobileElement> elements = DriverFactory.getDriver().findElements(By.className("android.widget.TextView"));
		String[] retorno = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			retorno[i] = elements.get(i).getText();
		}
		return retorno;
	}

}
