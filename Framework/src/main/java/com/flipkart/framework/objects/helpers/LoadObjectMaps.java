package com.flipkart.framework.objects.helpers;

import org.openqa.selenium.support.PageFactory;

import com.flipkart.framework.selenium.BaseWebDriverTest;
import com.flipkart.testing.objectmaps.FlipkartHomePageObjectMap;
import com.flipkart.testing.objectmaps.MobileListingPageObjectMap;


public class LoadObjectMaps {
	
	public static void loadObjects()
	{
		FlipkartHomePageObjectMap homePage = PageFactory.initElements(BaseWebDriverTest.driver, FlipkartHomePageObjectMap.class);
		MobileListingPageObjectMap listing = PageFactory.initElements(BaseWebDriverTest.driver, MobileListingPageObjectMap.class);
	}

}
