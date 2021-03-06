package com.flipkart.framework.selenium;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.framework.selenium.BaseWebDriver;
import com.flipkart.framework.selenium.WebDriverAccess;
import com.flipkart.framework.selenium.WebDriverAction;
import com.flipkart.framework.selenium.WebDriverWaits;

public class WebDriverAction extends WebDriverAccess {

	public static String ACTION_STYLE_WEBDRIVER = "WebDriver";
	public static String ACTION_STYLE_JAVASCRIPT = "JavaScript";
	public static String ACTION_STYLE_NEWLINE = "NewLine";
	public static String ACTION_STYLE_CTRLADEL = "CtrlADel";
	public static String ACTION_STYLE_CTRLADELTAB = "CtrlADelTab";
	public static String ACTION_STYLE_KEYS = "SendKeys";
	public static String ACTION_STYLE_CTRLAKEYS = "CtrAKeys";
	
	public static String parentWindowHandler = null;
	
	

	/*********** open browser ****************/
	public static void openBrowser(String url) throws Exception {
		driver.get(url);
	}
	
	public static String getCurrentUrl() throws Exception {
		return driver.getCurrentUrl();
	}

	/*********** close browser ****************/ 
	public static void closeBrowser() {
		driver.close();
	}

	/*********** refresh ****************/
	public static void refresh() throws Exception {
		driver.navigate().refresh();
	}

	/*********** click on element ****************/
	
	public static void clickUsingActionClass(final WebElement element, String... style) 	throws Exception {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();;
	}

	public static void click(final WebElement el, String... style)	throws Exception {
		String click = style.length > 0 ? style[0] : ACTION_STYLE_WEBDRIVER; // default is standard click
		if (click.equals(ACTION_STYLE_WEBDRIVER)) 		{	el.click();	} 
		else if (click.equals(ACTION_STYLE_JAVASCRIPT)) {	((JavascriptExecutor) driver).executeScript("arguments[0].click();", el); } 
		else if (click.equals(ACTION_STYLE_NEWLINE)) 	{	el.sendKeys("\n"); } 
		else 											{	throw new Exception("Unknown click action style: " + style[0]); }
	}

	/*********** clear an element ****************/
	
	public static void clear(final WebElement element, String... style)	throws Exception {
		String action = style.length > 0 ? style[0] : ACTION_STYLE_WEBDRIVER; // default is standard clear
		if (action.equals(ACTION_STYLE_WEBDRIVER)) 			{	element.clear(); } 
		else if (action.equals(ACTION_STYLE_CTRLADEL)) 		{	element.sendKeys(Keys.chord(Keys.CONTROL, "a")); element.sendKeys(Keys.DELETE);	} 
		else if (action.equals(ACTION_STYLE_CTRLADELTAB)) 		{	element.sendKeys(Keys.chord(Keys.CONTROL, "a")); element.sendKeys(Keys.DELETE);	element.sendKeys(Keys.TAB);	} 
		else 												{	throw new Exception("Unknown clear action style: " + style[0]);	}
	}


	/*********** click and clear an element ****************/

	public static void clickAndClear(final WebElement element, String... style)	throws Exception {
		String click = style.length > 0 ? style[0] : ACTION_STYLE_WEBDRIVER; // default is standard click
		String clear = style.length > 0 ? style[1] : ACTION_STYLE_WEBDRIVER; // default is standard clear
		click(element, click);
		clear(element, clear);
	}


	
	/*********** enter a value into a field ****************/

	public static void enterFieldValue(final WebElement el, String value, String... styles) throws Exception {
		String click = styles.length > 0 ? styles[0] : ACTION_STYLE_WEBDRIVER; // default is standard click
		String send = styles.length > 1 ? styles[1] : ACTION_STYLE_KEYS; // default is standard send		
		click(el, click);
		if(send.equals(ACTION_STYLE_CTRLAKEYS)) {
			el.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			el.sendKeys(value);
		}
		else if(send.equals(ACTION_STYLE_KEYS)) {
			el.sendKeys(value);
		} else if(send.equals(ACTION_STYLE_JAVASCRIPT))  {
			JavascriptExecutor execute = (JavascriptExecutor) BaseWebDriver.driver;
			execute.executeScript("document.getElementById('"+el+"').value = '"+value+"';");
		}
	}

	/**
	 * Selects an option in a dropdown menu.
	 * @param locator locator for the drop down menu
	 * @param value value of the option (not visible text)
	 * @throws Exception
	 */
	public static void selectDropDownOptionByValue(final WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * Selects an option in a dropdown menu.
	 * @param locator locator for the drop down menu
	 * @param value value of the option (not visible text)
	 * @throws Exception
	 */
	public static void selectDropDownOptionByText(final WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/*********** hover over an element ****************/

	public static void hoverOverElement(WebElement element, String... styles) throws Exception {
		String click = styles.length > 0 ? styles[0] : ACTION_STYLE_WEBDRIVER; // default is standard click
		if (click.equals(ACTION_STYLE_WEBDRIVER)) 			{ new Actions(driver).moveToElement(element).build().perform();	} 
		else if (click.equals(ACTION_STYLE_JAVASCRIPT)) 	{ ((JavascriptExecutor)driver).executeScript("arguments[0].mouseover();", element);} 
		else 												{ throw new Exception("Unknown click style: " + styles[0]);	}
	}


	/*********** maximize current window ****************/
	public  static void maximizeCurrentWindow() throws Exception {		
		
		if( browser.equalsIgnoreCase("ie") || browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("chrome"))
			driver.manage().window().maximize();
	}
	
	/*********** back to previous page ****************/
	public  static void goBackToPrevious() throws Exception {		
		
		if(browser.equalsIgnoreCase("ie") || browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("chrome"))
			driver.navigate().back();
	}

	/*********** clear an active window ****************/
	public static void closeActiveWindow() throws Exception {
		driver.close();
	}
	
	public static void closeAllExceptActiveWindow() throws Exception {
		String originalHandle = driver.getWindowHandle();
		for(String handle : driver.getWindowHandles()) {
	        if (!handle.equals(originalHandle)) {
	            driver.switchTo().window(handle);
	            driver.close();
	        }
	    }

	    driver.switchTo().window(originalHandle);
	}

	/*********** switch to another window ****************/
	public static void switchTo(String handle) throws Exception {
		driver.switchTo().window(handle);
	}

	/*********** switch to another frame ****************/
	public static void switchToFrame(String name) throws Exception {
		driver.switchTo().frame(name);
	}
	
	/*********** attempts switch to frame by number ****************/
	public static void switchToFrame(int frameNumber) throws Exception {
		driver.switchTo().frame(frameNumber);
	}

	/*********** attempts switch to frame by locator  @param locator ****************/
	public static void switchToFrame(By locator) throws Exception {
		switchToFrame(driver.findElement(locator));
	}
	
	/*********** attempts switch to frame by WebElement ****************/
	public static void switchToFrame(WebElement element) throws Exception {
		driver.switchTo().frame(element);
	}
	
	/*********** attempts switch to page content ****************/
	public static void switchToDefaultContent() throws Exception {
		driver.switchTo().defaultContent();
	}
	/*********** attempts switch to an alert ****************/
	public static Alert switchToAlertBox() throws Exception{
		return driver.switchTo().alert();
	}
	

	/*********** attempts switch to another window ****************/
	public static void switchToNewWindow(final Set<String> handles,  int time) throws Exception {
		(new WebDriverWait(driver, time)).until(new ExpectedCondition<Boolean>() { 
			public Boolean apply(WebDriver d) { 
				Set<String> newHandles = d.getWindowHandles(); 
				newHandles.removeAll(handles); 
				if (newHandles.size() > 0) { 
					d.switchTo().window(newHandles.iterator().next()); 
					return true; 
				} else { 
					return false; 
				} 
			} 
		}); 
	}
	
	public static void switchToNewWindow() throws Exception {
		parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
		System.out.println("Current window handle is: " +subWindowHandler);
	}
	
	public static void switchToParentWindow() throws Exception {
		driver.switchTo().window(parentWindowHandler);
	}
	
	/*********** Switch to new Tab ****************/
	public static void switchToNewTabTest() throws Exception {
		parentWindowHandler = driver.getWindowHandle();
		for(String winHandle : WebDriverAction.getDriver().getWindowHandles()){
			WebDriverAction.getDriver().switchTo().window(winHandle);
		}
		System.out.println("Current page is: " +WebDriverAction.getDriver().getTitle());
	}
	
	public static void switchToParentTab() throws Exception {
		driver.switchTo().window(parentWindowHandler);
	}
	
	/*********** Deletes all cookies ****************/
	public static void deleteAllCookies() throws Exception {
		driver.manage().deleteAllCookies();
	}
		
	/*********** scroll the window if to x and y coordinates  ****************/
	public static void scrollWindow(int x, int y) throws Exception{
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy("+x+","+y+")", "");
	}

	/*********** Scrolling a Web Element for which scroll feature is available  ****************/
	public static void scrollElementUp(WebElement element) throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script="return arguments[0].contentWindow.scrollTo(0,0)";
		js.executeScript(script, element);
	}
	
	public static void scrollPageToTop() throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	public static void scrollElementDown(WebElement element) throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will return  long value  
		Long height=(Long)js.executeScript("return arguments[0].scrollHeight",element);
		String script=String.format("arguments[0].contentWindow.scrollTo(0,%s)",height);
		js.executeScript(script,element);

	}
	
	/*******************Waits for locator, gets locator and scroll the window to particular locator *********************************/
	//Added by Paresh on 23 Feb 2018 
	public static void scrollWindowToElement(WebElement element) throws Exception{
		Point point=null;
		WebDriverWaits.waitUntilElementIsDisplayed(element);
		point = element.getLocation();
		scrollWindow(point.getX(), point.getY());
	}
		
		public static void scrollWindowToElement(WebElement element,int time) throws Exception{
			Point point=null;
			WebDriverWaits.waitUntilElementIsDisplayed(element,time);
			point = element.getLocation();
			scrollWindow(point.getX(), point.getY());
		}
		
		//Added  method to to verify element is active or not.
		public static boolean verifyActiveElementTest(WebElement element) throws Exception{
			boolean active=false;
			active=driver.switchTo().activeElement().equals(element);
			return active;
		}
		
		
	/****************************************************************************************************
	 * 
	 * *****************************MOBILE TESTING METHODS***********************************************
	 * 
	 * **************************************************************************************************/
	
	
	
	/**
	 * Allows the execution of double tapon the screen, analogous to double click using a Mouse.
	 * @param locator The WebElement to double tap
	 * @throws Exception
	 * @author  
	 * @since November 29, 2016
	 */
	public static void doubleTap(final By locator) throws Exception {
		/*actions.doubleTap(WebDriverAccess.getElement(locator)).build()
				.perform();*/
	}
	
	
	/**
	 * Allows the execution of the gesture 'down' on the screen. It is typically
	 * the first of a sequence of touch gestures.
	 * 
	 *@param x
	 *            The x coordinate relative to the viewport
	 * @param y
	 *            The y coordinate relative to the viewport
	 * @throws Exception
	 * @author  
	 * @since November 29, 2016
	 */
	public static void down(final int x, final int y) throws Exception {
		/*actions.down(x, y).build().perform();*/
	}

	/**
	 * Sends a flick gesture to the current view.
	 * 
	 * @param x
	 *            The horizontal speed in pixels/second
	 * @param y
	 *            The vertical speed in pixels/second
	 * @throws Exception
	 * @author  
	 *@since November 29, 2016
	 */
	public static void flick(final int x, final int y) throws Exception {
		/*actions.flick(x, y).build().perform();*/
	}

	/**
	 * Allows the execution of flick gestures starting in a location's element.
	 * 
	 * @param locator
	 *            The WebElement to flick on
	 * @param x
	 *            The x offset relative to the viewport
	 * @param y
	 *            The y offset relative to the viewport
	 * @param speed
	 *            The speed in pixels/second
	 * @author  
	 * @since November 29, 2016
	 */
	public static void flick(final By locator, final int x, final int y,
			final int speed) throws Exception {
		/*actions.flick(WebDriverAccess.getElement(locator), x, y, speed).build()
				.perform();*/
	}

	/**
	 * Allows the execution of long press gestures.
	 * 
	 * @param locator
	 *            The WebElement to long press
	 * @throws Exception
	 * @author  
	 * @since November 29, 2016
	 */
	public static void longPress(final By locator) throws Exception {
		/*actions.longPress(WebDriverAccess.getElement(locator)).build()
				.perform();*/
	}

	/**
	 * Allows the execution of single tap on the screen, analogous to click
	 * using a Mouse.
	 * 
	 * @param locator
	 *            the WebElement on the screen.
	 * @throws Exception
	* @author  
	 * @since November 29, 2016
	 */
	public static void singleTap(final By locator) throws Exception {
		/*actions.singleTap(WebDriverAccess.getElement(locator)).build()
				.perform();*/
	}

	/**
	 * Allows the execution of the gesture 'up' on the screen. It is typically
	 * the last of a sequence of touch gestures.
	 * 
	 * @param x
	 *            The x coordinate relative to the viewport
	 * @param y
	 *            The y coordinate relative to the viewport
	 * @throws Exception
	 * @author  
	 * @since November 29, 2016
	 */
	public static void up(final int x, final int y) throws Exception {
		/*actions.up(x, y).build().perform();*/
	}

	/**
	 * Allows the execution of the gesture 'move' on the screen.
	 * 
	 * @param x
	 *            The x coordinate relative to the viewport
	 * @param y
	 *            The y coordinate relative to the viewport
	 * @author  
	 * @since November 29, 2016
	 */
	public static void move(final int x, final int y) {
		/*actions.move(x, y).build().perform();*/
	}

	/**
	 * Creates a scroll gesture that starts on a particular screen location.
	 * 
	 * @param onElement
	 *            the WebElement where the scroll starts.
	 * @param xOffset
	 *            The x offset to scroll
	 * @param yOffset
	 *            The y offset to scroll
	 * @throws Exception
	 * @author  
	 * @since November 29, 2016
	 */
	public static void scroll(final By locator, final int x, final int y)
			throws Exception {
		/*actions.scroll(WebDriverAccess.getElement(locator), x, y);*/
	}

	/**
	 * Allows the view to be scrolled by an x and y offset.
	 * 
	 * @param xOffset
	 *            The horizontal offset relative to the viewport
	 * @param yOffset
	 *            The vertical offset relative to the viewport
	 * @author  
	 * @since November 29, 2016
	 */

	public static void scroll(int x, int y) {
		/*actions.scroll(x, y);*/
	}

	
	/**
	 * Returns the device orientation
	 * 
	 * @return ScreenOrientation
	 * @throws Exception
	 * @author  
	 * @since November 29, 2016
	 */
	public static ScreenOrientation getDeviceOrientation() throws Exception {
		WebDriver d = new Augmenter().augment(driver);
		Rotatable rotator = ((Rotatable) d);
		return rotator.getOrientation();
	}
	
	
	/**
	 * If this element is a text entry element, this will clear the value.
	 * 
	 * @param locator
	 *            Element locator
	 * @param Text 
	 * 			Items to select
	 * 
	 * @throws Exception
	 * @author  
	 * @since November 29, 2016
	 */


	public static void multiSelect(final Select element, final String... textItems)
			throws Exception {
		for (String textItem:textItems)
		{
			element.selectByVisibleText(textItem);
		}

	}
	
	/**
	 * Click this element. If this causes a new page to load, this method will
	 * attempt to block until the page has loaded.
	 * 
	 * @param locator
	 *            Element locator
	 * @param style
	 * 
	 * @throws Exception
	 */
	public static void doubleClick(final WebElement el)
	{
		Actions action = new Actions(driver);
		action.doubleClick(el).perform();
	}

	/**
	 * Right Click this element. 
	 * 
	 * @param locator
	 *            Element locator
	 * @param style
	 * 
	 * @throws Exception
	 */

	public static void rightClick(final WebElement el)
	{
		Actions actions = new Actions(driver);    
		actions.contextClick(el).build().perform();
	}
	/**
	 * Drags the element from its current position (or 0,0) by the given offset.
	 * If the coordinates provided are outside the viewport (the mouse will end
	 * up outside the browser window) then the viewport is scrolled to match.
	 * 
	 * @param locator
	 *            Element locator
	 * @param xOffset
	 *            horizontal offset. A negative value means moving the mouse
	 *            left.
	 * @param yOffset
	 *            vertical offset. A negative value means moving the mouse up.
	 * @throws Exception
	 */


	public static void drag(final WebElement source, final int xOffset,
			final int yOffset) throws Exception {
		final Actions builder = new Actions(driver);
		final Action dragAndDrop = builder.clickAndHold(source)
				.moveByOffset(xOffset, yOffset).release().build();
		dragAndDrop.perform();
	}

	/**
	 * This performs click-and-hold at the location of the source element, moves
	 * to the location of the target element, then releases the mouse.
	 * 
	 * @param source
	 *            element to emulate button down at.
	 * @param target
	 *            element to move to and release the mouse at.
	 * 
	 * @throws Exception
	 */

	/**
	 * This performs click-and-hold at the location of the source element, moves
	 * to the location of the target element, then releases the mouse.
	 * 
	 * @param source
	 *            element to emulate button down at.
	 * @param target
	 *            element to move to and release the mouse at.
	 * 
	 * @throws Exception
	 */
	public static void dragAndDrop(final WebElement source,
			final WebElement target) throws Exception {
		final Actions builder = new Actions(driver);
		final Action dragAndDrop = builder.clickAndHold(source)
				.moveToElement(target).release(target).build();
		dragAndDrop.perform();
	}

	/**
	 * This performs click-and-hold at the location of the source element, by
	 * given offset, then releases the mouse.
	 * 
	 * @param source
	 *            element to emulate button down at.
	 * @param target
	 *            element to move to and release the mouse at.
	 * @param xOffset
	 *            horizontal offset. A negative value means moving the mouse
	 *            left.
	 * @param yOffset
	 *            vertical offset. A negative value means moving the mouse up.
	 * 
	 * @throws Exception
	 */


	/**
	 * This performs click-and-hold at the location of the source element, by
	 * given offset, then releases the mouse.
	 * 
	 * @param source
	 *            element to emulate button down at.
	 * @param target
	 *            element to move to and release the mouse at.
	 * @param xOffset
	 *            horizontal offset. A negative value means moving the mouse
	 *            left.
	 * @param yOffset
	 *            vertical offset. A negative value means moving the mouse up.
	 * 
	 * @throws Exception
	 */
	public static void dragAndDrop(final WebElement source, final int xOffset, final int yOffset)
			throws Exception {
		final Actions builder = new Actions(driver);
		final Action dragAndDrop = builder.clickAndHold(source).moveByOffset(xOffset, yOffset)
				.release().build();
		dragAndDrop.perform();
	}
	
	


}
