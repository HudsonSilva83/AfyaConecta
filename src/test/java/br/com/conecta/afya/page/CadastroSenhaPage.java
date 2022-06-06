package br.com.conecta.afya.page;

import org.openqa.selenium.By;

import br.com.conecta.afya.core.BasePage;
import io.appium.java_client.MobileBy;

public class CadastroSenhaPage extends BasePage {

	public void preencherCampoSenha(String senha) {

		escrever(By.xpath("//*[@text='Digite uma senha']"), senha);

	}

	public void botaoAvancarSenha() {

		clicar(By.xpath("(//android.widget.Button)[2]"));

	}
	
	public void botaoContinuar() {

		clicar(MobileBy.AccessibilityId("CONTINUAR"));

	}

}
