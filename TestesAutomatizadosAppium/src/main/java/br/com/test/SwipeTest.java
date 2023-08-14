package br.com.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.SwipePage;
import br.com.pages.TelaInicialPage;

public class SwipeTest extends BaseTest {

	TelaInicialPage telaInicialPage = new TelaInicialPage();
	SwipePage page = new SwipePage();

	@Test
	public void deveRealizarSwipe() {
		telaInicialPage.selecionaOpcaoTelaInicial("Swipe");

		Assert.assertTrue(page.existeElementoPorTexto("Mova a tela para"));
		Assert.assertTrue(page.existeElementoPorTexto("a esquerda"));

		page.swipeLeft(0.1, 0.9);

		Assert.assertTrue(page.existeElementoPorTexto("E veja se"));
		Assert.assertTrue(page.existeElementoPorTexto("você consegue"));

		page.swipeLeft(0.1, 0.9);

		Assert.assertTrue(page.existeElementoPorTexto("Chegar até o fim!"));

		page.swipeRight(0.1, 0.9);
		page.swipeRight(0.1, 0.9);

		Assert.assertTrue(page.existeElementoPorTexto("a esquerda"));
	}

}
