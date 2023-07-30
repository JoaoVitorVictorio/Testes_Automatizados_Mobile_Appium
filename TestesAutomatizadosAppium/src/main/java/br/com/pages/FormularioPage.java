package br.com.pages;

import org.openqa.selenium.By;

import br.com.core.BasePage;
import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage {

	public void escreveNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);
	}

	public String getValidaNomeEscrito() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}

	public void selecionaOpcaoCombo(String console) {
		selecionarCombo(MobileBy.AccessibilityId("console"), console);
	}

	public String getOpcaoComboSelecionada() {
		return obterTexto(By.xpath("//android.widget.Spinner[@content-desc='console']/android.widget.TextView"));
	}

	public boolean getIsMarcado(String elemento) {
		return isCheckMarcado(MobileBy.AccessibilityId(elemento));
	}

	public void clicarElemento(String elemento) {
		clicar(MobileBy.AccessibilityId(elemento));
	}

	public void clicarSalvar() {
		clicar(By.xpath("//android.widget.TextView[@text='SALVAR']"));
	}

	public String getNomeRelatorio(String campo) {
		return obterTexto(By.xpath("//android.widget.TextView[@text='" + campo + "']"));
	}

	public String getConsoleRelatorio(String campo) {
		return obterTexto(By.xpath("//android.widget.TextView[@text='" + campo + "']"));
	}

	public String getStatusElementoRelatorio(String campo) {
		return obterTexto(By.xpath("//android.widget.TextView[@text='" + campo + "']"));
	}

}
