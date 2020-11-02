package com.flipkart.testing.objectmaps;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileListingPageObjectMap {
	
	@FindBy(xpath="//div[text()='Price -- Low to High']")
	public static WebElement MOBILE_LISTING_PAGE_SORT_BY_LOW_TO_HIGH;
	
	@FindBy(xpath="//div[@class='_1vC4OE _2rQ-NK']")
	public static List<WebElement> MOBILE_LISTING_PAGE_PRICES;

}
