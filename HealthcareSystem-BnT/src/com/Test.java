package com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class Test {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response Hello() {
		return Response.ok().entity(new Entity(1, "One")).build();
	}
}
