package com.heppapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.konffit.ToJson;
import com.models.User;
import com.models.UserDAO;


@Path("user")
public class CreateUser {
	
	//Admin statuksella olevan henkilö voi luoda uusia api avaimia tässä polussa
	//admin key 31a91607-d3e8-4285-a7e0-e7660a84a446
	@POST //LISÄÄ UUSI HEVONEN KANTAAN
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public String putHeppa(@FormParam("username")String username,@FormParam("isAdmin") Boolean isAdmin, @FormParam("apikey") String apikey) {
		
		if(username == null || isAdmin == null || apikey == null){
			return new ToJson().toJson("Check your input");
		}
				
		User user = new UserDAO().Authenticate(apikey);
		System.out.println("*******"+user.getAPIKEY()+"*******");
		if(user.getIsAdmin() == false){
			return new ToJson().toJson("Unauthorized");
		}
		
		String output = new UserDAO().newUser(username, isAdmin);		
		return output;	
    }
	
	

}
