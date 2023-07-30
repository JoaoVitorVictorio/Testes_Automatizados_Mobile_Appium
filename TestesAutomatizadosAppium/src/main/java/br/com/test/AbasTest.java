package br.com.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.AbasPages;
import br.com.pages.TelaInicialPage;

public class AbasTest extends BaseTest {
	TelaInicialPage telaInicialPage = new TelaInicialPage();
	AbasPages page = new AbasPages();

	@Test
	public void deveInteragirComAbas() {
		//acessar menu abas
		telaInicialPage.selecionaOpcaoTelaInicial("Abas");
		
		//verificar que está na aba 1
		Assert.assertEquals("Este é o conteúdo da Aba 1", page.getMensagemInformandoAbaAtual("1"));
		
		//acessar aba 2
		page.selecionarAba("2");
		
		//verifica que está na aba 2
		Assert.assertEquals("Este é o conteúdo da Aba 2", page.getMensagemInformandoAbaAtual("2"));
	}
}
