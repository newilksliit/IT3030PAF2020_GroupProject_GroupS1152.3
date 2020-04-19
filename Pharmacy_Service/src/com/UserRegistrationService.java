package com;

import model.UserRegistration;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.DatatypeConverter;

import com.sun.jersey.multipart.FormDataParam;
import com.sun.jersey.core.header.FormDataContentDisposition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

//For JSON
import com.google.gson.*;

import org.apache.commons.io.IOUtils;

@Path("/User_Registration")
public class UserRegistrationService {
	
	UserRegistration userObj = new UserRegistration();
	
	//////
	///////// Register - Customer ////////////////
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDrugs(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
			@FormParam("email") String email, @FormParam("address") String address,
			@FormParam("phoneNumber") Integer phoneNumber, @FormParam("userName") String userName, @FormParam("password") String password) {

		String output = userObj.insertCust(firstName, lastName, email, address, phoneNumber, userName, password);
		return output;
	}

}
