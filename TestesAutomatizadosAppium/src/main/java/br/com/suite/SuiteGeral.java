package br.com.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.test.AbasTest;
import br.com.test.AlertTest;
import br.com.test.CalculadoraTest;
import br.com.test.CliquesTest;
import br.com.test.FormularioTest;
import br.com.test.ScrollTest;
import br.com.test.SwipeElementTest;
import br.com.test.SwipeTest;

@RunWith(Suite.class)
@SuiteClasses({
	AbasTest.class,
	AlertTest.class,
	CalculadoraTest.class,
	CliquesTest.class,
	FormularioTest.class,
	ScrollTest.class,
	SwipeTest.class,
	SwipeElementTest.class
})

public class SuiteGeral {

}
