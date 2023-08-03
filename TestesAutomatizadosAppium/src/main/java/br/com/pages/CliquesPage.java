package br.com.pages;

import org.openqa.selenium.By;

import br.com.core.BasePage;

public class CliquesPage extends BasePage {

	public void efetuarCliqueLongo() {
		cliqueLongo("//*[@text='Clique Longo']");
	}

	public boolean validaCaixaPresenteNaTela() {
		String xpath = "//android.widget.TextView[@text='Clique Longo']";
		esperarElement(By.xpath(xpath), 1);
		return existeElementoPresente(xpath);
	}

}
