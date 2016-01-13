package com.anton.gremlinserver.sample;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Customer {
	
	private String name = "";
	private String email = "";
	private String gender = "";
	private String mobile = "";
	private Date dob = null;
	private List<CustomerRelation> customerRelation = null;
	private List<AddressRelation> addressRelation = null;
	
	
	public Customer(String name, String email, String gender, String mobile, Date dob)
	{
		this.setName(name);
		this.setEmail(email);
		this.setGender(gender);
		this.setMobile(mobile);
		this.setDob(dob);
		customerRelation = new ArrayList<CustomerRelation>();;
		addressRelation = new ArrayList<AddressRelation>();
	}
	
	
	public String toJson()
	{
		String customerJson = "";
		Gson gsonInstance = null;
		
		
		gsonInstance = new GsonBuilder().create();		
		customerJson = gsonInstance.toJson(this);
		
		return customerJson;
		
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}
	

	public List<CustomerRelation> getCustomerRelation() {
		return customerRelation;
	}


	public void setCustomerRelation(List<CustomerRelation> customerRelation) {
		this.customerRelation = customerRelation;
	}


	public List<AddressRelation> getAddressRelation() {
		return addressRelation;
	}


	public void setAddressRelation(List<AddressRelation> addressRelation) {
		this.addressRelation = addressRelation;
	}


	

}
