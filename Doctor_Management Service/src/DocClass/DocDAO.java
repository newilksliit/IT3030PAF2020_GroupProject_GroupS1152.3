package DocClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.print.Doc;

import LeaveClass.GetLeave;

public class DocDAO {


	public static void insertData(Doc gT) {

		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "";
		
		String query = "INSERT INTO `leave`(`Fname`, `Lname`, `Pnumber`, `Email`) VALUES (?,?,?,?)";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
		
			PreparedStatement ps = con.prepareStatement(query);
		
			ps.setString(1, gT.getEmpID());			
			ps.setString(2, gT.getType());		
            ps.setString(3, gT.getStart());
            ps.setString(4, gT.getEnd());            
            ps.setString(5, gT.getReason());
			
			ps.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
