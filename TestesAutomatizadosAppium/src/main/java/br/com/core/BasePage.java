package br.com.core;

import static br.com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);

	}

	public String obterTexto(By by) {
		String text = getDriver().findElement(by).getText();
		return text;
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicar(String xpath) {
		clicar(By.xpath(xpath));
	}
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//android.widget.CheckedTextView[@text='" + texto + "']"));
	}

	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
	}
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("false");
	}
	
	public void esperarClique(By by, Integer tempo) {
		WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	

	public void esperarElement(By by, Integer tempo) {
		WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	

	public Boolean esperarValor(By by, Integer tempo, String texto) {
		WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
		return wait.until(ExpectedConditions.attributeContains(by, "value", texto));
	}
	

	public Boolean esperarAtributo(By by, Integer tempo) {
		WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
		return wait.until(ExpectedConditions.attributeToBeNotEmpty(getDriver().findElement(by), "value"));
	}
	

	public void delaySegundos(int segundos) throws InterruptedException {
		Thread.sleep(segundos*1000);
	}
	
	public void tab(By by) {
		getDriver().findElement(by).sendKeys(Keys.TAB);
	}

}
