package com.ok.WorldBankData.config;

import org.openqa.selenium.By;

public class Locators {

	public static String dataTabLocator = "//ul[@class='_main_menu']/li/a[contains(@href, 'data.worldbank.org')]";
	
	public static String oldSiteLinkLocator = "//a[contains(@href, 'archive.data.worldbank.org')]";

	public static String byCountryTabLocator = "//li[@class='country first']";

	public static String highIncomeLinkLocator = "//a[text() = 'High income']";
	
	public static String countriesLocator = "//div[@id = 'block-views-income_levels_countries-block_1']//div[@class = 'grid-item']//a";
	
	public static final By countryNameLocator = By.xpath("//h1");
	public static final By GDPLocator = By.xpath("//a[contains(@href,'GDP.MKTP')]/span");
	public static final By populationLocator = By.xpath("//a[contains(@href,'SP.POP.TOTL')]/span");
	public static final By CO2Locator = By.xpath("//a[contains(text(), 'CO2 emissions')]/parent::div[@class='indicator-name']/following-sibling::div[position()=1]//span[@class='field-content']");

	public static final By homePageTabLocator = By.xpath("//a[text() = 'Home']");
}
