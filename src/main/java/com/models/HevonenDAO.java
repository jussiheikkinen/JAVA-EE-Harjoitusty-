package com.models;

import javax.ws.rs.core.MultivaluedMap;

import com.konffit.MongoKanta;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class HevonenDAO {

	public Hevonen getHevonen(Integer id){
		//Avataan yhteys mongokantaan
		MongoKanta mongo = new MongoKanta();
		DB db = mongo.getDatabase("TotoKanta");
		DBCollection coll = db.getCollection("hevonens");
		//Tehdään haku mongokantaan 
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("hevonenid", id);
		DBCursor cursor = coll.find(searchQuery);
		
		Hevonen heppa = new Hevonen();

		while (cursor.hasNext()) {
			BasicDBObject obj = (BasicDBObject) cursor.next();			
			heppa.setOmistaja(obj.getString("omistaja"));
			heppa.setValmentaja(obj.getString("valmentaja"));
			heppa.setSukupuoli(obj.getString("sukupuoli"));
			heppa.setNimi(obj.getString("nimi"));
			heppa.setLaji(obj.getString("laji"));
			heppa.setIka( obj.getInt("ika"));
			heppa.setId(obj.getInt("hevonenid"));	
		}
		
		mongo.SuljeTietokantayhteys();
		return heppa;
	}
	
	//TÄÄLLÄ LUODAAN UUSIA HEPPOJA KANTAAN
	public String uusiHevonen(MultivaluedMap<String, String> map){
		MongoKanta mongo = new MongoKanta();
		DB db = mongo.getDatabase("TotoKanta");
		DBCollection coll = db.getCollection("testi");
		
		try{		
		BasicDBObject document = new BasicDBObject();
		
		for(int i= 0; i < map.size();i++){
			document.put("omistaja",map.get("omistaja"));
			document.put("valmentaja",map.get("valmentaja"));
			document.put("sukupuoli",map.get("sukupuoli"));
			document.put("nimi",map.get("nimi"));
			document.put("laji",map.get("laji"));
			document.put("ika",map.get("ika"));
			document.put("hevonenid",map.get("id"));
			coll.save(document);
		}		
		}catch(Exception e){
			e.printStackTrace();
			return "status: failed, 500";			
		}
		return "status: ok, 201";		
	}
	
	//POISTA HEPPA KANNASTA
	public String poistaHeppa(String param){
		MongoKanta mongo = new MongoKanta();
		DB db = mongo.getDatabase("TotoKanta");
		DBCollection coll = db.getCollection("testi");
		
		try{
		BasicDBObject query = new BasicDBObject();
		query.put("hevonenid", param);
		coll.remove(query);
		
		}catch(Exception e){
			e.printStackTrace();
			return "Poistaminen epäonnistui";
		}
		return "Poistaminen onnistui";
		
	}

	//PÄIVITÄ HEPPA TIETOKANTAAN
	public String paivitaHeppa(String param, MultivaluedMap<String, String> map){
		MongoKanta mongo = new MongoKanta();
		DB db = mongo.getDatabase("TotoKanta");
		DBCollection coll = db.getCollection("testi");

		BasicDBObject query = new BasicDBObject();
		query.put("hevonenid",param);
		try{
		BasicDBObject document = new BasicDBObject();
		document.put("omistaja",map.get("omistaja"));
		document.put("valmentaja",map.get("valmentaja"));
		document.put("sukupuoli",map.get("sukupuoli"));
		document.put("nimi",map.get("nimi"));
		document.put("laji",map.get("laji"));
		document.put("ika",map.get("ika"));
		document.put("hevonenid",map.get("id"));
		
		coll.update(query, document);
		}catch(Exception e){
			e.printStackTrace();
		return "Virhe";
		}
		
		return "Tallennettu";
	}
}
