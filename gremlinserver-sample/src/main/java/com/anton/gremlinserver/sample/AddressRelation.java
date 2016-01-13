package com.anton.gremlinserver.sample;

public class AddressRelation {
	private String addressType = "";
	private Double validSince = 0.0;
	private String ownerType = "";
	private Address address = null;
	
	
	public AddressRelation(String addressType, Double validSince, String ownerType, Address address)
	{
		this.setAddressType(addressType);
		this.setValidSince(validSince);
		this.setOwnerType(ownerType);
		this.setAddress(address);
	}


	public String getAddressType() {
		return addressType;
	}


	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String getOwnerType() {
		return ownerType;
	}


	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}


	public Double getValidSince() {
		return validSince;
	}


	public void setValidSince(Double validSince) {
		this.validSince = validSince;
	}
	
	

}
