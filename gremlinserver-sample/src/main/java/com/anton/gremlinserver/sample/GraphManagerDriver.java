package com.anton.gremlinserver.sample;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class GraphManagerDriver {
	
	GraphManager graphManagerInstance = null;
	
	
	public Long createCustomer(Customer customerInstance)
    {
    	
    	Long customerId = 0L;
    	Map<String, Object> customerParams = null;
    	
    	
    	customerParams = Utility.getCustomerGraphParams(customerInstance);
    	
    	graphManagerInstance = new GraphManager();
    	
    	customerId = graphManagerInstance.createCustomer(customerParams);   	   	
    	  	
    	return customerId;
    }
	
	public Long createAddress(Address addressInstance)
    {
    	
		Long addressId = 0L;
    	Map<String, Object> addressParams = null;
    	
    	
    	addressParams = Utility.getAddressGraphParams(addressInstance);
    	
    	graphManagerInstance = new GraphManager();
    	
    	addressId = graphManagerInstance.createAddress(addressParams);
    	
    	System.out.format("Address %s created with Id %d", addressInstance.getCity(), addressId);
    	
    	return addressId;
    }
	
	public String createCustomerRelation(Customer customerInstance)
    {
    	String relationshipId = "";    	
    	Map<String, Object> customerRelationParams = null;
  
   	
    	customerRelationParams = Utility.getCustomerRelationGraphParams(customerInstance);
		
 	   	
    	graphManagerInstance = new GraphManager();
    	
    	
    	graphManagerInstance.createCustomerRelation(customerRelationParams);
    	
    	return relationshipId;
	
    }
	
	
	public void createCustomerAddressRelation(Customer customerInstance)
    {
		Long customerId = 0L;
		Long addressId = 0L;
		String edgeId = "";
		Map<String, Object> customerAddressParams = null;
		AddressRelation addressRelationInstance = null;
		    	
    	
		customerId = createCustomer(customerInstance);
		//TODO expand code for multiple address
		//TODO expand code to check if address already exists
		//assuming there is only 1 address
		
		addressRelationInstance = customerInstance.getAddressRelation().get(0);
		addressId = createAddress(addressRelationInstance.getAddress());
		
		customerAddressParams = new HashMap<String, Object>();
		
		customerAddressParams.put("customerId", customerId);
		customerAddressParams.put("relation", "lives");
		customerAddressParams.put("addressId", addressId);
		customerAddressParams.put("addressType", addressRelationInstance.getAddressType());
		customerAddressParams.put("validSince", addressRelationInstance.getValidSince());
		customerAddressParams.put("ownerType", addressRelationInstance.getOwnerType());
		
		
		
		
    	graphManagerInstance = new GraphManager();
    	
    	edgeId = graphManagerInstance.createCustomerAddressRelation(customerAddressParams);
    	
    	System.out.format("Customer Relation %s created with Id %s", customerInstance.getName(), edgeId);
    	  	
    }
	
	
	public Customer getCustomer(String name) throws ParseException
    {
    	String customPropertyString = "";
		Map<String, Object> customerParams = null;
		Customer customerInstance = null;
		
		customerParams = new HashMap<String, Object>();
		customerParams.put("name", name);
    	    	
    	graphManagerInstance = new GraphManager();
    	
    	customPropertyString = graphManagerInstance.getCustomer(customerParams);
    	
    	customerInstance = Utility.serializeCustomer(customPropertyString);
    	
    	return customerInstance;
    	
  
    }

}
