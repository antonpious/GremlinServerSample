package com.anton.gremlinserver.sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class App 
{
    public static void main( String[] args ) throws ParseException
    {   	   	
    	//Uncomment to run the samples
    	//Delete or change entities when you want to rerun
    	//Simple creation of a vertex from an POJO Object
    	//createCustomer();
    	
    	//Simple get customer by name
    	//getCustomer();
    	
    	//Create customers independently and then link them by edge using name identifier
    	CreateCustomerRelation();
    	
    	//Create customer and address first get their id and then link them by edge using identifier
    	//createCustomerAddressAndAddressRelation();
    }
    
    
    public static void createCustomer() throws ParseException
    {
    	Customer sara = null;
    	GraphManagerDriver graphManger = null;
    	Long customerId = 0L;
    	    	
    	sara = new Customer("sara","sara111@gmail.com", "female", "2812502234", new SimpleDateFormat("MM/dd/yyyy").parse("08/18/1980"));
    	
    	graphManger = new GraphManagerDriver();
    	
    	customerId = graphManger.createCustomer(sara);
    	
    	System.out.format("Customer %s created with Id %d", sara.getName(), customerId);
    	
    }
    
    public static void getCustomer() throws ParseException
    {
    	Customer sara = null;
    	GraphManagerDriver graphManger = null;
    	
    	graphManger = new GraphManagerDriver();
    	
    	sara = graphManger.getCustomer("sara");
    	
    	System.out.println(sara.toJson());
    }
    
    public static void CreateCustomerRelation() throws ParseException
    {
    	Customer mark = null;
    	Customer frank = null;
    	//frank father is mark
    	GraphManagerDriver graphManger = null;
    	String relationshipId = "";
    	CustomerRelation frankFather = null;
    	    	
    	mark = new Customer("mark","mark1234@gmail.com", "male", "6532523451", new SimpleDateFormat("MM/dd/yyyy").parse("02/17/1995"));
    	frank = new Customer("frank","frankhardy@gmail.com", "male", "4561237890", new SimpleDateFormat("MM/dd/yyyy").parse("06/13/2014"));
    	
    	graphManger = new GraphManagerDriver();
    	
    	graphManger.createCustomer(mark);
    	graphManger.createCustomer(frank);
    	
    	//(String relationType, Date effectiveStartDate, Boolean isFavorite, Customer customer)
    	frankFather = new CustomerRelation("father", new SimpleDateFormat("MM/dd/yyyy").parse("06/13/2014"), true, mark);
    	
    	frank.getCustomerRelation().add(frankFather);
    	
    	//create the relation by finding the vertex by name of the customer
    	relationshipId = graphManger.createCustomerRelation(frank);
    	
    	System.out.format("Customer %s relationship created with Id %s", frank.getName(), relationshipId);
    }
    
    public static void createCustomerAddressAndAddressRelation() throws ParseException
    {
    	
    	Customer david = null;  	
    	Address davidPersonal = null;
    	AddressRelation davidAddress = null;
    	
    	
    	GraphManagerDriver graphManger = null;
    		
    	
    	//String name, String email, String gender, String mobile, Date dob October 2, 1869
    	david = new Customer("david","davidnathan@gmail.com", "male", "8329323234", new SimpleDateFormat("MM/dd/yyyy").parse("09/19/1984"));
    	
    	//address of david and sara
    	davidPersonal = new Address("2424 Newcastle St", "Apt1243", "Houston", "Texas", 77081);
    	
    	//String addressType, Double validSince, String ownerType, Address address
    	davidAddress = new AddressRelation("personal",1.5,"rent", davidPersonal);
    	
    	david.getAddressRelation().add(davidAddress);
    	
    	graphManger = new GraphManagerDriver();
    	
    	graphManger.createCustomerAddressRelation(david);
    	
    	System.out.println(david.toJson());
    	//JSON format output
/*
 * 
 * 
 {
   "name": "david",
   "email": "davidnathan@gmail.com",
   "gender": "male",
   "mobile": "8329323234",
   "dob": "Sep 19, 1984 12:00:00 AM",
   "customerRelation": [],
   "addressRelation": [
      {
         "addressType": "personal",
         "validSince": 1.5,
         "ownerType": "rent",
         "address": {
            "address1": "2424 Newcastle St",
            "address2": "Apt1243",
            "city": "Houston",
            "state": "Texas",
            "zip": 77081
         }
      }
   ]
}
 * 
 *     
 *     	
 */


    }
      
    
}
