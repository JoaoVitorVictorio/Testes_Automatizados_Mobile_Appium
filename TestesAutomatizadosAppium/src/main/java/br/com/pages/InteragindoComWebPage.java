package br.com.pages;

import org.openqa.selenium.By;

import br.com.core.BasePage;

public class InteragindoComWebPage extends BasePage {

	public void setLogin(String login) {
		escrever(By.xpath("//android.widget.EditText[@resource-id='email']"), login);
	}

	public void setSenha(String senha) {
		escrever(By.xpath("//android.widget.EditText[@resource-id='senha']"), senha);
	}

	public void clicarBotaoEntrar() {
		clicar(By.xpath("//android.widget.Button[@text='Entrar']"));
	}

	public String getMensagemTelaInicial() {
		return obterTexto(By.xpath("//android.view.View[@text='Bem vindo, João Vitor!']"));
	}

}
