package com.konffit;

import com.google.gson.Gson;

public class ToJson {
	
	public ToJson(){}
	
	public String toJson(Object obj){
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		return json;
	}	
	
}
