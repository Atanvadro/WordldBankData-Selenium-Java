package com.ok.WorldBankData.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ok.WorldBankData.config.*;
import com.ok.WorldBankData.tests.CountryData;
import com.ok.selenium.util.WebUtil;

public class OldHICPage {
	
	public HomePage clickOnHomePageTab(WebDriver driver){
		WebUtil.clickWithOffset(driver, Locators.homePageTabLocator);
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public OldCountryPage clickOnCountry(WebDriver driver, String countryName){
		String countryLocator = Locators.countriesLocator + "[text() = '" + countryName + "']";
		
		WebUtil.waitForElementVisible(driver, By.xpath(countryLocator));
		
		if(WebUtil.elementExists(driver, Locators.PopUpBannerLocator)){
			WebUtil.click(driver, Locators.PopUpBannerLocator);
			System.out.println("POPUP DESTROYED");
		}
		
		WebUtil.clickWithOffset(driver, By.xpath(countryLocator));
		
		return PageFactory.initElements(driver, OldCountryPage.class);
	}

	public CountryData[] initCountriesDataArray(WebDriver driver) {
		List<WebElement> countriesElementsList = driver.findElements(By.xpath(Locators.countriesLocator));
		int numberOfCountries = countriesElementsList.size();
		CountryData[] countriesDataArr = new CountryData[numberOfCountries];

		int i = 0;
		for ( WebElement element: countriesElementsList) {
			//System.out.println(element.getText());
			String countryName = element.getText();
			countriesDataArr[i] = new CountryData(countryName);
			i++;
		}
		return countriesDataArr;
	}
}
