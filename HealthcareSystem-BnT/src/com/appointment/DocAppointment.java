package com.appointment;

import model.Doc;


//For Rest Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For xml
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/appointment")
public class DocAppointment {
	
	Doc docObj = new Doc();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readDoc() {
		
		return docObj.readDoc();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDoc(@FormParam("docId") String docId,
	                    @FormParam("pName") String pName,
	                    @FormParam("aDate") String aDate,
	                    @FormParam("aPlace") String aPlace)
	{
		String output = docObj.insertDoc(docId, pName, aDate, aPlace);
		return output;
	}
		
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)	
	public String updateDoc(String appointdata) {
		
		//convert the input string to a JSON object
		JsonObject appointObj = new JsonParser().parse(appointdata).getAsJsonObject();
		
		//read the values from the JSON object
		String appointmentId = appointObj.get("appointmentId").getAsString();
		String docId = appointObj.get("docId").getAsString();
		String pName = appointObj.get("pName").getAsString();
		String aDate = appointObj.get("aDate").getAsString();
		String aPlace = appointObj.get("aPlace").getAsString();
		
		String output = docObj.updateDoc(appointmentId, docId, pName, aDate, aPlace);
		return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDoc(String appointdata) {
		
		//convert the input string to an xml document
		Document doc = Jsoup.parse(appointdata, "", Parser.xmlParser());
		
		//read the value from the element <appointmentId>
		String appointmentId = doc.select("appointmentId").text();
		String output = docObj.deleteDoc(appointmentId);
		return output;
		
	}
	
	

}
