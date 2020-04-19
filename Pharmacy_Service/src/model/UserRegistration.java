package model;

import java.sql.*;
import java.util.*;

import org.json.*;

public class UserRegistration {

	// A common method to connect to the DB
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pharmacy_db", "root", "");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	/////////////// Insert New Customer - Customer ////////////////
	public String insertCust(String fname, String lfname, String email, String address, Integer phone, String userName,
			String password) {
		String output = "";
		Integer cust_ID = 0;
		String emailadd = email;

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database.";
			}

			String checkExistenceQuery = "select * from `customers` where email='" + emailadd + "'";

			Statement checkquery = con.createStatement();
			ResultSet rs = checkquery.executeQuery(checkExistenceQuery);

			if (rs.next()) {
				return "User is already Exist with this email address";
			}

			else {
				String queryCust = " insert into `customers`(`firstName`, `lastName`,`email`,`address`,`phoneNumber`)"
						+ "values (?, ?, ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(queryCust, Statement.RETURN_GENERATED_KEYS);

				// binding values
				preparedStmt.setString(1, fname);
				preparedStmt.setString(2, lfname);
				preparedStmt.setString(3, email);
				preparedStmt.setString(4, address);
				preparedStmt.setInt(5, phone);
				//
				preparedStmt.execute();

				// Get auto generated custID
				ResultSet AutoCustID = preparedStmt.getGeneratedKeys();

				if (AutoCustID.next()) {
					cust_ID = AutoCustID.getInt(1);
				}
				Integer Rnumber=new Random().nextInt(999999);

				/// Insert into Login Details table
				String queryLoginDetails = " insert into `customer_logindetails`(`custID`, `userName`,`password`,`token`) values ('"
						+ cust_ID + "', ?, ?, '"+Rnumber+"')";
				PreparedStatement preparedStmtLogDetails = con.prepareStatement(queryLoginDetails);

				preparedStmtLogDetails.setString(1, userName);
				preparedStmtLogDetails.setString(2, password);
				preparedStmtLogDetails.execute();

				con.close();
				output = "Successfully Inserted Customer Details!";
			}
		}

		catch (Exception e) {
			output = "Error while Registering!";
			System.err.println(e.getMessage());
		}
		return output;
	}

}
