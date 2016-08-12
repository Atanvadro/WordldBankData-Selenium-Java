package com.ok.WorldBankData.tests;

import com.ok.WorldBankData.config.Config;
import com.ok.WorldBankData.config.Locators;
import com.ok.WorldBankData.pageobjects.*;
import com.ok.selenium.util.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WBD_Test_1 {
	public static void main(String [ ] args) throws Exception{
	
		WebDriver driver = new FirefoxDriver();
	//    @Before
	//    public void setDriver(){
	//        String browserName = System.getenv("browser");
	//        if (browserName != null && browserName.equalsIgnoreCase("Chrome")){
	//            String chromeDriverPath = GmailLoginTest.class.getClassLoader().getResource("bin/chromedriver.exe").getPath();
	//            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	//            driver = new ChromeDriver();
	//        }else{
	//            driver = new FirefoxDriver();
	//        }
	//    }
	
	    
	//	Sr. No.   Test Step   Expected Result
	//	 1  Open the world bank site in a firefox browser.
	//	 www.worldbank.org  World bank site home page should open
		HomePage homePage;
	//	homePage= WebUtil.goToPage(driver, HomePage.class, "http://www.worldbank.org");
	//	driver.get("http://www.worldbank.org");
	//	 2  Click on the Data tab.  It should navigate to World bank site Data tab.
	//    DataPage dataPage = homePage.clickDataTab(driver);
	//	 3.1  Click on the link "visit the old site here" to navigate to older site.
	//	(Note - Above step added due to recent modification to the world bank website)
	//    OldDataMenuTab oldDataMenuTab = dataPage.clickOldSiteLink(driver);
	//     3.2	Click on the "By Country" option below the label "Data".  It should navigate to "http://archive.data.worldbank.org/" page
	//	(Note - Above step added due to recent modification to the world bank website)
	//	It should navigate to World bank site "Data" tab "Countries and Economies" section i.e. country page. 
	//     OldCountriesAndEconomiesPage oldCountriesAndEconomiesPage = oldDataMenuTab.clickByCountryTab(driver);
	//	 4  In the Countries and Economies" section, in the "Income Levels" block,  click on "High income" item.  It should navigate to World bank site's income-level/HIC page. 
	//     OldHICPage oldHICPAge = oldCountriesAndEconomiesPage.clickHighIncome(driver);
		OldHICPage oldHICPage = WebUtil.goToPage(driver, OldHICPage.class, "http://archive.data.worldbank.org/income-level/HIC");
		CountryData[] countriesDataArr = oldHICPage.initCountriesDataArray(driver);

//	 	5  Click on Country Andorra.  It should navigate to Andorra country specific page.
		OldCountryPage oldCountryPage = oldHICPage.clickOnCountry(driver, "Andorra");
		  
//	 	6  Note the value for following 3 factors
//		"GDP at market prices (current US$)"
//		"Population, total"
//		"CO2 emissions (metric tons per capita)"
//	 	The required data should get noted for the specific country.
		CountryData andorraData = oldCountryPage.getData(driver);
//		System.out.println(country.toString());
//		OldCountryPage oldCountryPage = WebUtil.goToPage(driver, OldCountryPage.class, "http://archive.data.worldbank.org/country/united-states");
//		OldCountryPage oldCountryPage11 = WebUtil.goToPage(driver, OldCountryPage.class, "http://archive.data.worldbank.org/country/andorra");
//		CountryData country11 = oldCountryPage11.getData(driver);
//		System.out.println(country11.toString());
	     
//		7  Navigate back to World bank site's income-level/HIC page.  It should navigate to World bank site's income-level/HIC page.
		oldHICPage = WebUtil.navigateBack(driver, OldHICPage.class);
		
//	 	8  Read and note the data as in step 6 for each country.  The required data should get noted for all the countries.
		for (int i = 0; i < countriesDataArr.length; i++){
			String nextCountry = countriesDataArr[i].name;
			
			oldCountryPage = oldHICPage.clickOnCountry(driver, nextCountry);
			countriesDataArr[i] = oldCountryPage.getData(driver);
			oldHICPage = WebUtil.navigateBack(driver, OldHICPage.class);
					
			System.out.println(i + " " + countriesDataArr[i].toString());
		}
//		 9  Click on Home tab of the country page.  World bank site home page should open. 
	     homePage = oldHICPage.clickOnHomePageTab(driver);
		
//	 	10  Close the browser.  Browser should get closed. 
	     WebUtil.closeBrowser(driver);
	     
//		11  Process the data programmatically and log the names of  top 3 countries along with their "GDP at market prices (current US$)" value.  It should log the names of top 3 countries as per their "GDP at market prices (current US$)" value to the test log.
	     
//		12  Process the data programmatically and log the names of  top 3 countries along with their Population, total" value.  It should log the names of top 3 countries as per their "Population, total" value to the test log.
	     
//	 	13  Process the data programmatically and log the names of  top 3 countries along with their "CO2 emissions (metric tons per capita)" value.  It should log the names of top 3 countries as per their "CO2 emissions (metric tons per capita)" value to the test log.
	     
//	 	14  Export the all country data for all the 3 factors in the csv format at appropriate location in the Project directory.     It should export the specified data in the csv format at appropriate location in the Project directory. 
//	      CountryData country = new CountryData("Ukraine");
//	      country.population = 50000000;
//	      country.GDP = 1000000000000d;
//	      country.CO2 = 16.0f;
//	      CountryData[] countries = new CountryData[3];
//	      countries[0] = country;
//	      countries[1] = country;
//	      countries[2] = new CountryData("Empty");
//	      
	      String[] headers = new String[4];
	      headers[0] = "Country name";
	      headers[1] = "GDP";
	      headers[2] = "Population";
	      headers[3] = "CO2";
		
	      CSVUtil.saveArrayToCSV(countriesDataArr, headers, Config.pathToExportCSV);	
	}
}
