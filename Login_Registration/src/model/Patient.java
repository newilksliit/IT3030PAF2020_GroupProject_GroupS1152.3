package model; 
 
import java.sql.*; 
 
public class Patient{ 
	
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
 
	public String insertPatient(String pusername, String ppassword, String email, String fName, String lName, String dob, int ccNo, String expDate, int cvc){
	 
		String output = ""; 
 
		try{
		 
			Connection con = connect();
 
			if(con == null)
		 		{return "Error while connecting to the database for inserting."; } 
 
		 
			String query = " insert into patient (`pId`, `pusername`, `ppassword`, `email`, `fName`, `lName`, `dob`, `ccNo`, `expDate`, `cvc`)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
     
			 preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, pusername);
			 preparedStmt.setString(3, ppassword);
			 preparedStmt.setString(4, email);
			 preparedStmt.setString(5, fName);
			 preparedStmt.setString(6, lName);
			 preparedStmt.setString(7, dob);
			 preparedStmt.setInt(8, ccNo);
			 preparedStmt.setString(9, expDate);
			 preparedStmt.setInt(10, cvc);
		 
		
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
 
	public String readPatients(){
		String output = "";
		
 
		try{    
			Connection con = connect(); 
			

			if (con == null)    
				{return "Error while connecting to the database for reading."; } 

			output = "<table border=\"1\"><tr><th>pId</th><th>Name</th><th>email </th><th>DoB </th><th>Credit Card No</th><th>Update</th><th>Remove</th></tr>"; 

			String query = "select pId, fName, lName, email, dob, ccNo from patient";    
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query); 

			while (rs.next()){
				String pId = Integer.toString(rs.getInt("pId"));
				String fName = rs.getString("fName");     
				String lName = rs.getString("lName");     
				String email = rs.getString("email");     
				Date dob = (rs.getDate("dob"));
				Integer ccNo = rs.getInt("ccNo");
			

			output += "<tr><td>" + pId + "</td>";     
			output += "<td>" + fName + " " + lName + "</td>";     
			output += "<td>" + email + "</td>";     
			output += "<td>" + dob + "</td>"; 
			output += "<td>" + ccNo + "</td>";

			output += "<td><input name=\"btnUpdate\" type=\"button\"  value=\"Update\" class=\"btn btn-secondary\"></td>" + "<td><form method=\"post\" action=\"Admin.jsp\">"      + "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"      class=\"btn btn-danger\">"      + "<input name=\"pId\" type=\"hidden\" value=\"" + pId      + "\">" + "</form></td></tr>"; 
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

	public String updatePatient(String pId, String fName, String lName, String email, String dob, int ccNo, String expDate, int cvc){
		String output = ""; 
	 
		try{    
			
			Connection con = connect(); 
	 
			if (con == null)    
				{return "Error while connecting to the database for updating."; } 
	 
	       String query = "UPDATE patient SET fName=?, lName=?, email=?, dobc=?, ccNo=?, expDate=?, cvc=?" + "WHERE pId=?"; 
	 
	       PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
	       preparedStmt.setString(1, fName);
	       preparedStmt.setString(2, lName);    
	       preparedStmt.setString(3, email);    
	       preparedStmt.setString(4, dob);    
	       preparedStmt.setInt(5, ccNo);
	       preparedStmt.setString(6, expDate);
	       preparedStmt.setInt(7, cvc);
	 
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
	
	public String deletePatient(String pId){   
		String output = ""; 
	 
		try{    
			
			Connection con = connect(); 
	 
			if (con == null)    
				{return "Error while connecting to the database for deleting."; } 
	 
			String query = "delete from patient where pId=?"; 
	 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
			preparedStmt.setInt(1, Integer.parseInt(pId)); 
	 
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




