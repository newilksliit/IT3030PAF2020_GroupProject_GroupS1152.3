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
								@FormParam("ccNo") int ccNo,
								@FormParam("expDate") String expDate,
								@FormParam("cvc") int cvc){
		
		String output = patientObj.insertPatient(pusername, ppassword, email, fName, lName, dob, ccNo, expDate, cvc); 
		return output; 
		
	} 
	 
} 