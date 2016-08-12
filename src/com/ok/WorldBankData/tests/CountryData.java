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
	
	public String[] toStringArr(){
		String[] data = new String[4];
		data[0] = name;
		data[1] = Double.toString(GDP);
		data[2] = Long.toString(population);
		data[3] = Float.toString(CO2);
		return data;
	}
}
