package br.com.pages;

import br.com.core.BasePage;

public class SwipePage extends BasePage {

	public boolean existeElementoPorTexto(String texto) {
		return existeElementoPresente("//android.widget.TextView[@text='" + texto + "']");
	}

}
