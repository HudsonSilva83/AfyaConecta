package br.com.conecta.afya.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.conecta.afya.core.BasePage;
import br.com.conecta.afya.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class EnviarDocumentacaoPage extends BasePage {

	public void descerTela() throws InterruptedException {

		scroll(0.6, 0.1);

	}

	public boolean validarTela(String texto) {
		return existeElementoPorAtributo(MobileBy.AccessibilityId("Seu processo de admissão"), "content-desc", texto);

	}

	public void botaoEnviarDocumentos() throws InterruptedException {
		descerTela();
		
		clicar(MobileBy.AccessibilityId("ENVIAR DOCUMENTOS"));
	}

	public String validarTelaDocumentosNecessarios() {

		return obterTextoAtributo(MobileBy.AccessibilityId(
				"Você só pode concluir o processo se estiver com os documentos abaixo, com exceção do que não se aplica"));

	}

	public void botaoContinuar() throws InterruptedException {
		descerTela();
		descerTela();
		clicar(MobileBy.AccessibilityId("CONTINUAR"));
		descerTela();

	}

	public void botaoEnviar() throws InterruptedException {

		// Thread.sleep(4000);
		// scroll(0.9, 0.1);

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("ENVIAR")));

		clicar(MobileBy.AccessibilityId("ENVIAR"));
	}

	public void botaoAnexarArquivo() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Anexar arquivo")));

		clicar(MobileBy.AccessibilityId("Anexar arquivo"));

	}

	public void selecionarArquivoeSocial() throws InterruptedException {

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='arquivoJPG.jpg']")));
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));

		descerTela();

	}

	public void botaoEnviarArquivo() throws InterruptedException {
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("ENVIAR ARQUIVO")));

		clicar(MobileBy.AccessibilityId("ENVIAR ARQUIVO"));

	}

	public void botaoIdentidade() {
		clicar(MobileBy.AccessibilityId("ENVIAR"));

	}

	public void preencherRG(String RG) {
		escrever(By.xpath("//*[@text='Digite aqui']"), RG);

	}

	public void preencherOrgaoEmissor(String RG) {
		escrever(By.xpath("//*[@text='Digite aqui']"), RG);

	}

	public void botaoSetaBaixo() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 25);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[2]")));

		clicar(By.xpath("(//android.widget.Button)[2]"));

	}

	public void preencherDataEmissaoRG(String dataEmissaoRG) {
		escrever(By.xpath("//*[@text='DD / MM / AAAA']"), dataEmissaoRG);

	}

	public void preencherIdentidadeUF(String identidadeUF) {
		escrever(By.xpath("//*[@text='Digite aqui']"), identidadeUF);

	}

	public void preencherIdentidadeNacionalidade(String nacionalidade) {
		escrever(By.xpath("//*[@text='Digite aqui']"), nacionalidade);

	}

	public void preencherIdentidadeEstadoNatal(String estadoNatal) {
		escrever(By.xpath("//*[@text='Digite aqui']"), estadoNatal);

	}

	public void preencherIdentidadeCidadeNatal(String cidadeNatal) {
		escrever(By.xpath("//*[@text='Digite aqui']"), cidadeNatal);

	}

	public void preencherIdentidaDataNascimento(String dataNascimento) {
		escrever(By.xpath("//*[@text='DD / MM / AAAA']"), dataNascimento);

	}

	public void preencherIdentidaNomeMae(String nomeMae) {
		escrever(By.xpath("//*[@text='Digite aqui']"), nomeMae);

	}

	public void botaoCheckFinalizar() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[2]")));

		clicar(By.xpath("(//android.widget.Button)[2]"));

	}

	public void botaoAnexarIdentidade() {
		clicar(By.xpath("(//android.widget.ImageView)[7]"));

	}

	public void pegarArquivoIdentidadeFrente() throws InterruptedException {

		Thread.sleep(1000);
		// scroll(0.9, 0.1);
		// Thread.sleep(1000);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));

	}

	public void pegarArquivoIdentidadeVerso() throws InterruptedException {
		// scroll(0.9, 0.1);
		Thread.sleep(1000);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));

	}

	public void preencherNumeroCarteiraTrabalho(String numCarteiraTrabalho) {
		escrever(By.xpath("//*[@text='Digite aqui']"), numCarteiraTrabalho);

	}

	public void preencherNumeroSerieCarteiraTrabalho(String serieCarteiraTrabalho) {
		escrever(By.xpath("//*[@text='Digite aqui']"), serieCarteiraTrabalho);

	}

	public void preencherUFCarteiraTrabalho(String ufCarteiraTrabalho) {
		escrever(By.xpath("//*[@text='Digite aqui']"), ufCarteiraTrabalho);

	}

	public void preencherDataEmissaoCTPS(String dataEmissaoCTPS) {
		escrever(By.xpath("//*[@text='DD / MM / AAAA']"), dataEmissaoCTPS);

	}

	public void pegarArquivoCTPSFrente() {
		// scroll(0.8, 0.5);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));

	}

	public void pegarArquivoCTPSDados() {
		// scroll(0.8, 0.5);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));

	}

	public void clicarAlterar() {

		clicar(By.xpath("(//android.widget.ImageView)[7]"));

	}

	public void preencherCep(String CEP) {
		escrever(By.xpath("//*[@text='Digite aqui']"), CEP);

	}

	public void enderecoVisivel() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("BELO HORIZONTE,")));

	}

	public void preencherComplemento(String complemento) {

		clicar(By.xpath("//*[@text='Apto, bloco, sala etc.']"));
		escrever(By.xpath("//*[@text='Apto, bloco, sala etc.']"), complemento);

	}

	public void preencherNumeroEndereco(String numeroEndereco) {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Digite aqui']")));

		clicar(By.xpath("//*[@text='Digite aqui']"));
		escrever(By.xpath("//*[@text='Digite aqui']"), numeroEndereco);

	}

	public void anexarComprovanteResidencia() {

		botaoAnexarArquivo();
		// scroll(0.8, 0.1);
		// clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));

	}

	public void selecionarArquivoJPG() {

		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));

	}

	public void selecionarArquivoPDF() {

		clicar(By.xpath("//*[@text='arquivoPDF.pdf']"));

	}

	public void anexarArquivoJpg() throws InterruptedException {

		botaoAnexarArquivo();
		// scroll(0.8, 0.1);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));
		Thread.sleep(2000);
		// scroll(0.8, 0.1);

	}

	public void anexarArquivoPDF() throws InterruptedException {

		botaoAnexarArquivo();
		// scroll(0.8, 0.1);
		clicar(By.xpath("//*[@text='arquivoPDF.pdf']"));
		Thread.sleep(2000);
		scroll(0.8, 0.1);
		botaoEnviarArquivo();

	}

	public void botaoSelecionar() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("SELECIONAR")));
		clicar(MobileBy.AccessibilityId("SELECIONAR"));

	}

	public void selecionarEstadoCivil(String estadoCivil) throws InterruptedException {

		clicar(MobileBy.AccessibilityId(estadoCivil));
		// Thread.sleep(1000);
		// botaoAvancarTela();

	}

	public void anexarCertidaoCasamento() throws InterruptedException {
		botaoAnexarArquivo();
		// scroll(0.8, 0.1);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));
		scroll(0.8, 0.1);
		botaoEnviarArquivo();

	}

	public void botaoPreencherPis() throws InterruptedException {

		clicar(MobileBy.AccessibilityId("PREENCHER PIS"));
		// escrever(By.xpath("//*[@text='Digite aqui o número']"), pis);
		// Thread.sleep(4000);
		// botaoCheckFinalizar();

	}

	public void preencherNumeroPis(String numeroPIS) throws InterruptedException {

		escrever(By.xpath("//*[@text='Digite aqui o número']"), numeroPIS);
		// Thread.sleep(4000);
		// botaoCheckFinalizar();

	}

	public void preeencherTituloEleitor(String numeroTitulo) throws InterruptedException {

		// scroll(0.8, 0.1);
		escrever(By.xpath("//*[@text='Digite aqui']"), numeroTitulo);
		Thread.sleep(2000);
		botaoCheckFinalizar();

	}

	public void preeencherDataEmissaoTituloEleitor(String dataTitulo) {
		escrever(By.xpath("//*[@text='DD / MM / AAAA']"), dataTitulo);
		botaoSetaBaixo();

	}

	public void preeencherUFTituloEleitor(String tituloUF) {
		escrever(By.xpath("//*[@text='Digite aqui']"), tituloUF);
		botaoSetaBaixo();

	}

	public void preeencherZonaVotacao(String zonaVotacao) {

		escrever(By.xpath("//*[@text='Digite aqui']"), zonaVotacao);
		botaoSetaBaixo();

	}

	public void preeencherSecaoVotacao(String secao) {
		escrever(By.xpath("//*[@text='Digite aqui']"), secao);
		botaoSetaBaixo();
		botaoCheckFinalizar();

	}

	public void enviarTitulo() throws InterruptedException {

		botaoAnexarArquivo();
		// scroll(0.8, 0.1);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));
		scroll(0.8, 0.1);
		botaoEnviarArquivo();

	}

	public void comprovanteVotacao() throws InterruptedException {
		Thread.sleep(9000);
		botaoAnexarArquivo();
		// scroll(0.8, 0.1);
		clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));
		scroll(0.8, 0.1);
		botaoEnviarArquivo();

	}

	public void botaoAvancarTela() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[2]")));

		clicar(By.xpath("(//android.widget.Button)[2]"));

	}

	public void anexarCertificadoReservista() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Certificado de reservista")));

		Thread.sleep(6000);

		botaoAnexarArquivo();
		clicar(By.xpath("//*[@text='arquivoPDF.pdf']"));
		scroll(0.8, 0.1);
		botaoEnviarArquivo();
	}

	public void informarDiplomaEscolaridade() throws InterruptedException {

		Thread.sleep(2000);
		clicar(MobileBy.AccessibilityId("ENVIAR"));

	}

	public void selecionarGrauInstrucao(String grauInstrucao) {
		clicar(MobileBy.AccessibilityId(grauInstrucao));
		botaoAvancarTela();

	}

	public void anexarDiplomaEscolaridade() throws InterruptedException {

		botaoAnexarArquivo();
		clicar(By.xpath("//*[@text='arquivoPDF.pdf']"));
		scroll(0.8, 0.1);
		botaoEnviarArquivo();

	}

	public void anexarComprovanteConta() throws InterruptedException {

		botaoAnexarArquivo();
		clicar(By.xpath("//*[@text='arquivoPDF.pdf']"));
		scroll(0.8, 0.1);
		botaoEnviarArquivo();
	}

	public void informarDependentes(String dependentes) throws InterruptedException {
		Thread.sleep(6000);
		scroll(0.8, 0.1);
		clicar(MobileBy.AccessibilityId(dependentes));

	}

	public void adicionarConta() {
		clicar(MobileBy.AccessibilityId("ADICIONAR CONTA"));

	}

	public void informarDadosConta(String banco, String agencia, String contaNumero) {

		escrever(By.xpath("//*[@text='Digite aqui seu banco']"), banco);
		botaoSetaBaixo();

		escrever(By.xpath("//*[@text='Digite aqui sua agência']"), agencia);
		botaoSetaBaixo();

		escrever(By.xpath("//*[@text='Qual é a sua conta?']"), contaNumero);
		botaoCheckFinalizar();

	}

	public void verificarEtapa() throws InterruptedException {
		// verificar a tela final
		Thread.sleep(2000);
		// aqui posso tenta colocar o explicito
		scroll(0.6, 0.2);
		scroll(0.9, 0.1);
		Thread.sleep(5000);
		scroll(0.9, 0.1);
		scroll(0.9, 0.1);
		scroll(0.9, 0.1);
		scroll(0.9, 0.1);

	}

	public void aceitarTermo() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.CheckBox")));

		clicar(By.xpath("//android.widget.CheckBox"));

	}

	public void concluirEnvio() {

		clicar(MobileBy.AccessibilityId("CONCLUIR ENVIO"));
	}

	public String mensagm() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Li e aceito os termos de envio das informações presentes"));

	}

	public void botaoIrHomePage() {
		clicar(MobileBy.AccessibilityId("IR PARA HOME"));

	}

	public String verificaMensagemDocumentosEnviados() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Documentos enviados"));

	}

	public String telaDocumentosNecessarios() {
		return obterTextoAtributo(MobileBy.AccessibilityId(
				"Você só pode concluir o processo se estiver com os documentos abaixo, com exceção do que não se aplica"));

	}

	public String verificarTelaIdentidade() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Documento de identidade"));
	}

	public String verificarTelaConfirmacaoRG() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Confirmação do RG"));
	}

	public String verificarMensagemCarteiraTrabalho(String mensagem) {

		return obterTextoAtributo(MobileBy.AccessibilityId(mensagem));
	}

	public String verificarMensagemCertidaoNascimento(String mensagem) {

		return obterTextoAtributo(MobileBy.AccessibilityId(mensagem));
	}

	public String verificarMensagemCertificadoReservista(String mensagem) {

		return obterTextoAtributo(MobileBy.AccessibilityId(mensagem));
	}

	public String verificarMensagemDiploma(String mensagem) {

		return obterTextoAtributo(MobileBy.AccessibilityId(mensagem));
	}

	public String verificarMensagemEnvioTitulo(String mensagem) {

		return obterTextoAtributo(MobileBy.AccessibilityId(mensagem));
	}

	public String verificarMensagemComprovante(String mensagem) {

		return obterTextoAtributo(MobileBy.AccessibilityId(mensagem));
	}

	public String verificarTelaFoto3x4() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Foto 3x4"));

	}

	public String verificarTelaEstadoCivil() {
		return obterTextoAtributo(MobileBy.AccessibilityId(
				"Selecione o seu estado civil, assim indicaremos os documentos necessários para envio."));

	}

	public String verificarTelaPIS() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Informe o seu número PIS"));

	}

	public String verificarTelaeSocial() {
		return obterTextoAtributo(MobileBy.AccessibilityId("eSocial"));

	}

	public String verificarMensagemFoto3X4(String mensagem) {
		return obterTextoAtributo(MobileBy.AccessibilityId(mensagem));

	}

	public String verificarTelaQualidadeFoto() {

		return obterTextoAtributo(MobileBy.AccessibilityId(
				"Fique atento na qualidade das fotos dos documentos que vamos solicitar nos próximos passos."));

	}

	public String verificarTelaCertidaoNascimento() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Certidão de nascimento"));

	}

	public String verificarTelaCertificadoReservista() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Certificado de reservista"));

	}

	public String verificarTelaDiplomaComprovante() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Diploma ou comprovante de escolaridade"));

	}

	public String verificarTelaTituloEleitor() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Título de eleitor"));

	}

	public String verificarTelaAnexarTituloEleitor() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Envio do título"));

	}

	public String verificarTelaComprovanteUltimaVotacao() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Comprovante da última votação"));

	}

	public String verificarTelaCarteiraTrabalho() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Carteira de trabalho"));

	}

	public String verificarTelaConfirmacaoCarteiraTrabalho() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Confirmação carteira de trabalho"));

	}

	public String verificarTelaEndereco() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Endereço"));

	}

	public String verificarTelaComprovanteResidencia() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Comprovante de residência"));

	}

	public String verificarTelaDeclaracaoDependentes() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Declaração de dependentes"));

	}

	public String verificaMensagemDocumentoEnviado(String mensagem) {

		return obterTextoAtributo(MobileBy.AccessibilityId(mensagem));
	}

	public String verificarTelaDiploma() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Selecione seu grau de instrução"));

	}

	public String obterNumeroRGTela(String numeroRG) {
		return obterTextoAtributo(MobileBy.AccessibilityId(numeroRG));

	}

	public String obterCertidaoCasamentoNascimentoTela(String certidaoCasNasc) {
		return obterTextoAtributo(MobileBy.AccessibilityId(certidaoCasNasc));

	}

	public String obterCertificadoReservistaTela(String certificadoReservista) {
		return obterTextoAtributo(MobileBy.AccessibilityId(certificadoReservista));

	}

	public String obterTituloEleitorTela(String tituloEleitor) {
		return obterTextoAtributo(MobileBy.AccessibilityId(tituloEleitor));

	}

	public String obterComprovanteEleitoralTela(String tituloEleitor) {
		return obterTextoAtributo(MobileBy.AccessibilityId(tituloEleitor));

	}

	public String obterGrauInstituicaoTela(String grauInstituicao) {
		return obterTextoAtributo(MobileBy.AccessibilityId(grauInstituicao));

	}

	public String obternumeroTituloTela(String numeroTitulo) {
		return obterTextoAtributo(MobileBy.AccessibilityId(numeroTitulo));

	}

	public String obterDataEmissaoTituloTela(String dataTitulo) {
		return obterTextoAtributo(MobileBy.AccessibilityId(dataTitulo));

	}

	public String obterUfTituloTela(String ufTitulo) {
		return obterTextoAtributo(MobileBy.AccessibilityId(ufTitulo));

	}

	public String obterSecaoTituloTela(String secaoTitulo) {
		return obterTextoAtributo(MobileBy.AccessibilityId(secaoTitulo));

	}

	public String obterZonaTituloTela(String zonaTitulo) {
		return obterTextoAtributo(MobileBy.AccessibilityId(zonaTitulo));

	}

	public String verificarAnexoRGCNH() {

		return obterTextoAtributo(MobileBy.AccessibilityId("RG ou CNH"));
	}

	public String obternumeroCarteiraTrabalhoTela(String numeroTitulo) {
		return obterTextoAtributo(MobileBy.AccessibilityId(numeroTitulo));

	}

	public String obterufCarteiraTrabalhoTela(String numeroTitulo) {
		return obterTextoAtributo(MobileBy.AccessibilityId(numeroTitulo));

	}

	public String obterserieCarteiraTrabalhoTela(String numeroTitulo) {
		return obterTextoAtributo(MobileBy.AccessibilityId(numeroTitulo));

	}

	public String obterdataEmissaoCTPSTela(String numeroTitulo) {
		return obterTextoAtributo(MobileBy.AccessibilityId(numeroTitulo));

	}

	public String obterNumeroPISTela(String numeroPIS) {

		return obterTextoAtributo(MobileBy.AccessibilityId(numeroPIS));
	}

	public String obterComprovanteResidenciaTela(String comprovanteResidencia) {

		return obterTextoAtributo(MobileBy.AccessibilityId(comprovanteResidencia));
	}

	public String obterCEPTela(String cep) {
		return obterTextoAtributo(MobileBy.AccessibilityId(cep));
	}

	public String obterEnderecoTela(String endereco) {
		return obterTextoAtributo(MobileBy.AccessibilityId(endereco));
	}

	public String obterFoto3X4Tela(String foto) {
		return obterTextoAtributo(MobileBy.AccessibilityId(foto));
	}

	public String verificarTelaDeclaracaoEnvio() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Leia e aceite os termos de envio dos documentos"));
	}

	public String verificarTelaDocumentosEnviados() {

		return obterTextoAtributo(MobileBy.AccessibilityId("Documentos enviados"));
	}
	
	public String verificarEtapasConcluidas() {
		String etapasConcluidas =  obterTextoAtributo(By.xpath("(//android.view.View/android.widget.ImageView)[2]"));
		return etapasConcluidas.replaceAll("\\n", " ");
		
	}

}
