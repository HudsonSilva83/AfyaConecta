package br.com.conecta.afya.core;

import static br.com.conecta.afya.utils.Utils.removerAcentos;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class BaseTest {

	// @Rule
	// public TestName testName = new TestName();

	@AfterClass
	public static void finalizaClasse() {

		DriverFactory.KillDriver();

	}
	
	
	
	@After
	public void tearDown() {
		
		
		DriverFactory.getDriver().resetApp();

	}


	public void gerarScreenShot(String feature, String cenario) {
		File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {

	
			FileUtils.copyFile(imagem,
					new File("target/evidencias/" + removerAcentos(feature) + "/" + removerAcentos(cenario) + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






	public static byte[] teste() throws IOException {
		
		File src = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(src);
		return fileContent;
		
		
		
		
		
	}
}
