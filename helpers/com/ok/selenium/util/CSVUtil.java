package com.ok.selenium.util;

import java.io.FileWriter;
import java.io.IOException;

import com.ok.WorldBankData.tests.CountryData;
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

}
