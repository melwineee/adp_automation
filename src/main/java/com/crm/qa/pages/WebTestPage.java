package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.crm.qa.base.TestBase;

public class WebTestPage extends TestBase{
	
	
	public WebTestPage(WebDriver driver) {
		
		super();
	}
	
	

	public static By searchTxtBox = By.id("twotabsearchtextbox");
	public static By searchSubmitIcon = By.id("nav-search-submit-button");
	public static By firstSearchResult = By.xpath("(//span[@data-component-type='s-product-image'])[1]");
	public static By addToCartButton = By.id("add-to-cart-button");
	public static By cartButton = By.id("attach-sidesheet-view-cart-button");
	public static By cartHeader = By.xpath("//h1[contains(text(),'Shopping Cart')]");
	public static By secureTransactionIconWrapper = By.id("secureTransactionIconWrapper");
	
	
}
