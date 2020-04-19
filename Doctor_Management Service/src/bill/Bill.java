package bill;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import LeaveClass.GetLeave;

public class Bill{

	try
	{
		Class.bill("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c=DriverManager.getConnection ("jdbc:odbc:abc", "root", "data");
		Statement s= c.createStatement();
		String sq="select * from patient where patient_id="+b;
		ResultSet rs=s.executeQuery(sq);
		if(rs.next())
		{
		rs.getString(1);
		rs.getString(2);	
		rs.getString(3);
		Integer.parseInt(rs.getString(4));
		rs.getString(5);
		rs.getString(6);
		rs.getString(7);
		rs.getString(8);l=f+500+3000;
		m1=3000;
		}
		
	}catch(Exception e){ out.println(e);}	


}
