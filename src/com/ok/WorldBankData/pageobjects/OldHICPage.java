package com.ok.WorldBankData.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ok.WorldBankData.config.*;
import com.ok.selenium.util.WebUtil;

public class OldHICPage {
	
	public HomePage clickOnHomePageTab(WebDriver driver){
		WebUtil.clickWithOffset(driver, Locators.homePageTabLocator);
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public OldCountryPage clickOnCountry(WebDriver driver, String countryName){
		String countryLocator = Locators.countriesLocator + "[text() = '" + countryName + "']";
		
		WebUtil.clickWithOffset(driver, By.xpath(countryLocator));
		
		return PageFactory.initElements(driver, OldCountryPage.class);
	}
}
