package com;
 
import java.io.IOException;
 
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import sun.misc.BASE64Decoder;
 
import model.Login;
 
@Path("/Login")
public class LoginService {
	
	Login loginObj = new Login();
	
	@SuppressWarnings("restriction")
	@GET
    @Path("/")
    public boolean isUserAuthenticated(String authString){
         
        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        decodedAuth = new String(bytes);
        
        String[] values = decodedAuth.split(":", 2);
        
        String username = values[0];
        String password = values[1];
        
        System.out.println(decodedAuth);
         
        loginObj.login(username, password);
        
         
        return true;
    }
}