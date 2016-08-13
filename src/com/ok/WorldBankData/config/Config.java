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

	public static String etalonAndorraData = "Country: Andorra GDP: 3.249E9 Population: 70470 CO2: 6.0";
	
	public static String[] etalonThreeHighestGDP = new String[]{"Country: United States GDP: 1.795E13 Population: 321400000 CO2: 17.0",
			 													"Country: Japan GDP: 4.123E12 Population: 127000000 CO2: 9.3",
			 													"Country: Germany GDP: 3.356E12 Population: 81410000 CO2: 8.9"};
	public static String[] etalonThreeHighestPopulation = new String[]{"Country: United States GDP: 1.795E13 Population: 321400000 CO2: 17.0",
																		"Country: Japan GDP: 4.123E12 Population: 127000000 CO2: 9.3",
																		"Country: Germany GDP: 3.356E12 Population: 81410000 CO2: 8.9"};
	public static String[] etalonThreeHighestCO2 = new String[]{"Country: Qatar GDP: 1.669E11 Population: 2235000 CO2: 44.0",
																"Country: Trinidad and Tobago GDP: 2.781E10 Population: 1360000 CO2: 37.1",
																"Country: Kuwait GDP: 1.128E11 Population: 3892000 CO2: 28.1"};
}
