package com.Deltax.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;

public class TestBase {

	public static Properties Repository = new Properties();
	public File f;
	public FileInputStream FI;
	public static WebDriver driver;

public void loadPropertiesFile() throws IOException {
	f = new File(System.getProperty("user.dir") + "//src//test//java/Deltax_QA_Online//Deltax_Automation//config//config.properties");
	FI = new FileInputStream(f);
	Repository.load(FI);
}
public void init() throws IOException {
	String log4jConfPath = "src//test//java//log4j.properties";
	PropertyConfigurator.configure(log4jConfPath);
	loadPropertiesFile();
	selectBrowser(Repository.getProperty("browser"));
	driver.manage().window().maximize();
	driver.get(Repository.getProperty("url"));
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

public void selectBrowser(String browser){
	if(System.getProperty("os.name").contains("Window")){
		if(browser.equalsIgnoreCase("firefox")){
			//https://github.com/mozilla/geckodriver/releases
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//java//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			//https://chromedriver.storage.googleapis.com/index.html
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//java//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
	}
	else if(System.getProperty("os.name").contains("Mac")){
		System.out.println(System.getProperty("os.name"));
		if(browser.equalsIgnoreCase("firefox")){
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"//src//test//java//Drivers//geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//java//Drivers//chromedriver");
			driver = new ChromeDriver();
		}
	}
}
public void expliciteWait(WebElement element, int timeToWaitInSec) {
	WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
	wait.until(ExpectedConditions.visibilityOf(element));
}

public void waitForPageToLoad(long timeOutInSeconds) {
	ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver driver) {
			return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		}
	};
	try {
		System.out.println("Waiting for page to load...");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(expectation);
	} catch (Throwable error) {
		System.out.println("Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
		Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");

	}
}
public void waitFor(int sec) throws InterruptedException {
	Thread.sleep(sec * 1000);
}
public  void getScreenShot(String fileName) throws IOException {
	File outputFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(outputFile, new File(System.getProperty("user.dir") + "//src//test//java//screenshots" + fileName + ".jpg"));
}

public void CloseBrowser(){
	driver.close();
}
}