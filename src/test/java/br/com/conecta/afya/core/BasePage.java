package br.com.conecta.afya.core;

import static br.com.conecta.afya.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	public void escrever(By by, String texto) {

		
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		
		getDriver().findElement(by).sendKeys(texto);

	}

	public String obterTexto(By by) {

		String texto = getDriver().findElement(by).getText();

		return texto;

	}

	public String obterTextoMobileElement(By by) {

		MobileElement texto = getDriver().findElement(by);

		return texto.getText();

	}

	public String obterTextoAtributo(By by) {

		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));

		return getDriver().findElement(by).getAttribute("content-desc");

	}

	public String obterTextoAtributoText(By by) {

		return getDriver().findElement(by).getAttribute("text");

	}

	public void clicarCombo(By by) {

		getDriver().findElement(by).click();

	}

	public void clicar(By by) {
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		
		limpar(by);
		getDriver().findElement(by).clear();
		getDriver().findElement(by).click();

	}

	public void clicarCheck(By by) {

		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));

		getDriver().findElement(by).click();

	}

	public void clicarPorTexto(By by) {

		getDriver().findElement(by).click();

	}

	public void selecionarOpcaoCombo(By by) {

		getDriver().findElement(by).click();

	}

	public String obterAtributoCheck(By by) {

		MobileElement elemento = getDriver().findElement(by);
		return elemento.getAttribute("checked");

	}

	public String obterAtributoHabilitado(By by) {

		MobileElement elemento = getDriver().findElement(by);
		return elemento.getAttribute("displayed");

	}

	public String obterAtributoHabilitado2(By by) {

		MobileElement elemento = getDriver().findElement(by);
		return elemento.getAttribute("enabled");

	}

	public boolean obterAtributoHabilitadoClicavel(By by, String atributo) {

		MobileElement elemento = getDriver().findElement(by);
		return elemento.getAttribute("clickable").contains(atributo);

	}

	public boolean verificarBotaoDesabilitado(By by) {

		MobileElement elemento = getDriver().findElement(by);
		return elemento.getAttribute("clickable").contains("false");

	}

	public boolean verificarRadio(By by) {

		MobileElement elemento = getDriver().findElement(by);
		return elemento.getAttribute("clickable").contains("true");

	}

	public boolean existeElementosPorTexto(String texto) {

		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));

		return elementos.size() > 0;

	}

	public ArrayList<String> listTela(By by) {

		List<MobileElement> telaLista = getDriver().findElements(by);
		ArrayList<String> lista = new ArrayList<String>();

		for (MobileElement elemento : telaLista) {

			lista.add(elemento.getText());

		}

		return lista;

	}

	public boolean existeElementoPorTexto(By by, String texto) {

		WebElement elemento = getDriver().findElement(by);

		return elemento.getText().contains(texto);

	}

	public String atributoClass(By by, String atributo) {

		WebElement elemento = getDriver().findElement(by);

		return elemento.getAttribute(atributo);

	}

	public boolean existeElementoPorAtributo(By by, String atributo, String texto) {

		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));

		WebElement elemento = getDriver().findElement(by);
		return elemento.getAttribute(atributo).contains(texto);

	}

	public MobileElement atributo(By by) {

		WebElement elemento = getDriver().findElement(by);

		return (MobileElement) elemento;

	}

	public void clicarTap(int x, int y) {

		AndroidTouchAction touch = new AndroidTouchAction(getDriver());
		touch.press(PointOption.point(x, y)).perform();

	}

	public void tapNormal(int x, int y) {

		new TouchAction(getDriver()).press(PointOption.point(x, y)).release().perform();

	}

	public void clicarTapLong(int x, int y) {

		AndroidTouchAction touch = new AndroidTouchAction(getDriver());
		touch.longPress(PointOption.point(x, y)).perform();

	}

	public void clicarLongo(String valor) {

		AndroidTouchAction touch = new AndroidTouchAction(DriverFactory.getDriver());
		touch.longPress(LongPressOptions.longPressOptions()
				.withElement(ElementOption
						.element(DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + valor + "']")))))
				.perform();

	}

	public void clicarLongo(By by) {

		AndroidTouchAction touch = new AndroidTouchAction(DriverFactory.getDriver());
		touch.longPress(LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(DriverFactory.getDriver().findElement(by)))).perform();

	}

	public void clicarDuplo() {

		clicar(MobileBy.AccessibilityId("Já tenho uma conta"));

	}

	public void scroll(double inicio, double fim) {

		Dimension size = DriverFactory.getDriver().manage().window().getSize();

		int x = size.width / 2;
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);

		new TouchAction(getDriver()).longPress(PointOption.point(x, start_y)).moveTo(PointOption.point(x, end_y))
				.release().perform();

	}

	public void swipe(double inicio, double fim) {

		Dimension size = DriverFactory.getDriver().manage().window().getSize();

		int y = size.height / 2;
		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);

		new TouchAction(getDriver()).longPress(PointOption.point(start_x, y)).moveTo(PointOption.point(end_x, y))
				.release().perform();

	}

	public String obterMensagemAlerta() {

		return obterTexto(By.id("android:id/message"));

	}

	public void tap(MobileElement buttonElemnt) {

		Actions action = new Actions(DriverFactory.getDriver());
		action.moveToElement(buttonElemnt);
		action.click();
		action.perform();

	}

	public void tapc() {

		while (getDriver().findElements(MobileBy.xpath("//*[@class='android.widget.Button'][3]")).size() > 0)

		{

			getDriver().findElement(MobileBy.xpath("//*[@class='android.widget.Button'][3]")).click();

		}

	}

	public void limpar(By by) {

		getDriver().findElement(by).clear();

	}

}
