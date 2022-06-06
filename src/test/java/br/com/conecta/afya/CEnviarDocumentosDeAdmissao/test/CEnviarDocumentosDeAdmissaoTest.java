package br.com.conecta.afya.CEnviarDocumentosDeAdmissao.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	features = "src/test/resources/features/EnviarDocumentosDeAdmissao.feature", 
	glue = "br.com.conecta.afya.CEnviarDocumentosDeAdmissao.steps", 
	monochrome = true, 
	dryRun = false,
    //tags = "~@ignore",
	plugin = {"json:target/EnviarDocumentosDeAdmissao.json"})





public class CEnviarDocumentosDeAdmissaoTest {

}
