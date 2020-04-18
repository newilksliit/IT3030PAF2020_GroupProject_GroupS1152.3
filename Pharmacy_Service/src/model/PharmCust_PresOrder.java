package model;

import java.sql.*;
import org.json.*;

public class PharmCust_PresOrder {

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

	/////////////// Insert Prescription image - Customer ////////////////
	////////////////////////////////////////////////////////////////////
	public String insertPrescriptionImages(String imageName, String imagePath) {
		String status = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}

			// create a prepared statement
			String query = "INSERT INTO `prescription`(`uploadDate`, `imageName`, `imageDir`) VALUES(current_date(), ?, ?)";
			PreparedStatement preparedStatement = con.prepareStatement(query);

			// binding values
			preparedStatement.setString(1, imageName);
			preparedStatement.setString(2, imagePath);

			// execute the statement
			preparedStatement.executeUpdate();
			con.close();

			status = "Successful";
		} catch (Exception ex) {
			ex.printStackTrace();
			status = "Unsuccessful__3";
		}

		return status;
	}
}
