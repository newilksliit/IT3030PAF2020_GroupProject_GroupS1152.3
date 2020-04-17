package model;

import java.sql.*;
import org.json.*;

public class PharmCust_Order {

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

	/////////////// Read Only Available Drugs to buy ////////////////
	// Consider ----> Quantity > 10 AND check Expire date AND Type OTC [id=1] ////
	//////////////////////////////////////////////////////////////////////////////
	public String readAvailableDrugs() {
		String output = "";
		JSONObject json = new JSONObject();

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			String query = "select d.drugID, d.drugName, d.quantity, d.strength, d.ExpireDate, d.UnitPrice, c.categoryName from drugs d, type t, category c where t.typeID=d.typeID and c.categoryID=d.categoryID and d.quantity > 10 and ExpireDate > current_date() and d.typeID = 1 order by d.drugID";

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
				// String typeName = rs.getString("typeName");
				String categoryName = rs.getString("categoryName");

				JSONObject drug = new JSONObject();

				drug.put("Drug ID", drugID);
				drug.put("Drug Name", drugName);
				drug.put("Quantity", quantity);
				drug.put("Strength", strength);
				drug.put("Expire Date", ExpireDate);
				drug.put("Unit Price", UnitPrice);
				// drug.put("typeName", typeName);
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

	/////////// Read Drugs by input parameter - drug ID //////////////
	///// *******Scenario - Customer select a drug to buy******* ////////
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
				// String typeID = Integer.toString(rs.getInt("typeID"));
				// String categoryID = Integer.toString(rs.getInt("categoryID"));

				JSONObject drug = new JSONObject();

				drug.put("drugID", drugID);
				drug.put("drugName", drugName);
				drug.put("quantity", quantity);
				drug.put("strength", strength);
				drug.put("ExpireDate", ExpireDate);
				drug.put("UnitPrice", UnitPrice);
				// drug.put("typeID", typeID);
				// drug.put("categoryID", categoryID);
				array.put(drug);

				///////////////// insert into Temp Table //////////////////////////////////
				String addToTempquery = "insert into `#temptable`(`drugid`, `name`, `strength`, `availableQuantity`, `unitprice`) values ('"
						+ drugID + "', '" + drugName + "', '" + strength + "', '" + quantity + "', '" + UnitPrice
						+ "')";
				PreparedStatement preparedStmtToTemp = con.prepareStatement(addToTempquery);

				preparedStmtToTemp.execute();
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

	//////////// Update TempTable - add Quantity /////////////////
	////// ***** Scenario - Customer enter the quantity he wants to buy****/////
	//////// According to quantity, Line Total will be calculated and updated //////
	/////////// ///////////////////////////////////////////////////////////////////
	public String updateTempTable(Integer ID, Integer quantity) {
		String output = "";
		Integer quantity_available = 0;
		Double lineTot = 0.0;
		Double unitPrice = 0.0;

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			String readTempquery = "select * from `#temptable` where `tempID`='" + ID + "'";
			PreparedStatement preparedStmtToTemp = con.prepareStatement(readTempquery);
			ResultSet rs = preparedStmtToTemp.executeQuery();

			while (rs.next()) {
				quantity_available = rs.getInt("availableQuantity");
				unitPrice = rs.getDouble("unitprice");
			}
			lineTot = unitPrice * quantity;

			if (quantity < (quantity_available - 10)) {
				// create a prepared statement
				String query = "UPDATE `#temptable` SET actualQuantity=?, lineTotal='" + lineTot + "' WHERE tempID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, quantity);
				preparedStmt.setInt(2, ID);

				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Updated successfully";
			} else {
				output = "Sorry! Stock is not enough";
			}

		} catch (Exception e) {
			output = "Error while updating the drug details!";
			System.err.println(e.getMessage());
		}
		return output;
	}

	//////////// Delete a listed Drug from TempTable ///////////
	//// **** Scenario - Customer deleted a listed drug from buying *****//////
	/////////// ////////////////////////////////////////////////////////////
	public String deleteListedDrug(Integer ID) {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from `#temptable` where tempID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, ID);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";

		} catch (Exception e) {
			output = "Error while deleting the drug.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	/////// Read/ View Without Prescription ORDER --> BUY /////////
	/// with Total Price //////// Must direct to online payment portal///
	///////// Data should pass to an INVOICE template //////////////
	public String buyOrder() {
		String output = "";
		Double TotalPrice = 0.0;
		Integer order_ID=0;

		JSONObject json = new JSONObject();

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			///////////////// insert into Order Table
			///////////////// //////////////////////////////////
			Integer UserID = 2; // Must take User ID according to login*********

			String addOrderquery = "insert into `order`(`orderDate`, `confirmationStatus`, `userID`) values (current_date(), 'Confirmed', '" + UserID + "')";
			PreparedStatement preparedStmtToOrder = con.prepareStatement(addOrderquery, Statement.RETURN_GENERATED_KEYS);
			preparedStmtToOrder.execute();
			ResultSet AutoID = preparedStmtToOrder.getGeneratedKeys();
			
			 if (AutoID.next()) {
				 order_ID = AutoID.getInt(1);
			 }
		            
			
			////////////////////////////////////////////////////

			String query = "select * from `#temptable` order by `tempID`";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			JSONArray array = new JSONArray();

			// iterate through the rows in the result set
			while (rs.next()) {
				String tempID = Integer.toString(rs.getInt("tempID"));
				String drugid = Integer.toString(rs.getInt("drugid"));
				String name = rs.getString("name");
				String strength = rs.getString("strength");
				String availableQuantity = Integer.toString(rs.getInt("availableQuantity"));
				String unitprice = Double.toString(rs.getDouble("unitprice"));
				String actualQuantity = Integer.toString(rs.getInt("actualQuantity"));
				String lineTotal = Double.toString(rs.getDouble("lineTotal"));

				JSONObject order = new JSONObject();

				order.put("Item No", tempID);
				order.put("Drug ID", drugid);
				order.put("Drug Name", name);
				order.put("Strength", strength);
				order.put("Available Quantity", availableQuantity);
				order.put("Unit Price", unitprice);
				order.put("Quantity", actualQuantity);
				order.put("Line Total", lineTotal);
				array.put(order);
				
				///////////////// insert into Order DetailsTable
				///////////////// //////////////////////////////////
				String addOrderDetailsquery = "insert into `orderdetails`(`orderID`, `drugID`, `quantity`) values ('"+order_ID+"', '"+drugid+"','"+actualQuantity+"')";
				PreparedStatement PrepStmtToOrderDetails = con.prepareStatement(addOrderDetailsquery);
				PrepStmtToOrderDetails.execute();
				/////////////////////////////////////////////////////////////////////////////
			}
			json.put("List", array);

			String query1 = "select sum(lineTotal) AS TotalP from `#temptable`";
			Statement stmt1 = con.createStatement();
			ResultSet rs1 = stmt1.executeQuery(query1);
			while (rs1.next()) {
				TotalPrice = rs1.getDouble("TotalP");
			}


			///////// Update Total Price //////////////////
			String updateTotalPricequery = "UPDATE `order` SET totalPrice='" + TotalPrice + "' WHERE orderID='" + order_ID+"'";
			PreparedStatement preparedStmtUpdate = con.prepareStatement(updateTotalPricequery);
			preparedStmtUpdate.execute();
			////////////////////////////////////////////////////

			con.close();

		} catch (Exception e) {
			output = "Error while reading the drug details!";
			System.err.println(e.getMessage());
		}
		output = json.toString() + "'\n\n'" + "Total Price = " + TotalPrice;
		return output;
	}

}
