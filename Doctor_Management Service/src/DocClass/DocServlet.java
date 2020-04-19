package DocClass;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DocServlet")
public class DocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   
		String Fname = request.getParameter("Fname");
		String Lname = request.getParameter("Lname");
		String Start = request.getParameter("Pnumber");
		String End = request.getParameter("Email");
		
		Doc GT = new Doc(Fname, Lname, Pnumber, Email);
		DocDAO.insertData(GT);
	  
	
	}

}



