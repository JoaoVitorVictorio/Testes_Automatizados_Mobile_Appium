package br.com.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.ScrollPage;
import br.com.pages.TelaInicialPage;

public class ScrollTest extends BaseTest {
	
	private TelaInicialPage telaInicialPage = new TelaInicialPage();
	private ScrollPage page = new ScrollPage();
	
	@Test
	public void realizarScrollNaTela() throws InterruptedException {
		page.scroll("Opção bem escondida");
		
		telaInicialPage.selecionaOpcaoTelaInicial("Opção bem escondida");
		
		Assert.assertEquals("Você achou essa opção", page.getValidaMensagemSucesso());
		
		page.clicarSair();
	}

}
