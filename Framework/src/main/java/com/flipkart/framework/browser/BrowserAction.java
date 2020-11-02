package com.flipkart.framework.browser;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.flipkart.framework.logger.ScriptLogger;
import com.flipkart.framework.selenium.WebDriverAction;

public class BrowserAction extends BrowserAccess{
	
	public static void click(final WebElement element, final String... style) throws Exception {
		WebDriverAction.click(element, style);
		
	}
	
	public static void clickUsingActionClass(final WebElement element, final String... style) throws Exception {
		WebDriverAction.clickUsingActionClass(element, style);
		
	}

	
	public static void doubleClick(final WebElement element, final String... style) throws Exception {
		WebDriverAction.doubleClick(element);
		
	}

	
	public static void rightClick(final WebElement element, final String... style) throws Exception {
		WebDriverAction.rightClick(element);
		
	}

	
	public static void clear(final WebElement element, final String... style) throws Exception {
		WebDriverAction.clear(element, style);
		
	}

	
	public static void drag(final WebElement element, final int xOffset, final int yOffset) throws Exception {
		WebDriverAction.drag(element, xOffset, yOffset);
		
	}

	
	public static void dragAndDrop(final WebElement source, final WebElement target) throws Exception {
		WebDriverAction.dragAndDrop(source, target);
	}

	
	public static void dragAndDrop(final WebElement source, final int xOffset, final int yOffset)
			throws Exception {
		WebDriverAction.dragAndDrop(source, xOffset, yOffset);
	}

	
	public static void enterFieldValue(final WebElement element, final String value, final String... styles)
			throws Exception {
		WebDriverAction.enterFieldValue(element, value, styles);
		
	}

	public static void clickAndClear(final WebElement element, final String... styles) throws Exception {
		WebDriverAction.clickAndClear(element, styles);
		
	}

	
	public static void selectDropdownOptionByValue(final WebElement element, final String value) throws Exception {
		
		WebDriverAction.selectDropDownOptionByValue(element, value);
	}
	
	
	public static void selectDropdownOptionByText(final WebElement element, final String text) throws Exception {		
		WebDriverAction.selectDropDownOptionByText(element, text);
	}

	
	public static void hoverOverElement(final WebElement element, final String... styles) throws Exception {
		
		WebDriverAction.hoverOverElement(element);
	}

	
	public static void switchToFrame(final String frameName) throws Exception {
		
		WebDriverAction.switchToFrame(frameName);
	}

	
	public static void switchToFrame(final By locator ) throws Exception {
		WebDriverAction.switchToFrame(locator);
	}
    
	
	public static void switchToFrame(final WebElement element ) throws Exception {
		WebDriverAction.switchToFrame(element);
	}
	
	
	public static void switchToFrame(final int frameNumber) throws Exception {
		WebDriverAction.switchToFrame(frameNumber);
	}
	
	
	
	public static void switchToDefaultContent() throws Exception {
		
		WebDriverAction.switchToDefaultContent();
	}

	
	public static void openBrowser(final String appUrl) throws Exception {
		
		WebDriverAction.openBrowser(appUrl);
	}
	
	public static String getCurrentUrl() throws Exception {
		return WebDriverAction.getCurrentUrl();
	}
	
	public static void closeBrowser() throws Exception {
		WebDriverAction.closeBrowser();
	}

	
	public static void maximizeCurrentWindow() throws Exception {

		WebDriverAction.maximizeCurrentWindow();
	}
	
	
	public static void goBackToPrevious() throws Exception {
		WebDriverAction.goBackToPrevious();
	}

	
	public static void refresh() throws Exception {
		
		WebDriverAction.refresh();
	}

	
	public static void closeActiveWindow(Boolean useJS) throws Exception {
		if (useJS) {
			
			int startWindowCount = WebDriverAction.getDriver().getWindowHandles().size();
			ScriptLogger.debug("Window Count before close:" + startWindowCount);
			JavascriptExecutor js = (JavascriptExecutor) WebDriverAction.getDriver();
			String script = "window.onbeforeunload = null;" + "window.close();";
			js.executeScript(script);
			int maxCloseAttempts = 10;
			while (WebDriverAction.getDriver().getWindowHandles().size() == startWindowCount && maxCloseAttempts > 0) {
				ScriptLogger.debug("Window Count before close:" + startWindowCount
						+ " Is the same after close attempt, trying again...");
				ScriptLogger.debug("Sleeping 10 ms...");
				Thread.sleep(10);
				ScriptLogger.debug("...Attempt: " + maxCloseAttempts);
				js.executeScript(script);
				maxCloseAttempts -= 1;
			}
			if (maxCloseAttempts < 0) {
				ScriptLogger.debug("Failed to close window after 10 attempts");
			}
		} else {
			closeActiveWindow();
		}
	}

	public static void closeActiveWindow() throws Exception {
		WebDriverAction.closeActiveWindow();
	}
	
	public static void closeAllExceptActiveWindow() throws Exception {
		WebDriverAction.closeAllExceptActiveWindow();
	}

	
	public static void switchTo(final String handle) throws Exception {
		WebDriverAction.switchTo(handle);
	}

	
	public static void switchToPageByTitle(final String title) throws Exception {
		Thread.sleep(5000);
		Set<String> handles = WebDriverAction.getWindowHandles();
		String currentPageTitle;
		ScriptLogger.debug("Switching to window with title : '" + title + "'.");
		for (String handle : handles) {
			WebDriverAction.switchTo(handle);
			currentPageTitle = WebDriverAction.getPageTitle();
			if (currentPageTitle.contains(title)) {
				ScriptLogger.debug("Switched to window with title : '" + title + "'.");
				return;
			} else {
				ScriptLogger.debug(currentPageTitle + " does not match : '" + title + "'.");
			}

		}
		throw new Exception(title + " Not found in current windows");
	}

	
	public static void deleteAllCookies() throws Exception {
		WebDriverAction.deleteAllCookies();
	}

	
	public static void switchToNewWindow(final Set<String> handles, int time) throws Exception {
		WebDriverAction.switchToNewWindow(handles, time);
	}
	
	public static void switchToNewWindow() throws Exception {
		WebDriverAction.switchToNewWindow();
	}
	
	public static void switchToNewTab() throws Exception {
		WebDriverAction.switchToNewTabTest();
	}
	
	public static void switchToParentTab() throws Exception {
		WebDriverAction.switchToParentTab();
	}
	
	public static void switchToParentWindow() throws Exception {
		WebDriverAction.switchToParentWindow();
	}
	
	
	public static void scrollWindow(final int x, final int y) throws Exception {
		ScriptLogger.debug("Scrolling the window to horizontal offset (X-axis) by " + x
				+ " co-ordinates and vertical offset (Y-axis) by " + y + " co-ordinates.");
		WebDriverAction.scrollWindow(x, y);
	}

	
	public static void selectMultiple(final Select element, String... items) throws Exception {
		WebDriverAction.multiSelect(element, items);
	}	

	public static Alert switchToAlertBox() throws Exception {
		return WebDriverAction.switchToAlertBox();
	}

	public static void scrollElementUp(WebElement element) throws Exception {
		WebDriverAction.scrollElementUp(BrowserAccess.getElement(element));
	}
	
	public static void scrollPageToTop() throws Exception{
		WebDriverAction.scrollPageToTop();
	}

	public static void scrollElementDown(WebElement element) throws Exception {
		WebDriverAction.scrollElementDown(BrowserAccess.getElement(element));
	}
	
	/*******************Waits for locator, gets locator and scroll the window to particular locator *********************************/
	
	
	
		public static void scrollWindowToElement(final WebElement element,int time) throws Exception {
			WebDriverAction.scrollWindowToElement(element, time);
			
		}

	
	public static void scrollWindowToElement(final WebElement element) throws Exception {
		WebDriverAction.scrollWindowToElement(BrowserAccess.getElement(element));
	}		
	
	
	public static boolean verifyActiveElement(final WebElement element ) throws Exception {
		boolean active=false;
		active=WebDriverAction.verifyActiveElementTest(element);
		return active;
	}
}
