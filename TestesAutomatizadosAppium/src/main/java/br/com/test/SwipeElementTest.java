package br.com.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.ScrollPage;
import br.com.pages.SwipePage;
import br.com.pages.TelaInicialPage;

public class SwipeElementTest extends BaseTest {

	TelaInicialPage telaInicial = new TelaInicialPage();
	ScrollPage scroll = new ScrollPage();
	SwipePage page = new SwipePage();

	@Test
	public void deveInteragirComSwipeList() throws InterruptedException {
		scroll.descerTela();
		telaInicial.selecionaOpcaoTelaInicial("Swipe List");

		page.swipeElementRight("Opção 1");
		page.clicarBotaoMais();
		Assert.assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));

		page.swipeElementRight("Opção 4");
		page.clicarBotaoMenos();
		Assert.assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));

		page.swipeElementLeft("Opção 5 (-)");
		Assert.assertTrue(page.existeElementoPorTexto("Opção 5"));
	}
}
