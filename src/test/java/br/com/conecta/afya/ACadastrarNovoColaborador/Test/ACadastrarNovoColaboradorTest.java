package br.com.conecta.afya.ACadastrarNovoColaborador.Test;



import org.junit.runner.RunWith;

import br.com.conecta.afya.core.BaseTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features/CadastrarNovoColaborador.feature", 
		glue = {"br.com.conecta.afya.ACadastrarNovoColaborador.steps"}, 
		tags = "@criacao",
		monochrome = true, dryRun = false, 
		plugin = {"json:target/CadastrarNovoColaborador.json","html:target/CadastrarNovoColaborador.html"})


public class ACadastrarNovoColaboradorTest extends BaseTest{

}
