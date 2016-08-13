package com.ok.selenium.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.ok.WorldBankData.tests.CountryData;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVUtil {
	public static void saveArrayToCSV(CountryData[] countriesArray, String[] headers, String filePath) throws IOException{
	      CSVWriter writer = new CSVWriter(new FileWriter(filePath), ';');
	      
	      writer.writeNext(headers);
	      
	      //Write the record to file
	      for (int i = 0; i< countriesArray.length; i++){
		      writer.writeNext(countriesArray[i].toStringArr());
	      }

	      //close the writer
	      writer.close();
	}
	
	public static CountryData[] loadArrayFromCSV(String filePath) throws IOException{
	      CSVReader reader = new CSVReader(new FileReader(filePath), ';');
	      

	      List<String[]> allRows = reader.readAll();
	      CountryData[] countriesArr = new CountryData[allRows.size() - 1];
	      
	      for(int i = 1; i < allRows.size(); i++){
	    	  String[] row = allRows.get(i);
	    	  String name = row[0];
	    	  double GDP = Double.parseDouble(row[1]);
	    	  long population = Long.parseLong(row[2]);
	    	  float CO2 = Float.parseFloat(row[3]);
	    	  countriesArr[i-1] = new CountryData(name, GDP, population, CO2);
	      }
	      
	      //close the writer
	      reader.close();
	      return countriesArr;
	}
}
