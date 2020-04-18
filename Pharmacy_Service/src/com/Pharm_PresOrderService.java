package com;

import model.Pharm_PresOrder;

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

@Path("/Pharm_PresOrder")
public class Pharm_PresOrderService {

	Pharm_PresOrder orderObj = new Pharm_PresOrder();

	//////
	///////// Read Prescription Orders - Pharmacist
	/////////////////////////////////////////////////////
	@GET
	@Path("/Prescriptions")
	@Produces(MediaType.APPLICATION_JSON)
	public String readPrescriptionOrders() {
		return orderObj.readPrescriptionOrders();
	}

	//////
	///////// Prescription Orders
	///////// Read Only Available DRUGS - Pharmacist
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String readAvailableDrugs() {
		return orderObj.readAvailableDrugs();
	}

	//////
	///////// Without prescription Orders
	//////// Read DRUGS by drug ID - Customer ////////////////
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

}
