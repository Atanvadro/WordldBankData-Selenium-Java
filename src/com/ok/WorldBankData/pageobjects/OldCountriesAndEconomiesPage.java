package com.ok.WorldBankData.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ok.WorldBankData.config.*;
import com.ok.selenium.util.WebUtil;

public class OldCountriesAndEconomiesPage {

	public OldHICPage clickHighIncome(WebDriver driver) {
		WebUtil.clickWithOffset(driver, By.xpath(Locators.highIncomeLinkLocator));
		return PageFactory.initElements(driver, OldHICPage.class);
	}
}
