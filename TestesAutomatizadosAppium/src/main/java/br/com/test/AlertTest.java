package br.com.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.AlertasPage;
import br.com.pages.TelaInicialPage;

public class AlertTest extends BaseTest {
	
	private TelaInicialPage telaInicialPage = new TelaInicialPage();
	private AlertasPage page = new AlertasPage();
	
	@Before
	public void setup() {
		telaInicialPage.selecionaOpcaoTelaInicial("Alertas");
	}
	
	
	@Test
	public void deveConfirmaAlerta() {
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
	
	@Test
	public void deveClicarForaDoAlerta() throws InterruptedException {
			//clicar alerta simples
			page.clicarAlertaSimples();
			
			//clicar fora da caixa
			page.clicarForaCaixa();
			
			//verificar que a mensagem não está presente
			Assert.assertFalse(page.existeElementoPorTexto());
		}
}
