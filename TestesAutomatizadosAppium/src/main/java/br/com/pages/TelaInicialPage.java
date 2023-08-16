package br.com.pages;

import org.openqa.selenium.By;

import br.com.core.BasePage;

public class TelaInicialPage extends BasePage {

	public void selecionaOpcaoTelaInicial(String opcao) {
		String xpath = "//android.widget.TextView[@text='" + opcao + "']";
		esperarElement(By.xpath(xpath), 10);
		clicar(By.xpath(xpath));
	}

}
