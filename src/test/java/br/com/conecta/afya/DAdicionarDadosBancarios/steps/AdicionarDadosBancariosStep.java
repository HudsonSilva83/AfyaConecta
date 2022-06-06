package br.com.conecta.afya.DAdicionarDadosBancarios.steps;

import java.io.IOException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;

import br.com.conecta.afya.ACadastrarNovoColaborador.Test.ACadastrarNovoColaboradorTest;
import br.com.conecta.afya.core.BaseTest;
import br.com.conecta.afya.core.DriverFactory;
import br.com.conecta.afya.page.DadosBancariosPage;
import br.com.conecta.afya.page.HomePage;
import br.com.conecta.afya.page.LoginPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class AdicionarDadosBancariosStep extends BaseTest {

	
	
	private AndroidDriver<MobileElement> driver;

	HomePage home = new HomePage();
	LoginPage login = new LoginPage();
	DadosBancariosPage dadosBancarios = new DadosBancariosPage();

	@AfterStep
	public void as(Scenario scenario) throws IOException {

		scenario.attach(BaseTest.teste(), "image/png", "AdicionarDadosBancarios");

	}

	@After
	public static void finalizaCenario() {

		DriverFactory.KillDriver();

	}

	@Dado("que eu esteja logado e que ja tenha enviado os documentos para admissao")
	public void que_eu_esteja_logado_e_que_ja_tenha_enviado_os_documentos_para_admissao(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);
		String CPF = map.get("CPF");
		String Senha = map.get("Senha");

		home.clicarJaTenhoUmaConta();
		Thread.sleep(1000);
		login.preencherCpf(CPF);
		login.botaoAvancar();
		Thread.sleep(1000);
		login.preencherSenha(Senha);
		login.botaoAvancarSenha();

	}

	@Entao("o app apresenta a tela para iniciar as informacoes dos dados Bancarios")
	public void o_app_apresenta_a_tela_para_iniciar_as_informacoes_dos_dados_bancarios() throws InterruptedException {

		Thread.sleep(8000);

		dadosBancarios.scrollar(0.8, 0.1);
		// a forma como está implementado o front, dificulta a captura do texto.

	}

	@Quando("aciono o comando Enviar Depois")
	public void aciono_o_comando_enviar_depois() {

		dadosBancarios.clicarBotaoEnviarDepois();

	}

	@Entao("o app apresenta a tela home com status como {string} e a opcao de enviar os dados bancarios")
	public void o_app_apresenta_a_tela_home_com_status_como_e_a_opcao_de_enviar_os_dados_bancarios(String status)
			throws InterruptedException {

		// Da foma como está implementada dificulta a captura do texto na tela
		// para validação.

		Thread.sleep(5000);
		dadosBancarios.scrollar(0.5, 0.1);
		Assert.assertEquals("ENVIAR DADOS BANCÁRIOS", dadosBancarios.verificarBotaoTela());

	}

	@Entao("aciono o comando para comecar")
	public void aciono_o_comando_para_comecar() {

		dadosBancarios.clicarBotaoComecar();

	}

	@Quando("aciono o comando Adicionar uma conta Depois")
	public void aciono_o_comando_adicionar_uma_conta_depois() {

		dadosBancarios.scrollar(0.8, 0.1);
		dadosBancarios.clicarLinkAdicionarContaumaDepois();

	}

	@Entao("o app retorna para a tela home com status como {string} e a opcao de enviar os dados bancarios")
	public void o_app_retorna_para_a_tela_home_com_status_como_e_a_opcao_de_enviar_os_dados_bancarios(String string)
			throws InterruptedException {

		Thread.sleep(3000);
		dadosBancarios.scrollar(0.4, 0.1);
		Assert.assertEquals("ENVIAR DADOS BANCÁRIOS", dadosBancarios.verificarBotaoTela());

	}

	@Entao("o app apresenta a tela para colocar uma conta bancaria")
	public void o_app_apresenta_a_tela_para_colocar_uma_conta_bancaria() throws InterruptedException {

		Assert.assertEquals("Coloque uma conta bancária de sua escolha", dadosBancarios.verificarContaDeBancoTela());

	}

	@Entao("aciono o comando Adicionar Conta")
	public void aciono_o_comando_adicionar_conta() {

		
		dadosBancarios.clicarAdicionarConta();

	}

	@Entao("o app apresenta a tela para informar o banco")
	public void o_app_apresenta_a_tela_para_informar_o_banco() {

		
		Assert.assertEquals("Qual o seu banco?",dadosBancarios.verificarTelaInformarBanco());

	}

	@Entao("preencho o nome do banco {string} e aciono avancar")
	public void preencho_o_nome_do_banco_e_aciono_avancar(String nomeBanco) {

		
		dadosBancarios.preeencherCampoBanco(nomeBanco);
		dadosBancarios.botaoAvancar();

	}

	@Entao("o app apresenta a tela para informar a agencia")
	public void o_app_apresenta_a_tela_para_informar_a_agencia() {
		
		Assert.assertEquals("Qual é a sua agência?",dadosBancarios.verificarTelaInformarAgencia());

	}

	@Entao("preencho o nome da agencia {string} e aciono avancar")
	public void preencho_o_nome_da_agencia_e_aciono_avancar(String nomeAgencia) {

		
		dadosBancarios.preeencherCampoAgencia(nomeAgencia);
		dadosBancarios.botaoAvancar();

	}

	@Entao("o app apresenta a tela para informar a Conta")
	public void o_app_apresenta_a_tela_para_informar_a_conta() {

		
		Assert.assertEquals("Qual é a sua conta?",dadosBancarios.verificarTelaInformarConta());
		

	}

	@Entao("preencho a Conta {string} e aciono finalizar")
	public void preencho_a_conta_e_aciono_finalizar(String nomeConta) {

		
		dadosBancarios.preeencherCampoConta(nomeConta);
		dadosBancarios.botaoCheckFinalizar();

	}

	@Entao("o app apresenta a tela para anexar o comprovante de conta")
	public void o_app_apresenta_a_tela_para_anexar_o_comprovante_de_conta() {

		Assert.assertEquals("Comprovante de conta", dadosBancarios.verificarTelaComprovanteConta());

	}

	@Entao("aciono o comando para anexar o comprovante de conta")
	public void aciono_o_comando_para_anexar_o_comprovante_de_conta() {

		dadosBancarios.botaoAnexarArquivo();

	}

	@Entao("seleciono o arquivo e aciono o comando enviar o arquivo")
	public void seleciono_o_arquivo_e_aciono_o_comando_enviar_o_arquivo() throws InterruptedException {

		dadosBancarios.selecionarArquivo();
		dadosBancarios.scrollar(0.5, 0.1);
		dadosBancarios.enviarArquivo();
		

	}

	@Entao("o app apresenta a tela de sucesso com os dados bancarios cadastrados")
	public void o_app_apresenta_a_tela_de_sucesso_com_os_dados_bancarios_cadastrados() throws InterruptedException {

		Thread.sleep(2000);
		Assert.assertEquals("Dados bancários cadastrados",dadosBancarios.verificarTelaDadosBancariosCadastrados());

	}

}
