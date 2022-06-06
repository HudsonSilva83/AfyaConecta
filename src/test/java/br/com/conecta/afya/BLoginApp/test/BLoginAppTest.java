package br.com.conecta.afya.BLoginApp.test;

import org.junit.runner.RunWith;

import br.com.conecta.afya.core.BaseTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features/LoginApp.feature", glue = "br.com.conecta.afya.BLoginApp.steps", monochrome = true, dryRun = false,
				 //tags = "~@ignore",
		tags ="@Logar",
		plugin = {"pretty","json:target/LoginApp.json","html:target/LoginApp.html"})

public class BLoginAppTest extends BaseTest{

}
