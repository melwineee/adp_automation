package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	public LoginPage(WebDriver driver) {
		
		super();
	}
	
	
	public static By langEnglish = By.xpath("//a[@title='English']");
	public static By search = By.xpath("(//input[@name='q'])[2]");
	public static By searchList = By.xpath("//h4[@class='ui-lib-link__heading ui-lib-bold']");
	public static By totalResults = By.xpath("//p[@class='totalResultsText']");
	
	
	public static By burgerMenu = By.xpath("//a[@class='TPN-header__action-burger-btn']");
	public static By govtEntities = By.xpath("//a[text()='Abu Dhabi Government Entities']");
	public static By govtEntitiesSearch = By.xpath("//input[@class='search-box-input tt-input']");
	public static By govtEntitiesresultscount = By.xpath("//div[@class='results-count']");
	public static By govtEntitiesSearchList = By.xpath("//h2[@class='TPN-adge-card__Title']/a");
	public static By adpLink = By.xpath("//a[text()=' Abu Dhabi Police ']");
	
	
	
}
