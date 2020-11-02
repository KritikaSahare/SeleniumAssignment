package com.flipkart.framework.browser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.flipkart.framework.selenium.WebDriverAsserts;

public class BrowserAssert extends BrowserAccess{
	
	
	public static void assertAllTextPresent(final String... texts) throws Exception {
		assertAllTextPresent(Arrays.asList(texts));
	}
	
	
	public static void assertAllTextPresent(final Collection<String> texts) throws Exception {
		WebDriverAsserts.assertAllTextPresent(texts);
		
	}

	
	public static void assertAllElementsDisabled(final List<WebElement> elements) throws Exception {
		WebDriverAsserts.assertAllElementsDisabled(elements);
		
	}

	
	public static void assertElementDisabled(final Object... locators) throws Exception {
		assertElementDisabled(Arrays.asList(locators));
	}
	
	
	public static void assertElementDisabled(final Collection<WebElement> element) throws Exception {
		for (WebElement each : element){
			WebDriverAsserts.assertElementDisabled(each);
			
		}
	}
	
	
	public static void assertElementDisabled(final WebElement element) throws Exception {
		
		WebDriverAsserts.assertElementDisabled(element);
	}
	
	
	public static void assertAllElementsEnabled(final List<WebElement> elements) 	throws Exception {
		WebDriverAsserts.assertAllElementsEnabled(elements);
		
	}

	/**
	 * Asserts that all elements matching the locator are enabled
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementEnabled(final WebElement... element) throws Exception {
		assertElementEnabled(Arrays.asList(element));
		
	}
	
	/**
	 * Asserts that all elements matching the locator are enabled
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementEnabled(final Collection<WebElement> element) throws Exception {
		for (WebElement each : element){
			WebDriverAsserts.assertElementEnabled(each);
			
		}
	}
	
	/**
	 * Asserts that all elements matching the locator are present
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsPresent(final WebElement... element) 	throws Exception {
		assertElementIsPresent(Arrays.asList(element));
		
	}
	
	
	/**
	 * Asserts that all elements matching the locator are present
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsPresent(final Collection<WebElement> element) 	throws Exception {
		for (WebElement each : element){
			WebDriverAsserts.assertElementIsPresent(each);
			
		}
	}

	/**
	 * Asserts that all elements matching the locator are not present
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsNotPresent(final WebElement... element) throws Exception {
		assertElementIsNotPresent(Arrays.asList(element));
	}
	
	/**
	 * Asserts that all elements matching the locator are not present
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsNotPresent(final Collection<WebElement> element) throws Exception {
		for (WebElement each : element){
			WebDriverAsserts.assertElementIsNotPresent(each);
			
		}
	}
		
	/**
	 * Asserts that all elements matching the locator are displayed
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsDisplayed(final WebElement... element)	throws Exception {
		assertElementIsDisplayed(Arrays.asList(element));
	}
	
	/**
	 * Asserts that all elements matching the locator are displayed
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsDisplayed(final Collection<WebElement> element)	throws Exception {
		for (WebElement each : element)
		{
			WebDriverAsserts.assertElementIsDisplayed(each);
			
		}
	}

	/**
	 * Asserts that all elements matching the locator are not displayed
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsNotDisplayed(final WebElement... element) throws Exception {
		assertElementIsNotDisplayed(Arrays.asList(element));
	}
	
	/**
	 * Asserts that all elements matching the locator are not displayed
	 * @param locators
	 * @throws Exception
	 */
	public static void assertElementIsNotDisplayed(final Collection<WebElement> element) throws Exception {
		for (WebElement each : element){
			WebDriverAsserts.assertElementIsNotDisplayed(each);
			
		}
	}

	/**
	 * Asserts that the element matching the locator is displayed
	 * @param locator
	 * @throws Exception
	 */
	public static void assertAllElementsDisplayed(final List<WebElement> element) throws Exception {
		WebDriverAsserts.assertAllElementsDisplayed(element);
		
	}
	
	/**
	 * Asserts that the element matching the locator is not displayed
	 * @param locator
	 * @throws Exception
	 */
	public static void assertAllElementsNotDisplayed(final List<WebElement> element) throws Exception {
		WebDriverAsserts.assertAllElementsNotDisplayed(element);
		
	}
	
	/**
	 * Asserts that the element matching the locator is present but not displayed; fails on the first visible element
	 * @param locator
	 * @throws Exception
	 */
	public static void assertAllElementsPresentAndNotDisplayed(final List<WebElement> elements) throws Exception {
		WebDriverAsserts.assertAllElementsPresentAndNotDisplayed(elements);
		
	}	
	
	/**
	 * Assert that the actual object value is equal to the expected object value
	 * @param Object, Object, string
	 * @throws Exception
	 */
	
	public static void assertEquals(Object actual, Object expected, String message) throws Exception{
		WebDriverAsserts.assertEquals(actual, expected, message);
	}
	
	public static void assertElementIsSelected(final WebElement element) throws Exception{
		WebDriverAsserts.assertElementIsSelected(element);
	}
	
	public static void assertAllElementsSelected(final List<WebElement> elements) throws Exception {
		WebDriverAsserts.assertAllElementsSelected(elements);
		
	}	
	
	public static void assertAllElementsNotSelected(final List<WebElement> elements) throws Exception {
		WebDriverAsserts.assertAllElementsNotSelected(elements);
		
	}	
	
	public static void assertTrue(boolean value, String message) throws Exception {
		WebDriverAsserts.assertTrue(value, message);
		
	}
	

	
	
	
}
