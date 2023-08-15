package br.com.pages;

import org.openqa.selenium.By;

import br.com.core.BasePage;

public class ScrollPage extends BasePage {

	public String getValidaMensagemSucesso() {
		return obterTexto(By.id("android:id/message"));
	}

	public void clicarSair() {
		clicar(By.id("android:id/button1"));
	}

	public void descerTela() {
		scroll(0.9, 0.1);
	}

}
