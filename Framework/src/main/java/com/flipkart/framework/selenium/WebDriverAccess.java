package com.flipkart.framework.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.flipkart.framework.selenium.BaseWebDriver;



public class WebDriverAccess extends BaseWebDriver {
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	public static WebElement getElement(final WebElement element) throws Exception {
		return element;
	}	
	
	public static List<WebElement> getElements(final List<WebElement> element) throws Exception {
		return element;
	}
	
	public static String getElementInnerHtml(final WebElement el)  throws Exception {
		return (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", el);
	}
	
	public static String getElementAttributeValue(final WebElement element, String attribute) throws Exception {
		 return element.getAttribute(attribute);
	}
	
	
	public static String getElementText(final WebElement el, boolean... js)  throws Exception {
		if(js.length == 0 || js[0]) {	// default is JavaScript
			if(browser.equalsIgnoreCase("ie"))
				return (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerText;", el);
			else
				return (String)((JavascriptExecutor)driver).executeScript("return arguments[0].textContent;", el);
		}
		return el.getText();
	}
	
	public static List<String> getElementsText(final List<WebElement> elements, boolean... js) throws Exception {
		List<String> result = new ArrayList<String>();
		for(WebElement each : elements)
			result.add(getElementText(each, js).trim());
		return result;
	}
	
	public static String getPageTitle() throws Exception {
		return driver.getTitle();
	}
	
	public static String getWindowHandle() throws Exception {
		return driver.getWindowHandle();
	}
	
	public static Set<String> getWindowHandles() throws Exception {
		return driver.getWindowHandles();
	}
	
	
	/**
	 * Gets all options for a dropdown menu.
	 * @param locator locator for the dropdown menu.
	 * @return void
	 */
	public static List<WebElement> getDropDownOptions(final WebElement element) {
		Select select = new Select(element);
		return select.getOptions();
	}
	
	/**
	 * Remove an attribute
	 * @param Web element, Attribute, Value
	 * @return void
	 */
	public static String removeAttribute(final WebElement el,String...js) {
		return (String)((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('"+js[0]+"','"+js[1]+"')", el);
	}
	
	/**
	 * Remove an attribute
	 * @param Web element, Attribute, Value
	 * @return void
	 */
	public static String setAttribute(final WebElement el,String...js) {
		return (String)((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('"+js[0]+"','"+js[1]+"')", el);
		
		
	}
	
	public static String getPageSource() throws Exception {
		return driver.getPageSource();
	}
	
	/**
	 * Gets Network log Entries from network console
	 * @param window configuration
	 * @return void
	 */
	
	public static String getNetworkLogEntries() throws Exception{
		String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
		String networkLog = ((JavascriptExecutor) getDriver()).executeScript(scriptToExecute).toString();
		return networkLog; 
	}

   	public static String getDropdownOptionFirstSelectedValue(final WebElement element) throws Exception {
		Select select = new Select(element);
		String option = select.getFirstSelectedOption().getText();
		return option;
	}
}
