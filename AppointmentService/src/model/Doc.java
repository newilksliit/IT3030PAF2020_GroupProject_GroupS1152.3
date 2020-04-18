package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Doc {
	//A common method to connect to the DB
	private Connection connect()
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//Correct DB details
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthcare","root","");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		}
		
	
	public String insertDoc(String code, String name, String date, String place) {
		
		String output = "";
		try
		{
			Connection con = connect();
			if(con == null) {
				return "Error while connecting to database while inserting";
			}
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date d = new Date();
			date = df.format(d);
			java.sql.Date aDate1 = new java.sql.Date(d.getTime());
			
			//create a prepared statement
			String query = "INSERT INTO appointment(appointmentId,docId,pName,aDate,aPlace) Values(?,?,?,?,?);";
			//String query = "INSERT INTO appointment( docId, pName, aDate, aPlace) VALUES (?,?,?,?);";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			//binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2,code);
			preparedStmt.setString(3,name);
			preparedStmt.setDate(4,aDate1);
			preparedStmt.setString(5,place);
			
			//execute the statement
			preparedStmt.execute();
			con.close();
			
			output = "Appointment Inserted Successfully";
		}
		catch(Exception e) {
			output = "Error while inserting the appointment";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	public String readDoc()
	{
		String output = "";
		try
		{
			Connection con = connect();
			if(con==null) {
				return"Error while connecting to database while reading";
			}
			
			//prepare the html table to be displayed
			output = "<table border=\1\"><tr><th>Appointment ID</th><th>Doctor ID</th><th>Patient Name</th><th>Date</th><th>Hospital</th></tr>";
			String query = "select * from appointment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			//iterate through the rows in the resultset
			while(rs.next())
			{
				String appointmentId = Integer.toString(rs.getInt("appointmentId"));
				String docId = rs.getString("docId");
				String pName = rs.getString("pName");
				//String aDate = Double.toString(rs.getDouble("aDate"));
				java.sql.Date aDate = rs.getDate("aDate");
				String aPlace = rs.getString("aPlace");
				
				//Add into the html table
				output += "<tr><td>"+ appointmentId + "</td>";
				output += "<td>"+ docId + "</td>";
				output += "<td>" + pName + "</td>";
				output += "<td>" + aDate + "</td>";
				output += "<td>" + aPlace + "</td>";
				
				//buttons
				//output += "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>" + "<td><form method=\"post\" action=\"appointment.jsp\">" + "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">" + "<input name=\"appointmentId\" type=\"hidden\" value=\"" + appointmentId + "\">" + "</form></td></tr>";
				
			}
			
			con.close();
			//complete the html table
			output += "</table>";
		}
		catch (Exception e) {
			output = "Error while reading the appointments";
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	public String updateDoc(String appointmentId, String docId, String pName, String aDate, String aPlace )
	{
		String output = "";
		try
		{
			Connection con = connect();
			if(con==null) {
				return "Error while connecting to the database for updating";
			}
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date d = new Date();
			aDate = df.format(d);
			java.sql.Date aDate1 = new java.sql.Date(d.getTime());
			
			//create a prepared statement
			String query = "UPDATE appointment SET docId=?,pName=?,aDate=?, aPlace=? WHERE appointmentId=?";
			PreparedStatement preparedstmt = con.prepareStatement(query);
			
			//binding values
			preparedstmt.setString(1,docId);
			preparedstmt.setString(2, pName);
			//preparedstmt.setDouble(3, Double.parseDouble(aDate));
			preparedstmt.setDate(3, aDate1);
			preparedstmt.setString(4, aPlace);
			preparedstmt.setInt(5, Integer.parseInt(appointmentId));
			
			//execute statement
			preparedstmt.execute();
			con.close();
			
			output = "Appointment Updated Successfully";
		}
		catch (Exception e) {
			
			output = "Error while updating the item";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String deleteDoc(String appointmentId)
	{
		String output = "";
		try
		{
			Connection con = connect();
			
			if (con==null) {
				return "Error while connecting to the database for deleting";
			}
			
			//create a prepared statement
			String query = "delete from appointment where appointmentId=?";
			PreparedStatement preparedstmt = con.prepareStatement(query);
			
			//binding values
			preparedstmt.setInt(1, Integer.parseInt(appointmentId));
			
			//execute the statement
			preparedstmt.execute();
			con.close();
			
			output = "Appointment Deleted Successfully";
		}
		catch(Exception e)
		{
			output = "Error while deleting the item";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
