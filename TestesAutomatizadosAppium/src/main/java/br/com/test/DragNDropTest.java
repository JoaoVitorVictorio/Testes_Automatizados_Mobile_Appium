package br.com.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.DragNDropPage;
import br.com.pages.ScrollPage;
import br.com.pages.TelaInicialPage;

public class DragNDropTest extends BaseTest {

	DragNDropPage page = new DragNDropPage();
	ScrollPage scrollPage = new ScrollPage();
	TelaInicialPage telaInicialPage = new TelaInicialPage();

	private String[] estadoInicial = new String[] { "Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,",
			"e arraste para", "qualquer local desejado." };
	private String[] estadoIntermediario = new String[] { "é uma lista", "Drag em Drop!", "Faça um clique longo,",
			"e arraste para", "Esta", "qualquer local desejado." };
	private String[] estadoFinal = new String[] { "Faça um clique longo,", "é uma lista", "Drag em Drop!",
			"e arraste para", "Esta", "qualquer local desejado." };

	@Test
	public void deveEfetuarDragNDrop() throws InterruptedException {
		scrollPage.descerTela();
		telaInicialPage.selecionaOpcaoTelaInicial("Drag and drop");
		Assert.assertArrayEquals(estadoInicial, page.obterLista());

		page.arrastarESoltar("Esta", "e arraste para");
		Assert.assertArrayEquals(estadoIntermediario, page.obterLista());

		page.arrastarESoltar("Faça um clique longo,", "é uma lista");
		Assert.assertArrayEquals(estadoFinal, page.obterLista());
	}
}
