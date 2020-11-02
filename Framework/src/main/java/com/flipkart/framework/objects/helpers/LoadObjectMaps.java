package com.flipkart.framework.objects.helpers;

import org.openqa.selenium.support.PageFactory;

import com.flipkart.framework.selenium.BaseWebDriver;
import com.flipkart.testing.objectmaps.FlipkartHomePageObjectMap;
import com.flipkart.testing.objectmaps.MobileListingPageObjectMap;


public class LoadObjectMaps {
	
	public static void loadObjects()
	{
		FlipkartHomePageObjectMap homePage = PageFactory.initElements(BaseWebDriver.driver, FlipkartHomePageObjectMap.class);
		MobileListingPageObjectMap listing = PageFactory.initElements(BaseWebDriver.driver, MobileListingPageObjectMap.class);
	}

}
