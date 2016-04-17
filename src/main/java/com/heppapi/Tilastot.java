package com.heppapi;

//import javax.annotation.security.PermitAll;
//import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.konffit.ToJson;
import com.models.TilastoDAO;

//@PermitAll
@Path("tilastot")
public class Tilastot {
	
	//@RolesAllowed("user")
	@GET //HAKEE KAIKKI TILASTOT KANNASTA
	@Produces(MediaType.APPLICATION_JSON)
    public String getTilastot() {		
		
		TilastoDAO tilasto = new TilastoDAO();	
        return new ToJson().toJson(tilasto.getTilasto()); 
    }
}