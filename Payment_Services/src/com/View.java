package com;

import java.sql.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import com.Payment;

@Path("/payments")
public class View {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetPayment() {
		return Response.ok().entity(new PaymentController().readItems()).build();
	}
/*
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem() {
		String output = itemObj.insertItem(itemCode, itemName, itemPrice, itemDesc);
		return output;
	}
	*/

}