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
		page.clicarAlertaConfirm();
		Assert.assertEquals("Confirma a operação?", page.validaMensagemAlertaExibida());
		
		page.clicarConfirmar();
		Assert.assertEquals("Confirmado", page.validaMensagemAlertaExibida());
		
		page.clicarSair();
	}

	@Test
	public void deveClicarForaDoAlerta() throws InterruptedException {
		page.clicarAlertaSimples();

		page.clicarForaCaixa();

		Assert.assertFalse(page.validaCaixaPresenteNaTela());
	}
}
