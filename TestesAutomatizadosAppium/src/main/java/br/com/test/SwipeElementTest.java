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
	public void deveInteragirComSwipeList() {
		//Clicar swipe list
		scroll.descerTela();
		telaInicial.selecionaOpcaoTelaInicial("Swipe List");
		
		//opção1 para direita
		page.swipeElementRight("Opção 1");
		
		//Opção 1 +
		page.clicarBotaoMais();
		
		//Valida Opção 1 +
		Assert.assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));
		
		//Opção 4 para direita
		page.swipeElementRight("Opção 4");
		
		//Opção 4 -
		page.clicarBotaoMenos();
		
		//Valida Opção 4 -
		Assert.assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));
		
		//Opção 5 esquerda
		page.swipeElementLeft("Opção 5 (-)");
		
		//Valida Opção 5
		Assert.assertTrue(page.existeElementoPorTexto("Opção 5"));
	}
}
