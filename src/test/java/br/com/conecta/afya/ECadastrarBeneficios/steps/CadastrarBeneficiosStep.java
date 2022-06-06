package br.com.conecta.afya.ECadastrarBeneficios.steps;

import java.io.IOException;
import java.util.Map;
import org.apache.http.StatusLine;
import org.junit.Assert;
import br.com.conecta.afya.core.BaseTest;
import br.com.conecta.afya.core.DriverFactory;
import br.com.conecta.afya.page.CadastroBeneficiosPage;
import br.com.conecta.afya.page.HomePage;
import br.com.conecta.afya.page.LoginPage;
import br.com.conecta.afya.services.ExcluirDependentes;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CadastrarBeneficiosStep extends BaseTest {

	private AndroidDriver<MobileElement> driver;

	HomePage home = new HomePage();
	LoginPage login = new LoginPage();
	CadastroBeneficiosPage cadBeneficios = new CadastroBeneficiosPage();

	// @io.cucumber.java.Before
	// public void excluirDependentes() throws IOException {
	//
	// ExcluirDependentes excluir = new ExcluirDependentes();
	// StatusLine status1 = excluir.excluirDependentes();
	// StatusLine status2 = excluir.excluirDependentes();
	// String code = status2.toString();
	//
	// String apenasCode = code.replace("HTTP/1.1 ", "").replace(" OK", "");
	// String codeF = apenasCode.trim();
	// System.out.println(codeF);
	//
	// }

	@AfterStep
	public void as(Scenario scenario) throws IOException {

		scenario.attach(BaseTest.teste(), "image/png", "AdicionarDadosBancarios");

	}

	@After
	public static void finalizaCenario() {

		DriverFactory.KillDriver();

	}

	@Dado("que eu esteja logado e que ja tenha enviado os documentos para admissao e adicionado os Dados Bancarios")
	public void que_eu_esteja_logado_e_que_ja_tenha_enviado_os_documentos_para_admissao_e_adicionado_os_dados_bancarios(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);
		String CPF = map.get("CPF");
		String Senha = map.get("Senha");

		home.clicarJaTenhoUmaConta();
		Thread.sleep(4000);
		login.preencherCpf(CPF);
		login.botaoAvancar();
		Thread.sleep(1000);
		login.preencherSenha(Senha);
		login.botaoAvancarSenha();

	}

	@Entao("o app apresenta a tela para iniciar as informacoes dos dados do Beneficio")
	public void o_app_apresenta_a_tela_para_iniciar_as_informacoes_dos_dados_do_beneficio()
			throws InterruptedException {

		Thread.sleep(5000);

		String etapasConcluidas = cadBeneficios.verificarEtapasConcluidas();

		Assert.assertTrue(etapasConcluidas.contains("Cadastro Realizado com sucesso :)"));
		Assert.assertTrue(etapasConcluidas.contains("Envio de documentos Realizado com sucesso :)"));
		Assert.assertTrue(etapasConcluidas.contains("Dados Bancários Realizado com sucesso :)"));

		cadBeneficios.scrollar(0.8, 0.1);
		cadBeneficios.verificarInicioBeneficioTela();

	}

	@Entao("aciono o comando para comecar")
	public void aciono_o_comando_para_comecar() {

		cadBeneficios.clicarBotaoComecar();

	}

	@Entao("o app apresenta a tela com os beneficios disponiveis")
	public void o_app_apresenta_a_tela_com_os_beneficios_disponiveis() {

		cadBeneficios.verificaroBeneficioDisponiveisTela();

	}

	@Quando("aciono o comando para comecar para iniciar")
	public void aciono_o_comando_para_comecar_para_iniciar() {

		cadBeneficios.clicarBotaoComecar();

	}

	@Entao("o app apresenta a tela para selecionar se deseja vale transporte")
	public void o_app_apresenta_a_tela_para_selecionar_se_deseja_vale_transporte() {

		cadBeneficios.verificaroValeTransporteTela();

	}

	@Entao("seleciono a opcao {string} e aciono avancar")
	public void seleciono_a_opcao_e_aciono_avancar(String opcao) {

		cadBeneficios.selecionarOpcaoValeTransporte(opcao);
		cadBeneficios.botaoAvancarValeTransporte();

	}

	@Entao("o app apresenta as opcoes de transporte a ser utilizado")
	public void o_app_apresenta_as_opcoes_de_transporte_a_ser_utilizado() {

		Assert.assertEquals("Ônibus", cadBeneficios.verificarOpcaoOnibusTela());
		Assert.assertEquals("+", cadBeneficios.verificarOpcaoAdicionarOnibus());
		cadBeneficios.verificarOpcaoMetroTela();
		cadBeneficios.verificarOpcaoAdicionarMetro();
		cadBeneficios.verificarOpcaoTremTela();
		cadBeneficios.verificarOpcaoAdicionarTrem();

	}

	@Entao("seleciono a quantidade de onibus para a Ida ao trabalho {string} aciono avancar, preencho os dados do onibus a ser utilizado")
	public void seleciono_a_quantidade_de_onibus_para_a_ida_ao_trabalho_aciono_avancar_preencho_os_dados_do_onibus_a_ser_utilizado(
			String quantidadeOnibusIda, io.cucumber.datatable.DataTable dataTable) {

		cadBeneficios.selecionarQuantidadeOnibusIda(quantidadeOnibusIda);
		cadBeneficios.botaoAvancarValeOnibus();

		Assert.assertEquals("Informe a linha ou nome da empresa de transporte.",
				cadBeneficios.verificarTelaInformacoesOnibus());
		Map<String, String> map = dataTable.asMap(String.class, String.class);

		switch (quantidadeOnibusIda) {
		case "1":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			break;

		case "2":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			break;

		case "3":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha3"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa3"));
			cadBeneficios.botaoAvancarTerceiroOnibus();

			break;

		case "4":

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa"));
			cadBeneficios.botaoAvancarPrimeiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha2"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa2"));
			cadBeneficios.botaoAvancarSegundoOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha3"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa3"));
			cadBeneficios.botaoAvancarTerceiroOnibus();

			cadBeneficios.preencgerCampoLinhaEmpresa(map.get("nomeLinha4"));
			cadBeneficios.preencgerCampoPrecoPassagem(map.get("valorTarifa4"));
			cadBeneficios.botaoAvancarQuartoOnibus();

			break;

		}

	}

	@Entao("o app apresenta a pergunta referente ao trajeto ida e volta")
	public void o_app_apresenta_a_pergunta_referente_ao_trajeto_ida_e_volta() {

		Assert.assertEquals("Informe se o trajeto é o mesmo de ida e volta do trabalho",
				cadBeneficios.verificarTrajetoIdaVoltaTela());

	}

	@Entao("seleciono a opcao {string} como o mesmo trajeto e aciono avancar")
	public void seleciono_a_opcao_como_o_mesmo_trajeto_e_aciono_avancar(String opcao) throws InterruptedException {

		cadBeneficios.selecionarIdaVolta(opcao);
		cadBeneficios.botaoAvancarIdaVolta();

	}

	@Entao("o app apresenta a tela de confirmacao do pedido do vale transporte com os respectivos valores e aciono avancar")
	public void o_app_apresenta_a_tela_de_confirmacao_do_pedido_do_vale_transporte_com_os_respectivos_valores_e_aciono_avancar(
			io.cucumber.datatable.DataTable dataTable) {

		Assert.assertEquals("Confirme seu pedido do vale transporte", cadBeneficios.verificarConfirmarPedidoTela());

		cadBeneficios.clicarAbrirInfoDesconto();
		Assert.assertTrue(cadBeneficios.verificarTextoInfoDesconto().trim()
				.contains("Será descontado até 6% do valor de seu salário bruto para o pagamento do VT."));
		cadBeneficios.clicarFecharInfoDesconto();

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		// Assert.assertEquals((map.get("valorTrajetoIda")),
		// cadBeneficios.valorTrajetoIdaTela().substring(3, 7));
		// Assert.assertEquals((map.get("valorTrajetoVolta")),
		// cadBeneficios.valorTrajetoVoltaTela().substring(3, 7));
		// Assert.assertEquals((map.get("valorTotalDiario")),
		// cadBeneficios.valorTotalDiarioTela().substring(3, 7));
		// Assert.assertEquals((map.get("descontoMensal")),
		// cadBeneficios.valorDescontoTela().substring(3, 9).trim());

		cadBeneficios.botaoAvancarTelaConfirmacao();

	}

	@Entao("o app apresenta a tela de do termo de aceite")
	public void o_app_apresenta_a_tela_de_do_termo_de_aceite() {

		Assert.assertEquals("Termo de aceite do vale transporte", cadBeneficios.verificarAceiteTela());

	}

	@Quando("aciono aceitar e aciono finalizar")
	public void aciono_aceitar_e_aciono_finalizar() throws InterruptedException {
		Thread.sleep(1000);
		cadBeneficios.aceitarTermoVale();
		cadBeneficios.botaoFinalizar();

	}

	@Entao("o app apresenta a tela de vale transporte concluido e aciono comando avancar")
	public void o_app_apresenta_a_tela_de_vale_transporte_concluido_e_aciono_comando_avancar() {

		Assert.assertEquals("Vale transporte concluído!", cadBeneficios.verificaConclusaoValeTela());
		cadBeneficios.botaoAvancar();

	}

	@Entao("o app apresenta a tela de Plano Odontologico")
	public void o_app_apresenta_a_tela_de_Plano_Odontologico() throws InterruptedException {

		Assert.assertEquals("Plano odontológico", cadBeneficios.verificaPlanoOdontologico());

	}

	@Quando("escolho a opcao de ter plano odontologico")
	public void escolho_a_opcao_de_ter_plano_odontologico() throws InterruptedException {

		cadBeneficios.scroll(0.7, 0.1);

		cadBeneficios.botaoQueroPlanoOndotologico();
		// cadBeneficios.botaoNaoQueroPlanoOndotologico();

	}

	@Entao("o app apresenta as informacoes de planos disponiveis")
	public void o_app_apreseta_as_informacoes_de_planos_disponiveis() throws InterruptedException {
		Thread.sleep(2000);
		cadBeneficios.scroll(0.7, 0.1);

		Assert.assertEquals("Essencial Plus", cadBeneficios.verificaPlanoOdontologicoEssencialPlus());

		Thread.sleep(1000);
		cadBeneficios.lado();

		Assert.assertEquals("Essencial Top", cadBeneficios.verificaPlanoOdontologicoEssencialTop());
		cadBeneficios.lado2();
		cadBeneficios.lado();

		Assert.assertEquals("Premium Top", cadBeneficios.verificaPlanoOdontologicoPremium());

	}

	@Entao("escolho um dos planos disponiveis no caso {string} e aciono continuar")
	public void escolho_um_dos_planos_disponiveis_no_caso_e_aciono_continuar(String opcao) throws InterruptedException {

		Thread.sleep(2000);
		cadBeneficios.clicarNoPlano(opcao);
		cadBeneficios.botaoContinuar();

		Thread.sleep(4000);

	}

	@Entao("o app apresenta tela para incluir dependentes")
	public void o_app_apresenta_tela_para_incluir_dependentes() throws InterruptedException {

		Assert.assertEquals("Dependentes", cadBeneficios.verificarTelaIncluirDependentes());

	}

	@E("aciono comando para incluir dependentes")
	public void aciono_comando_para_incluir_dependentes() throws InterruptedException {

		cadBeneficios.botaoIncluirDependentes();
		cadBeneficios.scroll(0.7, 0.1);

	}

	@E("incluo o dependente com suas informacoes e aciono avancar")
	public void incluo_o_dependente_com_suas_informacoes_e_aciono_avancar(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		cadBeneficios.selecionarDependente((map.get("grauParentesto")));
		cadBeneficios.botaoSetaPraBaixo();
		cadBeneficios.selecionarIdade((map.get("idade")));
		cadBeneficios.botaoSetaPraBaixo();
		cadBeneficios.preencherNome(map.get("nomeCompeto"));
		cadBeneficios.botaoSetaPraBaixo();
		cadBeneficios.preencherDataNascimento((map.get("dataNascimento")));
		cadBeneficios.botaoSetaPraBaixo();
		cadBeneficios.preencherCPF((map.get("CPF")));
		cadBeneficios.botaoFinalizarDependente();

	}

	@Entao("o app apresenta a tela de certidao de nascimento")
	public void o_app_apresenta_a_tela_de_certidao_de_nascimento() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals("Certidão de nascimento", cadBeneficios.verificarTelaCertidaoNascimento());

	}

	@E("aciono o comando anexar a certidao de nascimento")
	public void aciono_o_comando_anexar_arquivo_da_declaracao_de_dependentes() {

		cadBeneficios.anexarArquivo();

	}

	@E("seleciono o arquivo da certidao de nascimento")
	public void seleciono_o_arquivo_da_certidao_de_nascimento() throws InterruptedException {

		cadBeneficios.selecionarArquivo();

	}

	@E("aciono comando de enviar o arquivo da certidao de nascimento")
	public void aciono_comando_de_enviar_o_arquivo_da_certidao_de_nascimento() throws InterruptedException {

		cadBeneficios.botaoEnviarArquivo();

	}

	@Entao("o app apresenta a tela de carteirinha de vacinacao")
	public void o_app_apresenta_a_tela_de_carteirinha_de_vacinacao() throws InterruptedException {

		Thread.sleep(3000);
		Assert.assertEquals("Carteirinha de vacinação", cadBeneficios.verificarTelaCarteitinhaVacinacao());

	}

	@Entao("aciono comando de anexar a carteirinha de vacinacao")
	public void aciono_comando_de_anexar_a_carteirinha_de_vacinacao() {

		cadBeneficios.anexarArquivo();

	}

	@Entao("seleciono o arquivo da carteirinha de vacinacao")
	public void seleciono_o_arquivo_da_carteirinha_de_vacinacao() throws InterruptedException {

		cadBeneficios.selecionarArquivo();

	}

	@Entao("aciono comando de enviar a carteirinha de vacinacao")
	public void aciono_comando_de_enviar_a_carteirinha_de_vacinacao() {
		cadBeneficios.scroll(0.6, 0.1);
		cadBeneficios.botaoEnviarArquivo();

	}

	@E("seleciono o dependente e aciono avancar")
	public void seleciono_o_dependente_e_aciono_avancar() throws InterruptedException {

		cadBeneficios.checkSelecionarDependente();
		cadBeneficios.botaoAvancarDependente();

	}

	@Entao("o app apresenta a tela com dados de confirmacao do plano ondotologico {string}")
	public void o_app_apresenta_a_tela_com_dados_de_confirmacao_do_plano_ondotologico(String plano)
			throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		Assert.assertEquals(plano, cadBeneficios.telaPlanoConfirmacao(plano));

	}

	@E("aciono o comando avancar da tela de confirmacao")
	public void aciono_o_comando_avancar_da_tela_de_confirmacao() throws InterruptedException {

		cadBeneficios.botaoAvancarConfirmacao();

	}

	@Entao("o app apresenta a tela termo de escolha do plano odontologico")
	public void o_app_apresenta_a_tela_termo_de_escolha_do_plano_odontologico() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals("Termos de escolha do plano odontológico", cadBeneficios.telaTermoOndotologico());

	}

	@E("aciono o comando de aceitar o termo e finalizar")
	public void aciono_o_comando_de_aceitar_o_termo_e_finalizar() throws InterruptedException {

		cadBeneficios.scroll(0.6, 0.1);
		cadBeneficios.checkSelecionarTermo();
		cadBeneficios.botaoFinalizarTermo();

	}

	@Entao("o app apresenta a tela plano odontologico concluida com sucesso e aciono avancar")
	public void o_app_apresenta_a_tela_plano_odontologico_concluida_com_sucesso_e_aciono_avancar()
			throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals("Plano odontológico concluído!", cadBeneficios.telaPlanoOndotologicoConcluido());

		cadBeneficios.botaoAvancar();

	}

	@Entao("o app apresenta a tela para informar o ticket restaurante e alimentação")
	public void o_app_apresenta_a_tela_para_informar_o_ticket_restaurante_e_alimentação() {

		Assert.assertEquals("Ticket restaurante e alimentação", cadBeneficios.telaPlanoTickets());
		cadBeneficios.scroll(0.8, 0.1);
		cadBeneficios.scroll(0.6, 0.1);

	}

	@Quando("aciono o comando para customizar o beneficio")
	public void aciono_o_comando_para_customizar_o_beneficio() {

		cadBeneficios.botaoCustomizarBeneficios();

	}

	@Entao("o app apresenta a tela de opção para receber como alimentação ou restaurante")
	public void o_app_apresenta_a_tela_de_opção_para_receber_como_alimentação_ou_restaurante() {

		cadBeneficios.scroll(0.8, 0.1);
		Assert.assertEquals("Valor integral como Ticket Alimentação", cadBeneficios.TicketAlimentacao());
		Assert.assertEquals("Valor integral como Ticket Restaurante", cadBeneficios.TicketRestaurante());

	}

	@Quando("aciono a opção de beneficio ticket {string} e aciono avancar do beneficio")
	public void aciono_a_opção_de_beneficio_ticket_e_aciono_avancar_do_beneficio(String opcaoTicket) {

		cadBeneficios.selecaoBeneficioTicket(opcaoTicket);
		cadBeneficios.botaoAvancarBeneficioTicket();

	}

	@Entao("o app apresenta a tela de confirmação da escolha {string} e aciono finalizar")
	public void o_app_apresenta_a_tela_de_confirmação_da_escolha_e_aciono_finalizar(String opcaoTicket)
			throws InterruptedException {

		Thread.sleep(2000);

		Assert.assertEquals("Confirme sua escolha", cadBeneficios.telaConfirmacaoTicket());

		Assert.assertEquals(opcaoTicket, cadBeneficios.opcaoConfirmacaoTicket(opcaoTicket));

		cadBeneficios.botaoFinalizar();

	}

	@Entao("o app apresenta a tela do termo de escolha do beneficio do Ticket")
	public void o_app_apresenta_a_tela_do_termo_de_escolha_do_beneficio_do_ticket() throws InterruptedException {

		Thread.sleep(1000);

		Assert.assertEquals("Termos de escolha do benefício", cadBeneficios.termoEscolhaTicket());

	}

	@Quando("aciono o comando de aceitar o termo de escolha do beneficio e finalizar")
	public void aciono_o_comando_de_aceitar_o_termo_de_escolha_do_beneficio_e_finalizar() throws InterruptedException {

		cadBeneficios.aceitarTermoBeleficioTicket();
		cadBeneficios.botaoFinalizar();

	}

	@Entao("o app apresenta a tela de escolha salva do Ticket e aciono comando avancar")
	public void o_app_apresenta_a_tela_de_escolha_salva_do_ticket_e_aciono_comando_avancar() {

		Assert.assertEquals("Sua escolha foi salva!", cadBeneficios.verificarTelasTicketSalvo());
		cadBeneficios.botaoAvancarTelaSalva();

	}

	@Entao("o app apresenta a tela de informacoes do Gympass")
	public void o_app_apresenta_a_tela_de_informacoes_do_gympass_e_aciono_continuar(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Assert.assertEquals("Gympass", cadBeneficios.telaGympass());

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		cadBeneficios.scroll(0.3, 0.1);
		Thread.sleep(2000);
		Assert.assertEquals(map.get("carrossel01"), cadBeneficios.obterTextoGympassCarrossel01());
		// System.out.println(cadBeneficios.obterTextoGympassCarrossel01());

//		cadBeneficios.lado(0.6, 0.1);
//		Assert.assertEquals(map.get("carrossel02"), cadBeneficios.obterTextoGympassCarrossel02());
//		Assert.assertEquals(map.get("carrossel03"), cadBeneficios.obterTextoGympassCarrossel03());
//		cadBeneficios.lado(0.6, 0.1);
//		cadBeneficios.lado(0.6, 0.1);
//		cadBeneficios.lado(0.5, 0.1);
//		Assert.assertEquals(map.get("carrossel04"), cadBeneficios.obterTextoGympassCarrossel04());
//		cadBeneficios.lado(0.5, 0.1);
//		cadBeneficios.lado(0.6, 0.1);
//
//		Assert.assertEquals(map.get("carrossel05"), cadBeneficios.obterTextoGympassCarrossel05());

		cadBeneficios.scroll(0.6, 0.1);

	}

	@E("o app apresenta os passos para o Gympass e aciono continuar")
	public void o_app_apresenta_os_passos_para_o_Gympass_e_aciono_continuar(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);
		Thread.sleep(1000);
//		Assert.assertEquals(map.get("passo01"), cadBeneficios.obterTextoGympassPasso1());
//		Assert.assertEquals(map.get("passo02"), cadBeneficios.obterTextoGympassPasso2());
//		Assert.assertEquals(map.get("passo03"), cadBeneficios.obterTextoGympassPasso3());
//		Assert.assertEquals(map.get("passo04"), cadBeneficios.obterTextoGympassPasso4());
//		Assert.assertEquals(map.get("passo05"), cadBeneficios.obterTextoGympassPasso5());
//		Assert.assertEquals(map.get("passo06"), cadBeneficios.obterTextoGympassPasso6());

		Thread.sleep(1000);
		cadBeneficios.botaoContinuar();

	}

	@Entao("o app apresenta a tela da escolha salva e informando que foi enviado email sobre o Gympass e aciono avancar")
	public void o_app_apresenta_a_tela_da_escolha_salva_e_informando_que_foi_enviado_email_sobre_o_gympass_e_aciono_avancar(
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		Thread.sleep(2000);

//		Assert.assertEquals(map.get("texto01"), cadBeneficios.textoSalvo());
//		Assert.assertEquals(map.get("texto02"), cadBeneficios.obterTextoDeenvioEmail());
		cadBeneficios.botaoAvancar();

	}

	@Entao("o app apresenta a tela de informacoes do Plano de Saude")
	public void o_app_apresenta_a_tela_de_informacoes_do_plano_de_saude(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {

		Map<String, String> map = dataTable.asMap(String.class, String.class);

		Thread.sleep(1000);
//		Assert.assertEquals(map.get("titulo"), cadBeneficios.tituloDoPlanoSaude());
//		Assert.assertEquals(map.get("texto01"), cadBeneficios.texto01DoPlanoSaude());
//		Assert.assertEquals(map.get("texto02"), cadBeneficios.texto02DoPlanoSaude());
//		Assert.assertEquals(map.get("texto03"), cadBeneficios.texto03DoPlanoSaude());

		Thread.sleep(500);
//		Assert.assertEquals(map.get("texto04"), cadBeneficios.texto04DoPlanoSaude());
//		Assert.assertEquals(map.get("texto05"), cadBeneficios.texto05DoPlanoSaude());

		cadBeneficios.scroll(0.9, 0.1);

		// validando o carrossel

		Thread.sleep(2000);
//		Assert.assertEquals(map.get("carrossel01"), cadBeneficios.textoSaudeDoCarrossel01());
//		Assert.assertEquals(map.get("carrossel02"), cadBeneficios.textoSaudeDoCarrossel02());

		//cadBeneficios.lado(0.6, 0.1);
//		Assert.assertEquals(map.get("carrossel03"), cadBeneficios.textoSaudeDoCarrossel03());

		//cadBeneficios.lado(0.9, 0.1);
		Thread.sleep(500);
		//cadBeneficios.lado(0.6, 0.1);
//		Assert.assertEquals(map.get("carrossel04"), cadBeneficios.textoSaudeDoCarrossel04());

	}

	@E("aciono comando para adicionar dependentes")
	public void aciono_comando_para_adicionar_dependentes() {

		cadBeneficios.clicarBotaoAdicionarDependentes();

	}

	@E("seleciono o dependente e aciono avancar da selecao do dependentes")
	public void seleciono_o_dependente_e_aciono_avancar_da_selecao_do_dependentes() {

		cadBeneficios.checkSelecionarDependente();
		cadBeneficios.botaoAvancarDependenteSaude();

	}
	
	
	
	@Entao("o app apresenta a tela de confirmacao do pedido do plano de saude e depois aciona avancar")
	public void o_app_apresenta_a_tela_de_confirmacao_do_pedido_do_plano_de_saude_e_depois_aciona_avancar(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	   
		
		Thread.sleep(5000);
		
		//System.out.println(cadBeneficios.tituloPlanoSelecionadoSaude());
		
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		
//		System.out.println(cadBeneficios.tituloPlanoSelecionadoSaude());
//		System.out.println(cadBeneficios.textoPlanoSelecionadoSaude());
//		System.out.println(cadBeneficios.textoTipoPlanoSelecionadoSaude());
//		System.out.println(cadBeneficios.nomeCadastradoNoPlano());
//		System.out.println(cadBeneficios.valorDescontoMensalPlanoSaude());
//		
		
		
		

      
		 
		
		
		Assert.assertEquals(map.get("titulo"), cadBeneficios.tituloPlanoSelecionadoSaude());
		Assert.assertEquals(map.get("texto01"), cadBeneficios.textoPlanoSelecionadoSaude());
        Assert.assertEquals(map.get("texto02"), cadBeneficios.textoTipoPlanoSelecionadoSaude());
		Assert.assertEquals(map.get("Cadastrado no Plano"), cadBeneficios.nomeCadastradoNoPlano());
		Assert.assertEquals(map.get("Desconto mensal"), cadBeneficios.valorDescontoMensalPlanoSaude());
		cadBeneficios.botaoSetaAvancarSaude();

		
		
		
		
		
	}
	@Entao("o app apresenta a tela do termo de aceite do plano de saude")
	public void o_app_apresenta_a_tela_do_termo_de_aceite_do_plano_de_saude() throws InterruptedException {
	   
		Thread.sleep(5000);
		System.out.println(cadBeneficios.verificarTextoTermoSaude());
		
		
		
		
	}
	@Quando("aciono aceitar o termo")
	public void aciono_aceitar_o_termo() throws InterruptedException {
		
		
		
		cadBeneficios.scroll(0.7, 0.1);
		cadBeneficios.clicarTermoSaude();
		cadBeneficios.clicarBotaoAceitar();

	}
	@Entao("o app apresenta a tela com o plano cadastro concluido")
	public void o_app_apresenta_a_tela_com_o_plano_cadastro_concluido() throws InterruptedException {
		
		Thread.sleep(5000);
		System.out.println(cadBeneficios.verificarTelaConcluidoPlanoSaude());	
		
	 
	}
	
	
	

}
