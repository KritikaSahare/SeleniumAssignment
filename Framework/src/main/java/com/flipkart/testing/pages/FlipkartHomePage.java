package com.flipkart.testing.pages;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.flipkart.framework.browser.BrowserAccess;
import com.flipkart.framework.browser.BrowserAction;
import com.flipkart.framework.browser.BrowserWait;
import com.flipkart.framework.logger.ScriptLogger;
import com.flipkart.framework.objects.Documentation;
import com.flipkart.framework.objects.exceptions.ApplicationException;
import com.flipkart.framework.objects.helpers.LoadObjectMaps;
import com.flipkart.framework.selenium.WebDriverAction;
import com.flipkart.testing.objectmaps.*;

public class FlipkartHomePage {
	
	
	
	@Test
	@Documentation(step="Click the cross button of login modal", expected="Able to click")
	public static void clickLoginModalCrossButton() throws Exception {
		ScriptLogger.info();
		try {
				BrowserWait.waitUntilElementIsDisplayed(FlipkartHomePageObjectMap.LOGIN_MODAL_CROSS_BTN,20);
				BrowserAction.click(FlipkartHomePageObjectMap.LOGIN_MODAL_CROSS_BTN);
			}	
				
		catch(Exception e) {
			throw new ApplicationException(e, "Unable to click login modal cross button");
		}
	}
	
	
	@Test
	@Documentation(step="hover on Electronics", expected="Able to hover")
	public static void hoverOnElectronicsLink() throws Exception{
		ScriptLogger.info();
		try {
			BrowserAction.hoverOverElement(FlipkartHomePageObjectMap.FLIPKART_HOMEPAGE_ELECTRONICS_LINK);
		}catch(Exception e) {
			throw new ApplicationException(e, "Unable to hover on electronics");
		}
	}
	
	@Test
	@Documentation(step="Click Mobile phone brand button", expected="Able to click")
	public static void clickMobilePhoneBrand(String brand) throws Exception{
		ScriptLogger.info();
		try {
			try {
	WebDriverAction.getDriver().findElement(By.xpath("//a[@title='Mobiles']//following-sibling::a[text()='"+brand+"']")).click();
			}
			catch(Exception e)
			{
				throw new ApplicationException("wrong brand name provided"+brand);
			}
	}catch(Exception e) {
		throw new ApplicationException(e, "Unable to click mobile phone brand.");
	}
	}
	
	
}