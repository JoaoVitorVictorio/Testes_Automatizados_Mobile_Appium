package br.com.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.AlertasPage;
import br.com.pages.TelaInicialPage;

public class AlertTest extends BaseTest {
	
	private TelaInicialPage telaInicialPage = new TelaInicialPage();
	private AlertasPage page = new AlertasPage();
	
	
	@Test
	public void deveConfirmaAlerta() {
		//acessar menu alerta 
		telaInicialPage.selecionaOpcaoTelaInicial("Alertas");
		
		//clicar em Alerta Confirm
		page.clicarAlertaConfirm();
		
		//Validar os texto
		Assert.assertEquals("Confirma a operação?", page.validaMensagemAlertaExibida());
		
		//Confirma alerta
		page.clicarConfirmar();
		
		//Verificar nova mensagem
		Assert.assertEquals("Confirmado", page.validaMensagemAlertaExibida());
		
		//Sair
		page.clicarSair();
	}
}
