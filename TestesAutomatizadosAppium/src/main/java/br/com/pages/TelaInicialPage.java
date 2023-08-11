package br.com.pages;

import org.openqa.selenium.By;

import br.com.core.BasePage;

public class TelaInicialPage extends BasePage {

	public void selecionaOpcaoTelaInicial(String opcao) {
		clicar(By.xpath("//android.widget.TextView[@text='" + opcao + "']"));
	}
}
