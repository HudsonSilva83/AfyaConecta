package br.com.conecta.afya.page;

import java.util.ArrayList;

import org.openqa.selenium.By;

import br.com.conecta.afya.core.BasePage;
import br.com.conecta.afya.core.DriverFactory;
import io.appium.java_client.MobileBy;
import sun.security.util.Length;

public class CadastroPage extends BasePage {

	public void clicarForaCaixa() {

		clicarTap(177, 398);

	}

	public void clicarJaTenhoUmaConta() {

		clicar(MobileBy.AccessibilityId("Já tenho uma conta"));
	}

	public void botaoAvancarCPF() {

		clicar(By.xpath("(//android.widget.LinearLayout//android.widget.Button)[2]"));

	}

	public void botaoAvancarSenha() {

		clicar(By.xpath("(//android.widget.FrameLayout//android.widget.Button)[2]"));

	}

	public void Atualizar() {

		clicar(MobileBy.AccessibilityId("Atualizar"));

	}

	public void preencherSenha(String senha) {

		escrever(By.xpath("//*[@text='Digite uma senha']"), senha);

	}

	public void tap() {

		clicarTap(500, 944);

	}

	public String obterTextoCadastro() {

		return atributoClass(MobileBy.AccessibilityId("Seu processo de admissão"), "content-desc");

	}

	public boolean verificarTextoPreCadastro(String texto) {

		return existeElementoPorAtributo(MobileBy.AccessibilityId(texto), "content-desc", texto);

	}

	public void alterarNome(String nome) throws InterruptedException {

		// descerTela();
		clicar(By.xpath("(//android.widget.ImageView)[1]"));
		limpar(By.xpath("//*[@text='Nome Teste']"));
		// limpar(By.xpath("//*[@text='HudsonSilva']"));

		escrever(By.xpath("//*[@text='Digite aqui']"), nome);
		botaoConfirmar();

	}

	public void botaoConfirmar() {

		clicar(MobileBy.AccessibilityId("CONFIRMAR"));

	}

	public void alterarEmail(String email) throws InterruptedException {

		clicar(By.xpath("(//android.widget.ImageView)[2]"));
		// limpar(By.xpath("//*[@text='conectateste001@gmail.com']"));
		limpar(By.xpath("//android.widget.EditText"));
		escrever(By.xpath("//*[@text='Digite aqui']"), email);
		Thread.sleep(1000);

	}

	public void alterarTelefone(String telefone) throws InterruptedException {

		clicar(By.xpath("(//android.widget.ImageView)[4]"));
		// limpar(By.xpath("//*[@text='(03) 19941-4365']"));
		escrever(By.xpath("//*[@text='Digite aqui']"), telefone);
		botaoConfirmar();
		// scroll(0.6, 0.1);

	}

	public void lapisAltearTelefone() {

		clicar(By.xpath("(//android.widget.ImageView)[4]"));

	}

	public void descerTela() {

		scroll(0.9, 0.2);

	}

	public void descerTelaTeste() {

		scroll(0.9, 0.6);

	}

	public void aceitarTermosCondicoes() {
		clicar(By.xpath("//android.widget.CheckBox"));

	}

	public boolean verificarCampoPreenchido(String texto) {

		return existeElementoPorAtributo(MobileBy.AccessibilityId(texto), "content-desc", texto);

	}

	public boolean verificarCampoCelularPreenchido() {

		return existeElementoPorAtributo(By.xpath("//*[@text='Digite aqui']"), "text", "Digite aqui");

	}

	public void assinar() {
		clicar(By.xpath("(//android.widget.ScrollView)[1]"));

	}

	public void botaoAvancarAssinatura() {

		// descerTela();
		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public String telaBemvindo(String idTexto) {
		return obterTextoAtributo(MobileBy.AccessibilityId(idTexto));

	}

	public String obterValorCampoNomeCompleto() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Nome Teste"));

	}

	public String obterValorCampoEmail() {
		return obterTextoAtributo(MobileBy.AccessibilityId(""));

	}

	public String obterValorCampoCelular() {
		return obterTextoAtributo(MobileBy.AccessibilityId("(00) 00000-0000"));

	}

	public String obterValorCampoCargo() {
		return obterTextoAtributo(MobileBy.AccessibilityId("ANALISTA DE DADOS PL"));

	}

	public String obterValorCampoUnidade() {
		return obterTextoAtributo(MobileBy.AccessibilityId("AFYA"));

	}

	public String verificarMensagemCadastroSucesso(String mensagem) {

		return obterTextoAtributo(MobileBy.AccessibilityId(mensagem));
	}

	public String verificarMensagemErro(String mensagem) {

		return obterTextoAtributo(MobileBy.AccessibilityId(mensagem));
	}

	public void botaoLimpar() {
		clicar(MobileBy.AccessibilityId("Limpar assinatura"));

	}

	public boolean verificarBotaoDesabilitadoAvancarAssinatura() {
		return obterAtributoHabilitadoClicavel(By.xpath("(//android.widget.Button)[3]"), "false");

	}

	public void botaoPularNomeSocial() {
		clicar(MobileBy.AccessibilityId("Não possuo nome social"));

	}

	public void botaoPularApelido() {
		clicar(MobileBy.AccessibilityId("Pular etapa"));

	}

	public String verificarEtapa(String etapa) {

		return obterTextoAtributo(MobileBy.AccessibilityId(etapa));
	}

	public void botaoVoltarEtapa() {

		clicar(By.xpath("(//android.widget.Button)[1]"));

	}

	public String verificarTextoCampo(String textoCampo) {

		return obterTexto(By.xpath("//*[@text='" + textoCampo + "']"));
	}

	public void botaoAvancarTela() {

		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public boolean verificarOpcaoRadioSelecionado(String opcao) {

		return verificarRadio(MobileBy.AccessibilityId(opcao));
	}

	public boolean botaoConfirmarDesabilitado() {

		return verificarBotaoDesabilitado(MobileBy.AccessibilityId("CONFIRMAR"));
	}

	public void selecaoBadeiraNacionalidade(String Pais) throws InterruptedException {
		Thread.sleep(3000);
		clicar(By.xpath("(//android.widget.ImageView)[1]"));
		Thread.sleep(1000);

		switch (Pais) {
		case "Brasil":

			clicar(By.xpath("(//android.widget.ImageView)[1]"));

			break;

		case "Espanha":

			clicar(By.xpath("(//android.widget.ImageView)[2]"));

			break;

		case "Estados Unidos":

			clicar(By.xpath("(//android.widget.ImageView)[3]"));

			break;

		case "Mexico":

			clicar(By.xpath("(//android.widget.ImageView)[4]"));

			break;

		}

	}

	public void preencherCampoCelular(String mascara) {

		clicar(By.xpath("//*[@text='Digite aqui']"));
		escrever(By.xpath("//*[@text='Digite aqui']"), mascara);

	}

	public String verificarQuantCampoCelular() throws InterruptedException {
		Thread.sleep(1000);
		String mascara = obterTextoAtributoText(By.xpath("(//android.widget.EditText)[1]"));
		// String mascara = obterTextoAtributoText(By.xpath("//*[@text='(01)
		// 11111-1111']"));

		int quantidade = mascara.length();
		String quant = Integer.toString(quantidade);
		return quant;
	}

	public String obterMensagem(String mensagemSenhaFraca) {

		return obterTextoAtributo(MobileBy.AccessibilityId(mensagemSenhaFraca));

	}

	public void apagarCampoSenha(String valor) {

		limpar(By.xpath("//*[@text='" + valor + "']"));

	}

	public void clicarVisualizar() {
		clicar(By.xpath("(//android.widget.ImageView)[1]"));

	}

	public boolean verificarBotaoAvancarDesabilitado() {
		return verificarBotaoDesabilitado(By.xpath("(//android.widget.Button)[2]"));

	}

	public String verificarEtapasConcluidas() {
		String etapasConcluidas = obterTextoAtributo(By.xpath("(//android.view.View/android.widget.ImageView)[2]"));
		return etapasConcluidas.replaceAll("\\n", " ");

	}

}
