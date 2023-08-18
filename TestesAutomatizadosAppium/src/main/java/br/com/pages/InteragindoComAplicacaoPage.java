package br.com.pages;

import org.openqa.selenium.By;

import br.com.core.BasePage;

public class InteragindoComAplicacaoPage extends BasePage {

	SwipePage page = new SwipePage();

	public void clicar(String elemento) {
		String xpath = "//android.widget.TextView[@text='" + elemento + "']";
		esperarElement(By.xpath(xpath), 2);
		clicar(By.xpath(xpath));
	}

	public String validarMensagemExibida(String mensagemApresentada) {
		String xpath = "//android.widget.TextView[@text='" + mensagemApresentada + "']";
		esperarElement(By.xpath(xpath), 2);
		return obterTexto(By.xpath(xpath));
	}

	public void clicarAba(String aba) {
		String xpath = "//android.widget.TextView[@text='" + aba + "']";
		esperarElement(By.xpath(xpath), 3);
		clicar(By.xpath(xpath));
	}

	public void setLogin(String login) {
		escrever(By.xpath("//android.widget.EditText[@text='Nome']"), login);
	}

	public void setSenha(String senha) {
		escrever(By.xpath("//android.widget.EditText[@text='Senha']"), senha);
	}

	public void selecionarConta(String conta) {
		cliqueLongo("//android.widget.TextView[@text='" + conta + "']");
	}

	public void setDescricao(String descricao) {
		escrever(By.xpath("//android.widget.EditText[@text='Descrição']"), descricao);
	}

	public void setInteressado(String interessado) {
		escrever(By.xpath("//android.widget.EditText[@text='Interessado']"), interessado);
	}

	public void setValor(String valor) {
		escrever(By.xpath("//android.widget.EditText[@text='Valor']"), valor);
	}

	public void digitarDescricaoNovaConta(String conta) {
		escrever(By.xpath("//android.widget.EditText[@text='Conta']"), conta);
	}

	public void selecionaConta(String conta) {
		selecionarCombo(By.xpath("//android.widget.TextView[@text='Selecione uma conta...']"), conta);
	}

	public String getMensagemContaIncluida() {
		return validarMensagemExibida("Conta adicionada com sucesso");
	}

	public String getMensagemContaExcluida() {
		return validarMensagemExibida("Conta excluída com sucesso");
	}

	public String getCriticaCampoObrigatorioInteressado() {
		return validarMensagemExibida("Interessado é um campo obrigatório");
	}

	public String getCriticaCampoObrigatorioValor() {
		return validarMensagemExibida("Valor é um campo obrigatório");
	}

	public String getCriticaCampoObrigatorioConta() {
		return validarMensagemExibida("Conta é um campo obrigatório");
	}

	public String getMensagemSucesso() {
		return validarMensagemExibida("Movimentação cadastrada com sucesso");
	}

	public String getMensagemMovimentacaoExcluida() {
		return validarMensagemExibida("Movimentação removida com sucesso!");
	}

	public void excluirMovimentacaoConta() {
		page.swipeElementRight("Movimentacao de conta");
		clicar("Del");
	}

}
