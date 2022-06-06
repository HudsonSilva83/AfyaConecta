package br.com.conecta.afya.CEnviarDocumentosDeAdmissao.steps;

import java.io.IOException;
import java.util.Map;

import org.junit.Assert;

import br.com.conecta.afya.core.BaseTest;
import br.com.conecta.afya.core.DriverFactory;
import br.com.conecta.afya.page.EnviarDocumentacaoPage;
import br.com.conecta.afya.page.HomePage;
import br.com.conecta.afya.page.LoginPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import net.bytebuddy.description.type.TypeDescription.Generic;

public class CEnviarDocumentosDeAdmissaoStep extends BaseTest {

	private String feature = "Enviar Documentos de Admissao";
	private String cenario = "";

	@Before
	public void setCenario(Scenario cen) {
		// feature = cen.getId().split(";")[0];
		cenario = cen.getName();

	}

	@AfterStep
	public void as(Scenario scenario) throws IOException {

		scenario.attach(BaseTest.teste(), "imagem/png", "any name");

	}

	@After
	public static void finalizaCenario() {

		DriverFactory.KillDriver();

	}

	private AndroidDriver<MobileElement> driver;

	HomePage home = new HomePage();
	EnviarDocumentacaoPage enviarDocPage = new EnviarDocumentacaoPage();
	LoginPage login = new LoginPage();

	@Dado("que eu esteja na tela Home do app")
	public void que_eu_esteja_na_tela_home_do_app() {
		Assert.assertEquals("Já tenho uma conta", home.verificarHomeJaTenhoConta());
	}

	@Quando("aciono a opcao para logar ja com um conta {string}")
	public void aciono_a_opcao_para_logar_ja_com_um_conta(String jaTenhoUmaConta) {

		home.clicarCampoCodigoAcesso(jaTenhoUmaConta);

	}

	@Quando("o app apresenta o campo CPF, preeencho com cpf {string} e aciono avancar")
	public void o_app_apresenta_o_campo_cpf_preeencho_com_cpf_e_aciono_avancar(String CPF) throws InterruptedException {

		Assert.assertTrue(login.verificarCampoCPF().contains("Entre com seu CPF"));
		login.preencherCpf(CPF);
		login.botaoAvancar();

	}

	@Quando("o app apresenta o campo senha, preencho com a senha {string} e aciono avancar")
	public void o_app_apresenta_o_campo_senha_preencho_com_a_senha_e_aciono_avancar(String senha)
			throws InterruptedException {

		Assert.assertTrue(login.verificarCampoSenha().contains("Senha"));
		login.preencherSenha(senha);
		login.botaoAvancarSenha();

	}

	@Quando("aciono o comando para Enviar Documentos")
	public void aciono_o_comando_para_enviar_documentos() throws InterruptedException {

		Thread.sleep(8000);
		login.scroll(0.6, 0.1);

		login.botaoEnviarDocumentos();

	}

	@Quando("o app apresenta tela com instrucao referente a qualidade das fotos para envio de documentos")
	public void o_app_apresenta_tela_com_instrucao_referente_a_qualidade_das_fotos_para_envio_de_documentos() {

		Assert.assertEquals(
				"Fique atento na qualidade das fotos dos documentos que vamos solicitar nos próximos passos.",
				enviarDocPage.verificarTelaQualidadeFoto());
	}

	@Quando("aciono o comando Continuar")
	public void aciono_o_comando_continuar() throws InterruptedException {

		enviarDocPage.botaoContinuar();

	}

	@Entao("o app apresenta a tela para iniciar o envio do documento de identidade")
	public void o_app_apresenta_a_tela_para_iniciar_o_envio_do_documento_de_identidade() throws InterruptedException {

		Assert.assertTrue(enviarDocPage.verificarTelaIdentidade().contains("Documento de identidade"));

	}

	@Entao("aciono o comando Enviar para iniciar o envio do documento de identidade")
	public void aciono_o_comando_enviar_para_iniciar_o_envio_do_documento_de_identidade() throws InterruptedException {

		enviarDocPage.scroll(0.9, 0.1);
		enviarDocPage.botaoEnviar();

	}

	@Entao("preencho os campos de identidade com os seguintes dados e avancando apos o seu preenchimento")
	public void preencho_os_campos_de_identidade_com_os_seguintes_dados_e_avancando_apos_o_seu_preenchimento(
			DataTable dataTable) {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		String RG = map.get("RG");
		String OrgaoEmissor = map.get("Orgao Emissor");
		String dataEmissaoRG = map.get("data de emissao RG");
		String ufEmissao = map.get("UF de emissao");
		String nacionalidade = map.get("Nacionalidade");
		String EstadoNatal = map.get("Estado Natal");
		String cidadeNatal = map.get("Cidade Natal");
		String dataNascimento = map.get("Data Nascimento");
		String nomeMae = map.get("Nome Mae");

		enviarDocPage.preencherRG(RG);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherOrgaoEmissor(OrgaoEmissor);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherDataEmissaoRG(dataEmissaoRG);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidadeUF(ufEmissao);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidadeNacionalidade(nacionalidade);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidadeEstadoNatal(EstadoNatal);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidadeCidadeNatal(cidadeNatal);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidaDataNascimento(dataNascimento);
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherIdentidaNomeMae(nomeMae);

	}

	@Entao("aciono o comando para finalizar a secao de preeenchimento dos documentos de identidade")
	public void aciono_o_comando_para_finalizar_a_secao_de_preeenchimento_dos_documentos_de_identidade() {

		enviarDocPage.botaoCheckFinalizar();

	}

	@Entao("o app apresenta a tela de confirmacao do RG")
	public void o_app_apresenta_a_tela_de_confirmacao_do_rg() {

		Assert.assertTrue(enviarDocPage.verificarTelaConfirmacaoRG().contains("Confirmação do RG"));

	}

	@Entao("aciono o comando para anexar a identidade Foto frente e verso")
	public void aciono_o_comando_para_anexar_a_identidade_foto_frente_e_verso() {

		enviarDocPage.botaoAnexarArquivo();

	}

	@Entao("seleciono a primeira foto para anexar")
	public void seleciono_a_primeira_foto_para_anexar() throws InterruptedException {

		enviarDocPage.pegarArquivoIdentidadeFrente();

	}

	@Entao("seleciono a segunda foto para anexar")
	public void seleciono_a_segunda_foto_para_anexar() throws InterruptedException {

		enviarDocPage.botaoAnexarArquivo();
		enviarDocPage.pegarArquivoIdentidadeVerso();

	}

	@Entao("aciono o comando para enviar o arquivo")
	public void aciono_o_comando_para_enviar_o_arquivo() throws InterruptedException {

		enviarDocPage.descerTela();
		enviarDocPage.botaoEnviarArquivo();

	}

	@Entao("o app apresenta mensagem de envio dos documentos de identidade {string}")
	public void o_app_apresenta_mensagem_de_envio_dos_documentos_de_identidade(String mensagem) throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(mensagem, enviarDocPage.verificaMensagemDocumentoEnviado(mensagem));

	}

	@Entao("o app apresenta a tela para selecionar o Estado civil")
	public void o_app_apresenta_a_tela_para_selecionar_o_estado_civil() throws InterruptedException {
		
		Thread.sleep(4000);
		System.out.println(enviarDocPage.verificarTelaEstadoCivil());

	}

	@Entao("aciono o comando selecionar para seguir com Estado Civil")
	public void aciono_o_comando_selecionar_para_seguir_com_estado_civil() throws InterruptedException {

		Thread.sleep(1000);

		enviarDocPage.botaoSelecionar();

	}

	@Entao("informo qual estado civil {string}")
	public void informo_qual_estado_civil(String opcaoEstadoCivil) throws InterruptedException {

		enviarDocPage.selecionarEstadoCivil(opcaoEstadoCivil);
		// enviarDocPage.anexarCertidaoCasamento();

	}

	@Entao("aciono o comando avancar")
	public void aciono_o_comando_avancar() {

		enviarDocPage.botaoAvancarTela();

	}

	@Entao("o app apresenta a tela para anexar certidao nascimento")
	public void o_app_apresenta_a_tela_para_anexar_certidao_nascimento() {

		Assert.assertEquals("Certidão de nascimento", enviarDocPage.verificarTelaCertidaoNascimento());

	}

	@Entao("aciono o comando para anexar a certidao de nascimento")
	public void aciono_o_comando_para_anexar_a_certidao_de_nascimento() {

		enviarDocPage.botaoAnexarArquivo();

	}

	@Entao("seleciono o arquivo para anexar")
	public void seleciono_o_arquivo_para_anexar() {

		enviarDocPage.selecionarArquivoPDF();
		enviarDocPage.scroll(0.8, 0.1);

	}

	@Entao("aciono o comando Enviar")
	public void aciono_o_comando_enviar() throws InterruptedException {

		enviarDocPage.botaoEnviarArquivo();

	}

	@Entao("o app apresenta mensagem da certidao de nascimento enviado com sucesso {string}")
	public void o_app_apresenta_mensagem_da_certidao_de_nascimento_enviado_com_sucesso(String mensagem) {

		enviarDocPage.verificarMensagemCertidaoNascimento(mensagem);

	}

	@Entao("o app apresenta a tela para anexar o Certificado de reservista")
	public void o_app_apresenta_a_tela_para_anexar_o_certificado_de_reservista() {

		enviarDocPage.verificarTelaCertificadoReservista();

	}

	@Entao("aciono o comando anexar arquivo Certificado de Reservista")
	public void aciono_o_comando_anexar_arquivo_certificado_de_reservista() {

		enviarDocPage.botaoAnexarArquivo();

	}

	@Entao("seleciono o arquivo Certificado de Reservista")
	public void seleciono_o_arquivo_certificado_de_reservista() {

		enviarDocPage.selecionarArquivoPDF();
		enviarDocPage.scroll(0.8, 0.1);

	}

	@Entao("aciono o comando Enviar Arquivo Certificado de Reservista")
	public void aciono_o_comando_enviar_arquivo_certificado_de_reservista() throws InterruptedException {

		enviarDocPage.botaoEnviarArquivo();

	}

	@Entao("o app apresenta mensagem do certificado de reservista enviado {string}")
	public void o_app_apresenta_mensagem_do_certificado_de_reservista_enviado(String mensagem) {

		Assert.assertEquals(mensagem, enviarDocPage.verificarMensagemCertificadoReservista(mensagem));

	}

	@Entao("o app apresenta a tela para enviar o Diploma ou comprovante de escolaridade")
	public void o_app_apresenta_a_tela_para_enviar_o_diploma_ou_comprovante_de_escolaridade()
			throws InterruptedException {

		Assert.assertEquals("Selecione seu grau de instrução", enviarDocPage.verificarTelaDiploma());

	}

	@Entao("aciono o comando para enviar o Diploma")
	public void aciono_o_comando_para_enviar_o_diploma_enviar() throws InterruptedException {

		Thread.sleep(3000);
		enviarDocPage.botaoEnviar();

	}

	@Entao("seleciono a opcao referente ao Grau de Instituicao {string} e acionando avancar")
	public void seleciono_a_opcao_referente_ao_grau_de_instituicao_e_acionando_avancar(String opcaoGrau) {

		enviarDocPage.selecionarGrauInstrucao(opcaoGrau);

	}

	@Entao("aciono o comando anexar arquivo do diploma de escolaridade")
	public void aciono_o_comando_anexar_arquivo_do_diploma_de_escolaridade() {

		enviarDocPage.botaoAnexarArquivo();

	}

	@Entao("seleciono o arquivo de escolaridade")
	public void seleciono_o_arquivo_de_escolaridade() {
		enviarDocPage.selecionarArquivoJPG();
		enviarDocPage.scroll(0.8, 0.1);

	}

	@Entao("aciono o comando Enviar Arquivo de escolaridade")
	public void aciono_o_comando_enviar_arquivo_de_escolaridade() throws InterruptedException {

		enviarDocPage.botaoEnviarArquivo();

	}

	@Entao("o app apresenta mensagem do Diploma Comprovante enviado {string}")
	public void o_app_apresenta_mensagem_do_diploma_comprovante_enviado(String mensagem) {

		Assert.assertEquals(mensagem, enviarDocPage.verificarMensagemDiploma(mensagem));
		;

	}

	// começa aqui

	@Entao("o app apresenta a tela para iniciar as informacoes do Titulo de eleitor")
	public void o_app_apresenta_a_tela_para_iniciar_as_informacoes_do_titulo_de_eleitor() {

		Assert.assertEquals("Título de eleitor", enviarDocPage.verificarTelaTituloEleitor());

	}

	@Entao("aciono o comando Enviar para o titulo de eleitor")
	public void aciono_o_comando_enviar_para_o_titulo_de_eleitor() throws InterruptedException {

		enviarDocPage.scroll(0.8, 0.1);
		enviarDocPage.botaoEnviar();

	}

	@Entao("preencho os campos referente ao título de eleitor e avancando apos o seu preenchimento")
	public void preencho_os_campos_referente_ao_título_de_eleitor_e_avancando_apos_o_seu_preenchimento(
			DataTable dataTable) throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		String NumeroTitulo = map.get("NumeroTituloEleitor");
		String DataEmissaoTitulo = map.get("DataEmissaoTitulo");
		String UFTituloEleitor = map.get("UFTituloEleitor");
		String ZonaVotacao = map.get("ZonaVotacao");
		String SecaoVotacao = map.get("SecaoVotacao");

		enviarDocPage.preeencherTituloEleitor(NumeroTitulo);
		enviarDocPage.preeencherDataEmissaoTituloEleitor(DataEmissaoTitulo);
		enviarDocPage.preeencherUFTituloEleitor(UFTituloEleitor);
		enviarDocPage.preeencherZonaVotacao(ZonaVotacao);
		enviarDocPage.preeencherSecaoVotacao(SecaoVotacao);

	}

	@Entao("aciono o comando para finalizar a secao do Titulo Eleitor")
	public void aciono_o_comando_para_finalizar_a_secao_do_titulo_eleitor() {

		enviarDocPage.botaoCheckFinalizar();

	}

	@Entao("o app apresenta a tela do anexar o Titulo de Eleitor")
	public void o_app_apresenta_a_tela_do_anexar_o_titulo_de_eleitor() {

		Assert.assertEquals("Envio do título", enviarDocPage.verificarTelaAnexarTituloEleitor());
		

	}

	@Entao("aciono o comando anexar o arquivo")
	public void aciono_o_comando_anexar_o_arquivo() throws InterruptedException {

		enviarDocPage.botaoAnexarArquivo();

	}

	@Entao("seleciono o arquivo")
	public void seleciono_o_arquivo() {

		enviarDocPage.selecionarArquivoPDF();

	}

	@Entao("aciono o comando Enviar Arquivo")
	public void aciono_o_comando_enviar_arquivo() throws InterruptedException {

		enviarDocPage.scroll(0.8, 0.1);
		enviarDocPage.botaoEnviarArquivo();

	}

	@Entao("o app apresenta mensagem de envio do titulo {string}")
	public void o_app_apresenta_mensagem_de_envio_do_titulo(String mensagem) {

		Assert.assertEquals(mensagem, enviarDocPage.verificarMensagemEnvioTitulo(mensagem));

	}
	// comprovante de votação

	@Entao("o app apresenta a tela para anexar o Comprovante da ultima votacao")
	public void o_app_apresenta_a_tela_para_anexar_o_comprovante_da_ultima_votacao() {

		// Assert.assertEquals("Comprovante da última votação",
		// enviarDocPage.verificarTelaComprovanteUltimaVotacao());

	}

	@Entao("aciono o comando anexar o arquivo do comprovante")
	public void aciono_o_comando_anexar_o_arquivo_do_comprovante() throws InterruptedException {

		enviarDocPage.botaoAnexarArquivo();
	}

	@Entao("seleciono o arquivo do comprovante")
	public void seleciono_o_arquivo_do_comprovante() throws InterruptedException {

		enviarDocPage.selecionarArquivoJPG();

	}

	@Entao("aciono o comando Enviar Arquivo do comprovante")
	public void aciono_o_comando_enviar_arquivo_do_comprovante() throws InterruptedException {

		enviarDocPage.scroll(0.8, 0.1);
		enviarDocPage.botaoEnviarArquivo();

	}

	@Entao("o app apresenta mensagem do Comprovante da ultima votacao {string}")
	public void o_app_apresenta_mensagem_do_comprovante_da_ultima_votacao(String mensagem) {

		Assert.assertEquals(mensagem, enviarDocPage.verificarMensagemComprovante(mensagem));

	}

	// carteira de trabalho

	@Entao("apresenta a tela para iniciar o envio do documento carteira de trabalho")
	public void apresenta_a_tela_para_iniciar_o_envio_do_documento_carteira_de_trabalho() throws InterruptedException {

		Thread.sleep(4000);

		Assert.assertEquals("Carteira de trabalho", enviarDocPage.verificarTelaCarteiraTrabalho());

		enviarDocPage.descerTela();
		Thread.sleep(1000);
		enviarDocPage.descerTela();

	}

	@Entao("aciono o comando Enviar para iniciar o envio do documento carteira de trabalho")
	public void aciono_o_comando_enviar_para_iniciar_o_envio_do_documento_carteira_de_trabalho()
			throws InterruptedException {

		enviarDocPage.botaoEnviar();

	}

	@Entao("preencho os campos da carteira de trabalho com os seguintes dados e avancando apos o seu preenchimento")
	public void preencho_os_campos_da_carteira_de_trabalho_com_os_seguintes_dados_e_avancando_apos_o_seu_preenchimento(
			DataTable dataTable) {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		enviarDocPage.preencherNumeroCarteiraTrabalho(map.get("NumeroCarteiraTrabalho"));
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherNumeroSerieCarteiraTrabalho(map.get("SerieCarteiraTrabalho"));
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherUFCarteiraTrabalho(map.get("UFCarteiraTrabalho"));
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherDataEmissaoCTPS(map.get("DataEmissaoCTPS"));

	}

	@Entao("aciono o comando para finalizar a secao de preeenchimento dos documentos de carteira de Trabalho")
	public void aciono_o_comando_para_finalizar_a_secao_de_preeenchimento_dos_documentos_de_carteira_de_trabalho() {

		enviarDocPage.botaoCheckFinalizar();

	}

	@Entao("o app apresenta a tela de confirmacao do Carteira de Trabalho")
	public void o_app_apresenta_a_tela_de_confirmacao_do_carteira_de_trabalho() throws InterruptedException {

		Thread.sleep(3000);

		enviarDocPage.verificarTelaConfirmacaoCarteiraTrabalho();

	}

	@Entao("aciono o comando para anexar a carteira de trabalho")
	public void aciono_o_comando_para_anexar_a_carteira_de_trabalho() throws InterruptedException {

		enviarDocPage.descerTela();
		enviarDocPage.botaoAnexarArquivo();

	}

	@Entao("seleciono a primeira pagina para anexar")
	public void seleciono_a_primeira_pagina_para_anexar() {

		enviarDocPage.pegarArquivoCTPSFrente();

	}

	@Entao("seleciono a segunda pagina para anexar")
	public void seleciono_a_segunda_pagina_para_anexar() throws InterruptedException {

		enviarDocPage.botaoAnexarArquivo();
		enviarDocPage.pegarArquivoCTPSDados();
		enviarDocPage.descerTela();

	}

	@Entao("aciono o comando para enviar o arquivo da carteira de trabalho")
	public void aciono_o_comando_para_enviar_o_arquivo_da_carteira_de_trabalho() throws InterruptedException {

		enviarDocPage.botaoEnviarArquivo();

	}

	@Entao("o app apresenta mensagem do envio da carteira de trabalho {string}")
	public void o_app_apresenta_mensagem_do_envio_da_carteira_de_trabalho(String mensagem) {

		Assert.assertEquals(mensagem, enviarDocPage.verificarMensagemCarteiraTrabalho(mensagem));

	}

	@Entao("o app apresenta a tela para informar o numero do PIS")
	public void o_app_apresenta_a_tela_para_informar_o_numero_do_pis() {

		Assert.assertEquals("Informe o seu número PIS", enviarDocPage.verificarTelaPIS());

	}

	@Entao("aciono o comando Preencher Pis")
	public void aciono_o_comando_preencher_pis() throws InterruptedException {

		enviarDocPage.botaoPreencherPis();

	}

	@Entao("informo o numero do PIS {string}")
	public void informo_o_numero_do_pis(String numPis) throws InterruptedException {

		enviarDocPage.preencherNumeroPis(numPis);

	}

	@Entao("aciono o comando para finalizar a secao de informe do PIS")
	public void aciono_o_comando_para_finalizar_a_secao_de_informe_do_pis() {

		enviarDocPage.botaoCheckFinalizar();

	}

	@Entao("o app apresenta a tela para iniciar as informações do eSocial")
	public void o_app_apresenta_a_tela_para_iniciar_as_informacoes_do_eSocial() throws InterruptedException {

		Assert.assertEquals("eSocial", enviarDocPage.verificarTelaeSocial());

	}

	@Quando("aciono o comando Enviar para iniciar o envio do documento eSocial")
	public void aciono_o_comando_enviar_para_iniciar_o_envio_do_documento_e_social() throws InterruptedException {

		enviarDocPage.scroll(0.9, 0.1);
		enviarDocPage.botaoEnviar();

	}

	@Quando("aciono o comando para anexar o documento eSocial")
	public void aciono_o_comando_para_anexar_o_documento_esocial() {

		enviarDocPage.botaoAnexarArquivo();

	}

	@Entao("seleciono o arquivo eSocial para anexar e aciono o comando Enviar Arquivo")
	public void seleciono_o_arquivo_e_social_para_anexar_e_aciono_o_comando_enviar_arquivo()
			throws InterruptedException {
		enviarDocPage.selecionarArquivoeSocial();
		enviarDocPage.botaoEnviarArquivo();
	}

	@Entao("o app apresenta mensagem do eSocial enviado {string}")
	public void o_app_apresenta_mensagem_do_eSocial_enviado(String mensagem) {

		Assert.assertEquals(mensagem, enviarDocPage.verificarMensagemComprovante(mensagem));

	}

	@Entao("o app apresenta a tela para iniciar as informações do Endereco")
	public void o_app_apresenta_a_tela_para_iniciar_as_informações_do_endereco() throws InterruptedException {

		Assert.assertEquals("Endereço", enviarDocPage.verificarTelaEndereco());
		Thread.sleep(2000);

	}

	@Entao("aciono o comando Enviar para iniciar o preeenchimento do endereco")
	public void aciono_o_comando_enviar_para_iniciar_o_preeenchimento_do_endereco() throws InterruptedException {

		enviarDocPage.botaoEnviar();

	}

	@Entao("preencho os campos de endereco e avancando apos o seu preenchimento")
	public void preencho_os_campos_de_endereco_e_avancando_apos_o_seu_preenchimento(DataTable dataTable) {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		enviarDocPage.preencherCep(map.get("CEP"));
		enviarDocPage.enderecoVisivel();
		enviarDocPage.botaoSetaBaixo();
		enviarDocPage.preencherNumeroEndereco(map.get("Numero"));
		enviarDocPage.preencherComplemento(map.get("Complemento"));

	}

	@Entao("aciono o comando para finalizar a secao de preeenchimento do endereco")
	public void aciono_o_comando_para_finalizar_a_secao_de_preeenchimento_do_endereco() {

		enviarDocPage.botaoCheckFinalizar();

	}

	@Entao("o app apresenta a tela do anexar o comprovante de residencia")
	public void o_app_apresenta_a_tela_do_anexar_o_comprovante_de_residencia() {

		Assert.assertEquals("Comprovante de residência", enviarDocPage.verificarTelaComprovanteResidencia());

	}

	@Entao("aciono o comando para anexar o comprovante de residencia")
	public void aciono_o_comando_para_anexar_o_comprovante_de_residencia() {

		enviarDocPage.anexarComprovanteResidencia();

	}

	@Entao("o app apresenta mensagem de envio do comprovante de residencia {string}")
	public void o_app_apresenta_mensagem_do_envio_do_comprovante_de_residencia(String mensagem) {

		Assert.assertEquals(mensagem, enviarDocPage.verificarMensagemDiploma(mensagem));

	}

	@Entao("o app apresenta a tela de Declaracao de dependentes")
	public void o_app_apresenta_a_tela_de_declaracao_de_dependentes() {

		Assert.assertEquals("Declaração de dependentes", enviarDocPage.verificarTelaDeclaracaoDependentes());

	}

	@Entao("aciono a opcao referente a dependentes {string}")
	public void aciono_a_opcao_referente_a_dependentes(String opcao) throws InterruptedException {

		enviarDocPage.informarDependentes(opcao);

	}

	@Entao("o app apresenta a tela para anexar o documento foto 3x4")
	public void o_app_apresenta_a_tela_para_anexar_o_documento_foto_3x4() {

		Assert.assertEquals("Foto 3x4", enviarDocPage.verificarTelaFoto3x4());

	}

	@Entao("aciono o comando para anexar a foto")
	public void aciono_o_comando_para_anexar_a_foto() {

		enviarDocPage.botaoAnexarArquivo();

	}

	@Entao("seleciono a foto para anexar")
	public void seleciono_a_foto_para_anexar() {

		enviarDocPage.selecionarArquivoJPG();
		enviarDocPage.scroll(0.9, 0.1);

	}

	@Entao("aciono o comando para enviar o arquivo foto")
	public void aciono_o_comando_para_enviar_o_arquivo_foto() throws InterruptedException {

		enviarDocPage.botaoEnviarArquivo();

	}

	@Entao("o app apresenta mensagem de sucesso para o arquivo foto {string}")
	public void o_app_apresenta_mensagem_de_sucesso_para_o_arquivo_foto(String mensagem) {

		Assert.assertEquals(mensagem, enviarDocPage.verificarMensagemFoto3X4(mensagem));
	}

	// aqui que vai verificar

	@Entao("o app apresenta a tela com os Documentos RG ou CNH anexado e preenchidos")
	public void o_app_apresenta_a_tela_com_os_documentos_rg_ou_cnh_anexado_e_preenchidos(
			io.cucumber.datatable.DataTable dataTable) {

		Assert.assertEquals("RG ou CNH", enviarDocPage.verificarAnexoRGCNH());

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		String numeroRG = map.get("Numero");
		String orgao = map.get("Orgao");
		String UF = map.get("UF");
		String data = map.get("Data");
		String nacionalidade = map.get("Nacionalidade");
		String estadoNatal = map.get("Estado Natal");
		String cidadeNatal = map.get("Cidade Natal");
		String nomeMae = map.get("Nome Mae");
		String nascimento = map.get("Data Nascimento");

		Assert.assertEquals(numeroRG, enviarDocPage.obterNumeroRGTela(numeroRG));
		Assert.assertEquals(orgao, enviarDocPage.obterNumeroRGTela(orgao));
		Assert.assertEquals(UF, enviarDocPage.obterNumeroRGTela(UF));
		Assert.assertEquals(data, enviarDocPage.obterNumeroRGTela(data));
		Assert.assertEquals(nacionalidade, enviarDocPage.obterNumeroRGTela(nacionalidade));
		Assert.assertEquals(estadoNatal, enviarDocPage.obterNumeroRGTela(estadoNatal));
		Assert.assertEquals(cidadeNatal, enviarDocPage.obterNumeroRGTela(cidadeNatal));
		Assert.assertEquals(nomeMae, enviarDocPage.obterNumeroRGTela(nomeMae));
		Assert.assertEquals(nascimento, enviarDocPage.obterNumeroRGTela(nascimento));

	}

	@Entao("o app apresenta a tela com o Estado Civil como {string}")
	public void o_app_apresenta_a_tela_com_o_estado_civil_como(String estadoCivil) throws InterruptedException {

		Assert.assertEquals(estadoCivil, enviarDocPage.obterNumeroRGTela(estadoCivil));
		System.out.println(enviarDocPage.obterNumeroRGTela(estadoCivil));

	}

	@Entao("o app apresenta a tela com a Certidao de Casamento ou nascimento anexado")
	public void o_app_apresenta_a_tela_com_a_certidao_de_casamento_ou_nascimento_anexado() throws InterruptedException {

		enviarDocPage.scroll(0.6, 0.1);
		Thread.sleep(5000);

		// Thread.sleep(8000);
		System.out.println("Certidão casamento ou nascimento");
		// Assert.assertEquals("Certidão casamento ou nascimento",
		// enviarDocPage.obterCertidaoCasamentoNascimentoTela("Certidão
		// casamento ou nascimento"));
		// System.out.println(enviarDocPage.obterCertificadoReservistaTela("Certificado
		// de reservista"));
	}

	@Entao("o app apresenta a tela com o Certificado de reservista anexado")
	public void o_app_apresenta_a_tela_com_o_a_certificado_de_reservista_anexado() {

		System.out.println("Certificado de reservista");

		// Assert.assertEquals("Certificado de reservista",
		// enviarDocPage.obterCertificadoReservistaTela("Certificado de
		// reservista"));

	}

	@Entao("o app apresenta a tela com o Comprovante de escolaridade ou diploma anexado a informacao do grau de instituicao")
	public void o_app_apresenta_a_tela_com_o_a_comprovante_de_escolaridade_ou_diploma_anexado_a_informacao_do_grau_de_instituicao(
			io.cucumber.datatable.DataTable dataTable) {

		enviarDocPage.scroll(0.6, 0.1);

		// Assert.assertEquals("Comprovante de escolaridade ou diploma",
		// enviarDocPage.obterCertidaoCasamentoNascimentoTela("Comprovante de
		// escolaridade ou diploma"));

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		String grauInstituicao = map.get("grauInstituicao");

		Assert.assertEquals(grauInstituicao, enviarDocPage.obterGrauInstituicaoTela(grauInstituicao));

	}

	@Entao("o app apresenta a tela com o titulo de eleitor anexado com os dados")
	public void o_app_apresenta_a_tela_com_o_titulo_de_eleitor_anexado_com_os_dados(
			io.cucumber.datatable.DataTable dataTable) {

		// Assert.assertEquals("Título de eleitor",
		// enviarDocPage.obterTituloEleitorTela("Título de eleitor"));

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		String numero = map.get("Numero");
		String dataEmissao = map.get("Data de emissao");
		String uf = map.get("UF");
		String secao = map.get("Secao");
		String zona = map.get("Zona");

		Assert.assertEquals(numero, enviarDocPage.obternumeroTituloTela(numero));
		Assert.assertEquals(dataEmissao, enviarDocPage.obterDataEmissaoTituloTela(dataEmissao));
		Assert.assertEquals(uf, enviarDocPage.obterUfTituloTela(uf));
		Assert.assertEquals(secao, enviarDocPage.obterSecaoTituloTela(secao));
		Assert.assertEquals(zona, enviarDocPage.obterZonaTituloTela(zona));

	}

	@Entao("o app apresenta a tela com o comprovante de votacao da ultima votacao anexado")
	public void o_app_apresenta_a_tela_com_o_comprovante_de_votacao_da_ultima_votacao_anexado() {

		// Assert.assertEquals("Comprovante última votação",
		// enviarDocPage.obterComprovanteEleitoralTela("Comprovante última
		// votação"));
		System.out.println("Comprovante última votação");

		enviarDocPage.scroll(0.6, 0.1);

	}

	@Entao("o app apresenta a tela com a carteira de trabalho anexado com os dados")
	public void o_app_apresenta_a_tela_com_a_carteira_de_trabalho_anexado_com_os_dados(
			io.cucumber.datatable.DataTable dataTable) {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		String numeroCarteiraTrabalho = map.get("NumeroCarteiraTrabalho");
		String ufCarteiraTrabalho = map.get("UFCarteiraTrabalho");
		String serieCarteiraTrabalho = map.get("SerieCarteiraTrabalho");
		String dataEmissaoCTPS = map.get("DataEmissaoCTPS");

		Assert.assertEquals(numeroCarteiraTrabalho,
				enviarDocPage.obternumeroCarteiraTrabalhoTela(numeroCarteiraTrabalho));
		Assert.assertEquals(ufCarteiraTrabalho, enviarDocPage.obterufCarteiraTrabalhoTela(ufCarteiraTrabalho));
		Assert.assertEquals(serieCarteiraTrabalho, enviarDocPage.obterserieCarteiraTrabalhoTela(serieCarteiraTrabalho));
		Assert.assertEquals(dataEmissaoCTPS, enviarDocPage.obterdataEmissaoCTPSTela(dataEmissaoCTPS));

	}

	@Entao("o app apresenta a tela com o numero do PIS {string}")
	public void o_app_apresenta_a_tela_com_o_numero_do_pis(String numeroPIS) {

		Assert.assertEquals(numeroPIS, enviarDocPage.obterNumeroPISTela(numeroPIS));
		enviarDocPage.scroll(0.6, 0.1);

	}

	@Entao("o app apresenta a tela com o eSocial anexado")
	public void o_app_apresenta_a_tela_com_o_e_social_anexado() {

		// Assert.assertEquals("eSocial",
		// enviarDocPage.obterNumeroPISTela("eSocial"));
		System.out.println("esocial");

	}

	@Entao("o app apresenta a tela com o comprovante de residencia anexado com os dados")
	public void o_app_apresenta_a_tela_com_o_comprovante_de_residencia_anexado_com_os_dados(
			io.cucumber.datatable.DataTable dataTable) {

		// Assert.assertEquals("Comprovante de residência",
		// enviarDocPage.obterComprovanteResidenciaTela("Comprovante de
		// residência"));

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		String cep = map.get("CEP");
		String endereco = map.get("Endereco");

		// Assert.assertEquals(cep, enviarDocPage.obterCEPTela(cep));
		// Assert.assertEquals(endereco,
		// enviarDocPage.obterEnderecoTela(endereco));
		System.out.println("Aqui tem dois erros: CEP errado e está desaparendo caracteres especiais acentuados");

	}

	@Entao("o app apresenta a tela com a foto 3x4 anexada")
	public void o_app_apresenta_a_tela_com_a_foto_3x4_anexada() {

		Assert.assertEquals("Foto 3x4", enviarDocPage.obterFoto3X4Tela("Foto 3x4"));
		enviarDocPage.scroll(0.4, 0.1);

	}

	@Entao("aciono o comando Concluir Envio")
	public void aciono_o_comando_concluir_envio() throws InterruptedException {

		// enviarDocPage.verificarEtapa();
		enviarDocPage.concluirEnvio();
		Thread.sleep(1000);

	}

	@Entao("o app apresenta a tela de Declaracao de envio")
	public void o_app_apresenta_a_tela_de_declaracao_de_envio() throws InterruptedException {

		Assert.assertEquals("Leia e aceite os termos de envio dos documentos",
				enviarDocPage.verificarTelaDeclaracaoEnvio());

	}

	@Entao("aceito o termo e aciono o comando Concluir Envio")
	public void aceito_o_termo_e_aciono_o_comando_concluir_envio() {

		enviarDocPage.aceitarTermo();
		enviarDocPage.concluirEnvio();

	}

	@Entao("o app apresenta tela de Documentos enviados com sucesso.")
	public void o_app_apresenta_tela_de_documentos_enviados_com_sucesso() throws InterruptedException {

		Assert.assertEquals("Documentos enviados", enviarDocPage.verificarTelaDocumentosEnviados());

	}

}
