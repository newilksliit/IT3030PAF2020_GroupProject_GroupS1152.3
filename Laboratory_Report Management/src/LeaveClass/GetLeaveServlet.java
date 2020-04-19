package LeaveClass;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/GetLeaveServlet")
public class GetLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   
		String EmpID = request.getParameter("EmpID");
		String Type = request.getParameter("Type");
		String Start = request.getParameter("Start");
		String End = request.getParameter("End");
		String Reason = request.getParameter("Reason");
	
		GetLeave GT = new GetLeave(EmpID, Type, Start, End, Reason);
		GetLeaveDAO.insertData(GT);
	  
	
	}

}


