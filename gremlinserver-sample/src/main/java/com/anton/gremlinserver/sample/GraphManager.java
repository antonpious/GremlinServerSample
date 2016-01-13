package com.anton.gremlinserver.sample;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.Cluster.Builder;
import org.apache.tinkerpop.gremlin.driver.Result;
import org.apache.tinkerpop.gremlin.driver.ResultSet;
import org.apache.tinkerpop.gremlin.driver.ser.GryoMessageSerializerV1d0;

public class GraphManager {
	
	private Cluster clientFactory = null;
	private Client clientInstance = null;
	private ResultSet results = null;
	private Iterator<Result> itor = null;
	
	public Long createCustomer(Map<String, Object> customerParams)
	{
		Long entityId = 0L;
		Result resultInstance = null;
		
		clientFactory = getClientFactory();
		clientInstance = clientFactory.connect();
		
		
		
		results = clientInstance.submit(
		"g.addV(T.label, type,"
		+ "'name',name,"
		+ "'email',email,"
		+ "'gender',gender,"
		+ "'mobile',mobile,"
		+ "'dob',dob).id()", customerParams
		);		
				
		
		itor = results.iterator();
		
		
		while (itor.hasNext()) {			
			resultInstance = itor.next();						
			entityId = resultInstance.getLong();		    		    
		}
		
		clientInstance.close();					
		
		return entityId;
	}
	
	public String getCustomer(Map<String, Object> customerParams)	
	{
		String result = "";
		Result resultInstance = null;
		
		clientFactory = getClientFactory();
		clientInstance = clientFactory.connect();
		
		
		results = clientInstance.submit("g.V().has('name',name).valueMap()", customerParams);
		
		
		//get iterator
		itor = results.iterator();
		
		//check if there are results
		while (itor.hasNext()) {
			//get result
			//This is the result of map.toString();
			//{gender=male, dob=Thu Nov 14 00:00:00 CST 1889, name=nehru, mobile=3423456781, email=nehrumj@gmail.com}
			//This is the result from the graph
			//{gender=[male], dob=[Thu Nov 14 00:00:00 CST 1889], mobile=[3423456781], name=[nehru], email=[nehrumj@gmail.com]}
			resultInstance = itor.next();
						
			result = resultInstance.getString();
		
								    
		}
		
		clientInstance.close();
		
		return 	result;
	}
	
	
	public Long createAddress(Map<String, Object> addressParams) {
		Long entityId = 0L;
		Result resultInstance = null;
		
		clientFactory = getClientFactory();
		clientInstance = clientFactory.connect();
		
		
		//String address1, String address2, String city, String state, Integer zip
		results = clientInstance.submit(
		"g.addV(T.label, type,"
		+ "'address1',address1,"
		+ "'address2',address2,"
		+ "'city',city,"
		+ "'state',state,"
		+ "'zip',zip).id()", addressParams
		);		
				
		
		itor = results.iterator();
		
		
		while (itor.hasNext()) {			
			resultInstance = itor.next();						
			entityId = resultInstance.getLong();		    		    
		}
		
		clientInstance.close();					
		
		return entityId;
	}

	public String createCustomerRelation(Map<String, Object> customerRelationParams) {
		String result = "";
		Result resultInstance = null;
		
		clientFactory = getClientFactory();
		clientInstance = clientFactory.connect();
		
		
		results = clientInstance.submit(
						"entitySource = g.V().has('name', source).next();"+
						"entityRelated = g.V().has('name', related).next();"+
						"entitySource.addEdge(relation,entityRelated,"
						+ "'effectiveStartDate',effectiveStartDate,"
						+ "'isFavorite',isFavorite).id();",
						customerRelationParams);
		
		
		//get iterator
		itor = results.iterator();
		
		//check if there are results
		while (itor.hasNext()) {

			resultInstance = itor.next();
						
			result = resultInstance.getString();
		
								    
		}
		
		clientInstance.close();
		
		return 	result;
	}
	
	
	public String createCustomerAddressRelation(Map<String, Object> customerAddressParams) {
		String result = "";
		Result resultInstance = null;
		
		clientFactory = getClientFactory();
		clientInstance = clientFactory.connect();
		
		
		results = clientInstance.submit(
						"entitySource = g.V(customerId).next();"+
						"entityRelated = g.V(addressId).next();"+
						"entitySource.addEdge(relation,entityRelated,"
						+ "'addressType',addressType,"
						+ "'validSince',validSince,"
						+ "'ownerType',ownerType).id();",
				customerAddressParams);
		
		
		//get iterator
		itor = results.iterator();
		
		//check if there are results
		while (itor.hasNext()) {

			resultInstance = itor.next();
						
			result = resultInstance.getString();
		
								    
		}
		
		clientInstance.close();
		
		return 	result;
	}
	
	public Long createEdge(String entityFrom, String entityTo)
	{
		Long entityId = new Long(0);

		Cluster cluster = getClientFactory();
		Client client = cluster.connect();
		
		//System.out.println("Connected the client");
		
		//	
		ResultSet results = client.submit(
				"entitySource = g.V().has('name', entitySource).next();"+
				"entityRelated = g.V().has('name', entityRelated).next();"+
				"entitySource.addEdge('parent',entityRelated,'isprimary',true);"
				);
		
		System.out.println("Submitted results");
		

		
		Iterator<Result> itty = results.iterator();
		
		
		while (itty.hasNext()) {
			
			System.out.println("Inside the itterator");
			
			Result resultInstance = itty.next();
			
			System.out.println(resultInstance.getString());
			
//			System.out.println("The result is :" + resultInstance.getLong());
//			
//			Vertex vertexInstance  = resultInstance.getVertex();
//			
////			
////			ver.property("name").toString();
//			entityId = (Long)vertexInstance.id();
//			
//		    System.out.println("The vertex Id is:" + entityId);
		    		    
		}
		
		System.out.println("outside Iterrator");
		client.close();
					
		
		return entityId;
	}
	
	
	

	
	public String getVertexIdByName(Long vertexId)	
	{
		String result = "";
		Cluster cluster = null;
		Client client = null;
		Map<String, Object> params = null;
		ResultSet results = null;
		Iterator<Result> itor = null;
		Result resultInstance = null;
		
		//get graph server graph properties
		cluster = getClientFactory();
		//connect to Gremlin server
		client = cluster.connect();
		
		//parameterize the query
		params = new HashMap<String,Object>();
		params.put("vertexId", vertexId);
		
		//submit to server and obtain results
		//results = client.submit("g.V().has('name', vertexName).next().id();",params);
		
		//g.V().has('name','nehru').valueMap();
		results = client.submit("g.V(vertexId).valueMap()", params);
		
		
		//get iterator
		itor = results.iterator();
		
		//check if there are results
		while (itor.hasNext()) {
			//get result
			resultInstance = itor.next();
						
			result = resultInstance.getString();
			
			System.out.println(result);
								    
		}
		

		client.close();
		//this is taking some time
		//not sure if this is needed
		cluster.close();
				
		return 	result;
	}		

	public String queryMultipleResults(String name)	
	{
		String result = "";		
		
		//Cluster cluster = getClusterFromFile();
		Cluster cluster = getClientFactory();
		Client client = cluster.connect();
		
		Map<String, Object> params = new HashMap<String,Object>();
		
		params.put("vertexName", "color70");
		
		//ResultSet results = client.submit("g.V().has('name', 'color70').next().id();");
		
		ResultSet results = client.submit("g.V().has('name', vertexName).next().id();",params);
		
//		
		Iterator<Result> itty = results.iterator();
//		
		while (itty.hasNext()) {
//			
//			System.out.println("getting results");
			Result resultInstance = itty.next();
			
			
			result = resultInstance.getString();
			
//			Vertex ver  = resultInstance.getVertex();
//			
//			result = ver.property("name").toString();
			
		    
		}
		
		System.out.println("closing client");
		client.close();
		System.out.println("closed client");
		System.out.println("closing cluster");
		//this is taking some time
		//cluster.close();
		//System.out.println("closed cluster");
		
		
				
		return 	result;
	}

	private Cluster getClientFactory()
	{
		Cluster cluster = null;
		//TODO get from config 
		String address = "192.168.0.71";
		int port = 8182;
		GryoMessageSerializerV1d0 serializerClass = null;
		Builder clusterBuilder = null;
		Map<String, Object> configMap = null;


		
		//This is required so that the result vertex can be serialized to string
		serializerClass = new GryoMessageSerializerV1d0();		
		configMap = new HashMap<String, Object>();
		configMap.put("serializeResultToString", "true");		
		serializerClass.configure(configMap, null);
		
		//build cluster configuration
		clusterBuilder = Cluster.build(address);		
		clusterBuilder.port(port);
		clusterBuilder.serializer(serializerClass);

			
		//create a cluster instance
		cluster = clusterBuilder.create();
			
		return cluster;
	}

	


	

}
