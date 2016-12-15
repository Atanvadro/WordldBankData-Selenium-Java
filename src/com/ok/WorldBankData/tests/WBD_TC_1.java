package com.ok.WorldBankData.tests;

import com.ok.WorldBankData.config.Config;
import com.ok.WorldBankData.config.Locators;
import com.ok.WorldBankData.pageobjects.*;
import com.ok.selenium.util.*;


import java.io.File;
import java.io.IOException;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class WBD_TC_1  {
	WebDriver driver;
	
	@Before
	public void setDriver(){
		
   		switch(Config.browser){
			case Chrome: driver = new ChromeDriver(); break;
			case IE:     driver = new InternetExplorerDriver();break;
			default:	 driver = new FirefoxDriver();
    	}
	}
	
	@Test
	public void TC_1() throws IOException{
		Logger.setUp();		
		
	 	Logger.logMESSAGE("1. Open the world bank site in a firefox browser.");
		HomePage homePage;
		homePage = WebUtil.goToPage(driver, HomePage.class, Config.homePageURL);
		AssertUtil.assertEquals("World bank site home page should open", Config.homePageURL, driver.getCurrentUrl());
		
	 	Logger.logMESSAGE("2.  Click on the Data tab. ");
	    DataPage dataPage = homePage.clickDataTab(driver);
	    AssertUtil.assertEquals("It should navigate to World bank site Data page", Config.dataPageURL, driver.getCurrentUrl());

//	 	3.1  Click on the link "visit the old site here". It should navigate to "http://archive.data.worldbank.org/" page
//		(Note - Above step added due to recent modification to the world bank website)
	    Logger.logMESSAGE("3.1  Click on the link 'visit the old site here' to navigate to older site.");
	    OldDataMenuTab oldDataMenuTab = dataPage.clickOldSiteLink(driver);
		AssertUtil.assertEquals("It should navigate to 'http://archive.data.worldbank.org/'", Config.oldDataPageURL, driver.getCurrentUrl());

	    
//     	3.2	Click on the "By Country" option below the label "Data". 
//		It should navigate to World bank site "Data" tab "Countries and Economies" section i.e. country page. 
	    Logger.logMESSAGE("3.2  Click on the 'By Country' option below the label 'Data'");     	
	    OldCountriesAndEconomiesPage oldCountriesAndEconomiesPage = oldDataMenuTab.clickOnByCountryTab(driver);
		AssertUtil.assertEquals("It should navigate to World bank site 'Data' tab 'Countries and Economies' section", Config.oldCountriesAndEconomiesPageURL, driver.getCurrentUrl());

//		4. In the Countries and Economies" section, in the "Income Levels" block,  click on "High income" item.  It should navigate to World bank site's income-level/HIC page. 
	    Logger.logMESSAGE("4. In the 'Countries and Economies' section, in the 'Income Levels' block,  click on 'High income' item");     	
		OldHICPage oldHICPage = oldCountriesAndEconomiesPage.clickHighIncome(driver);
		AssertUtil.assertEquals("It should navigate to World bank site's income-level/HIC page.", Config.oldHICPageURL, driver.getCurrentUrl());

		
//	 	5  Click on Country Andorra.  It should navigate to Andorra country specific page.
	    Logger.logMESSAGE("5. Click on Country Andorra.");     	
		OldCountryPage oldCountryPage = oldHICPage.clickOnCountry(driver, "Andorra");
		AssertUtil.assertEquals("It should navigate to Andorra country specific page.", Config.oldAndorraPageURL, driver.getCurrentUrl());
		  
//	 	6  Note the value for following 3 factors
//		"GDP at market prices (current US$)"
//		"Population, total"
//		"CO2 emissions (metric tons per capita)"
//	 	The required data should get noted for the specific country.
	    Logger.logMESSAGE("6. Note the value for GDP, population, CO2");  
		CountryData andorraData = oldCountryPage.getData(driver);
		AssertUtil.assertEquals("The required data should get noted for the specific country.", Config.etalonAndorraData, andorraData.toString());
		Logger.logMESSAGE(andorraData.toString());
	     
//		7  Navigate back to World bank site's income-level/HIC page.  It should navigate to World bank site's income-level/HIC page.
	    Logger.logMESSAGE("7. Navigate back to World bank site's income-level/HIC page.");  
		oldHICPage = WebUtil.navigateBack(driver, OldHICPage.class);
		AssertUtil.assertEquals("It should navigate to World bank site's income-level/HIC page.", Config.oldHICPageURL, driver.getCurrentUrl());

//	 	8  Read and note the data as in step 6 for each country.  The required data should get noted for all the countries.
	    Logger.logMESSAGE("8. Read and note the data as in step 6 for each country.");  		
		CountryData[] countriesDataArr = oldHICPage.initCountriesDataArray(driver);
		CountryData[] etalonCountriesDataArr = CSVUtil.loadArrayFromCSV(Config.pathToEtalonCountriesData);

		for (int i = 0; i < countriesDataArr.length; i++){
			String nextCountry = countriesDataArr[i].name;
			
			oldCountryPage = oldHICPage.clickOnCountry(driver, nextCountry);
			countriesDataArr[i] = oldCountryPage.getData(driver);
			
			AssertUtil.assertEquals("Data for " + etalonCountriesDataArr[i].name + " : " + countriesDataArr[i].toString(), 
									etalonCountriesDataArr[i].toString(), 
									countriesDataArr[i].toString());
			oldHICPage = WebUtil.navigateBack(driver, OldHICPage.class);
					
			System.out.println(i + " " + countriesDataArr[i].toString());
		}
//		 9  Click on Home tab of the country page.  World bank site home page should open. 
	    Logger.logMESSAGE("9. Click on Home tab of the country page..");  		
		homePage = oldHICPage.clickOnHomePageTab(driver);
		AssertUtil.assertEquals("World bank site home page should open", Config.homePageURL, driver.getCurrentUrl());
		
//	 	10  Close the browser.  Browser should get closed. 
		Logger.logMESSAGE("10. Close the browser.");
		WebUtil.closeBrowser(driver);
		if (driver.toString().contains("null")){
			Logger.logSUCCESS("Browser closed");
		}else{
			Logger.logFAIL("Browser is not closed");
		}
	     
//		11  Process the data programmatically and log the names of  top 3 countries along with their "GDP at market prices (current US$)" value.  It should log the names of top 3 countries as per their "GDP at market prices (current US$)" value to the test log.
		Logger.logMESSAGE("11. Process the data programmatically and log the names of  top 3 countries along with their 'GDP'");
		CountryData[] threeHighestGDP = getThreeHighestGDP(countriesDataArr);
		
		for (int i = 0; i < 3; i++){
			AssertUtil.assertEquals(threeHighestGDP[i].toString(), Config.etalonThreeHighestGDP[i], threeHighestGDP[i].toString());			
		}
			
//		12  Process the data programmatically and log the names of  top 3 countries along with their Population, total" value.  It should log the names of top 3 countries as per their "Population, total" value to the test log.
		Logger.logMESSAGE("12.  Process the data programmatically and log the names of  top 3 countries along with their 'Population, total' value");
		CountryData[] threeHighestPopulation = getThreeHighestPopulation(countriesDataArr);
		
		for (int i = 0; i < 3; i++){
			AssertUtil.assertEquals(threeHighestPopulation[i].toString(), Config.etalonThreeHighestPopulation[i], threeHighestPopulation[i].toString());
		}	 
		
//	 	13  Process the data programmatically and log the names of  top 3 countries along with their 'CO2 emissions (metric tons per capita)" value.  It should log the names of top 3 countries as per their "CO2 emissions (metric tons per capita)" value to the test log.
		Logger.logMESSAGE("13.  Process the data programmatically and log the names of  top 3 countries along with their 'CO2 emissions, (metric tons per capita)' value.");
		CountryData[] threeHighestCO2 = getThreeHighestCO2(countriesDataArr);
		
		for (int i = 0; i < 3; i++){
			AssertUtil.assertEquals(threeHighestCO2[i].toString(), Config.etalonThreeHighestCO2[i], threeHighestCO2[i].toString());			
		}
		
//	 	14  Export the all country data for all the 3 factors in the csv format at appropriate location in the Project directory.     It should export the specified data in the csv format at appropriate location in the Project directory. 
		Logger.logMESSAGE("14.  Export the all country data for all the 3 factors in the csv format at appropriate location in the Project directory..");

		String[] headers = new String[4];
	    headers[0] = "Country name";
	    headers[1] = "GDP";
	    headers[2] = "Population";
	    headers[3] = "CO2";
		
	    CSVUtil.saveArrayToCSV(countriesDataArr, headers, Config.pathToExportCountriesData);
	    File checkFile = new File(Config.pathToExportCountriesData);
	    if (checkFile.lastModified() - System.currentTimeMillis() < 60000){
	    	Logger.logSUCCESS("File was succesfully creadted.");
	    }else
	    {
	    	Logger.logFAIL("File was not created.");
	    }

	    Logger.tearDown();
	}

	private static CountryData[] getThreeHighestCO2(CountryData[] countriesDataArr) {
		CountryData[] tempArr = countriesDataArr.clone();
		java.util.Arrays.sort(tempArr, new Comparator<CountryData>() {
		    @Override
		    public int compare(CountryData c1, CountryData c2) {
		        return (int) (c2.CO2 - c1.CO2);
		    }
		});
		
		CountryData[] threeHighest = new CountryData[3];
		threeHighest[0] = tempArr[0];
		threeHighest[1] = tempArr[1];
		threeHighest[2] = tempArr[2];
		
		return threeHighest;
	}

	private static CountryData[] getThreeHighestPopulation(CountryData[] countriesDataArr) {
		CountryData[] tempArr = countriesDataArr.clone();
		java.util.Arrays.sort(tempArr, new Comparator<CountryData>() {
		    @Override
		    public int compare(CountryData c1, CountryData c2) {
		        return (int) (c2.population - c1.population);
		    }
		});
		
		CountryData[] threeHighest = new CountryData[3];
		threeHighest[0] = tempArr[0];
		threeHighest[1] = tempArr[1];
		threeHighest[2] = tempArr[2];
		
		return threeHighest;
	}

	private static CountryData[] getThreeHighestGDP(CountryData[] countriesDataArr) {
		CountryData[] tempArr = countriesDataArr.clone();
		java.util.Arrays.sort(tempArr, new Comparator<CountryData>() {
		    @Override
		    public int compare(CountryData c1, CountryData c2) {
		        return (int) (c2.GDP - c1.GDP);
		    }
		});
		
		CountryData[] threeHighest = new CountryData[3];
		threeHighest[0] = tempArr[0];
		threeHighest[1] = tempArr[1];
		threeHighest[2] = tempArr[2];
		
		return threeHighest;
	}
}
