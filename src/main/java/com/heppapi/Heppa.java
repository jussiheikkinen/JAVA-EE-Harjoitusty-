package com.heppapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.konffit.ToJson;
import com.models.Hevonen;
import com.models.HevonenDAO;
import com.models.User;
import com.models.UserDAO;

@Path("heppa")
public class Heppa {	
	
	//TESTI JOKA HAKEE AINA HEVOSEN JONKA ID MENEE KONSTRUKTORIIN, TESTAA MYÖS API-KEY:LLÄ TOIMIVAA AUTENTIKAATIOTA
	// TEstiavain: 31a91607-d3e8-4285-a7e0-e7660a84a446
	@GET 
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt(@HeaderParam("apikey") String apikey) {		
		
		UserDAO auth = new UserDAO();
		User user = auth.Authenticate(apikey);
		
		if(user.getUsername() != null){ 
		HevonenDAO hepo = new HevonenDAO();
		Hevonen heppa = hepo.getHevonen(3);
		return new ToJson().toJson(heppa);
		}
		return "{message: Unauthorized}";     
    }
	
	@POST //LISÄÄ UUSI HEVONEN KANTAAN
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public String putHeppa(MultivaluedMap<String, String> form) {
		
		HevonenDAO hepo = new HevonenDAO();
	    String result = hepo.uusiHevonen(form);
	    return "{message:" + result +"}";
	}

}
