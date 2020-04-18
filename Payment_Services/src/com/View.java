package com;

import java.sql.Date;

import javax.ws.rs.GET;
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
		return Response.ok().build();
	}
}