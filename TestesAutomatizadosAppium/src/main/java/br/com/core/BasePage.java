package br.com.core;

import static br.com.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	public void escrever(By by, String texto, boolean apagar) {
		if (apagar) {
			int tamanho = getDriver().findElement(by).getAttribute("value").length();

			for (int i = 0; i < tamanho; i++) {
				getDriver().findElement(by).sendKeys(Keys.BACK_SPACE);
			}
			getDriver().findElement(by).sendKeys(Keys.BACK_SPACE);
			getDriver().findElement(by).sendKeys(Keys.HOME);
		}
		getDriver().findElement(by).sendKeys(texto);
	}

	public void escrever(By by, String texto) {
		escrever(by, texto, false);
	}

	public void escrever(String id_campo, String texto, boolean apagar) {
		escrever(By.id(id_campo), texto, apagar);
	}

	public void escrever(String id_campo, String texto) {
		escrever(By.id(id_campo), texto);
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
		Thread.sleep(segundos * 1000);
	}

	public void tab(By by) {
		getDriver().findElement(by).sendKeys(Keys.TAB);
	}

	public boolean existeElementoPresente(String xpath) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath(xpath));
		return elementos.size() > 0;
	}

	public void tap(int x, int y) {
		new TouchAction<>(getDriver()).press(PointOption.point(x, y)).release().perform();
	}

	public void cliqueLongo(String xpath) {
		WebElement element = getDriver().findElement(By.xpath(xpath));
		new TouchAction<>(getDriver())
				.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element))).release()
				.perform();
	}

	public void cliqueDuplo(String texto) {
		String xpath = "//android.widget.TextView[@text='" + texto + "']";
		esperarElement(By.xpath(xpath), 3);
		clicar(xpath);
		clicar(xpath);
	}

	public WebElement scrollParaTexto(String text) {
		return getDriver().findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector())" + ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
	}

	public void scroll(double inicio, double fim) throws InterruptedException {
		org.openqa.selenium.Dimension screenSize = getDriver().manage().window().getSize();
		delaySegundos(3);
		int x = screenSize.width / 2;
		int startY = (int) (screenSize.height * inicio);
		int endY = (int) (screenSize.height * fim);

		new TouchAction<>(getDriver()).press(PointOption.point(x, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(x, endY))
				.release().perform();
	}

	public void swipeParaOTexto(String text) {
		new TouchAction<>(getDriver())
				.press(PointOption.point(getDriver().manage().window().getSize().width / 2,
						getDriver().manage().window().getSize().height / 2))
				.moveTo(PointOption.point(0, getDriver().manage().window().getSize().height / 2)).release().perform();
	}

	public void swipeLeft(double inicio, double fim) {
		org.openqa.selenium.Dimension screenSize = getDriver().manage().window().getSize();
		int startY = screenSize.height / 2;
		int endX = (int) (screenSize.width * inicio);
		int startX = (int) (screenSize.width * fim);

		new TouchAction<>(getDriver()).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(endX, startY))
				.release().perform();
	}

	public void swipeRight(double inicio, double fim) {
		org.openqa.selenium.Dimension screenSize = getDriver().manage().window().getSize();
		int startY = screenSize.height / 2;
		int startX = (int) (screenSize.width * inicio);
		int endX = (int) (screenSize.width * fim);

		new TouchAction<>(getDriver()).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(endX, startY))
				.release().perform();
	}

	public void swipeElement(MobileElement element, double inicio, double fim) {
		int y = element.getLocation().y + (element.getSize().height / 2);
		int startX = (int) (element.getSize().width * inicio);
		int endX = (int) (element.getSize().width * fim);

		new TouchAction<>(getDriver()).press(PointOption.point(startX, y))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(endX, y))
				.release().perform();
	}

	public void DragNDrop(String origem, String destino) {
		MobileElement inicio = DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + origem + "']"));
		MobileElement fim = DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + destino + "']"));

		TouchAction<?> touchAction = new TouchAction<>(DriverFactory.getDriver());
		touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(inicio)))
				.moveTo(ElementOption.element(fim)).release().perform();
	}

}
