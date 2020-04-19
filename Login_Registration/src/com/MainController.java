package com; 
 
import model.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType; 
 
//For JSON 
import com.google.gson.*;
import com.sun.jersey.api.view.Viewable;

//For XML 
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 
 
@Path("/Login_Registration") 
public class MainController {  
 
	@GET 
	@Path("/")
	@Produces(MediaType.TEXT_HTML) 
	public Viewable readLogin(){
		
		return new Viewable("/Login.jsp");
		
		
	}
	
	@POST 
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String userLogin(@FormParam("username") String username, @FormParam("password") String password){
		
		Login loginObj = new Login();
		
		String output = loginObj.login(username, password); 
		return output;
	
	}
	
	@Path("/logout")
	public class Logout {

	    @Context
	    private HttpServletRequest servletRequest;

	    @Context
	    private HttpServletResponse servletResponse;

	    @GET
	    public void logout(@CookieParam("accountHref") String accountHref) throws Exception {

	        Cookie myCookie = new Cookie("accountHref", accountHref);
	        myCookie.setMaxAge(0);
	        myCookie.setPath("/");
	        myCookie.setHttpOnly(true);
	        servletResponse.addCookie(myCookie);

	    }
	}
		
} 