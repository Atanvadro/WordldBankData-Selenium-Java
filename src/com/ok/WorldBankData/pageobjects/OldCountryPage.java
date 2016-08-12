package com.ok.WorldBankData.pageobjects;

import com.ok.WorldBankData.config.*;
import com.ok.WorldBankData.tests.CountryData;

import org.openqa.selenium.WebDriver;

import com.ok.selenium.util.WebUtil;

public class OldCountryPage {	

	public CountryData getData(WebDriver driver) {
		String countryName = WebUtil.getElementText(driver, Locators.countryNameLocator);
		CountryData data = new CountryData(countryName);
		
		String GDP = WebUtil.getElementText(driver, Locators.GDPLocator);
		System.out.println(parseGDP(GDP));
		data.GDP = parseGDP(GDP);
		
		String population = WebUtil.getElementText(driver, Locators.populationLocator);
		System.out.println(parsePopulation(population));
		data.population = parsePopulation(population);
		
		String CO2 = WebUtil.getElementText(driver, Locators.CO2Locator);
		System.out.println(CO2);
		data.CO2 = parseCO2(CO2);
		
		return data;
	}
	
	private float parseCO2(String CO2) {
		return Float.parseFloat(CO2);
	}

	private double parseGDP(String GDP){
		
		String trimmedStr = GDP.replace("$", "").replace("billion", "").replace("trillion","").replace(" ", "");
		
		double tempDbl = Double.parseDouble(trimmedStr);
		
		if (GDP.contains("billion")){
			tempDbl = tempDbl * 1000000000d;
		}
		if (GDP.contains("trillion")){
			tempDbl = tempDbl * 1000000000000d;
		} 
		return tempDbl;
	}
	
	private long parsePopulation(String population) {
		String trimmedStr = population.replace(" ", "").replace(",", "").replace("million", "").replace("billion", "");
		
		double tempDbl = Double.parseDouble(trimmedStr);
		if (population.contains("million")){
			tempDbl = tempDbl * 1000000d;
		}
		if (population.contains("billion")){
			tempDbl = tempDbl * 1000000000d;
		} 
		
		return (long)tempDbl;
	}
}
