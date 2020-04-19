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

	/////// Read or View Prescription ORDER --> ////////
	////// This request will generate from BUY - Customer //////
	////// Calculate Total Price of Order ////////////////////
	////// *** Must direct to online payment portal///////////////
	public String buyPresOrder() {
		String output = "";
		Double TotalPrice = 0.0;
		Integer order_ID = 0;

		JSONObject json = new JSONObject();

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			//////// insert into Order Table ////////////
			Integer UserID = 2; // Must take User ID according to login******

			String addOrderquery = "insert into `order`(`orderDate`, `confirmationStatus`, `userID`) values(current_date(), 'Confirmed', '"
					+ UserID + "')";

			PreparedStatement preparedStmtToOrder = con.prepareStatement(addOrderquery,
					Statement.RETURN_GENERATED_KEYS); // Get Auto generated oderID for this record
			preparedStmtToOrder.execute();
			ResultSet AutoID = preparedStmtToOrder.getGeneratedKeys();

			if (AutoID.next()) {
				order_ID = AutoID.getInt(1);
			}
			////// ===========================================////////

			///// Get records from TempPrstable to add them into Order details///
			String query = "select * from `#temptable_prescription` order by `tempPresID`";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			JSONArray array = new JSONArray();

			// iterate through the rows in the result set
			while (rs.next()) {
				String tempPresID = Integer.toString(rs.getInt("tempPresID"));
				Integer drugid = rs.getInt("drugid");
				String name = rs.getString("name");
				String strength = rs.getString("strength");
				Integer availableQuantity = rs.getInt("availableQuantity");
				String unitprice = Double.toString(rs.getDouble("unitprice"));
				Integer actualQuantity = rs.getInt("actualQuantity");
				String lineTotal = Double.toString(rs.getDouble("lineTotal"));

				JSONObject order = new JSONObject();

				order.put("Item No", tempPresID);
				order.put("Drug ID", drugid);
				order.put("Drug Name", name);
				order.put("Strength", strength);
				order.put("Available Quantity", availableQuantity);
				order.put("Unit Price", unitprice);
				order.put("Quantity", actualQuantity);
				order.put("Line Total", lineTotal);
				array.put(order);

				//////////// insert into Order DetailsTable ///////////////
				String addOrderDetailsquery = "insert into `orderdetails`(`orderID`, `drugID`, `quantity`) values ('"
						+ order_ID + "', '" + drugid + "','" + actualQuantity + "')";

				PreparedStatement PrepStmtToOrderDetails = con.prepareStatement(addOrderDetailsquery);
				PrepStmtToOrderDetails.execute();
				///// ===============================================///////

				/////////// Adjust or update drug stock quantity ///////////////
				/////////// reduce the quantity of order from drug stock /////////
				Integer size_quantity = 0;
				size_quantity = availableQuantity - actualQuantity;

				String updatedrug_quantity = "UPDATE `drugs` SET `quantity`='" + size_quantity + "' WHERE `drugID`='"
						+ drugid + "'";
				PreparedStatement preparedStmtUpd_Quantity = con.prepareStatement(updatedrug_quantity);
				preparedStmtUpd_Quantity.execute();
				/////// ============================================//////
			}
			json.put("List", array);

			//////// Calculate Total Price and get it ///////////
			String query1 = "select sum(lineTotal) AS TotalP from `#temptable_prescription`";
			Statement stmt1 = con.createStatement();

			ResultSet rs1 = stmt1.executeQuery(query1);
			while (rs1.next()) {
				TotalPrice = rs1.getDouble("TotalP");
			}

			///////// Update Total Price //////////////////
			String updateTotalPricequery = "UPDATE `order` SET totalPrice='" + TotalPrice + "' WHERE orderID='"
					+ order_ID + "'";

			PreparedStatement preparedStmtUpdate = con.prepareStatement(updateTotalPricequery);
			preparedStmtUpdate.execute();
			/////// ==============================================/////

			con.close();

		} catch (Exception e) {
			output = "Error while reading the drug details!";
			System.err.println(e.getMessage());
		}
		output = json.toString() + "'\n\n'" + "Total Price = " + TotalPrice;
		return output;
	}
}
