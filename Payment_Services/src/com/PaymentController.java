////////////////////////		File History			//////////////////
//------------------------------------------------------------------------
//Date		User			Description
//------	-----------		----------------------------------------------
//150420	IT16109254		:Created
//////////////////////////////////////////////////////////////////////////
package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Payment.Method;
import com.Payment.Status;
import com.Payment.Type;

public class PaymentController {

	/* Database connection */
	private String url = "127.0.0.1:3306/healthcare";
	private String username = "root";
	private String password = "root";

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://" + url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public List<Payment> readItems() {

		List<Payment> output = new ArrayList<Payment>();
		;

		try {
			Connection con = connect();
			if (con == null) {
				con.close();
				throw new Exception("Error connecting to database");
			}

			String query = "select * from tblPayment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				Payment item = new Payment();

				item.paymentId = rs.getInt("payment_id");
				item.userId = rs.getString("user_id");
				item.appointmentId = rs.getString("appointment_id");
				item.date = rs.getDate("date");
				item.type = ((rs.getString("type").equals("ONLINE")) ? Type.ONLINE : Type.MANUAL);
				item.method = (rs.getString("method").equals("CASH")) ? Method.CASH
						: ((rs.getString("method").equals("CHEQUE") ? Method.CHEQUE : Method.DEBIT));
				item.status = (rs.getString("status").equals("PENDING") ? Status.PENDING
						: ((rs.getString("status")).equals("PAID") ? Status.PAID : Status.RETURNED));
				item.amount = rs.getDouble("amount");
				// Add into the list
				output.add(item);
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String insertItem(Payment payment) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = "INSERT INTO `tblpayment` (`user_id`, `appointment_id`, `type`, `method`, `status`, `amount`+ ) + VALUES (?,?,?,?,?,?);";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, "gfd");
			preparedStmt.setString(2, "fdg");
			preparedStmt.setString(3, "manual");
			preparedStmt.setString(4, "cash");
			preparedStmt.setDouble(5, 12.12);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
