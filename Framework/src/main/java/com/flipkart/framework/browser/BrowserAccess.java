package com.flipkart.framework.browser;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.flipkart.framework.selenium.WebDriverAccess;

public class BrowserAccess {
	public static WebElement getElement(final WebElement element) throws Exception {
		return WebDriverAccess.getElement(element);
	}

	public static List<WebElement> getElements(final List<WebElement> element)
			throws Exception {
		return WebDriverAccess.getElements(element);
	}

	public static String getElementInnerHtml(final WebElement el)
			throws Exception {
		return WebDriverAccess.getElementInnerHtml(el);
	}

	public static String getElementAttributeValue(final WebElement e1,
			final String attribute) throws Exception {
		return WebDriverAccess.getElement(e1).getAttribute(
				attribute);
	}

	public static String getElementText(final WebElement element,
			final boolean... js) throws Exception {
		return WebDriverAccess.getElementText(element, js);
	}

	public static List<String> getElementsText(final List<WebElement> element,
			final boolean... js) throws Exception {
		return WebDriverAccess.getElementsText(element, js);
	}
		
	public static String getPageTitle()  throws Exception {
		return WebDriverAccess.getPageTitle();
	}
	
	public static String getWindowHandle()  throws Exception {
		return WebDriverAccess.getWindowHandle();
	}
	
	public static Set<String> getWindowHandles()  throws Exception {
		return WebDriverAccess.getWindowHandles();
	}
	
	public static String getPageSource() throws Exception {
		return WebDriverAccess.getPageSource();
	}
	
	public static String getNetworkLogEntries() throws Exception {
		return WebDriverAccess.getNetworkLogEntries();
	}
	
	
	/* Added for implementing language localization */
	
	

	public static String removeAttribute(final WebElement element,final String attribute, final String value) throws Exception {
		return WebDriverAccess.removeAttribute(element, attribute, value);
	}
	
//	public static String getDropdownOptionFirstSelectedValue(final Object locator) throws Exception {
//		return WebDriverAccess.getDropdownOptionFirstSelectedValue(getLocator(locator));
//	}
}
