package com; 
 
import model.Patient; 
 
//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
 
//For JSON 
import com.google.gson.*; 
 
//For XML 
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 
 
@Path("/Patients") 
public class PatientService { 
	
	Patient patientObj = new Patient(); 
 
	@GET 
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	public String readPatients(){
		
		return patientObj.readPatients(); 
		
		
	}
	
	@POST 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertPatient(@FormParam("pusername") String pusername,       
								@FormParam("ppassword") String ppassword,    
								@FormParam("email") String email,       
								@FormParam("fName") String fName,
								@FormParam("lName") String lName,
								@FormParam("dob") String dob,
								@FormParam("ccNo") String ccNo,
								@FormParam("expDate") String expDate,
								@FormParam("cvc") String cvc){
		
		String output = patientObj.insertPatient(pusername, ppassword, email, fName, lName, dob, ccNo, expDate, cvc); 
		return output; 
		
	} 
	
	@PUT 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updatePatient(String patientData){  
		JsonObject patientObject = new JsonParser().parse(patientData).getAsJsonObject(); 
		 
		String pId = patientObject.get("pId").getAsString();  
		String fName = patientObject.get("fName").getAsString();  
		String lName = patientObject.get("lName").getAsString();  
		String email = patientObject.get("email").getAsString(); 
		String dob = patientObject.get("dob").getAsString();
		String ccNo = patientObject.get("ccNo").getAsString();
		String expDate = patientObject.get("expDate").getAsString();
		String cvc = patientObject.get("cvc").getAsString();
		 
		String output = patientObj.updatePatient(pId, fName, lName, email, dob, ccNo, expDate, cvc);
		 
		return output; 
		
	} 
		 
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deletePatient(String patientData) { 
		Document doc = Jsoup.parse(patientData, "", Parser.xmlParser());       
		String pId = doc.select("pId").text(); 
		 
		 String output = patientObj.deletePatient(pId); 
		 
		 return output; 
		 
	} 
		  
} 