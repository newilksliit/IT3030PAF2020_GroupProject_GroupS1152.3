package model; 
 
import java.sql.*; 
 
public class Login{ 
	
	private Connection connect(){ 
		
		Connection con = null; 
	
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			   
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hdb", "root", "");
			
			}
		catch (Exception e)
		
		{e.printStackTrace();}
		
		return con;
		
	}
	
	public String login(String username, String password) {
		
		String output = "";
		
		try {
			
			if (username != null && password != null) {
				
				Connection con = connect();
				 
				if(con == null)
			 		{return "Error while connecting to the database for inserting."; } 
	 
				
				char ch = username.charAt(0);
				
				if (ch == 'p') {
					
					String query = "select pusername, ppassword from patient where pusername='" + username + "' and ppassword='" + password + "'";
					
					PreparedStatement stmt = con.prepareStatement(query);
					ResultSet rs = stmt.executeQuery(query);
					
		            if (rs.next()) {
		            	
		            	output = "Login Successfull.";		            
			              
			            
		            } 
		            else {
		            	
		            	output = "Invalid Login.";         	
			            			            
			            
		            }			       

			    } 
				else if(ch == 'd') {
			    	
			    	String query = "select dusername, dpassword from doctor where dusername='" + username + "' and dpassword='" + password + "'";
					
					PreparedStatement stmt = con.prepareStatement(query);
					ResultSet rs = stmt.executeQuery(query);
					
		            if (rs.next()) {
		            	
		            	output = "Login Successfull.";			              
			            
		            } 
		            else {
		            	
			            output =  "Invalid login.";
			            
		            }
			    }
				else if (ch == 'h') {
					
					String query = "select husername, hpassword from hospital where husername='" + username + "' and hpassword='" + password + "'";
					
					PreparedStatement stmt = con.prepareStatement(query);
					ResultSet rs = stmt.executeQuery(query);
					
		            if (rs.next()) {
		            	
		            	output = "Login Successfull.";			              
			            
		            } 
		            else {
		            	
			            output =  "Invalid login.";
			            
		            }

					
				}else if((username == "admin")&&(password == "admin123")) {
					
					output = "Administrator Login Successfull.";			
				
				}else {
					
					output = "Invalid credentials.";
				
				}
			}
			
		}
				
			catch (Exception err) {
			    	err.getMessage();
			    	err.printStackTrace();
			    
			}
		
		return output;
	}
}

			
		
	
