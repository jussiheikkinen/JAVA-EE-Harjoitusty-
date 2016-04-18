package com.models;

import java.util.UUID;

import com.konffit.MongoKanta;
import com.konffit.ToJson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class UserDAO {
	
	public String newUser(String username, Boolean isAdmin){
		
		MongoKanta mongo = new MongoKanta();
		DB db = mongo.getDatabase("TotoKanta");
		DBCollection coll = db.getCollection("user");
		
		UUID apikey = UUID.randomUUID();
		
		try{		
			BasicDBObject document = new BasicDBObject();	
			
			document.put("username", username);
			document.put("isAdmin", isAdmin);	
			document.put("apikey", apikey.toString());	
			coll.save(document);
			
		}catch(Exception e){
			e.printStackTrace();
			return "{status: 500}";
		}
		
		mongo.SuljeTietokantayhteys();
		
		Status status = new Status(isAdmin, apikey.toString(),username,"ok");
		return new ToJson().toJson(status);
	}
	
	public User Authenticate(String apikey){
		MongoKanta mongo = new MongoKanta();
		DB db = mongo.getDatabase("TotoKanta");
		DBCollection coll = db.getCollection("user");
		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("apikey", apikey);
		DBCursor cursor = coll.find(searchQuery);
		User user = new User();
		
		while (cursor.hasNext()) {
			BasicDBObject obj = (BasicDBObject) cursor.next();			
			user.setUsername(obj.getString("username"));
			user.setIsAdmin(obj.getBoolean("isAdmin"));			
			user.setAPIKEY(obj.getString("apikey"));			
		}	
		
		mongo.SuljeTietokantayhteys();
		
		return user;
	}	

	private static class Status{		
		@SuppressWarnings("unused")
		private Boolean isAdmin;		
		@SuppressWarnings("unused")
		private String apikey;
		@SuppressWarnings("unused")
		private String user;
		@SuppressWarnings("unused")
		private String status;
		
		public Status(Boolean isAdmin, String apikey, String user, String status){
			this.isAdmin = isAdmin;
			this.apikey =  "Write this up: " + apikey;
			this.user = user;
			this.status = status;
		}
	}

}
