package br.com.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.test.AbasTest;
import br.com.test.AlertTest;
import br.com.test.CalculadoraTest;
import br.com.test.CliquesTest;
import br.com.test.FormularioTest;

@RunWith(Suite.class)
@SuiteClasses({
	AbasTest.class,
	AlertTest.class,
	CalculadoraTest.class,
	CliquesTest.class,
	FormularioTest.class
})

public class SuiteGeral {

}
