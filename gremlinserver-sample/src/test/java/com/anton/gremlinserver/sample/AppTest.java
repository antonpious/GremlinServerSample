package com.anton.gremlinserver.sample;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
//    public static void CreateGraph() throws ParseException
//    {
//    	
//    	
//
//    	Customer david = null;
//    	//wife of david
//    	Customer sara = null;
//    	//daugther of david
//    	Customer eva = null;
//    	//son of david
//    	Customer mark = null;
//    	//wife of mark
//    	Customer mary = null;
//    	//son of mark
//    	Customer frank = null;
//    	//friend of mark
//    	Customer sam = null;
//    	//wife of same
//    	Customer anna = null;
//    	
//    	
//    	
//    	
//    	Address davidSaraPersonal = null;
//    	Address evaPersanal = null;
//    	Address markMaryPersonal = null;
//    	Address frankPersonal = null;
//    	Address samAnnaPersonal = null;
//    	Address office = null;
//    	Address gandhiAddress = null;
//    	AddressRelation davidAddress = null;
//    	
//    	GraphManagerDriver graphManger = null;
//    	
//    	
//    	
//    	
//    	
//    	
//    	//office address of s
//    	office = new Address("2929 Briarpark", "Suite 200", "Houston", "Texas", 77042);
//    	
//    	//gandhiAddress = new Address("12 freedom St ", "2nd Fl", "Porbandar", "Gujarat", 360545);
//    	
//    	
//    	//String name, String email, String gender, String mobile, Date dob October 2, 1869
//    	david = new Customer("david","davidnathan@gmail.com", "male", "8329323234", new SimpleDateFormat("MM/dd/yyyy").parse("09/19/1984"));
//    	
//    	//address of david and sara
//    	davidSaraPersonal = new Address("2424 Newcastle St", "Apt1243", "Houston", "Texas", 77081);
//    	
//    	//String addressType, Double validSince, String ownerType, Address address
//    	davidAddress = new AddressRelation("personal",1.5,"rent", davidSaraPersonal);
//    	
//    	david.getAddressRelation().add(davidAddress);
//    	
//    	graphManger = new GraphManagerDriver();
//    	
//    	graphManger.createCustomerAddressRelation(david);
//    	
//    	System.out.println(david.toJson());
//    	//JSON format output
///*
// * 
// * 
// {
//   "name": "david",
//   "email": "davidnathan@gmail.com",
//   "gender": "male",
//   "mobile": "8329323234",
//   "dob": "Sep 19, 1984 12:00:00 AM",
//   "customerRelation": [],
//   "addressRelation": [
//      {
//         "addressType": "personal",
//         "validSince": 1.5,
//         "ownerType": "rent",
//         "address": {
//            "address1": "2424 Newcastle St",
//            "address2": "Apt1243",
//            "city": "Houston",
//            "state": "Texas",
//            "zip": 77081
//         }
//      }
//   ]
//}
// * 
// *     
// *     	
// */
//
//
//    }     
    
    
//Sample codes
//	GraphManagerDriver graphManager = null;
//	
//	graphManager = new GraphManagerDriver();
//	
//	//create a vertext
	//graphManager.createCustomer(david);   	
	

//	GraphManagerDriver graphManager = null;
//	
//	graphManager = new GraphManagerDriver();
//	
//	//create a vertex
//	graphManager.createAddress(gandhiAddress);       	
	
	    	
	
	
	
//	System.out.println(Utility.getCustomerGraphParams(david).toString());
	
//	GraphManager manager = new GraphManager();
//	
//	
//	//Gandhi  16448L
	//Nehru 12504L
//	manager.getVertexIdByName(12504L);
	
//	String graphPropertyString = "{dob:[Sat Oct 02 00:00:00 CST 1869], gender:[male], mobile:[1234567890], name:[gandhi], email:[mkgandhi@gmail.com]}";

//	david = Utility.serializeCustomer(graphPropertyString);
//	
//	System.out.println(david.toJson());
	
	//Date dob = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy").parse("Sat Oct 02 00:00:00 CST 1869");
	
	//System.out.println(dob.toString());
	//Date dob = new SimpleDateFormat("MM-dd-yyyy").parse("10-02-1869");
	
	//Mon Jan 11 19:51:27 CST 2016
	//Sat Oct 02 00:00:00 CST 1869
	
	//dob = new Date();
	
	//System.out.println(dob.toString());   
}
