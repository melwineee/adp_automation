package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
import com.crm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{
	
	WebDriverWait wait; 
	public LoginPageTest(){
		super();
	}
	
	@BeforeSuite
	public void setUp(){
		initialization();
		 wait = new WebDriverWait(driver,Duration.ofSeconds(500));
		
	}
	
	@Test(priority=1)
	public void homePageTitleTest(){
		
		
		try {
			driver.get("https://www.tamm.abudhabi/ar-AE/");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.langEnglish));
			driver.findElement(LoginPage.langEnglish).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.search));
			String title = driver.getTitle();
			assertEquals(title,"TAMM - Abu Dhabi Government services");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Test(priority=2)
	public void qe1searchTestValidation(){
	try {
			
			WebElement search =driver.findElement(LoginPage.search);	
			search.click();
			search.clear();
			search.sendKeys("Abudhabi Police");
			search.sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.totalResults));
			String totalResults= driver.findElement(LoginPage.totalResults).getText();
			String totalResultsTemp="";
			int i;
			System.out.println(totalResults);
			
			List<WebElement> searchResult = driver.findElements(LoginPage.searchList);	
			System.out.println(" list size:"+searchResult.size());
			List<String> searchResultReq = new ArrayList<String>(); 
			List<String> searchResulttemp = new ArrayList<String>(); 
			for(i=1;i<=5;i++)
			
			{
				searchResultReq.add(driver.findElement(By.xpath("(//h4[@class='ui-lib-link__heading ui-lib-bold'])["+i+"]")).getText());	
				System.out.println(driver.findElement(By.xpath("(//h4[@class='ui-lib-link__heading ui-lib-bold'])["+i+"]")).getText());
			}
			System.out.println(" searchResultReqlist size add:"+searchResultReq.size());
			for( int k=1;k<=5;k++)
			
			{
				driver.navigate().refresh();
				totalResultsTemp= driver.findElement(LoginPage.totalResults).getText();
				Assert.assertEquals(totalResults, totalResultsTemp, "Total result status");
								
				for( int j=1;j<=5;j++) {
					
				searchResulttemp.add(driver.findElement(By.xpath("(//h4[@class='ui-lib-link__heading ui-lib-bold'])["+j+"]")).getText());	
				
				}
				
				if (searchResultReq.equals(searchResulttemp) == true) {
					
					
		            System.out.println(" Array List are equal refresh "+k);
		   
		        }
		        else {
		        	 System.out.println(" Array List are not equal : refresh "+k);
		        	Assert.fail("Array List are not equal : refresh "+k);
		           
		        }
				
				searchResulttemp.clear();
		    }
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Test(priority=3)
	public void qe2searchTestValidation(){
	try {
		driver.get("https://www.tamm.abudhabi");
		
	wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.burgerMenu));
		String title2 = driver.getTitle();
		assertEquals(title2,"TAMM - Abu Dhabi Government services");
		
		driver.findElement(LoginPage.burgerMenu).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.govtEntities));

		driver.findElement(LoginPage.govtEntities).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.govtEntitiesSearch));
			WebElement search =driver.findElement(LoginPage.govtEntitiesSearch);
			
			search.click();
			search.clear();
			search.sendKeys("ADP");
			search.sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.govtEntitiesresultscount));

			String totalResults= driver.findElement(LoginPage.govtEntitiesresultscount).getText();
			
			int i;
			System.out.println(totalResults);
			
			List<WebElement> searchResult = driver.findElements(LoginPage.govtEntitiesSearchList);	
			System.out.println(" list size:"+searchResult.size());
			for(i=1;i<=searchResult.size();i++)
			
			{
				String linkText=driver.findElement(By.xpath("(//h2[@class='TPN-adge-card__Title']/a)["+i+"]")).getText();
				System.out.println(driver.findElement(By.xpath("(//h2[@class='TPN-adge-card__Title']/a)["+i+"]")).getText());
				if(linkText.startsWith("A")||linkText.startsWith("D")||linkText.startsWith("P")){
					
					System.out.println(" Results having A,D,P listed");
				}else {
					System.out.println(" Results are not having A,D,P");	
					
				}
			
			}
			driver.findElement(LoginPage.adpLink).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.govtEntitiesresultscount));
			String title1 = driver.getTitle();
		
			assertEquals(title1,"TAMM - AbuDhabiPolice");
			
			String totalResultsADP= driver.findElement(LoginPage.govtEntitiesresultscount).getText();	
			System.out.println("ADP Search result: "+totalResultsADP);
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
