package br.com.conecta.afya.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver() {

		if (driver == null) {

			createDriver();

		}

		return driver;

	}

	private static void createDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		
		desiredCapabilities.setCapability("deviceName", "Nexus_4_API_30");
	    desiredCapabilities.setCapability("udid", "emulator-5554");
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("platformVersion", "11.0");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("autoGrantPermissions", "true");
	    		desiredCapabilities.setCapability(MobileCapabilityType.APP,
		"C:\\Users\\DELL\\workspace\\ConectaAfyaAuto\\src\\test\\resources\\16107110.apk");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

	}

	public static void KillDriver() {

		if (driver != null) {
			driver.quit();
			driver = null;

		}

	}
}
