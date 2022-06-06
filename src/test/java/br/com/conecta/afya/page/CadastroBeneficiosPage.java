package br.com.conecta.afya.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.conecta.afya.core.BasePage;
import br.com.conecta.afya.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class CadastroBeneficiosPage extends BasePage {

	public void scrollar(double inicio, double fim) {

		scroll(inicio, fim);

	}

	public String verificarInicioBeneficioTela() {

		return obterTextoAtributo(MobileBy.AccessibilityId("COMEÇAR"));

	}

	public void clicarBotaoComecar() {
		clicar(MobileBy.AccessibilityId("COMEÇAR"));

	}

	public String verificaroBeneficioDisponiveisTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId(
				"Estes são os seus benefícios. Nos próximos passos, iremos customizar cada um deles."));

	}

	public String verificaroValeTransporteTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Vale transporte"));

	}

	public void selecionarOpcaoValeTransporte(String opcao) {
		clicar(MobileBy.AccessibilityId(opcao));

	}

	public void botaoAvancarValeTransporte() {
		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[3]"));

	}

	public String verificarOpcaoOnibusTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Ônibus"));

	}

	public String verificarOpcaoMetroTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Metrô"));

	}

	public String verificarOpcaoTremTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Trem"));

	}

	public String verificarOpcaoAdicionarOnibus() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[15]"));

	}

	public String verificarOpcaoAdicionarMetro() {
		return obterTextoAtributo((By.xpath("(//android.view.View)[19]")));

	}

	public String verificarOpcaoAdicionarTrem() {
		return obterTextoAtributo((By.xpath("(//android.view.View)[23]")));

	}

	public void selecionarQuantidadeOnibusIda(String quantidadeIda) {

		switch (quantidadeIda) {
		case "1":

			clicar(By.xpath("(//android.view.View)[15]"));

			break;

		case "2":

			clicar(By.xpath("(//android.view.View)[15]"));
			clicar(By.xpath("(//android.view.View)[15]"));

			break;

		case "3":

			clicar(By.xpath("(//android.view.View)[15]"));
			clicar(By.xpath("(//android.view.View)[15]"));
			clicar(By.xpath("(//android.view.View)[15]"));

			break;

		case "4":

			clicar(By.xpath("(//android.view.View)[15]"));
			clicar(By.xpath("(//android.view.View)[15]"));
			clicar(By.xpath("(//android.view.View)[15]"));
			clicar(By.xpath("(//android.view.View)[15]"));

			break;

		}

	}

	public void botaoAvancarValeOnibus() {
		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[3]"));

	}

	public String verificarTelaInformacoesOnibus() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Informe a linha ou nome da empresa de transporte."));

	}

	public void preencgerCampoLinhaEmpresa(String linha) {
		clicar(By.xpath("//*[@text='Nome da linha ou empresa']"));
		escrever(By.xpath("//*[@text='Nome da linha ou empresa']"), linha);

	}

	public void preencgerCampoPrecoPassagem(String tarifaPassagem) {
		clicar(By.xpath("//*[@text='Informe o preço da passagem']"));
		escrever(By.xpath("//*[@text='Informe o preço da passagem']"), tarifaPassagem);

	}

	public void botaoAvancarPrimeiroOnibus() {
		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[2]"));

	}

	public void botaoAvancarSegundoOnibus() {
		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[2]"));

	}

	public void botaoAvancarTerceiroOnibus() {
		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[2]"));

	}

	public void botaoAvancarQuartoOnibus() {
		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[2]"));

	}

	public String verificarTrajetoIdaVoltaTela() {
		return obterTextoAtributo(
				MobileBy.AccessibilityId("Informe se o trajeto é o mesmo de ida e volta do trabalho"));

	}

	public void selecionarIdaVolta(String opcao) {
		clicar(MobileBy.AccessibilityId(opcao));

	}

	public void botaoAvancarIdaVolta() {
		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[3]"));

	}

	public String verificarConfirmarPedidoTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Confirme seu pedido do vale transporte"));
	}

	public String valorTrajetoIdaTela() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[14]"));

	}

	public String valorTrajetoVoltaTela() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[17]"));
	}

	public String valorTotalDiarioTela() {

		return obterTextoAtributo(By.xpath("(//android.view.View)[19]"));

	}

	public String valorDescontoTela() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[21]"));
	}

	public void clicarAbrirInfoDesconto() {
		clicar(By.xpath("(//android.widget.ImageView)[1]"));

	}

	public void clicarFecharInfoDesconto() {

		// clicar(By.xpath("(//android.widget.Button)[1]"));

		tapNormal(53, 53);

	}

	public String verificarTextoInfoDesconto() {
		return obterTextoAtributo(By.xpath("(//android.widget.Button)[1]"));

	}

	public void botaoAvancarTelaConfirmacao() {

		clicar(By.xpath("(//android.widget.LinearLayout//android.view.View//android.widget.Button)[2]"));

	}

	public String verificarAceiteTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Termo de aceite do vale transporte"));
	}

	public void aceitarTermoVale() {
		clicar(By.xpath("//android.widget.CheckBox"));

	}

	public void aceitarTermoBeleficioTicket() {
		clicar(By.xpath("//android.widget.CheckBox"));

	}

	public void botaoFinalizar() {

		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public String verificaConclusaoValeTela() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Vale transporte concluído!"));
	}

	public String verificaPlanoOdontologico() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Plano odontológico"));
	}

	public String verificarTelaOpcaoSalva() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Sua escolha foi salva!"));
	}

	public String verificarTelaPlanoOndologico() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Plano odontológico"));
	}

	public void botaoAvancar() {
		clicar(MobileBy.AccessibilityId("AVANÇAR"));

	}

	public void botaoQueroPlanoOndotologico() {
		clicar(MobileBy.AccessibilityId("ESCOLHER UM PLANO"));

	}

	public void botaoNaoQueroPlanoOndotologico() {
		clicar(MobileBy.AccessibilityId("Não quero plano odontológico"));

	}

	public void botaoEscolherPlano() {
		clicar(MobileBy.AccessibilityId("ESCOLHER UM PLANO"));

	}

	public void lado(double inicio, double fim) {
		swipe(inicio, fim);

	}

	public void lado() {
		swipe(0.4, 0.1);

	}

	public void lado2() {
		swipe(0.5, 0.1);

	}

	public String verificaPlanoOdontologicoEssencialPlus() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Essencial Plus"));
	}

	public String verificaPlanoOdontologicoEssencialTop() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Essencial Top"));
	}

	public String verificaPlanoOdontologicoPremium() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Premium Top"));
	}

	public void paraLadoEsquerdo() {
		swipe(0.1, 0.9);
		swipe(0.1, 0.2);

	}

	public void cliarEssencialPlus() {
		// TODO Auto-generated method stub

	}

	public void clicarNoPlano(String opcao) {

		paraLadoEsquerdo();
		tapNormal(113, 714);

	}

	public void botaoContinuar() {

		clicar(MobileBy.AccessibilityId("CONTINUAR"));
	}

	public String verificarTelaIncluirDependentes() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Dependentes"));
	}

	public String verificarTelaCertidaoNascimento() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Certidão de nascimento"));
	}

	public String verificarTelaComprovanteMatricula() {
		return obterTextoAtributo(
				MobileBy.AccessibilityId("Comprovante de matrícula em Instituição de Ensino Superior"));
	}

	public String verificarTelaCarteitinhaVacinacao() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Carteirinha de vacinação"));
	}

	public void botaoIncluirDependentes() {
		// clicar(MobileBy.AccessibilityId("Adicionar filho e/oudependente"));
		tapNormal(90, 647);

	}

	public void selecionarDependente(String opcao) {
		clicar(MobileBy.AccessibilityId(opcao));

	}

	public void botaoSetaPraBaixo() {

		clicar(By.xpath("(//android.widget.Button)[2]"));
	}

	public void selecionarIdade(String opcao) {
		clicar(MobileBy.AccessibilityId(opcao));

	}

	public void preencherNome(String nome) {
		escrever(By.xpath("//*[@text='Digite aqui']"), nome);

	}

	public void preencherDataNascimento(String data) {
		escrever(By.xpath("//*[@text='DD / MM / AAAA']"), data);

	}

	public void preencherCPF(String CPF) {
		clicar(By.xpath("//android.widget.EditText"));
		escrever(By.xpath("//android.widget.EditText"), CPF);

	}

	public void selecionarDependenteCheck() {
		clicar(By.xpath("//android.widget.CheckBox"));

	}

	public void botaoSetaAvancarSaude() {
		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public void botaoSetaAvancar() {
		clicar(By.xpath("(//android.widget.Button)[5]"));

	}

	public void anexarArquivo() {
		clicar(MobileBy.AccessibilityId("Anexar arquivo"));

	}

	public void selecionarArquivo() throws InterruptedException {

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='arquivoJPG.jpg']")));
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));

	}

	public void botaoFinalizarDependente() {
		clicar(By.xpath("(//android.widget.Button)[2]"));

	}

	public void botaoEnviarArquivo() {
		clicar(MobileBy.AccessibilityId("ENVIAR ARQUIVO"));

	}

	public void checkSelecionarDependente() {
		clicar(By.xpath("//android.widget.CheckBox"));

	}

	public String telaPlanoConfirmacao(String plano) {
		return obterTextoAtributo(MobileBy.AccessibilityId(plano));

	}

	public String telaTermoOndotologico() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Termos de escolha do plano odontológico"));
	}

	public void botaoFinalizarTermo() {
		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public void checkSelecionarTermo() {
		clicarCheck(By.xpath("//android.widget.CheckBox"));

	}

	public String telaPlanoOndotologicoConcluido() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Plano odontológico concluído!"));
	}

	public String telaPlanoTickets() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Ticket restaurante e alimentação"));
	}

	public void botaoAvancarDependente() {
		clicar(By.xpath("(//android.widget.Button)[3]"));

	}
	
	public void botaoAvancarDependenteSaude() {
		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public void botaoAvancarConfirmacao() {
		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public void botaoCustomizarBeneficios() {
		clicar(MobileBy.AccessibilityId("CUSTOMIZAR BENEFÍCIO"));

	}

	public String TicketAlimentacao() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Valor integral como Ticket Alimentação"));

	}

	public String TicketRestaurante() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Valor integral como Ticket Restaurante"));

	}

	public void selecaoBeneficioTicket(String opcaoTicket) {

		switch (opcaoTicket) {

		case "Alimentação":

			clicar(MobileBy.AccessibilityId("Valor integral como Ticket Alimentação"));
			// clicar(By.xpath("(//android.widget.Button)[2]"));

			break;

		case "Restaurante":

			clicar(MobileBy.AccessibilityId("Valor integral como Ticket Restaurante"));
			// clicar(By.xpath("(//android.widget.Button)[2]"));

			break;

		}

	}

	public String telaConfirmacaoTicket() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Confirme sua escolha"));

	}

	public String opcaoConfirmacaoTicket(String opcaoTicket) {

		String valor = "nada";

		switch (opcaoTicket) {

		case "Ticket Alimentação":

			valor = obterTextoAtributo(MobileBy.AccessibilityId("Ticket Alimentação"));

			break;

		case "Ticket Restaurante":

			valor = obterTextoAtributo(MobileBy.AccessibilityId("Ticket Restaurante"));

			break;

		}

		return valor;

	}

	public String termoEscolhaTicket() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Termos de escolha do benefício"));
	}

	public String verificarTelasTicketSalvo() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Sua escolha foi salva!"));

	}

	public void botaoAvancarBeneficioTicket() {

		clicar(By.xpath("(//android.widget.Button)[3]"));
	}

	public void botaoAvancarTelaSalva() {
		clicar(MobileBy.AccessibilityId("AVANÇAR"));

	}

	public String telaGympass() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Gympass"));
	}

	public String obterTextoGympassCarrossel01() {
		return obterTextoAtributo(By.xpath("(//android.widget.ImageView)[1]"));

	}

	public String obterTextoGympassCarrossel02() {
		return obterTextoAtributo(By.xpath("(//android.widget.ImageView)[2]"));

	}

	public String obterTextoGympassCarrossel03() {
		return obterTextoAtributo(By.xpath("(//android.widget.ImageView)[3]"));

	}

	public String obterTextoGympassCarrossel04() {
		return obterTextoAtributo(By.xpath("(//android.widget.ImageView)[2]"));

	}

	public String obterTextoGympassCarrossel05() {
		return obterTextoAtributo(By.xpath("(//android.widget.ImageView)[2]"));
	}

	public String obterTextoGympassPasso1() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[3]"));
	}

	public String obterTextoGympassPasso2() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[4]"));
	}

	public String obterTextoGympassPasso3() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[5]"));
	}

	public String obterTextoGympassPasso4() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[6]"));
	}

	public String obterTextoGympassPasso5() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[7]"));
	}

	public String obterTextoGympassPasso6() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[8]"));
	}

	public String textoSalvo() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[7]"));
	}

	public String obterTextoDeenvioEmail() {
		return obterTextoAtributo(By.xpath("(//android.view.View)[8]"));
	}

	public String tituloDoPlanoSaude() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[2]"));
	}

	public String texto01DoPlanoSaude() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[3]"));
	}

	public String texto02DoPlanoSaude() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[4]"));
	}

	public String texto03DoPlanoSaude() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[5]"));
	}

	public String texto04DoPlanoSaude() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[6]"));
	}

	public String texto05DoPlanoSaude() {
		return obterTextoAtributo(By.xpath("(//android.widget.ScrollView/android.view.View)[7]"));
	}

	public void clicarBotaoAdicionarDependentes() {
		clicar(MobileBy.AccessibilityId("ADICIONAR DEPENDENTES"));

	}

	public String textoSaudeDoCarrossel01() {
		return obterTextoAtributo(By.xpath(
				"(//android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.ImageView)[1]"));
	}

	public String textoSaudeDoCarrossel02() {
		return obterTextoAtributo(By.xpath(
				"(//android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.ImageView)[2]"));
	}

	public String textoSaudeDoCarrossel03() {
		return obterTextoAtributo(By.xpath(
				"(//android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.ImageView)[3]"));
	}

	public String textoSaudeDoCarrossel04() {
		return obterTextoAtributo(By.xpath(
				"(//android.view.View/android.widget.ScrollView/android.view.View/android.view.View/android.widget.ImageView)[2]"));
	}

	public String tituloPlanoSelecionadoSaude1() {
		return obterTextoAtributo(
				MobileBy.AccessibilityId("Haverá um desconto integral na folha de pagamento mensal."));
	}

	public String tituloPlanoSelecionadoSaude() {
		return obterTextoAtributo(
				By.xpath("(//android.view.View/android.view.View/android.view.View/android.view.View)[8]"));
	}

	public String textoPlanoSelecionadoSaude() {
		return obterTextoAtributo(
				By.xpath("(//android.view.View/android.view.View/android.view.View/android.view.View)[9]"));
	}

	public String textoTipoPlanoSelecionadoSaude() {
		return obterTextoAtributo(
				By.xpath("(//android.view.View/android.view.View/android.view.View/android.view.View)[10]"));
	}

	public String nomeCadastradoNoPlano() {
		return obterTextoAtributo(
				By.xpath("(//android.view.View/android.view.View/android.view.View/android.view.View)[12]"));
	}

	public String valorDescontoMensalPlanoSaude() {
		return obterTextoAtributo(
				By.xpath("(//android.view.View/android.view.View/android.view.View/android.view.View)[13]"));
	}

	public String verificarEtapasConcluidas() {
		String etapasConcluidas = obterTextoAtributo(By.xpath("(//android.view.View/android.widget.ImageView)[2]"));
		return etapasConcluidas.replaceAll("\\n", " ");

	}

	public String verificarTextoTermoSaude() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Termos de escolha do benefício"));

	}

	public void clicarTermoSaude() {
		clicar(By.xpath("//android.widget.CheckBox"));

	}

	public void clicarBotaoAceitar() {
		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public String verificarTelaConcluidoPlanoSaude() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Plano de saúde concluído!"));
	}

}
