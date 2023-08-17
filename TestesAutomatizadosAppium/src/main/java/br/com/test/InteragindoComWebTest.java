package br.com.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.InteragindoComWebPage;
import br.com.pages.TelaInicialPage;

public class InteragindoComWebTest extends BaseTest {
	TelaInicialPage telaInicialPage = new TelaInicialPage();
	InteragindoComWebPage page = new InteragindoComWebPage();

	@Test
	public void deveRealizarLoginComSucesso() throws InterruptedException {
		telaInicialPage.selecionaOpcaoTelaInicial("SeuBarriga Híbrido");

		page.setLogin("joaoteste@gmail.com");
		page.setSenha("123456");

		page.clicarBotaoEntrar();

		Assert.assertEquals("Bem vindo, João Vitor!", page.getMensagemTelaInicial());
	}

}
