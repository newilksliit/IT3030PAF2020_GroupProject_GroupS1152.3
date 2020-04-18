package com; 
 
import model.Patient; 
 
//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
 
//For JSON 
import com.google.gson.*; 
 
//For XML import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 
 
@Path("/Patient") 
public class PatientService { 
	
	Patient patientObj = new Patient(); 
 
	@GET 
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	public String insertPatient(){
		
		return patientObj.insertPatient(null, null, null, null, null, null, 0, null, 0);  
		}
	} 