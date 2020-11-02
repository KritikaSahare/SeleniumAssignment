package com.flipkart.framework.selenium;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.flipkart.framework.selenium.WebDriverAccess;


/**
 * Contains WebDriver assertions, each of them throws an exception if not true
 *
 */
public class WebDriverAsserts extends WebDriverAccess {
	
	// Asserts that all texts are present on the current page
	public static void assertAllTextPresent(String ... texts) throws Exception {
		assertAllTextPresent(Arrays.asList(texts));
	}
	
	public static void assertAllTextPresent(Collection<String> texts) throws Exception {
		String pageSource = driver.getPageSource();
		for(String each : texts) {
			if(!pageSource.contains(each))
				throw new Exception("Text=" + each + " is not present");
		}			
	}
	
	// Asserts that an element is disabled
	
	public static void assertElementDisabled(final WebElement element) throws Exception {
		if(element == null)
			throw new Exception("Element not found or unable to access");
		String disabled = element.getAttribute("disabled");
		String aria = element.getAttribute("aria-disabled");
		String className = element.getAttribute("className");
		if("disabled".equalsIgnoreCase(disabled) || "true".equalsIgnoreCase(disabled) || "true".equalsIgnoreCase(aria) || className.contains("disabled"))
			return;
			throw new Exception("Element is not disabled.");
	}
	
	// Asserts that an element is enabled
	public static void assertElementEnabled(final WebElement element) throws Exception{
		try { 	assertElementDisabled( element);	}
		catch(Exception e) { return;}
		throw new Exception("Element is not enabled with locator " + element);
	}
	
	// Asserts that elements are enabled
	
	
	public static void assertElementsEnabled(Collection<WebElement> element) throws Exception {	
		for(WebElement each : element) {
				assertElementEnabled(each);
		}
	}
	
	// Asserts that elements are disabled
	public static void assertElementsDisabled(final WebElement ... elements) throws Exception {	
		assertElementsDisabled(Arrays.asList(elements));
	}
	public static void assertElementsDisabled(final Collection<WebElement> elements) throws Exception {	
		for(WebElement each : elements) {
				assertElementDisabled(each);
		}
	}
	
	// Asserts that all elements matching the locator are disabled
	public static void assertAllElementsDisabled(final List<WebElement> elements) throws Exception{
		if(elements == null || elements.size() == 0)
			throw new Exception("Elements not found with locator " + elements);
		boolean result = true;		
		for(int i = 0; i < elements.size() && result; i++) {
			String disabled = elements.get(i).getAttribute("disabled");
			String aria = elements.get(i).getAttribute("aria-disabled");
			if("disabled".equalsIgnoreCase(disabled) || "true".equalsIgnoreCase(disabled) || "true".equalsIgnoreCase(aria))
				continue;
			result = false;
		}
		if(!result)
			throw new Exception("Not all elements are disabled with locator " + elements);
	}

	// Asserts that all elements matching the locator are enabled
	public static void assertAllElementsEnabled(final List<WebElement> elements) throws Exception{
	//	List<WebElement> elements = driver.findElements(locator);
		if(elements == null || elements.size() == 0)
			throw new Exception("Elements not found with locator " + elements);
		boolean result = true;		
		for(int i = 0; i < elements.size() && result; i++) {
			String disabled = elements.get(i).getAttribute("disabled");
			String aria = elements.get(i).getAttribute("aria-disabled");
			if(isEmpty(disabled) && isEmpty(aria))
				continue;
			if("enabled".equalsIgnoreCase(disabled) || "false".equalsIgnoreCase(disabled) || "false".equalsIgnoreCase(aria))
				continue;
			result = false;
		}
		if(!result)
			throw new Exception("Not all elements are enabled with locator " + elements);
	}
	
	// Asserts that elements are not present
	public static void assertElementIsNotPresent(final WebElement...element) throws Exception {
		int size =0;
		try { size = element.length;	}
		catch(Exception e) { 	}		
		if(size > 0)
			throw new Exception ("Unexpectedly found an element: " + element);
	}

	// Asserts that elements are not present
	public static void assertElementIsPresent(final WebElement... element) throws Exception {
			int size = element.length;
			if(size == 0)
				throw new Exception ("Did not find an element: " + element);
		}
	
	
	// Asserts that ALL elements are displayed, fails on the first hidden element
	public static void assertAllElementsDisplayed(final List<WebElement> elements) throws Exception {
		if(elements == null || elements.size() == 0)
			throw new Exception("Elements not found with locator " + elements);
		for(int i = 0; i < elements.size(); i++) {
			if(!elements.get(i).isDisplayed()) {
				throw new Exception("Element is not displayed with locator=" + elements + ", index=" + i);
			}
		}		
	}
	
	// Asserts that ALL elements are not displayed (or not present), fails on the first visible element
	public static void assertAllElementsNotDisplayed(final List<WebElement> elements) throws Exception {
		if(elements == null || elements.size() == 0)
			return;
		for(int i = 0; i < elements.size(); i++) {
			if(elements.get(i).isDisplayed()) {
				throw new Exception("Element is displayed with locator=" + elements + ", index=" + i);
			}
		}	
	}
	
	// Asserts that ALL elements are present and not displayed, fails on the first visible element
		public static void assertAllElementsPresentAndNotDisplayed(final List<WebElement> elements) throws Exception {
			if(elements == null || elements.size() == 0)
				throw new Exception("Elements not found with locator " + elements);
			for(int i = 0; i < elements.size(); i++) {
				if(elements.get(i).isDisplayed()) {
					throw new Exception("Element is displayed with locator=" + elements + ", index=" + i);
				}
			}	
		}
		
	/**
	 * 
	 * @param locator
	 * @throws Exception If element is not present or is not displayed
	 */

	public static void assertElementIsNotVisible(final WebElement... element) throws Exception {
		try {
			assertElementIsNotPresent(element);				
		}
		catch(Exception e) { return;}
		for(WebElement each :element)
		{
		if(each.getAttribute("style").toLowerCase().contains("display: none"))	
			return;
		}
		throw new Exception("The element is visible");
	}
	
	
	public static void assertElementIsDisplayed(final WebElement element) throws Exception{
		if(!element.isDisplayed())
			throw new Exception("Did not display Search Toolbar");	
	}
	
	public static void assertElementIsNotDisplayed(final  WebElement... element) throws Exception{
		if(element.length!=0)
			throw new Exception("Assertion Failed: Element is getting displayed");	
	}
	
	public static void assertElementIsSelected(final WebElement element) throws Exception {
		if(!element.isSelected())
			throw new Exception("Element is not selected");
	}
	
	public static void assertElementIsNotSelected(final WebElement element) throws Exception {
		if(element.isSelected())
			throw new Exception("Element is selected");
	}
	
	// Asserts that ALL elements are selected, fails on the first selected element
		public static void assertAllElementsSelected(final List<WebElement> elements) throws Exception {
			if(elements == null || elements.size() == 0)
				throw new Exception("Elements not found with locator " + elements);
			for(int i = 0; i < elements.size(); i++) {
				if(!elements.get(i).isSelected()) {
					throw new Exception("Element is not selected with locator=" + elements + ", index=" + i);
				}
			}		
		}
		
		// Asserts that all elements are not selected (or not present), fails on the first selected element
		public static void assertAllElementsNotSelected(final List<WebElement> elements) throws Exception {
			if(elements == null || elements.size() == 0)
				return;
			for(int i = 0; i < elements.size(); i++) {
				if(elements.get(i).isSelected()) {
					throw new Exception("Element is selected with locator=" + elements + ", index=" + i);
				}
			}	
		}
	
	
	public static boolean isEmpty(String input) {
		return input == null || input.trim().length()== 0;
	}
	
	
	public static void assertEquals(Object actual, Object expected, String message) throws Exception {
		Assert.assertEquals(actual, expected, message); 
	}
	
	public static void assertTrue(boolean value, String message) throws Exception {
		Assert.assertTrue(value,message);
	}
	
	
	
	
	

}
