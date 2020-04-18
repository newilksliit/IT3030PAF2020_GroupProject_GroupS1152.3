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

	/////////////// Read Prescription Orders - Pharmacist ////////////////
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

	/////////////// Read Only Available Drugs - Pharmacist ////
	// Consider ----> Quantity > 10 AND check Expire date ////
	//////// Reason 1 --> To check all types of drugs are available //////
	//////// Reason 2 --> To make orders for uploaded prescriptions //////
	public String readAvailableDrugs() {
		String output = "";
		JSONObject json = new JSONObject();

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			String query = "select d.drugID, d.drugName, d.quantity, d.strength, d.ExpireDate, d.UnitPrice, c.categoryName from drugs d, type t, category c where t.typeID=d.typeID and c.categoryID=d.categoryID and d.quantity > 10 and ExpireDate > current_date() order by d.drugID";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			JSONArray array = new JSONArray();

			// iterate through the rows in the result set
			while (rs.next()) {
				String drugID = Integer.toString(rs.getInt("drugID"));
				String drugName = rs.getString("drugName");
				String quantity = Integer.toString(rs.getInt("quantity"));
				String strength = rs.getString("strength");
				String ExpireDate = rs.getString("ExpireDate");
				String UnitPrice = Double.toString(rs.getDouble("UnitPrice"));
				String categoryName = rs.getString("categoryName");

				JSONObject drug = new JSONObject();

				drug.put("Drug ID", drugID);
				drug.put("Drug Name", drugName);
				drug.put("Quantity", quantity);
				drug.put("Strength", strength);
				drug.put("Expire Date", ExpireDate);
				drug.put("Unit Price", UnitPrice);
				drug.put("Category Name", categoryName);
				array.put(drug);
			}
			json.put("List", array);
			con.close();

		} catch (Exception e) {
			output = "Error while reading the drug details!";
			System.err.println(e.getMessage());
		}
		output = json.toString();
		return output;
	}

	/// Read Drugs by input parameter - drug ID - Pharmacist ///
	//***Scenario - Pharmacist select drugs to make orders for Prescriptions**
	///////// Consider ----> Quantity should be more than 10 //////////////
	public String readDrugsByID(Integer ID) {
		String output = "";

		JSONObject json = new JSONObject();
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			String query = "select * from drugs where drugID=? and quantity > 10";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, ID);

			ResultSet rs = preparedStmt.executeQuery();
			JSONArray array = new JSONArray();

			// iterate through the rows in the result set
			while (rs.next()) {
				String drugID = Integer.toString(rs.getInt("drugID"));
				String drugName = rs.getString("drugName");
				String quantity = Integer.toString(rs.getInt("quantity"));
				String strength = rs.getString("strength");
				String ExpireDate = rs.getString("ExpireDate");
				String UnitPrice = Double.toString(rs.getDouble("UnitPrice"));

				JSONObject drug = new JSONObject();

				drug.put("drugID", drugID);
				drug.put("drugName", drugName);
				drug.put("quantity", quantity);
				drug.put("strength", strength);
				drug.put("ExpireDate", ExpireDate);
				drug.put("UnitPrice", UnitPrice);
				array.put(drug);

				///////////////// Insert selected drug details into TempTable_Prescription
				///////////////// //////////////////////////////////
				String addToTempPresquery = "insert into `#temptable_prescription`(`drugid`, `name`, `strength`, `availableQuantity`, `unitprice`) values ('"
						+ drugID + "', '" + drugName + "', '" + strength + "', '" + quantity + "', '" + UnitPrice
						+ "')";

				PreparedStatement preparedStmtToTempPres = con.prepareStatement(addToTempPresquery);
				preparedStmtToTempPres.execute();
				/////////////////////////////////////////////////////////////////////////////
			}
			json.put("List", array);
			con.close();

		} catch (Exception e) {
			output = "Error while reading the drug details!";
			System.err.println(e.getMessage());
		}
		output = json.toString();
		return output;
	}

}
