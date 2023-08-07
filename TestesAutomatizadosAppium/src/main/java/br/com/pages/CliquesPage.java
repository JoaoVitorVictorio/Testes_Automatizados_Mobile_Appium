package br.com.pages;

import org.openqa.selenium.By;

import br.com.core.BasePage;

public class CliquesPage extends BasePage {

	public void efetuarCliqueLongo() {
		cliqueLongo("//*[@text='Clique Longo']");
	}

	public void efetuarDuploClique() {
		cliqueDuplo("Clique duplo");
	}

	public boolean validaCaixaPresenteNaTela(String texto) {
		String xpath = "//android.widget.TextView[@text='" + texto + "']";
		esperarElement(By.xpath(xpath), 1);
		return existeElementoPresente(xpath);
	}

}
