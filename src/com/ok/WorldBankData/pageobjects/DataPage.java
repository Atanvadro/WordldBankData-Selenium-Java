package com.ok.WorldBankData.pageobjects;

import com.ok.WorldBankData.locators.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ok.selenium.util.WebUtil;

public class DataPage {
	public OldDataMenuTab clickOldSiteLink(WebDriver driver){
		WebUtil.waitForElementVisible(driver, By.xpath(Locators.oldSiteLinkLocator));
		WebUtil.click(driver, By.xpath(Locators.oldSiteLinkLocator));
		return PageFactory.initElements(driver, OldDataMenuTab.class);
	}
}
