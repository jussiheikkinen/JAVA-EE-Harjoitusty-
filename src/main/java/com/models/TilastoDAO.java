package com.models;

import java.util.ArrayList;

import com.konffit.MongoKanta;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class TilastoDAO {
	
	public ArrayList<Tilasto> getTilasto(){
		MongoKanta mongo = new MongoKanta();
		DB db = mongo.getDatabase("TotoKanta");
		DBCollection coll = db.getCollection("sukupuolis");
		
		DBCursor cursor = coll.find();
		
		ArrayList<Tilasto> lista = new ArrayList<Tilasto>();
		
		try {
			   while(cursor.hasNext()) {
				   Tilasto tilasto = new Tilasto();
				   BasicDBObject obj = (BasicDBObject) cursor.next();			
				   	tilasto.setKolmoset(Integer.valueOf(obj.getString("kolmoset")));
				   	tilasto.setKakkoset(Integer.valueOf(obj.getString("kakkoset")));
				   	tilasto.setVoitot(Integer.valueOf(obj.getString("voitot")));
					tilasto.setStartit(Integer.valueOf(obj.getString("startit")));
					tilasto.setSukupuoli(obj.getString("sukupuoli"));
					lista.add(tilasto);
			   }
			} finally {
			   cursor.close();			   
			}	

		return lista;
	}

}
