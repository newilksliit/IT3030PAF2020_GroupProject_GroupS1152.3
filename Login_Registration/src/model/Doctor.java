package model; 
 
import java.sql.*; 
 
public class Doctor{ 
	
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
 
	public String insertDoctor(String dusername, String dpassword, String dName, String specialization, String charges, int hospital){
	 
		String output = ""; 
 
		try{
		 
			Connection con = connect();
 
			if(con == null)
		 		{return "Error while connecting to the database for inserting."; } 
 
		 
			String query = " insert into doctor (`docId`, `dusername`, `dpassword`, `dName`, `specialization`, `charges`, `hospital`)" + " values (?, ?, ?, ?, ?, ?, ?)"; 
			String Query = "insert into user (`username`, `password`)" + " values(?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			PreparedStatement prepStm = con.prepareStatement(Query);
     
			 preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, dusername);
			 preparedStmt.setString(3, dpassword);
			 preparedStmt.setString(4, dName);
			 preparedStmt.setString(5, specialization);
			 preparedStmt.setString(6, charges);
			 preparedStmt.setInt(7, hospital);
			 
			 prepStm.setString(1, dusername);
			 prepStm.setString(2, dpassword);
		
			 preparedStmt.execute();
			 prepStm.execute();
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
 
	public String readDoctors(){
		String output = "";
		
 
		try{    
			Connection con = connect(); 
			

			if (con == null)    
				{return "Error while connecting to the database for reading."; } 

			output = "<table border=\"1\"><tr><th>docId</th><th>Name</th><th>specialization</th><th>charges</th><th>hospitalID</th><th>Update</th><th>Remove</th></tr>"; 

			String query = "select docId, dName, specialization, charges, hospital from doctor";    
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query); 

			while (rs.next()){
				String docId = Integer.toString(rs.getInt("docId"));
				String dName = rs.getString("dName");     
				String special = rs.getString("specialization");
				String charges = rs.getString("charges");
				Integer hId = rs.getInt("hospital");
			

			output += "<tr><td>" + docId + "</td>";     
			output += "<td>" + dName + "</td>";     
			output += "<td>" + special + "</td>";     
			output += "<td>" + charges + "</td>"; 
			output += "<td>" + hId + "</td>";

			output += "<td><input name=\"btnUpdate\" type=\"button\"  value=\"Update\" class=\"btn btn-secondary\"></td>" + "<td><form method=\"post\" action=\"Admin.jsp\">"      + "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"      class=\"btn btn-danger\">"      + "<input name=\"docId\" type=\"hidden\" value=\"" + docId      + "\">" + "</form></td></tr>"; 
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

	public String updateDoctor(int docId, String dName, String specialization, String charges, int hId){
		String output = ""; 
	 
		try{    
			
			Connection con = connect(); 
	 
			if (con == null)    
				{return "Error while connecting to the database for updating."; } 
	 
	       String query = "UPDATE doctor SET dName=?, specialization=?, charges=?, hospital=? WHERE docId=?"; 
	 
	       PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
	       preparedStmt.setString(1, dName);
	       preparedStmt.setString(2, specialization);    
	       preparedStmt.setString(3, charges);     
	       preparedStmt.setInt(4, hId);
	       preparedStmt.setInt(5, docId);
	 
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
	
	public String deleteDoctor(String docId){   
		String output = ""; 
	 
		try{    
			
			Connection con = connect(); 
	 
			if (con == null)    
				{return "Error while connecting to the database for deleting."; } 
	 
			String query = "delete from doctor where docId=?"; 
	 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
			preparedStmt.setInt(1, Integer.parseInt(docId)); 
	 
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




