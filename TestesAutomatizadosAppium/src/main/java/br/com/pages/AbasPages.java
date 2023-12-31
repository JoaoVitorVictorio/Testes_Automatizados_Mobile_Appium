package br.com.pages;

import org.openqa.selenium.By;

import br.com.core.BasePage;

public class AbasPages extends BasePage {

	public String getMensagemInformandoAbaAtual(String numero) {
		return obterTexto(By.xpath("//android.widget.TextView[@text='Este é o conteúdo da Aba " + numero + "']"));
	}

	public void selecionarAba(String aba) {
		String xpath = "//android.widget.TextView[@text='Aba " + aba + "']";
		esperarElement(By.xpath(xpath), 5);
		clicar(xpath);
	}
}
