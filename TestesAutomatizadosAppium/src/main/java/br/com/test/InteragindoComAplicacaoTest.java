package br.com.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.core.BaseTest;
import br.com.pages.InteragindoComAplicacaoPage;
import br.com.pages.TelaInicialPage;

public class InteragindoComAplicacaoTest extends BaseTest {

	TelaInicialPage telaInicialPage = new TelaInicialPage();
	InteragindoComAplicacaoPage page = new InteragindoComAplicacaoPage();

	@Before
	public void deveRealizarLoginComSucesso() {
		telaInicialPage.selecionaOpcaoTelaInicial("SeuBarriga Nativo");

		page.setLogin("joaoteste@gmail.com");
		page.setSenha("123456");

		page.clicar("ENTRAR");
	}

	@Test
	public void deveResetarOsDados() {
		page.clicar("RESET");
	}

	@Test
	public void deveInserirUmaContaNova() {
		page.clicarAba("Contas");

		page.digitarDescricaoNovaConta("Conta Teste");
		page.clicar("SALVAR");

		Assert.assertEquals("Conta adicionada com sucesso", page.getMensagemContaIncluida());
	}

	@Test
	public void deveExcluirUmaConta() {
		page.clicarAba("Contas");

		page.selecionarConta("Conta mesmo nome");
		page.clicar("EXCLUIR");

		Assert.assertEquals("Conta excluída com sucesso", page.getMensagemContaExcluida());
	}

	@Test
	public void deveInserirMovimentacaoDeConta() {
		page.clicarAba("Mov...");

		page.setDescricao("Teste Movimentacao");
		page.clicar("SALVAR");
		Assert.assertEquals("Interessado é um campo obrigatório", page.getCriticaCampoObrigatorioInteressado());

		page.setInteressado("Joao Teste");
		page.clicar("SALVAR");
		Assert.assertEquals("Valor é um campo obrigatório", page.getCriticaCampoObrigatorioValor());

		page.setValor("123");
		page.clicar("SALVAR");
		Assert.assertEquals("Conta é um campo obrigatório", page.getCriticaCampoObrigatorioConta());

		page.selecionaConta("Conta para movimentacoes");
		page.clicar("SALVAR");
		Assert.assertEquals("Movimentação cadastrada com sucesso", page.getMensagemSucesso());
	}

	@Test
	public void deveRemoverMovimentacao() {
		page.clicarAba("Resumo");

		page.clicar("ATUALIZAR");
		page.excluirMovimentacaoConta();

		Assert.assertEquals("Movimentação removida com sucesso!", page.getMensagemMovimentacaoExcluida());
		page.clicarAba("Home");
	}
}
