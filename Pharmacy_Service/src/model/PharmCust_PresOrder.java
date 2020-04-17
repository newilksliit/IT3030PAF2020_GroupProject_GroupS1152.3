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

		public String insertPrescriptionImages(Integer orderId, String imageName, String imagePath) {
			String status = "";

			try {
				Connection connection = connect();

				if (connection == null) {
					return "Error while connecting to the database for inserting.";
				}

				// create a prepared statement
				String query = "INSERT INTO prescription (`orderID`, `imageName`, `imageDir`) VALUES (?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				// binding values
				preparedStatement.setInt(1, orderId);
				preparedStatement.setString(2, imageName);
				preparedStatement.setString(3, imagePath);

				// execute the statement
				preparedStatement.executeUpdate();
				connection.close();

				status = "Successful";
			} catch (Exception ex) {
				ex.printStackTrace();
				status = "Unsuccessful__3";
			}

			return status;
		}


}
