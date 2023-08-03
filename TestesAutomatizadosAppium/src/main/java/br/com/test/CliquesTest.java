package br.com.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.CliquesPage;
import br.com.pages.TelaInicialPage;

public class CliquesTest extends BaseTest {

	private TelaInicialPage telaInicialPage = new TelaInicialPage();
	private CliquesPage page = new CliquesPage();

	@Before
	public void setup() {
		telaInicialPage.selecionaOpcaoTelaInicial("Cliques");
	}

	@Test
	public void deveRealizarCliqueLongo() {
		page.efetuarCliqueLongo();
		Assert.assertTrue(page.validaCaixaPresenteNaTela());
	}

}
