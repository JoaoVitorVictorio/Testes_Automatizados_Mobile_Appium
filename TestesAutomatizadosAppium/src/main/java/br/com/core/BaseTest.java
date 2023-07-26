package br.com.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	@Rule
	public TestName testName = new TestName();

	@After
	public void tearDown() {
		gerarScreenshot();
		DriverFactory.killDriver();
//		DriverFactory.getDriver().resetApp();
	}

	public void gerarScreenshot() {
		File imagens = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagens, new File("target/screenshots/" + testName.getMethodName() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
