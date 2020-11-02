package com.flipkart.framework.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.framework.browser.BrowserAction;
import com.flipkart.framework.browser.BrowserWait;
import com.flipkart.framework.logger.ScriptLogger;
import com.flipkart.framework.objects.Documentation;
import com.flipkart.framework.objects.helpers.LoadObjectMaps;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseWebDriver {

	public static WebDriver driver;
	public static String browser;
	public static int waitTime;
	public static int thinkTime;
	protected static int implicitWaitTime;
	
	@BeforeSuite(alwaysRun=true)
	@Parameters ({"browser", "waitTime", "thinkTime", "implicitWait","url"})
	public void startBrowserBeforeSuite(String browser, int waitTime, int thinkTime, int implicitWait,String url) throws Exception
	  {
			BaseWebDriver.browser = browser;
			BaseWebDriver.waitTime = waitTime;
			BaseWebDriver.thinkTime = thinkTime;
			BaseWebDriver.implicitWaitTime = implicitWait;
			
			if(browser.equalsIgnoreCase("chrome"))	
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if (browser.equals("firefox")) 
			{
				WebDriverManager.firefoxdriver().setup();	
			}
			 driver.manage().window().maximize();
			 BrowserAction.openBrowser(url);
     		 ScriptLogger.info("Navigating to: " + "url");
		     BrowserWait.waitForPageToBeLoaded();
			 Thread.sleep(5000);
			 driver.manage().deleteAllCookies();
			 driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
      }
	
	@AfterSuite
	public void closeBrowserAfterSuite() throws Exception {
		BrowserAction.closeBrowser();
	}

//	@Test
//	@Parameters("env")
//	@Documentation(step = "Launch application url in browser", expected = "Browser should be launched with the given url")
//	public static void navigateToUrlTest(String env) throws Exception {
//		System.out.println("I am into it");
//		String url="";
//		if(env.equalsIgnoreCase("prod")) {
//			url = "https://www.flipkart.com/";
//		}else if(env.equalsIgnoreCase("staging")) {
//			url = "https://www.flipkart.com/";
//		BrowserAction.openBrowser(url);
//	    ScriptLogger.info("Navigating to: " + "url");
//	    BrowserWait.waitForPageToBeLoaded();
//		Thread.sleep(5000);
//	}
	
}