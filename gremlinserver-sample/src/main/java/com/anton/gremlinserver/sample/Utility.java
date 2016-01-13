package com.anton.gremlinserver.sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Utility {

	public static Map<String, Object> getCustomerGraphParams(Customer customerInstance) {
		Map<String, Object> customerGraphParams = null;

		customerGraphParams = new HashMap<String, Object>();

		customerGraphParams.put("type", "Customer");
		customerGraphParams.put("name", customerInstance.getName());
		customerGraphParams.put("email", customerInstance.getEmail());
		customerGraphParams.put("gender", customerInstance.getGender());
		customerGraphParams.put("mobile", customerInstance.getMobile());
		customerGraphParams.put("dob", customerInstance.getDob());

		return customerGraphParams;
	}

	public static Customer serializeCustomer(String graphPropertyString) throws ParseException {
		Customer customerInstance = null;
		String workingString = "";
		String[] mapProperties = null;
		String[] mapProperty = null;
		String mapKey = "";
		String mapValue = "";
		Map<String, String> propertyStringMap = null;
		String propertyString = "";

		System.out.println(graphPropertyString);

		// The data would be in this format with no order
		// This is the format in Gremlin
		// {dob:[Sat Oct 02 00:00:00 CST 1869], gender:[male],
		// mobile:[1234567890], name:[gandhi], email:[mkgandhi@gmail.com]}
		// This is the format in Java notice the '='
		// {gender=[female], dob=[Mon Aug 18 00:00:00 CDT 1980],
		// mobile=[2812502234], name=[sara], email=[sara111@gmail.com]}

		// remove starting and ending curly brackets
		workingString = graphPropertyString.substring(1, graphPropertyString.length() - 1);

		propertyStringMap = new HashMap<String, String>();
		// split by comma (assuming there is no comma in the text)
		// TODO Comma agnostic
		mapProperties = workingString.split(",");

		for (Integer counter = 0; counter < mapProperties.length; counter++) {
			propertyString = mapProperties[counter];

			// split by colon
			// the limit is to make sure that it does by first occurrence of :
			// TODO = agnostic
			mapProperty = propertyString.split("=", 2);

			// remove white spaces
			mapKey = mapProperty[0].trim();
			workingString = mapProperty[1].trim();
			// remove start and end box brackets
			mapValue = workingString.substring(1, workingString.length() - 1);

			// System.out.format("key:%s-value:%s \n", mapKey, mapValue);
			propertyStringMap.put(mapKey, mapValue);
		}

		// String name, String email, String gender, String mobile, Date dob
		// String to Strongly Typed
		// TODO Correct for values not present
		customerInstance = new Customer(propertyStringMap.get("name"), propertyStringMap.get("email"),
				propertyStringMap.get("gender"), propertyStringMap.get("mobile"),
				new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy").parse(propertyStringMap.get("dob")));

		return customerInstance;
	}

	// String address1, String address2, String city, String state, Integer zip
	public static Map<String, Object> getAddressGraphParams(Address addressInstance) {
		Map<String, Object> addressGraphParams = null;

		addressGraphParams = new HashMap<String, Object>();

		addressGraphParams.put("type", "Address");
		addressGraphParams.put("address1", addressInstance.getAddress1());
		addressGraphParams.put("address2", addressInstance.getAddress2());
		addressGraphParams.put("city", addressInstance.getCity());
		addressGraphParams.put("state", addressInstance.getState());
		addressGraphParams.put("zip", addressInstance.getZip());

		return addressGraphParams;

	}

	public static Map<String, Object> getCustomerRelationGraphParams(Customer customerInstance) {
		Map<String, Object> customerRelationParams = null;
		CustomerRelation customerRelationInstance = null;

		// TODO expand code for multiple relations
		// TODO expand code to check if relation already exists
		// assuming there is only 1 relation

		customerRelationInstance = customerInstance.getCustomerRelation().get(0);

		customerRelationParams = new HashMap<String, Object>();

		customerRelationParams.put("source", customerInstance.getName());
		customerRelationParams.put("relation", customerRelationInstance.getRelationType());
		customerRelationParams.put("related", customerRelationInstance.getCustomer().getName());
		customerRelationParams.put("effectiveStartDate", customerRelationInstance.getEffectiveStartDate());
		customerRelationParams.put("isFavorite", customerRelationInstance.getIsFavorite());

		return customerRelationParams;
	}

}
