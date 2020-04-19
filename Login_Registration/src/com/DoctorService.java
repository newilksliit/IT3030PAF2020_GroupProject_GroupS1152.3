package com; 
 
import model.Doctor; 
 
//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
 
//For JSON 
import com.google.gson.*; 
 
//For XML 
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 
 
@Path("/Doctors") 
public class DoctorService { 
	
	Doctor doctorObj = new Doctor(); 
 
	@GET 
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	public String readDoctors(){
		
		return doctorObj.readDoctors();
		
		
	}
	
	@POST 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertDoctor(@FormParam("dusername") String dusername, 
							   @FormParam("dpassword") String dpassword, 
							   @FormParam("dName") String dName, 
							   @FormParam("specialization") String specialization,
							   @FormParam("charges") String charges,
							   @FormParam("hospital") int hospital){
		
		String output = doctorObj.insertDoctor(dusername, dpassword, dName, specialization, charges, hospital); 
		return output;
	
	}
		
	@PUT 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateDoctor(String doctorData){  
		JsonObject doctorObject = new JsonParser().parse(doctorData).getAsJsonObject(); 
		 
		String docId = doctorObject.get("docId").getAsString();
		String dName = doctorObject.get("dName").getAsString();  
		String specialization = doctorObject.get("specialization").getAsString(); 
		String charges = doctorObject.get("charges").getAsString();
		String hId = doctorObject.get("hospital").getAsString();
		int hospital = Integer.parseUnsignedInt(hId);
		
		String output = doctorObj.updateDoctor(docId, dName, specialization, charges, hospital);
		 
		return output; 
		
	} 	 
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteDoctor(String doctorData) { 
		Document doc = Jsoup.parse(doctorData, "", Parser.xmlParser());       
		String docId = doc.select("docId").text(); 
		 
		 String output = doctorObj.deleteDoctor(docId); 
		 
		 return output; } 

	} 