package br.com.pages;

import org.openqa.selenium.By;

import br.com.core.BasePage;

public class AlertasPage extends BasePage{

	public void clicarAlertaConfirm() {
		clicar("//android.widget.TextView[@text='ALERTA CONFIRM']");
	}

	public String validaMensagemAlertaExibida() {
		String id = "android:id/message";
		esperarElement(By.id(id), 10);
		return obterTexto(By.id(id));
	}
	
	public void clicarConfirmar() {
		clicar(By.xpath("//android.widget.Button[@text='CONFIRMAR']"));;
	}

	public void clicarSair() {
		clicar(By.xpath("//android.widget.Button[@text='SAIR']"));
		
	}
	
}
