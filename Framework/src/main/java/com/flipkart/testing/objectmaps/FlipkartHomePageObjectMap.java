package com.flipkart.testing.objectmaps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FlipkartHomePageObjectMap {
	
	
	
	@FindBy(xpath="//*[text()='✕']")
	public static WebElement LOGIN_MODAL_CROSS_BTN;
	
	@FindBy(xpath="//span[contains(text(),'Electronics')]")
	public static WebElement FLIPKART_HOMEPAGE_ELECTRONICS_LINK;
	
	@FindBy(xpath="//a[@title='Mobiles']//following-sibling::a[text()='Mi']")
	public static WebElement FLIPKART_HOMEPAGE_MI_LINK;
	
	
	
	@FindBy(xpath="//input[@placeholder='Enter full name']")
	public static WebElement STORE_HOMEPAGE_SIGNUP_POP_UP_FULL_NAME;
	
	@FindBy(xpath="//input[contains(@placeholder,'email ad')]")
	public static WebElement STORE_HOMEPAGE_SIGNUP_POP_UP_EMAIL_ID;
	
	@FindBy(xpath="//input[contains(@placeholder,'password')]")
	public static WebElement STORE_HOMEPAGE_SIGNUP_POP_UP_PASSWORD;
	
	
	
	
	
	
	

}
