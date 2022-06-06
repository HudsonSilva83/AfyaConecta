package br.com.conecta.afya.ACadastrarNovoColaborador.steps;

import java.io.IOException;
import java.util.Map;

import org.junit.Assert;
import br.com.conecta.afya.core.BaseTest;
import br.com.conecta.afya.core.DriverFactory;
import br.com.conecta.afya.page.CadastroPage;
import br.com.conecta.afya.page.CadastroSenhaPage;
import br.com.conecta.afya.page.HomePage;
import br.com.conecta.afya.page.InformacoesPessoaisPage;
import br.com.conecta.afya.services.ExcluirUsuario;
import br.com.conecta.afya.services.GerarCodigoAcesso;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class ACadastrarNovoColaboradorStep extends BaseTest {

	private AndroidDriver<MobileElement> driver;

	HomePage home = new HomePage();
	CadastroPage cadastro = new CadastroPage();
	CadastroSenhaPage cadastroSenha = new CadastroSenhaPage();
	InformacoesPessoaisPage informacoesPessoais = new InformacoesPessoaisPage();
	GerarCodigoAcesso codigoAcesso = new GerarCodigoAcesso();

	private String feature = "Cadastrar Novo Colaborador";
	private String cenario = "";

	@Before

	public void inicioCenario(Scenario cen) throws Exception {
		// feature = cen.getId().split(";")[0];
		cenario = cen.getName();
//
//		ExcluirUsuario exusu = new ExcluirUsuario();
//		exusu.excluirUsuario();
		
		System.out.println("teste");

	}

	@AfterStep
	public void as(Scenario scenario) throws IOException {

		scenario.attach(BaseTest.teste(), "image/png", "Cadastrar Novo Colaborador");

	}

	@After
	public static void finalizaCenario() {

		DriverFactory.KillDriver();

	}

	// @AfterAll()
	// public static void finalizaClasse() {
	//
	// DriverFactory.KillDriver();
	//
	// }

	@Dado("que eu esteja na tela Home do aplicativo")
	public void que_eu_esteja_na_tela_home_do_aplicativo() {

		Assert.assertEquals("Já tenho uma conta", home.verificarHomeJaTenhoConta());

	}

	@Dado("aciono a opcao {string}")
	public void aciono_a_opcao(String CodigoAcesso) {
		home.clicarCampoCodigoAcesso(CodigoAcesso);
	}

	@Dado("preeencho o campo codigo")
	public void preeencho_o_campo_codigo() throws Exception {

		String codigo = GerarCodigoAcesso.gerarCodigoAcesso();
		home.preencherCodigoAcesso(codigo);
		Thread.sleep(1000);
	}

	@Dado("aciono comando avancar")
	public void aciono_comando_avancar() {
		home.avancarButton();
	}

	@Entao("o app apresenta a tela de {string}")
	public void o_app_apresenta_a_tela_de(String telaBemvindo) {

		Assert.assertEquals("Bem vindo!", cadastro.telaBemvindo(telaBemvindo));
		Assert.assertTrue(cadastro
				.verificarTextoPreCadastro("Ficamos muito felizes por você ter escolhido fazer parte do nosso time!"));
		Assert.assertTrue(cadastro.verificarTextoPreCadastro(
				"Nesta primeira etapa é necessário que você siga os passos abaixo para completar seu cadastro."));
		cadastro.descerTela();

	}

	@Entao("apresenta a tela com os dados ja preenchidos")
	public void apresenta_a_tela_com_os_dados_ja_preenchidos(io.cucumber.datatable.DataTable dataTable) {

		Map<String, String> map = dataTable.asMap(String.class, String.class);
		Assert.assertEquals(map.get("nomeCompleto"), cadastro.obterValorCampoNomeCompleto());
		// Assert.assertEquals(map.get("email"),
		// cadastro.obterValorCampoNomeCompleto());
		Assert.assertEquals(map.get("celular"), cadastro.obterValorCampoCelular());
		Assert.assertEquals(map.get("cargo"), cadastro.obterValorCampoCargo());
		Assert.assertEquals(map.get("unidade"), cadastro.obterValorCampoUnidade());

	}

	@Entao("altero os campo nomeCompleto para {string}")
	public void altero_os_campo_nome_completo_para(String nomeCompleto) throws InterruptedException {

		cadastro.alterarNome(nomeCompleto);

	}

	@Entao("altero o campo email para {string}")
	public void altero_o_campo_email_para(String campoEmail) throws InterruptedException {

		cadastro.alterarEmail(campoEmail);
		cadastro.botaoConfirmar();

	}

	@Entao("altero o campo celular para {string}")
	public void altero_o_campo_celular_para(String campoCelular) throws InterruptedException {

		cadastro.alterarTelefone(campoCelular);
		//
		// // Assert.assertTrue(cadastro.verificarCampoPreenchido("Automacao
		// // Conecta Afya"));
		// //
		// Assert.assertTrue(cadastro.verificarCampoPreenchido("conecta.afya@gmail.com"));
		// // Assert.assertTrue(cadastro.verificarCampoPreenchido("(99)
		// // 99999-9999"));
		// // Assert.assertTrue(cadastro.verificarCampoPreenchido("ANALISTA DE
		// // DADOS PL"));
		// // Assert.assertTrue(cadastro.verificarCampoPreenchido("AFYA"));

	}

	@Quando("aciono os comandos para aceitar o termo e confirmar")
	public void aciono_os_comandos_para_aceitar_o_termo_e_confirmar() {

		cadastro.aceitarTermosCondicoes();
		// cadastro.descerTelaTeste();
		cadastro.botaoConfirmar();

	}

	@Então("o app apresenta a tela para assinatura")
	public void o_app_apresenta_a_tela_para_assinatura() {

		cadastro.botaoAvancarAssinatura();

	}

	@Quando("faco a assinatura e aciono avancar")
	public void faco_a_assinatura_e_aciono_avancar() throws InterruptedException {

		cadastro.assinar();
		Thread.sleep(2000);
		cadastro.botaoAvancarAssinatura();

	}

	@Quando("preencho o campo senha {string} e aciono avancar")
	public void preencho_o_campo_senha_e_aciono_avancar(String senha) {

		cadastroSenha.preencherCampoSenha(senha);
		cadastroSenha.botaoAvancarSenha();

	}

	@Entao("o app apresenta a tela de Parabens com a opcao para continuar")
	public void o_app_apresenta_a_tela_de_parabens_com_a_opcao_para_continuar() {

		Assert.assertTrue(
				cadastro.verificarTextoPreCadastro("A primeira etapa do seu cadastro foi concluída com sucesso"));
		Assert.assertTrue(cadastro.verificarTextoPreCadastro(
				"Agora, precisaremos de informações pessoais suas para completar seu cadastro"));

		cadastroSenha.botaoContinuar();

	}

	@Entao("preencho o nome social {string} e aciono avancar")
	public void preencho_o_nome_social_e_aciono_avancar(String nomeSocial) throws InterruptedException {

		Assert.assertTrue(informacoesPessoais.verificarTextoTelaInformacoesPessoais("Informações pessoais"));
		informacoesPessoais.preencherCampoNomeSocial(nomeSocial);
		Thread.sleep(1000);
		informacoesPessoais.botaoAvancarTela();

	}

	@Entao("preencho o apelido {string} e aciono avancar")
	public void preencho_o_apelido_e_aciono_avancar(String apelido) {

		informacoesPessoais.preencherCampoApelido(apelido);

	}

	@Entao("seleciono a opcao de certificado Reservista como {string} e aciono avancar")
	public void seleciono_a_opcao_de_certificado_reservista_como_e_aciono_avancar(String opcaoReservista) {

		informacoesPessoais.possueCertificadoReservista(opcaoReservista);

	}

	@Entao("seleciono a opcao de genero como {string} e aciono avancar")
	public void seleciono_a_opcao_de_genero_como_e_aciono_avancar(String opcaoGenero) throws InterruptedException {
		informacoesPessoais.selecionarIdentidadeGenero(opcaoGenero);
	}

	@Entao("seleciono a opcao de cor ou Raca como {string} e aciono avancar")
	public void seleciono_a_opcao_de_cor_ou_raca_como_e_aciono_avancar(String opcaoCorRaca) {

		informacoesPessoais.selecionarRaca(opcaoCorRaca);

	}

	@Quando("seleciono a opcao de tipo deficiencia como {string} e aciono avancar")
	public void seleciono_a_opcao_de_tipo_deficiencia_como_e_aciono_avancar(String tipoDeficiencia)
			throws InterruptedException {

		informacoesPessoais.selecionarDeficiencia(tipoDeficiencia);
		informacoesPessoais.botaoAvancarTela();

	}

	@Entao("o app apresenta a tela com a mensagem {string}.")
	public void o_app_apresenta_a_tela_com_a_mensagem(String mensagem) {

		informacoesPessoais.telaCadastroComSucesso();
		Assert.assertEquals("true", informacoesPessoais.telaCadastradoSucesso());
		gerarScreenShot(feature, cenario);

	}

	@Quando("faco a assinatura e aciono o comando Limpar")
	public void faco_a_assinatura_e_aciono_o_comando_limpar() {
		cadastro.assinar();
		cadastro.botaoLimpar();
	}

	@Entao("a assinatura é desfeita e a tela fica disponivel para uma nova assinatura")
	public void a_assinatura_é_desfeita_e_a_tela_fica_disponivel_para_uma_nova_assinatura()
			throws InterruptedException {

		Thread.sleep(1000);
		Assert.assertTrue(cadastro.verificarBotaoDesabilitadoAvancarAssinatura());
		gerarScreenShot(feature, cenario);

	}

	@Entao("aciono o comando para pular a etapa do preenchimento do nome social aciono avancar")
	public void aciono_o_comando_para_pular_a_etapa_do_preenchimento_do_nome_social_aciono_avancar() {

		cadastro.botaoPularNomeSocial();
		gerarScreenShot(feature, cenario);

	}

	@Entao("o app efetua o registro sem o nome social com sucesso")
	public void o_app_efetua_o_registro_sem_o_nome_social_com_sucesso() {

		informacoesPessoais.telaCadastroComSucesso();
		Assert.assertEquals("true", informacoesPessoais.telaCadastradoSucesso());
		gerarScreenShot(feature, cenario);

	}

	@Entao("aciono o comando para pular a etapa do preenchimento do apelido aciono avancar")
	public void aciono_o_comando_para_pular_a_etapa_do_preenchimento_do_apelido_aciono_avancar() {

		cadastro.botaoPularApelido();
		gerarScreenShot(feature, cenario);
	}

	@Entao("o app efetua o registro sem o apelido com sucesso")
	public void o_app_efetua_o_registro_sem_o_apelido_com_sucesso() {

		informacoesPessoais.telaCadastroComSucesso();
		Assert.assertEquals("true", informacoesPessoais.telaCadastradoSucesso());
		gerarScreenShot(feature, cenario);

	}

	@Entao("o app apresenta a tela de inicio da etapa para o nome social com a Etapa {string}")
	public void o_app_apresenta_a_tela_de_inicio_da_etapa_para_o_nome_social_com_a_etapa(String Etapa_1de6) {

		Assert.assertEquals("Etapa 1 de 6", cadastro.verificarEtapa(Etapa_1de6));

	}

	@Entao("o app apresenta a Etapa da tela apelido {string} e opcao de voltar")
	public void o_app_apresenta_a_etapa_da_tela_apelido_e_opcao_de_voltar(String Etapa_2de6) {

		Assert.assertEquals("Etapa 2 de 6", cadastro.verificarEtapa(Etapa_2de6));

	}

	@Quando("aciono o comando voltar para a tela do nome social")
	public void aciono_o_comando_voltar_para_a_tela_do_nome_social() {

		cadastro.botaoVoltarEtapa();

	}

	@Entao("o app apresenta o nome social mantido como {string}")
	public void o_app_apresenta_o_nome_social_mantido_como(String nomeSocial) {

		Assert.assertEquals(nomeSocial, cadastro.verificarTextoCampo(nomeSocial));
		gerarScreenShot(feature, cenario);

	}

	@Entao("o app apresenta a Etapa da tela do certificado reservista {string} e opcao de voltar")
	public void o_app_apresenta_a_etapa_da_tela_do_certificado_reservista_e_opcao_de_voltar(String Etapa_3de6) {

		Assert.assertEquals("Etapa 3 de 6", cadastro.verificarEtapa(Etapa_3de6));

	}

	@Quando("aciono o comando voltar para a tela do apelido")
	public void aciono_o_comando_voltar_para_a_tela_do_apelido() {

		cadastro.botaoVoltarEtapa();
	}

	@Entao("o app apresenta o nome do apelido mantido como {string}")
	public void o_app_apresenta_o_nome_do_apelido_mantido_como(String nomeApelido) {

		Assert.assertEquals(nomeApelido, cadastro.verificarTextoCampo(nomeApelido));
	}

	@Entao("o app apresenta a Etapa da tela identidade de genero {string} e opcao de voltar")
	public void o_app_apresenta_a_etapa_da_tela_identidade_de_genero_e_opcao_de_voltar(String Etapa_4de6) {

		Assert.assertEquals("Etapa 4 de 6", cadastro.verificarEtapa(Etapa_4de6));

	}

	@Quando("aciono o comando voltar para a tela do certificado")
	public void aciono_o_comando_voltar_para_a_tela_do_certificado() {
		cadastro.botaoVoltarEtapa();
	}

	@Entao("o app apresenta a opcao na tela do certificado mantido como a opcao {string}")
	public void o_app_apresenta_a_opcao_na_tela_do_certificado_mantido_como_a_opcao(String opcaoCertificado) {

		Assert.assertTrue(opcaoCertificado, cadastro.verificarOpcaoRadioSelecionado(opcaoCertificado));
	}

	@Entao("o app apresenta a Etapa da tela cor e raca {string} e opcao de voltar")
	public void o_app_apresenta_a_etapa_da_tela_cor_e_raca_e_opcao_de_voltar(String Etapa_5de6) {

		Assert.assertEquals("Etapa 5 de 6", cadastro.verificarEtapa(Etapa_5de6));

	}

	@Entao("aciono o comando voltar para a tela do genero")
	public void aciono_o_comando_voltar_para_a_tela_do_genero() {

		cadastro.botaoVoltarEtapa();

	}

	@Entao("apresenta a opcao do genero mantido como {string}")
	public void apresenta_a_opcao_do_genero_mantido_como(String opcaoGenero) {

		Assert.assertTrue(opcaoGenero, cadastro.verificarOpcaoRadioSelecionado(opcaoGenero));

	}

	@Entao("o app apresenta a Etapa da tela tipo de deficiencia {string} e opcao de voltar")
	public void o_app_apresenta_a_etapa_da_tela_tipo_de_deficiencia_e_opcao_de_voltar(String Etapa_6de6) {

		Assert.assertEquals("Etapa 6 de 6", cadastro.verificarEtapa(Etapa_6de6));

	}

	@Entao("aciono o comando voltar para a tela do cor-Raca")
	public void aciono_o_comando_voltar_para_a_tela_do_cor_raca() {
		cadastro.botaoVoltarEtapa();
	}

	@Entao("o app apresenta a opcao na tela do Cor-Raca mantido como a opcao {string}")
	public void o_app_apresenta_a_opcao_na_tela_do_cor_raca_mantido_como_a_opcao(String opcaoCorRaca) {

		Assert.assertTrue(opcaoCorRaca, cadastro.verificarOpcaoRadioSelecionado(opcaoCorRaca));

	}

	@Entao("altero o campo email com um valor inválido o app apresenta mensagem {string} e o comando de confirmar permanece desabilitado")
	public void altero_o_campo_email_com_um_valor_inválido_o_app_apresenta_mensagem_e_o_comando_de_confirmar_permanece_desabilitado(
			String mensagem, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		String email_1 = map.get("email_1");
		String email_2 = map.get("email_2");
		String email_3 = map.get("email_3");
		String email_4 = map.get("email_4");
		String email_5 = map.get("email_5");
		String email_6 = map.get("email_6");

		cadastro.alterarEmail(email_1);
		cadastro.botaoConfirmar();

		Assert.assertEquals("Digite um e-mail válido", cadastro.verificarMensagemErro(mensagem));
		Assert.assertTrue(cadastro.botaoConfirmarDesabilitado());

		cadastro.alterarEmail(email_2);
		cadastro.botaoConfirmar();

		Assert.assertEquals("Digite um e-mail válido", cadastro.verificarMensagemErro(mensagem));
		Assert.assertTrue(cadastro.botaoConfirmarDesabilitado());

		cadastro.alterarEmail(email_3);
		cadastro.botaoConfirmar();

		Assert.assertEquals("Digite um e-mail válido", cadastro.verificarMensagemErro(mensagem));
		Assert.assertTrue(cadastro.botaoConfirmarDesabilitado());

		cadastro.alterarEmail(email_4);
		cadastro.botaoConfirmar();

		Assert.assertEquals("Digite um e-mail válido", cadastro.verificarMensagemErro(mensagem));
		Assert.assertTrue(cadastro.botaoConfirmarDesabilitado());

		cadastro.alterarEmail(email_5);
		cadastro.botaoConfirmar();

		Assert.assertEquals("Digite um e-mail válido", cadastro.verificarMensagemErro(mensagem));
		Assert.assertTrue(cadastro.botaoConfirmarDesabilitado());

		cadastro.alterarEmail(email_6);
		cadastro.botaoConfirmar();

		Assert.assertEquals("Digite um e-mail válido", cadastro.verificarMensagemErro(mensagem));
		Assert.assertTrue(cadastro.botaoConfirmarDesabilitado());

		gerarScreenShot(feature, cenario);

	}

	@Entao("verifico que o campo celular já vem preenchido")
	public void verifico_que_o_campo_celular_já_vem_preenchido() {
		// esperar ramon ajustar
		System.out.println("esperar ramon ajustar");
		// cadastro.lapisAltearTelefone();
		// Assert.assertFalse(cadastro.verificarCampoCelularPreenchido());
	}

	@Dado("aciono alterar do campo celular")
	public void aciono_alterar_do_campo_celular() {

		cadastro.lapisAltearTelefone();
	}

	@Entao("seleciono a opcao do pais {string}")
	public void seleciono_a_opcao_do_pais(String Pais) throws InterruptedException {

		cadastro.selecaoBadeiraNacionalidade(Pais);

	}

	@Entao("preencho o campo celular com a mascara para o brasil {string}")
	public void preencho_o_campo_celular_com_a_mascara_para_o_brasil(String mascaraBrasil) {

		cadastro.preencherCampoCelular(mascaraBrasil);

	}

	@Entao("o app verifica a quantidade de caracteres de {int} para a mascara Brasil preenchida")
	public void o_app_verifica_a_quantidade_de_caracteres_de_para_a_mascara_brasil_preenchida(Integer quantidadeBrasil)
			throws InterruptedException {

		String quantitade = quantidadeBrasil.toString();
		Assert.assertEquals(quantitade, cadastro.verificarQuantCampoCelular());

	}

	@Entao("preencho o campo celular com a mascara para a Espanha {string}")
	public void preencho_o_campo_celular_com_a_mascara_para_a_espanha(String mascaraEspanha) {

		cadastro.preencherCampoCelular(mascaraEspanha);

	}

	@Entao("o app verifica a quantidade de caracteres de {int} para a mascara Espanha preenchida")
	public void o_app_verifica_a_quantidade_de_caracteres_de_para_a_mascara_espanha_preenchida(
			Integer quantidadeEspanha) throws InterruptedException {

		String quantitade = quantidadeEspanha.toString();
		Assert.assertEquals(quantitade, cadastro.verificarQuantCampoCelular());

	}

	@Entao("preencho o campo celular com a mascara para o Estados Unidos {string}")
	public void preencho_o_campo_celular_com_a_mascara_para_o_estados_unidos(String mascaraEUA) {

		cadastro.preencherCampoCelular(mascaraEUA);

	}

	@Entao("o app verifica a quantidade de caracteres de {int} para a mascara Estados Unidos preenchida")
	public void o_app_verifica_a_quantidade_de_caracteres_de_para_a_mascara_estados_unidos_preenchida(
			Integer quantidadeEUA) throws InterruptedException {

		String quantitade = quantidadeEUA.toString();
		Assert.assertEquals(quantitade, cadastro.verificarQuantCampoCelular());
	}

	@Entao("preencho o campo celular com a mascara para o Mexico {string}")
	public void preencho_o_campo_celular_com_a_mascara_para_o_mexico(String mascaraMexico) {

		cadastro.preencherCampoCelular(mascaraMexico);

	}

	@Entao("o app verifica a quantidade de caracteres de {int} para a mascara Mexico preenchida")
	public void o_app_verifica_a_quantidade_de_caracteres_de_para_a_mascara_mexico_preenchida(Integer quantidadeMexico)
			throws InterruptedException {

		String quantitade = quantidadeMexico.toString();
		Assert.assertEquals(quantitade, cadastro.verificarQuantCampoCelular());

		gerarScreenShot(feature, cenario);

	}

	@Entao("preencho o campo senha para validar de nivel fraca apresentando a mensagem {string} e nao habilita o botao avancar")
	public void preencho_o_campo_senha_para_validar_de_nivel_fraca_apresentando_a_mensagem_e_nao_habilita_o_botao_avancar(
			String mensagemSenhaFraca, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		String validacao1 = map.get("validacao1");
		String validacao2 = map.get("validacao2");
		String validacao3 = map.get("validacao3");
		String validacao4 = map.get("validacao4");
		String validacao5 = map.get("validacao5");
		String validacao6 = map.get("validacao6");

		cadastro.clicarVisualizar();
		cadastro.preencherSenha(validacao1);
		Assert.assertEquals(mensagemSenhaFraca, cadastro.obterMensagem("Senha fraca"));
		cadastro.apagarCampoSenha(validacao1);
		Assert.assertTrue(cadastro.verificarBotaoAvancarDesabilitado());

		cadastro.preencherSenha(validacao2);
		Assert.assertEquals(mensagemSenhaFraca, cadastro.obterMensagem("Senha fraca"));
		cadastro.apagarCampoSenha(validacao2);
		Assert.assertTrue(cadastro.verificarBotaoAvancarDesabilitado());

		cadastro.preencherSenha(validacao3);
		Assert.assertEquals(mensagemSenhaFraca, cadastro.obterMensagem("Senha fraca"));
		cadastro.apagarCampoSenha(validacao3);
		Assert.assertTrue(cadastro.verificarBotaoAvancarDesabilitado());

		cadastro.preencherSenha(validacao4);
		Assert.assertEquals(mensagemSenhaFraca, cadastro.obterMensagem("Senha fraca"));
		cadastro.apagarCampoSenha(validacao4);
		Assert.assertTrue(cadastro.verificarBotaoAvancarDesabilitado());

		cadastro.preencherSenha(validacao5);
		Assert.assertEquals(mensagemSenhaFraca, cadastro.obterMensagem("Senha fraca"));
		cadastro.apagarCampoSenha(validacao5);
		Assert.assertTrue(cadastro.verificarBotaoAvancarDesabilitado());

		cadastro.preencherSenha(validacao6);
		Assert.assertEquals(mensagemSenhaFraca, cadastro.obterMensagem("Senha fraca"));
		cadastro.apagarCampoSenha(validacao6);
		Assert.assertTrue(cadastro.verificarBotaoAvancarDesabilitado());

		gerarScreenShot(feature, cenario);

	}

	// @Quando("preencho o campo senha para validar o nivel media")
	// public void
	// preencho_o_campo_senha_para_validar_o_nivel_media(io.cucumber.datatable.DataTable
	// dataTable) throws InterruptedException {
	//
	// Map<String, String> map = dataTable.asMap(String.class, String.class);
	// String nivelMedia = map.get("senhaMedia");
	// cadastro.clicarVisualizar();
	// cadastro.preencherSenha(nivelMedia);
	// cadastro.apagarCampoSenha(nivelMedia);
	// Assert.assertFalse(cadastro.verificarBotaoAvancarDesabilitado());
	//
	//
	//
	//
	//
	// }

	// @Entao("o app apresenta a mensagem de senha media {string} e habilita o
	// comando para avancar")
	// public void
	// o_app_apresenta_a_mensagem_de_senha_media_e_habilita_o_comando_para_avancar(String
	// mensagemSenhaMedia) {
	//
	// Assert.assertEquals(mensagemSenhaMedia, cadastro.obterMensagem("Senha
	// media"));
	//
	// }

	@Quando("preencho o campo senha para validar de nivel forte")
	public void preencho_o_campo_senha_para_validar_de_nivel_forte(io.cucumber.datatable.DataTable dataTable) {

		Map<String, String> map = dataTable.asMap(String.class, String.class);
		String senhaForte = map.get("senhaForte");
		cadastro.clicarVisualizar();
		cadastro.preencherSenha(senhaForte);

	}

	@Entao("o app apresenta a mensagem de senha forte {string} e habilita o comando para avancar")
	public void o_app_apresenta_a_mensagem_de_senha_forte_e_habilita_o_comando_para_avancar(String mensagemSenhaForte) {

		Assert.assertEquals(mensagemSenhaForte, cadastro.obterMensagem("Senha forte"));
		Assert.assertFalse(cadastro.verificarBotaoAvancarDesabilitado());

		gerarScreenShot(feature, cenario);
	}

}
