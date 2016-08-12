package com.ok.WorldBankData.pageobjects;

import com.ok.WorldBankData.locators.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ok.selenium.util.WebUtil;

public class OldHICPage {
	
	public OldCountryPage clickOnCountry(WebDriver driver, String countryName){
		String countryLocator = Locators.countriesLocator + "[text() = '" + countryName + "']";
		
		WebUtil.clickWithOffset(driver, By.xpath(countryLocator));
		
		return PageFactory.initElements(driver, OldCountryPage.class);
	}
}
