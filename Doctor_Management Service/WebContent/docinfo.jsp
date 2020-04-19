<%@ page import ="java.sql.*" %>
<%
   
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jani",
            "root", "");
    Statement st = con.createStatement();
    ResultSet rs;
    
    String sql = "DELETE FROM members WHERE first_name=?";
    
    PreparedStatement statement = con.prepareStatement(sql);
    statement.setString(1, "bill");
     
    int rowsDeleted = statement.executeUpdate();
    if (rowsDeleted > 0) {
        System.out.println("A user was deleted successfully!");
    }
%>
