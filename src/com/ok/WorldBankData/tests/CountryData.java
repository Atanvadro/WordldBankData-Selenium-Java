package com.ok.WorldBankData.tests;

public class CountryData {
	public String name;
	public double GDP;
	public long population;
	public float CO2;
	
	public CountryData(String name)
	{
		this.name = name;
	}
	
	public String toString(){
		return "Country: " + name + " GDP: " + GDP + " Population: " + population + " CO2: " + CO2;
	}
}
