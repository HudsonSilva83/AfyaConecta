package br.com.conecta.afya.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.conecta.afya.core.BasePage;
import br.com.conecta.afya.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class LoginPage extends BasePage {

	public void preencherCpf(String cpf) throws InterruptedException {

		escrever(By.xpath("//*[@text='Entre com seu CPF']"), cpf);

		// WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),
		// 15);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[2]")));

		// System.out.println(obterAtributoHabilitado2(By.xpath("(//android.widget.Button)[2]")));

		// botaoAvancar();

	}

	public void botaoAvancar() throws InterruptedException {
		Thread.sleep(2000);
		clicar(By.xpath("(//android.widget.Button)[2]"));

	}

	public void preencherSenha(String senha) throws InterruptedException {

		escrever(By.xpath("//*[@text='Senha']"), senha);
		// botaoAvancarSenha();
		// Thread.sleep(2000);

	}

	public void botaoAvancarSenha() throws InterruptedException {

		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public String verificarTelaSenha() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Agora, digite a senha de acesso"));
	}

	public String verificarTelaLogada() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Seu processo de admissão"));
	}

	public String verificarMensagemCPF(String mensagem) {
		return obterTextoAtributo(MobileBy.AccessibilityId(mensagem));
	}

	public String verificarCampoCPF() {

		return obterTexto(By.xpath("//*[@text='Entre com seu CPF']"));

	}

	public String verificarCampoSenha() {
		return obterTexto(By.xpath("//*[@text='Senha']"));
	}

	public void botaoEnviarDocumentos() {

		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("ENVIAR DOCUMENTOS")));
		clicar(MobileBy.AccessibilityId("ENVIAR DOCUMENTOS"));

	}

	public String verificarMensagemESocial(String mensagem) {
	
		return obterTextoAtributo(MobileBy.AccessibilityId(mensagem));
	}
	
	public String verificarEtapasConcluidas() {
		String etapasConcluidas =  obterTextoAtributo(By.xpath("(//android.view.View/android.widget.ImageView)[2]"));
		return etapasConcluidas.replaceAll("\\n", " ");
		
	}
	
	
	

}
