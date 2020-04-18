package model; 
 
import java.sql.*; 
 
public class Hospital{ 
	
	private Connection connect(){ 
		
		Connection con = null; 
	
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			   
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hdb", "root", "");
			
			}
		catch (Exception e)
		
		{e.printStackTrace();}
		
		return con;
		} 
 
	public String insertHospital(String husername, String hpassword, String hName, String address){
	 
		String output = ""; 
 
		try{
		 
			Connection con = connect();
 
			if(con == null)
		 		{return "Error while connecting to the database for inserting."; } 
 
		 
			String query = " insert into hospital (`hId`, `husername`, `hpassword`, `hName`, `address`)" + " values (?, ?, ?, ?, ?)"; 
 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
     
			 preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, husername);
			 preparedStmt.setString(3, hpassword);
			 preparedStmt.setString(4, hName);
			 preparedStmt.setString(5, address);
			 		
			 preparedStmt.execute();
			 con.close(); 
		 
			 output = "Inserted successfully";
		 
	 } 
		catch (Exception e)
	 {
			output = "Error while inserting the item.";    
			System.err.println(e.getMessage());   
	} 
		 
		  return output; 
	 }
 
	public String readHospitals(){
		String output = "";
		
 
		try{    
			Connection con = connect(); 
			

			if (con == null)    
				{return "Error while connecting to the database for reading."; } 

			output = "<table border=\"1\"><tr><th>hId</th><th>Name</th><th>address</th></tr>"; 

			String query = "select hId, hName, address from hospital";    
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query); 

			while (rs.next()){
				String hId = Integer.toString(rs.getInt("hId"));
				String hName = rs.getString("hName");     
				String address = rs.getString("address");
					

				output += "<tr><td>" + hId + "</td>";     
				output += "<td>" + hName + "</td>";     
				output += "<td>" + address + "</td>";     
				
				output += "<td><input name=\"btnUpdate\" type=\"button\"  value=\"Update\" class=\"btn btn-secondary\"></td>" + "<td><form method=\"post\" action=\"Admin.jsp\">"      + "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"      class=\"btn btn-danger\">"      + "<input name=\"hId\" type=\"hidden\" value=\"" + hId      + "\">" + "</form></td></tr>"; 
			} 

			con.close(); 
  
			output += "</table>";   
		} 
		catch (Exception e){    
			
			output = "Error while reading the items.";   
			System.err.println(e.getMessage());   
		} 

		return output; 
 } 

	public String updateHospital(String hId, String hName, String address){
		String output = ""; 
	 
		try{    
			
			Connection con = connect(); 
	 
			if (con == null)    
				{return "Error while connecting to the database for updating."; } 
	 
	       String query = "UPDATE hospital SET hName=?, address=?" + "WHERE hId=?"; 
	 
	       PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
	       preparedStmt.setString(1, hName);
	       preparedStmt.setString(2, address);    
	       	 
	       preparedStmt.execute();    
	       con.close(); 
	 
	       output = "Updated successfully";   
	       
		}   
		catch (Exception e){    
			
			output = "Error while updating the item.";    
			System.err.println(e.getMessage());   
			
		} 
	 
	  return output;  
	  
	}
	
	public String deleteHospital(String hId){   
		String output = ""; 
	 
		try{    
			
			Connection con = connect(); 
	 
			if (con == null)    
				{return "Error while connecting to the database for deleting."; } 
	 
			String query = "delete from hospital where hId=?"; 
	 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
			preparedStmt.setInt(1, Integer.parseInt(hId)); 
	 
			preparedStmt.execute();    
			con.close(); 
	 
			output = "Deleted successfully";
			
		}   
		catch (Exception e){
			output = "Error while deleting the item.";   
			System.err.println(e.getMessage());   
			
		} 
	 
		return output;  
		
	} 
 }




