package com.flipkart.testing.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.framework.browser.BrowserAction;
import com.flipkart.framework.browser.BrowserWait;
import com.flipkart.framework.logger.ScriptLogger;
import com.flipkart.framework.objects.Documentation;
import com.flipkart.framework.objects.exceptions.ApplicationException;
import com.flipkart.framework.objects.helpers.LoadObjectMaps;
import com.flipkart.framework.selenium.WebDriverAction;
import com.flipkart.testing.objectmaps.FlipkartHomePageObjectMap;
import com.flipkart.testing.objectmaps.MobileListingPageObjectMap;
import com.flipkart.testing.pages.FlipkartHomePage;
import com.flipkart.testing.pages.MobileListingPage;

public class FlipkartScenario1Test {

	
	@BeforeClass(alwaysRun=true)
	@Documentation(step = "Load object maps", expected = "Object map configuration should be loaded")
	public static void loadObjectMaps(){
		ScriptLogger.info();
		LoadObjectMaps.loadObjects();
	}
	
	
	@Test
	@Documentation(step="Click the cross button of login modal", expected="Able to click")
	public static void clickLoginModalCrossButtonTest() throws Exception {
		FlipkartHomePage.clickLoginModalCrossButton();
	}
	
	@Test(dependsOnMethods = "clickLoginModalCrossButtonTest", priority = 1)
	@Documentation(step="hover on Electronics", expected="Able to hover")
	public static void hoverOnElectronicsLinkTest() throws Exception{
		FlipkartHomePage.hoverOnElectronicsLink();
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = "hoverOnElectronicsLinkTest", priority = 1)
	@Parameters("mobileBrand")
	@Documentation(step="Click Mobile phone brand button", expected="Able to click")
	public static void clickMobilePhoneBrandTest(String mobileBrand) throws Exception{
		FlipkartHomePage.clickMobilePhoneBrand(mobileBrand);
	}
	
	@Test(dependsOnMethods = "clickMobilePhoneBrandTest", priority = 1)
	public static void waitForPageToBeLoadedTest() throws Exception {
		BrowserWait.waitForPageToBeLoaded();
		BrowserAction.refresh();
	}
	
	@Test(dependsOnMethods = "waitForPageToBeLoadedTest", priority = 1)
	@Documentation(step="Click Sort By Low to High Tab",expected ="Able to click")
	public static void clickSortByLowToHigh() throws Exception
	{
		MobileListingPage.clickSortByLowToHigh();
		BrowserWait.waitForPageToBeLoaded();
	}
	
	@Test(dependsOnMethods = "clickSortByLowToHighTest", priority = 1)
	@Documentation(step="Verify prices are sorted in low to high",expected ="Prices should be sorted")
	public static void verifySortLowToHighOfNProducts() throws ApplicationException
	{
		MobileListingPage.verifySortLowToHighOfNProducts(3);
	}
}
