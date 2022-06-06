package br.com.conecta.afya.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.conecta.afya.core.BasePage;
import br.com.conecta.afya.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class DadosBancariosPage extends BasePage {

	public void scrollar(double inicio, double fim) {

		scroll(inicio, fim);

	}

	public void clicarBotaoEnviarDepois() {
		clicar(MobileBy.AccessibilityId("ENVIAR DEPOIS"));
		
	}

	public String verificarBotaoTela() {
		
			return obterTextoAtributo(MobileBy.AccessibilityId(
					"ENVIAR DADOS BANCÁRIOS"));

		}
	
	
	public String verificarContaDeBancoTela() {
		
		return obterTextoAtributo(MobileBy.AccessibilityId(
				"Coloque uma conta bancária de sua escolha"));

	}

	public void clicarBotaoComecar() {
		clicar(MobileBy.AccessibilityId("COMEÇAR"));
		
	}

	public void clicarLinkAdicionarContaumaDepois() {
		clicar(MobileBy.AccessibilityId("Adicionar uma conta depois"));
		
	}

	public void clicarAdicionarConta() {
		clicar(MobileBy.AccessibilityId("ADICIONAR CONTA"));
		
	}
	
	
	public String verificarTelaInformarBanco() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Qual o seu banco?"));

	}
	
	public String verificarTelaInformarAgencia() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Qual é a sua agência?"));

	}
	
	
	public String verificarTelaComprovanteConta() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Comprovante de conta"));

	}
	
	
	
	public void botaoAvancar(){
		
		clicar(By.xpath("(//android.widget.Button)[2]"));
		
		
		
	}

	public void preeencherCampoBanco(String nomebanco) {
		
	 escrever(By.xpath("//*[@text='Digite aqui seu banco']"),nomebanco );
		
	}
	
	public void preeencherCampoAgencia(String nomeAgencia) {
		
		 escrever(By.xpath("//*[@text='Digite aqui sua agência']"),nomeAgencia );
			
		}
	
	public void preeencherCampoConta(String nomeConta) {
		
		 escrever(By.xpath("//*[@text='Qual é a sua conta?']"),nomeConta );
			
		}
	
	
	
	public void botaoCheckFinalizar() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.Button)[2]")));

		clicar(By.xpath("(//android.widget.Button)[2]"));

	}
	
	
	
	public void botaoAnexarArquivo() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Anexar arquivo")));

		clicar(MobileBy.AccessibilityId("Anexar arquivo"));

	}

	public void selecionarArquivo() throws InterruptedException {
		

			Thread.sleep(1000);
			// scroll(0.9, 0.1);
			// Thread.sleep(1000);
			clicar(By.xpath("//*[@text='arquivoJPG.jpg']"));

		}

	public String verificarTelaInformarConta() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Qual é a sua conta?"));
		
	}

	public String verificarTelaDadosBancariosCadastrados() {
		return obterTextoAtributo(MobileBy.AccessibilityId("Dados bancários cadastrados"));
		
	}

	public void enviarArquivo() {
		clicar(MobileBy.AccessibilityId("ENVIAR ARQUIVO"));
		
	}
	
	public String verificarEtapasConcluidas() {
		String etapasConcluidas =  obterTextoAtributo(By.xpath("(//android.view.View/android.widget.ImageView)[2]"));
		return etapasConcluidas.replaceAll("\\n", " ");
		
	}
		
	}
	
	
	
	
	
	


