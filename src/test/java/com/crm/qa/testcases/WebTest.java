package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.WebTestPage;;


public class WebTest extends TestBase{
	
	WebDriverWait wait; 
	public WebTest(){
		super();
	}
	
	@BeforeSuite
	public void setUp(){
		initialization();
		 wait = new WebDriverWait(driver,Duration.ofSeconds(500));
		
	}
	
	@Test(priority=1)
	public void navigateToAmazonPage(){
		
		
		try {
			driver.get("https://www.amazon.in/");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(WebTestPage.searchTxtBox));
			
			if(driver.findElement(WebTestPage.searchTxtBox).isDisplayed())
			{
				 System.out.println("Home Page Navigation succesful");
			}else {
				
				System.out.println("Home Page Navigation failed");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	
		@Test(priority=2)
		public void searchItem(){
			
			
			try {
				
				driver.findElement(WebTestPage.searchTxtBox).sendKeys("‘Apple iPhone 14 Pro");
				driver.findElement(WebTestPage.searchSubmitIcon).click();	
				wait.until(ExpectedConditions.visibilityOfElementLocated(WebTestPage.firstSearchResult));

				if(driver.findElement(WebTestPage.firstSearchResult).isDisplayed())
				{
					 System.out.println("Item Search succesful");
				}else {
					
					System.out.println("Item Search failed");
				}
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			@Test(priority=3)
			public void navigateToProductDetailsPage(){
				
				
				try {
					
					driver.findElement(WebTestPage.firstSearchResult).click();	 
					
					ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
				      //switch to new tab
				      driver.switchTo().window(newTb.get(1));
				      System.out.println("Page title of new tab: " + driver.getTitle());
				      
					if(driver.findElement(WebTestPage.addToCartButton).isDisplayed())
					{
						 System.out.println("Product Details Page navigation succesful");
					}else {
						
						System.out.println("Product Details Page navigation failed");
					}
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
	}
			@Test(priority=4)
			public void addtoCart(){
				
				
				try {
					
				   driver.findElement(WebTestPage.addToCartButton).click();	 
			    
					driver.findElement(WebTestPage.cartButton).click();
					if(driver.findElement(WebTestPage.cartHeader).isDisplayed())
					{
						 System.out.println("Cart Page Navigation succesful");
					}else {
						
						System.out.println("Cart Page Navigation failed");
					}
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
	}
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
	
}
