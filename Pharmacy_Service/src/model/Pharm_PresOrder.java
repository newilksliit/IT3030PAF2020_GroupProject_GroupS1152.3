package model;

import java.sql.*;
import org.json.*;

public class Pharm_PresOrder {

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

	/////////////// Read Prescription Orders  - Pharmacist ////////////////
	///////////////////////////////////////////////////////////////////////
	public String readPrescriptionOrders() {
		String output = "";
		JSONObject json = new JSONObject();

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			String query = "select * from `prescription` order by `prescriptionID`";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			JSONArray array = new JSONArray();

			// iterate through the rows in the result set
			while (rs.next()) {
				String prescriptionID = Integer.toString(rs.getInt("prescriptionID"));
				String uploadDate = rs.getString("uploadDate");
				String imageName = rs.getString("imageName");
				String imageDir = rs.getString("imageDir");

				JSONObject img1 = new JSONObject();

				img1.put("Prescription ID", prescriptionID);
				img1.put("Upload Date", uploadDate);
				img1.put("Image Name", imageName);
				img1.put("Image Directory", imageDir);

				array.put(img1);
			}
			json.put("List", array);
			con.close();

		} catch (Exception e) {
			output = "Error while reading details!";
			System.err.println(e.getMessage());
		}
		output = json.toString();
		return output;
	}

}
