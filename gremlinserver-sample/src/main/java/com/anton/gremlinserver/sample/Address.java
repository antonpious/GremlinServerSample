package com.anton.gremlinserver.sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Address {
	private String address1 = "";
	private String address2 = "";
	private String city = "";
	private String state = "";
	private Integer zip = 0;
	
	public Address(String address1, String address2, String city, String state, Integer zip)
	{
		this.setAddress1(address1);
		this.setAddress2(address2);
		this.setCity(city);
		this.setState(state);
		this.setZip(zip);
	}
	
	
	public String toJson()
	{
		String addressJson = "";
		Gson gsonInstance = null;
		
		
		gsonInstance = new GsonBuilder().create();		
		addressJson = gsonInstance.toJson(this);
		
		return addressJson;
		
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	

}
