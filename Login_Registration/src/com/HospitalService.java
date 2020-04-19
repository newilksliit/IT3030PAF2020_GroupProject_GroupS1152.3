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
		
	@PUT 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateHospital(String hospitalData){  
		JsonObject hospitalObject = new JsonParser().parse(hospitalData).getAsJsonObject(); 
		 
		String id = hospitalObject.get("hId").getAsString();
		int hId = Integer.parseUnsignedInt(id);
		String hName = hospitalObject.get("hName").getAsString();  
		String address = hospitalObject.get("address").getAsString();  
		
		String output = hospitalObj.updateHospital(hId, hName, address);
		 
		return output; 
		
	} 	 
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteHospital(String hospitalData) { 
		Document doc = Jsoup.parse(hospitalData, "", Parser.xmlParser());       
		String hId = doc.select("hId").text(); 
		 
		 String output = hospitalObj.deleteHospital(hId); 
		 
		 return output; } 

	} 