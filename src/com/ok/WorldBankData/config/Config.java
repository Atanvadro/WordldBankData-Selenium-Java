package com.ok.WorldBankData.config;

public class Config {
	public static final String pathToExportCountriesData = "testdata/ExportedData.csv";
	public static final String pathToEtalonCountriesData = "testdata/ExportedData-Etalon.csv";
	
	public static final Browsers browser = Browsers.Firefox;
	
	public static String homePageURL = "http://www.worldbank.org/";
	public static String dataPageURL = "http://data.worldbank.org/";
	public static String oldDataPageURL = "http://archive.data.worldbank.org/";
	public static String oldCountriesAndEconomiesPageURL = "http://archive.data.worldbank.org/country";
	public static String oldHICPageURL = "http://archive.data.worldbank.org/income-level/HIC";
	public static String oldAndorraPageURL = "http://archive.data.worldbank.org/country/andorra";

	public static String etalonAndorraData = " Country: Andorra GDP: 3.249E9 Population: 70470 CO2: 6.0";
	
	
	
}
