package br.com.conecta.afya.DAdicionarDadosBancarios.Test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features/AdicionarDadosBancarios.feature", glue = {
				"br.com.conecta.afya.DAdicionarDadosBancarios.steps" }, tags = "@ContaBancaria", monochrome = true, dryRun = false, plugin = {
						"json:target/AdicionarDadosBancarios.json", "html:target/AdicionarDadosBancarios.html"})

public class DAdicionarDadosBancariosTest {

}
