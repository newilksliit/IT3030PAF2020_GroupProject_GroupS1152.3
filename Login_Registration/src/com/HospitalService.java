package com; 
 
import model.Hospital; 
 
//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
 
//For JSON 
import com.google.gson.*; 
 
//For XML 
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 
 
@Path("/Hospital") 
public class HospitalService { 
	
	Hospital hospitalObj = new Hospital(); 
 
	@GET 
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	public String readHospitals(){
		
		return hospitalObj.readHospitals();
		
		
	}
	
	@POST 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertHospital(@FormParam("husername") String husername, @FormParam("hpassword") String hpassword, @FormParam("hName") String hName, @FormParam("address") String address){
		
		String output = hospitalObj.insertHospital(husername, hpassword, hName, address); 
		return output;
	
	}
		
		 
		

	} 