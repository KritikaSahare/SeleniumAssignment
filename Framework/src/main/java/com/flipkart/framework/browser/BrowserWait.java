package com.flipkart.framework.browser;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.flipkart.framework.selenium.WebDriverWaits;

public class BrowserWait extends BrowserAccess{
	/**
	 * Wait until elements are displayed
	 * @param Object
	 * @throws Exception
	 */
	public static void waitUntilElementIsDisplayed(final WebElement... element)
			throws Exception {
		for (WebElement each : element) {
		
			WebDriverWaits.waitUntilElementIsDisplayed(each);
		}		
	}

	/**
	 * Wait until elements are displayed
	 * @param WebElement
	 * @throws Exception
	 */
	public static void waitUntilElementIsDisplayed(final WebElement e1)	throws Exception {		
		WebDriverWaits.waitUntilElementIsDisplayed(e1);		
	}
	
	/**
	 * Wait until elements are displayed
	 * @param locator
	 * @param waitTime
	 * @throws Exception
	 */
	public static void waitUntilElementIsDisplayed(final WebElement e1, final int waitTime) throws Exception {		
		
		WebDriverWaits.waitUntilElementIsDisplayed(e1, waitTime);
		
	}

	/**
	 * Wait until elements are not displayed
	 * @param locator
	 * @param waitTime
	 * @throws Exception
	 */
	public static void waitUntilElementIsNotDisplayed(final WebElement... element)
			throws Exception {
		for (WebElement each : element) {
			
			WebDriverWaits.waitUntilElementIsNotDisplayed(element);
		}
	}
	
	/**
	 * Wait until elements are not displayed
	 * @param WebElement
	 * @throws Exception
	 */
	public static void waitUntilElementIsNotDisplayed(final WebElement e1)
			throws Exception {
		WebDriverWaits.waitUntilElementIsNotDisplayed(e1);
	}

	/**
	 * Wait until element is not displayed
	 * @param locator
	 * @param waitTime
	 * @throws Exception
	 */	
	public static void waitUntilElementIsNotDisplayed(final WebElement e1, final int waitTime) throws Exception {
	
		WebDriverWaits.waitUntilElementIsNotDisplayed(e1, waitTime);
	}

	/**
	 * Wait until more than one elements are present
	 * @param Object
	 * @throws Exception
	 */
	public static void waitUntilMoreThanOneElementPresent(final List<WebElement> element) throws Exception {
			WebDriverWaits.waitUntilMoreThanOneElementPresent(element);
		
	}
	
	/**
	 * Wait until more than one elements are present
	 * @param locator
	 * @param waitTime
	 * @throws Exception
	 */
	public static void waitUntilMoreThanOneElementPresent(final  List<WebElement> element,final int waitTime) throws Exception {
		
		WebDriverWaits.waitUntilMoreThanOneElementPresent(element, waitTime);
	}

	/**
	 * Wait until specified numbers of elements are present
	 * @param locator
	 * @param count
	 * @throws Exception
	 */
	public static void waitUntilCountOfElementsPresent(final  List<WebElement> element,
			final int count) throws Exception {
		//ScriptLogger.debug("Waiting for "+count+" instances of element to present: \"[Locator = {"+ObjectMapHelper.getLocatorName(locator)+ ": "+locator+ "}]\"" );		
		WebDriverWaits.waitUntilCountOfElementsPresent(element, count);
	}
	
	/**
	 * Wait until specified numbers of elements are present
	 * @param locator
	 * @param count
	 * @param waitTime
	 * @throws Exception
	 */
	public static void waitUntilCountOfElementsPresent(final List<WebElement> element,
			final int count, final int waitTime) throws Exception {
		WebDriverWaits.waitUntilCountOfElementsPresent(element, count, waitTime);
	}
	
	
	/**
	 * Wait until at least one element is present
	 * @param Object
	 * @throws Exception
	 */
	public static void waitUntilAtLeastOneElementPresent(final List<WebElement> element) throws Exception {
		for (WebElement each : element) {
			
			WebDriverWaits.waitUntilAtLeastOneElementPresent(element);
		}
	}
	
	/**
	 * Wait until more than one elements are present
	 * @param locator
	 * @param waitTime
	 * @throws Exception
	 */
	public static void waitUntilAtLeastOneElementPresent(final List<WebElement> element,final int waitTime) throws Exception {
		
		WebDriverWaits.waitUntilAtLeastOneElementPresent(element, waitTime);
	}
	

	/**
	 * Wait for page title to change as specified
	 * @param Page title
	 * @throws Exception
	 */
	public static void waitUntilPageTitle(final String title) throws Exception {
		WebDriverWaits.waitUntilPageTitle(title);		
	}
	
	/**
	 * Wait for page title to change as specified
	 * @param title
	 * @param time
	 * @throws Exception
	 */
	public static void waitUntilPageTitle(final String title, final int time)
			throws Exception {
		
		WebDriverWaits.waitUntilPageTitle(title, time);
	}
	
	/**
	 * Wait for page title to change as specified
	 * @param title
	 * @throws Exception
	 */
	public static void waitUntilPageTitleChanges(final String title)
			throws Exception {
		WebDriverWaits.waitUntilPageTitleChanges(title);
	}
	
	/**
	 * Wait for page title to change as specified
	 * @param title
	 * @param time
	 * @throws Exception
	 */	
	public static void waitUntilPageTitleChanges(final String title,
			final int time) throws Exception {
	
		WebDriverWaits.waitUntilPageTitleChanges(title, time);
	}
	
	/**
	 * Wait until specified texts appear
	 * @param text
	 * @throws Exception
	 */	
	public static void waitUntilText(final String... text) throws Exception {
		for (String each : text) {			
			WebDriverWaits.waitUntilText(each);
		}
	}
	
	/**
	 * Wait until specified text appear
	 * @param text
	 * @param time
	 * @throws Exception
	 */
	public static void waitUntilText(final String text, final int time)
			throws Exception {
			WebDriverWaits.waitUntilText(text, time);
	}
	
	/**
	 * Wait until specified text is not present
	 * @param text
	 * @throws Exception
	 */
	public static void waitUntilNotText(final String... text) throws Exception {
		for (String each : text) {
		
			WebDriverWaits.waitUntilNotText(each);
		}
	}
	
	/**
	 * Wait until specified text is not present
	 * @param text
	 * @param time
	 * @throws Exception
	 */
	public static void waitUntilNotText(final String text, final int time)
			throws Exception {
		
		WebDriverWaits.waitUntilNotText(text, time);
	}

	public static void waitUntilAttributeHasValue(final WebElement element,
			final String attribute) throws Exception {
		WebDriverWaits.waitUntilAttributeHasValue(
				element, attribute);
	}
	public static void waitUntilAttributeHasValue(final WebElement element,
			final String attribute, final int time) throws Exception {
		WebDriverWaits.waitUntilAttributeHasValue(
				element, attribute, time);
	}

	/**
	 * Wait until specified texts are visible
	 * @param text
	 * @throws Exception
	 */
	public static void waitUntilTextVisible(final String... text)
			throws Exception {
		for (String each : text) {
			
			WebDriverWaits.waitUntilTextVisible(each);
		}
	}
	
	/**
	 * Wait until specified partial texts are visible
	 * @param text
	 * @throws Exception
	 */
	public static void waitUntilPartialTextVisible(final String... text)
			throws Exception {
		for (String each : text) {
			
			WebDriverWaits.waitUntilPartialTextVisible(each);
		}
	}


	/**
	 * Wait until specified text is visible
	 * @param text
	 * @param time
	 * @throws Exception
	 */
	public static void waitUntilTextVisible(final String text, final int time)
			throws Exception {
		
		WebDriverWaits.waitUntilTextVisible(text, time);
	}

	public static void waitUntilTextVisible(final String text, final int time, final boolean partialMatch) throws Exception {
		WebDriverWaits.waitUntilTextVisible(text, time, partialMatch);
	}

	/**
	 * Wait until specified texts are not visible
	 * @param text
	 * @param time
	 * @throws Exception
	 */
	public static void waitUntilNotTextVisible(final String... text)
			throws Exception {
		for (String each : text) {
			
			WebDriverWaits.waitUntilNotTextVisible(each);
		}
	}

	
	public static void waitUntilNotTextVisible(final String text, final int time)
			throws Exception {
		WebDriverWaits.waitUntilNotTextVisible(text, time);
	}

	public static void waitUntilNotTextVisible(final String text,
			final int time, final boolean partialMatch) throws Exception {
		WebDriverWaits.waitUntilNotTextVisible(text, time, partialMatch);
	}
	
	



	public static void waitForPageToBeLoaded() throws Exception {
		WebDriverWaits.waitForWaitPageToBeLoaded();
	}
	
	public static void waitUntilNewWindowIsLoaded(final List<String> existingWindowHandles) throws Exception {
		WebDriverWaits.waitUntilNewWindowIsLoaded(existingWindowHandles);
	}
	
	public static void waitUntilElementIsClickable(final WebElement element, final int waitTime) throws Exception {
		WebDriverWaits.waitUntilElementIsClickable(element, waitTime);
	}

	/**
	 * Wait until specified time
	 * @param time
	 */
	 public static void waitForTime(int time)
	 {
		 WebDriverWaits.waitForTime(time);
	 }
}
