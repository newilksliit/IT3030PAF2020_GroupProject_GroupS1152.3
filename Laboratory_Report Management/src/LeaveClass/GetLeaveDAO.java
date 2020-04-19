
package LeaveClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetLeaveDAO {

	public static void insertData(GetLeave GT) {

		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "";
		
		String query = "INSERT INTO `leave`(`EmpID`, `Type`, `Start`, `End`, `Reason`) VALUES (?,?,?,?,?)";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
		
			PreparedStatement ps = con.prepareStatement(query);
		
			ps.setString(1, GT.getEmpID());			
			ps.setString(2, GT.getType());		
            ps.setString(3, GT.getStart());
            ps.setString(4, GT.getEnd());            
            ps.setString(5, GT.getReason());
			
			ps.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
