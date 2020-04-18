package model; 
 
import java.sql.*; 
 
public class Patient{ 
	//A common method to connect to the DB  
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
 
 public String insertPatient(String pusername, String ppassword, String email, String fName, String lName, String dob, int ccNo, String expDate, int cvc){
	 
	 String output = ""; 
 
	 try{
		 
		 Connection con = connect();
 
		 if(con == null)
		 	{return "Error while connecting to the database for inserting."; } 
 
		 // create a prepared statement
		 String query = " insert into patient (`pId`, `pusername`, `ppassword`, `email`, `fName`, `lName`, `dob`, `ccNo`, `expDate`, `cvc`)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
 
		 // binding values    
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
		 
		// execute the statement
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
 }




