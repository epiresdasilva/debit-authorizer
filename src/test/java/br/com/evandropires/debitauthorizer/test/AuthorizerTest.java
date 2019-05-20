package br.com.evandropires.debitauthorizer.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:caracteristicas", tags = "@Sucesso",
        glue = "cucumber.teste.passos", monochrome = true, dryRun = false)
public class AuthorizerTest {
}
