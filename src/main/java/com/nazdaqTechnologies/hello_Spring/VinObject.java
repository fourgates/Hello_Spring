package com.nazdaqTechnologies.hello_Spring;

public class VinObject 
{
	String VIN;
	String make;
	String model;
	String year;
	
	public VinObject()
	{
		VIN = make = model = year = " ";
	}
	public VinObject(String vIN, String make, String model, String year) 
	{
		VIN = vIN;
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vIN) {
		VIN = vIN;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "VinObject [VIN=" + VIN + ", make=" + make + ", model=" + model
				+ ", year=" + year + "]";
	}
	
	
	
}
