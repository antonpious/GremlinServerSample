package com.anton.gremlinserver.sample;

import java.util.Date;

public class CustomerRelation {
	private String relationType = "";
	private Date effectiveStartDate = null;
	private Customer customer = null;
	private Boolean isFavorite = false;
	
	public CustomerRelation(String relationType, Date effectiveStartDate, Boolean isFavorite, Customer customer)
	{
		this.setRelationType(relationType);
		this.setEffectiveStartDate(effectiveStartDate);
		this.setIsFavorite(isFavorite);
		this.setCustomer(customer);
		
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public Date getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Boolean getIsFavorite() {
		return isFavorite;
	}

	public void setIsFavorite(Boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

}
