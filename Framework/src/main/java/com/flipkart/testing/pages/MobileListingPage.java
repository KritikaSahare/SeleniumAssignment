package com.flipkart.testing.pages;

import java.util.List;

import org.testng.annotations.Test;

import com.flipkart.framework.browser.BrowserAccess;
import com.flipkart.framework.browser.BrowserAction;
import com.flipkart.framework.browser.BrowserWait;
import com.flipkart.framework.logger.ScriptLogger;
import com.flipkart.framework.objects.Documentation;
import com.flipkart.framework.objects.exceptions.ApplicationException;
import com.flipkart.testing.objectmaps.FlipkartHomePageObjectMap;
import com.flipkart.testing.objectmaps.MobileListingPageObjectMap;

public class MobileListingPage {
	
	
	@Test
	@Documentation(step="Click Sort By Low to High Tab",expected ="Able to click")
	public static void clickSortByLowToHigh() throws ApplicationException
	{
		ScriptLogger.info();
		try
		{
			BrowserWait.waitUntilElementIsDisplayed(MobileListingPageObjectMap.MOBILE_LISTING_PAGE_SORT_BY_LOW_TO_HIGH,20);
			BrowserAction.click(MobileListingPageObjectMap.MOBILE_LISTING_PAGE_SORT_BY_LOW_TO_HIGH);
		}catch(Exception e)
		{
			throw new ApplicationException(e,"unable to click sort by low to high tab");
		}
	}

	@Test
	@Documentation(step="Verify prices are sorted in low to high",expected ="Prices should be sorted")
	public static void verifySortLowToHighOfNProducts(int number) throws ApplicationException
	{
		ScriptLogger.info();
		try
		{
			List<String> list= BrowserAccess.getElementsText(MobileListingPageObjectMap.MOBILE_LISTING_PAGE_PRICES);
			for(int i=0; i<number;i++)
			{
				System.out.println("Prices of "+i+" Mobile is :"+Integer.parseInt(list.get(i).replaceAll("[\\D]", "")));
				if(!(Integer.parseInt(list.get(i).replaceAll("[\\D]", "")) <= Integer.parseInt(list.get(i+1).replaceAll("[\\D]", ""))))
						{
					     throw new ApplicationException("prices are not in sorted order");
						}
			}
		}catch(Exception e)
		{
			throw new ApplicationException(e,"unable to verify the low to high sorting");
		}
	}

}
