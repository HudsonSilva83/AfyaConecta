package br.com.conecta.afya.ECadastrarBeneficios.Test;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features/CadastrarBeneficios.feature", glue = {
				"br.com.conecta.afya.ECadastrarBeneficios.steps" }, tags = "@Beneficios", monochrome = true, dryRun = false, plugin = {
						"json:target/CadastrarBeneficios.json", "html:target/CadastrarBeneficios.html"})


public class ECadastrarBeneficiosTest {

}
