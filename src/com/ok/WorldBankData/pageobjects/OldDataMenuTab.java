package com.ok.WorldBankData.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ok.WorldBankData.config.*;
import com.ok.selenium.util.WebUtil;

public class OldDataMenuTab {

	public OldCountriesAndEconomiesPage clickOnByCountryTab(WebDriver driver) {
		WebUtil.click(driver, By.xpath(Locators.byCountryTabLocator));
		return PageFactory.initElements(driver, OldCountriesAndEconomiesPage.class);
	}	
}
