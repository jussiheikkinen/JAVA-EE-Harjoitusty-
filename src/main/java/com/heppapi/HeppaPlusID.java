package com.heppapi;

import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.konffit.ToJson;
import com.models.Hevonen;
import com.models.HevonenDAO;

@Path("heppa/{heppaid}")
public class HeppaPlusID {

    @GET //HAKEE HEVOSEN TIEDOT IDN PERUSTEELLA
    @Produces(MediaType.APPLICATION_JSON)
    public String getHeppa(@PathParam("heppaid") Integer heppaId) {
    	
    	HevonenDAO hepo = new HevonenDAO();		
    	Hevonen heppa = hepo.getHevonen(heppaId);
    	
    	return new ToJson().toJson(heppa);
    }
    
    @POST //PÄIVITÄ HEVONEN KANNASTA
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public String putHeppa(@PathParam("heppaid") String heppaId, MultivaluedMap<String, String> form) {
    	HevonenDAO hepo = new HevonenDAO();
    	String result = hepo.paivitaHeppa(heppaId, form);
    	return "{message:" + result +"}";
    }
 
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String delHeppa(@PathParam("heppaid") @Pattern(regexp = "[0-100000]+", message = "The id must be a valid number") String heppaId) {
    	HevonenDAO hepo = new HevonenDAO();
    	String result = hepo.poistaHeppa(heppaId);
    	return "{message:" + result +"}";	
    }
    
}
