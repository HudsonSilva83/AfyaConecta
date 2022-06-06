package br.com.conecta.afya.LCadastrar.EnviarDocumentos.LIXO;

import org.junit.Assert;

import br.com.conecta.afya.core.BaseTest;
import br.com.conecta.afya.page.CadastroPage;
import br.com.conecta.afya.page.CadastroSenhaPage;
import br.com.conecta.afya.page.EnviarDocumentacaoPage;
import br.com.conecta.afya.page.HomePage;
import br.com.conecta.afya.page.InformacoesPessoaisPage;
import br.com.conecta.afya.page.LoginPage;
import br.com.conecta.afya.services.ExcluirUsuario;
import br.com.conecta.afya.services.GerarCodigoAcesso;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CadastrarEnviarDocumentosStepLixo extends BaseTest {

	private String feature = "CadastrarEnviarDoc";
	private String cenario = "EnviaDocumentosSucesso";

	@Before
	public void setCenario(Scenario cen) {
//		cenario = cen.getName();
//		feature = cen.getId().split(";")[0];

	}

	private AndroidDriver<MobileElement> driver;

	HomePage home = new HomePage();
	CadastroPage cadastro = new CadastroPage();
	CadastroSenhaPage cadastroSenha = new CadastroSenhaPage();
	InformacoesPessoaisPage informacoesPessoais = new InformacoesPessoaisPage();
	GerarCodigoAcesso codigoAcesso = new GerarCodigoAcesso();
	EnviarDocumentacaoPage enviarDocPage = new EnviarDocumentacaoPage();
	//LoginPage login = new LoginPage();

	@Dado("que fiz meu cadastro na plataforma do Conecta Afya")
	public void que_fiz_meu_cadastro_na_plataforma_do_conecta_afya() throws Exception {

		ExcluirUsuario exusu = new ExcluirUsuario();
		exusu.excluirUsuario();

		// servico aonde traz somente o codigo
		String codigo = GerarCodigoAcesso.gerarCodigoAcesso();

		System.out.println(codigo);

		// Credenciais credenciais = Obter@Senha.postCredenciais();
		//
		// String CPF = credenciais.getLogin();
		// String codigo = credenciais.getPassword();
		//


		home.preencherCodigoAcesso(codigo);
		home.avancarButton();
		Thread.sleep(2000);

		Assert.assertTrue(cadastro.verificarTextoPreCadastro("Bem vindo!"));
		Assert.assertTrue(cadastro
				.verificarTextoPreCadastro("Ficamos muito felizes por você ter escolhido fazer parte do nosso time!"));
		Assert.assertTrue(cadastro.verificarTextoPreCadastro(
				"Nesta primeira etapa é necessário que você siga os passos abaixo para completar seu cadastro."));

		cadastro.alterarNome("Automacao Conecta Afya");

		cadastro.alterarEmail("conecta.afya@gmail.com");

		cadastro.alterarTelefone("(99) 99999-9999");

//		Assert.assertTrue(cadastro.verificarCampoPreenchido("Automacao Conecta Afya"));
//		Assert.assertTrue(cadastro.verificarCampoPreenchido("conecta.afya@gmail.com"));
//		Assert.assertTrue(cadastro.verificarCampoPreenchido("(99) 99999-9999"));
//		Assert.assertTrue(cadastro.verificarCampoPreenchido("ANALISTA DE DADOS PL"));
//		Assert.assertTrue(cadastro.verificarCampoPreenchido("AFYA"));
		cadastro.aceitarTermosCondicoes();
		cadastro.botaoConfirmar();
		Thread.sleep(1000);
		cadastro.assinar();
		Thread.sleep(1000);

		cadastro.botaoAvancarAssinatura();
		cadastroSenha.preencherCampoSenha("@TesteAutomacaoAfya22");
		cadastroSenha.botaoAvancarSenha();

		Assert.assertTrue(
				cadastro.verificarTextoPreCadastro("A primeira etapa do seu cadastro foi concluída com sucesso"));
		Assert.assertTrue(cadastro.verificarTextoPreCadastro(
				"Agora, precisaremos de informações pessoais suas para completar seu cadastro"));

		cadastroSenha.botaoContinuar();

		Assert.assertTrue(informacoesPessoais.verificarTextoTelaInformacoesPessoais("Informações pessoais"));

		informacoesPessoais.preencherCampoNomeSocial("Automacao Social Afya");
		informacoesPessoais.preencherCampoApelido("Automacao Apelido Afya");
		informacoesPessoais.possueCertificadoReservista("Sim");
		informacoesPessoais.selecionarIdentidadeGenero("Não-binário");
		informacoesPessoais.selecionarRaca("Outra opção");
		informacoesPessoais.selecionarDeficiencia("Prefiro não informar");
		informacoesPessoais.botaoAvancarTela();
		informacoesPessoais.telaCadastroComSucesso();
		Assert.assertEquals("true", informacoesPessoais.telaCadastradoSucesso());

	}

	@Quando("iniciar o envio dos documentos")
	public void iniciar_o_envio_dos_documentos() throws InterruptedException {

		informacoesPessoais.botaoPularApresentacao();
		Assert.assertTrue(enviarDocPage.validarTela("Seu processo de admissão"));
		enviarDocPage.botaoEnviarDocumentos();
		Assert.assertEquals(
				"Você só pode concluir o processo se estiver com os documentos abaixo, com exceção do que não se aplica",
				enviarDocPage.validarTelaDocumentosNecessarios());
		enviarDocPage.botaoContinuar();

	}

	@Quando("preencher os dados do documento eSocial")
	public void preencher_os_dados_do_documento_e_social() throws InterruptedException {

		enviarDocPage.botaoEnviar();
		enviarDocPage.botaoAnexarArquivo();
		enviarDocPage.selecionarArquivoeSocial();
		enviarDocPage.botaoEnviarArquivo();
		Thread.sleep(6000);
		enviarDocPage.botaoEnviar();

	}

	@Quando("preencher os dados do documento de Identidade")
	public void preencher_os_dados_do_documento_de_identidade() throws InterruptedException {

		enviarDocPage.preencherRG("11395038");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherOrgaoEmissor("SSP");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherDataEmissaoRG("25/12/2000");

		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidadeUF("MG");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidadeNacionalidade("Brasileira");
		enviarDocPage.botaoSetaBaixo();

		enviarDocPage.preencherIdentidadeEstadoNatal("Minas Gerais");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidadeCidadeNatal("Belo Horizonte");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidaDataNascimento("09/03/1983");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidaNomeMae("Nome Mae");
		enviarDocPage.botaoCheckFinalizar();

		enviarDocPage.botaoAnexarArquivo();
		enviarDocPage.pegarArquivoIdentidadeFrente();
		enviarDocPage.botaoAnexarArquivo();
		enviarDocPage.pegarArquivoIdentidadeVerso();
		enviarDocPage.descerTela();
		enviarDocPage.botaoEnviarArquivo();

	}

	@Quando("preencher os dados do documento de Carteira de Trabalho")
	public void preencher_os_dados_do_documento_de_carteira_de_trabalho() throws InterruptedException {

		Thread.sleep(6000);
		enviarDocPage.descerTela();
		enviarDocPage.botaoEnviar();
		enviarDocPage.preencherNumeroCarteiraTrabalho("7777777");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherNumeroSerieCarteiraTrabalho("01");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherUFCarteiraTrabalho("MG");
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherDataEmissaoCTPS("25/12/2000");
		enviarDocPage.botaoCheckFinalizar();
		Thread.sleep(3000);
		enviarDocPage.descerTela();
		enviarDocPage.botaoAnexarArquivo();
		enviarDocPage.pegarArquivoCTPSFrente();
		enviarDocPage.botaoAnexarArquivo();
		enviarDocPage.pegarArquivoCTPSDados();
		enviarDocPage.descerTela();
		enviarDocPage.botaoEnviarArquivo();
		Thread.sleep(5000);
		enviarDocPage.botaoEnviar();

	}

	@Quando("preencher os dados de Endereco")
	public void preencher_os_dados_de_endereco() throws InterruptedException {

		enviarDocPage.preencherCep("31680320");
		enviarDocPage.enderecoVisivel();
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherNumeroEndereco("400");
		enviarDocPage.preencherComplemento("Ap 101 Bloco F");
		enviarDocPage.botaoCheckFinalizar();
		enviarDocPage.anexarComprovanteResidencia();
		enviarDocPage.anexarArquivoPDF();

	}

	@Quando("preencher os dados do Estado Civil")
	public void preencher_os_dados_do_estado_civil() throws InterruptedException {

		enviarDocPage.selecionarEstadoCivil("Casado(a)");
		enviarDocPage.anexarCertidaoCasamento();

	}

	@Quando("preencher os dados do PIS")
	public void preencher_os_dados_do_pis() throws InterruptedException {

		//enviarDocPage.botaoPreencherPis("11111111111");

	}

	@Quando("preencher os dados do Titulo Eleitor")
	public void preencher_os_dados_do_titulo_eleitor() throws InterruptedException {

		enviarDocPage.preeencherTituloEleitor("111111111111");
		enviarDocPage.preeencherDataEmissaoTituloEleitor("12/03/1993");
		enviarDocPage.preeencherUFTituloEleitor("MG");
		enviarDocPage.preeencherZonaVotacao("01");
		enviarDocPage.preeencherSecaoVotacao("02");
		enviarDocPage.enviarTitulo();
		enviarDocPage.comprovanteVotacao();

	}

	@Quando("preencher os dados do CertifiCado de Reservista")
	public void preencher_os_dados_do_certifi_cado_de_reservista() throws InterruptedException {

		enviarDocPage.anexarCertificadoReservista();
		Thread.sleep(3000);

	}

	@Quando("preencher os dados do Diploma Escolaridade")
	public void preencher_os_dados_do_diploma_escolaridade() throws InterruptedException {

		enviarDocPage.informarDiplomaEscolaridade();
		enviarDocPage.selecionarGrauInstrucao("Ensino fundamental incompleto");
		enviarDocPage.anexarDiplomaEscolaridade();

	}

	@Quando("preencher os dados de Dependentes")
	public void preencher_os_dados_de_dependentes() throws InterruptedException {

		enviarDocPage.informarDependentes("NÃO TENHO DEPENDENTES");

	}

	@Quando("acionar para finalizar o envio dos Documentos")
	public void acionar_para_finalizar_o_envio_dos_documentos() throws InterruptedException {

		enviarDocPage.verificarEtapa();
		enviarDocPage.concluirEnvio();
		Thread.sleep(1000);

	}

	@Quando("aceitar o termo e finalizar")
	public void aceitar_o_termo_e_finalizar() {

		enviarDocPage.aceitarTermo();
		enviarDocPage.concluirEnvio();

	}

	@Entao("os documentos sao enviados com sucesso.")
	public void os_documentos_sao_enviados_com_sucesso() {

		Assert.assertEquals("Documentos enviados", enviarDocPage.verificaMensagemDocumentosEnviados());
		gerarScreenShot(feature, cenario);
		enviarDocPage.botaoIrHomePage();
			tearDown();
	}
     
}
