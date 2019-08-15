package com.qa.testbase;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.Util;

public class TestBase {

	public static FileReader fir;
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	

	public TestBase() {

		if (prop == null) {
			loadProperties();
		}
	}

	public void loadProperties() {

		prop = new Properties();

		try {
			fir = new FileReader("config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebDriver initDriver() {

		if (driver == null) {
			String browser = prop.getProperty("browser");
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browser.equals("FF")) {
				System.setProperty("webdriver.gecko.driver",
						"D:\\Selenium\\geckodriver-v0.24.0-win32\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Util.IMPLICT_WAIT, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 100);

			driver.get(prop.getProperty("url"));
		}
		return driver;
	}
}
