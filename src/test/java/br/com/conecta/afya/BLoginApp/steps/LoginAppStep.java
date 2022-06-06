package br.com.conecta.afya.BLoginApp.steps;

import java.io.IOException;

import org.junit.Assert;

import br.com.conecta.afya.core.BaseTest;
import br.com.conecta.afya.core.DriverFactory;
import br.com.conecta.afya.page.HomePage;
import br.com.conecta.afya.page.LoginPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class LoginAppStep extends BaseTest {

	private AndroidDriver<MobileElement> driver;

	HomePage home = new HomePage();
	LoginPage login = new LoginPage();

	private String feature = "Login APP";
	private String cenario = "";

	@Before
	public void setCenario(Scenario cen) {
		//feature = cen.getId().split(";")[0];
		cenario = cen.getName();
		

	}
	
	
	@AfterStep
	public void as(Scenario scenario) throws IOException {

		scenario.attach(BaseTest.teste(), "image/png", "Login");

	}

	@After
	public static void finalizaCenario() {

		DriverFactory.KillDriver();

	}

	@Dado("que eu esteja na tela de Home")
	public void que_eu_esteja_na_tela_de_home() {

		Assert.assertEquals("Já tenho uma conta", home.verificarHomeJaTenhoConta());

		gerarScreenShot(feature, cenario);

	}

	@Quando("quando clico na opção {string}")
	public void quando_clico_na_opção(String JatenhoConta) {

		home.clicarJaTenhoUmaConta();

	}

	@Quando("preeencho o campo com um CPF valido {string}")
	public void preeencho_o_campo_com_um_cpf_valido(String CPF) throws InterruptedException {
		login.preencherCpf(CPF);
	}

	@Quando("aciono comando para avancar cpf")
	public void aciono_comando_para_avancar_cpf() throws InterruptedException {

		login.botaoAvancar();

	}

	@Então("o APP irá direcionar para tela de senha")
	public void o_app_irá_direcionar_para_tela_de_senha() {

		Assert.assertEquals("Agora, digite a senha de acesso", login.verificarTelaSenha());

	}

	@Quando("preencho o campo senha com o valor {string}")
	public void preencho_o_campo_senha_com_o_valor(String Senha) throws InterruptedException {
		login.preencherSenha(Senha);
	}

	@Quando("aciono o comando avancar senha")
	public void aciono_o_comando_avancar_senha() throws InterruptedException {

		login.botaoAvancarSenha();
	}

	@Então("o APP irá direcionar para a tela logada")
	public void o_app_irá_direcionar_para_a_tela_logada() {
		Assert.assertEquals("Seu processo de admissão", login.verificarTelaLogada());
	}

	@Quando("preeencho o campo com um CPF inválido {string}")
	public void preeencho_o_campo_com_um_cpf_inválido(String CPF) throws InterruptedException {
		login.preencherCpf(CPF);
	}

	@Quando("aciono comando para avancar")
	public void aciono_comando_para_avancar() throws InterruptedException {

		login.botaoAvancar();

	}

	@Então("o APP apresenta mensagem {string}")
	public void o_app_apresenta_mensagem(String mensagem) {

		Assert.assertEquals(mensagem, login.verificarMensagemCPF(mensagem));
		gerarScreenShot(feature, cenario);

	}

	@Quando("preeencho o campo com um CPF válido {string}")
	public void preeencho_o_campo_com_um_cpf_válido(String CPF) throws InterruptedException {
		login.preencherCpf(CPF);
	}

	@Quando("preeencho o campo senha com o valor inválido {string}")
	public void preeencho_o_campo_senha_com_o_valor_inválido(String Senha) throws InterruptedException {

		login.preencherSenha(Senha);

	}

}
