package com.konffit;

import java.util.Set;

import com.mongodb.*;

public class MongoKanta {
	
	private MongoClient mongoClient;
	
	public MongoKanta(){
		mongoClient = LuoTietokantaYhteys();
	}

	private MongoClient LuoTietokantaYhteys(){
		
		try{	
												//http://46.101.255.44
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		
		/*  Poista kommentointi jos kantaan tarvitsee salasanan
		MongoCredential credential = MongoCredential.createCredential(userName, database, password);
		MongoClient mongoClient = new MongoClient(new ServerAddress(), Arrays.asList(credential));
		*/	
		return mongoClient;
		
		}catch(Exception e){	
			System.out.println("Yhteyden luominen kantaan epäonnistui");
			e.printStackTrace();
			return new MongoClient();
		}

	}
	
	public void SuljeTietokantayhteys(){
		try{
			
		mongoClient.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public DB getDatabase(String database){		
				
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB( database );
		
		return db;
	}
	
	public Set<String> getCollectionNames(DB db){
		Set<String> tables = db.getCollectionNames();	
		return tables;
		
	}
}