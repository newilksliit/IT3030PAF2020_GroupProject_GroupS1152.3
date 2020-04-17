package com;

import model.PharmCust_Order;
import model.Pharm_Drug;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.multipart.FormDataParam;
import com.sun.jersey.core.header.FormDataContentDisposition;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/PharmCust_Order")
public class PharmCust_OrderService {
	
	PharmCust_Order orderObj = new PharmCust_Order();
	
	
	//////
	///////// Without prescription Orders
	///////// Read Only Available DRUGS -----> checks quantity - Customer ////////////////
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String readAvailableDrugs() {
		return orderObj.readAvailableDrugs();
	}
	
	
    //////
	///////// Without prescription Orders
	////////  Read DRUGS by drug ID - Customer ////////////////
	@GET
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String readDrugsByID(String drugData) {
		JsonObject drugObject = new JsonParser().parse(drugData).getAsJsonObject();

		Integer drugID = drugObject.get("drugID").getAsInt();

		String output = orderObj.readDrugsByID(drugID);
		return output;		
	}

	
	//////
	///////// Without prescription Orders
	///////// Update Quantity (wanted) - Customer ////////////////
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateTempTable(String drugData) {
		// Convert the input string to a JSON object
		JsonObject drugObject = new JsonParser().parse(drugData).getAsJsonObject();

		// Read the values from the JSON object
		Integer tempID = drugObject.get("tempID").getAsInt();
		Integer actualQuantity = drugObject.get("actualQuantity").getAsInt();

		String output = orderObj.updateTempTable(tempID, actualQuantity);
		return output;
	}
	
	
	//////
	////////// Without prescription Orders 
	///////// Delete a listed Drug - Customer ////////////////
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteListedDrug(String drugData) {
		JsonObject drugObject = new JsonParser().parse(drugData).getAsJsonObject();

		Integer tempID = drugObject.get("tempID").getAsInt();

		String output = orderObj.deleteListedDrug(tempID);
		return output;
	}
	
	//////
	///////// Without prescription Orders
	///////// Read Without Prescription Order ////////////////
	@GET
	@Path("/Invoice")
	@Produces(MediaType.APPLICATION_JSON)
	public String buyOrder() {
		return orderObj.buyOrder();
	}

}
