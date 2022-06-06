package br.com.conecta.afya.page;

import org.openqa.selenium.By;

import br.com.conecta.afya.core.BasePage;
import io.appium.java_client.MobileBy;

public class InformacoesPessoaisPage extends BasePage {

	public boolean verificarTextoTelaInformacoesPessoais(String texto) {

		return existeElementoPorAtributo(MobileBy.AccessibilityId(texto), "content-desc", texto);

	}

	public void preencherCampoNomeSocial(String nomeSocial) {

		escrever(By.xpath("//*[@text='Digite seu nome social']"), nomeSocial);

	}

	public void botaoAvancarTela() {

		clicar(By.xpath("(//android.widget.Button)[3]"));

	}

	public void preencherCampoApelido(String apelido) {
		escrever(By.xpath("//*[@text='Digite seu apelido']"), apelido);
		botaoAvancarTela();

	}

	public void possueCertificadoReservista(String opcaoReservista) {

		clicar(MobileBy.AccessibilityId(opcaoReservista));
		botaoAvancarTela();
		scroll(0.9, 0.1);

	}

	public void selecionarIdentidadeGenero(String opcaoIdentidadeGenero) throws InterruptedException {
		clicar(MobileBy.AccessibilityId(opcaoIdentidadeGenero));
		botaoAvancarTela();
		Thread.sleep(1000);
		scroll(0.5, 0.1);

	}

	public void selecionarRaca(String opcaoRaca) {
		scroll(0.6, 0.1);

		clicar(MobileBy.AccessibilityId(opcaoRaca));
		botaoAvancarTela();

	}

	public void selecionarDeficiencia(String opcaoDeficiencia) throws InterruptedException {
		scroll(0.9, 0.1);

		clicar(MobileBy.AccessibilityId(opcaoDeficiencia));

	}

	public String telaCadastradoSucesso() {

		return obterAtributoHabilitado(By.xpath("//android.widget.FrameLayout"));

	}

	public void telaCadastroComSucesso() {
		clicarLongo(By.xpath("//android.widget.ImageView"));

	}

	public void botaoPularApresentacao() {

		clicar(MobileBy.AccessibilityId("Pular apresentação"));

	}

}
