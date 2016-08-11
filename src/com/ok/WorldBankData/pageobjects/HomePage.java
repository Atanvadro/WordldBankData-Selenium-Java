package com.ok.WorldBankData.pageobjects;

import com.ok.WorldBankData.locators.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ok.selenium.util.WebUtil;

public class HomePage{

	public HomePage() {
		// TODO Auto-generated constructor stub
	}

	public void clickDataTab(WebDriver driver) {
		// TODO Auto-generated method stub
		WebUtil.click(driver, By.xpath(Locators.dataTabLocator));
	}

}
