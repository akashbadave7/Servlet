

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.StatementEvent;

/**
 * Servlet implementation class DatabaseAccess
 */
//@WebServlet("/DatabaseAccess")
public class DatabaseAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	      // JDBC driver name and database URL
		final String JDBC_Driver = "com.mysql.jdbc.Driver";
		final String DB_Url = "jdbc:mysql://localhost:3306/Test";
		
		//Database credential
		final String username = "root";
		final String password = "root";
		Connection con=null;
		Statement stmt = null;
		//set response type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Database Result";
		out.println("<html><head><title>"+title+"</title></head>"
				+ "<body><h2>"+title+"</h2>");
		
		try
		{
			Class.forName(JDBC_Driver);
			con = DriverManager.getConnection(DB_Url,username,password);
			stmt = con.createStatement();
			String sql= "select * from Employee";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				// retrieve each column
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				// display values
				out.println("Id : "+id+"<br>");
				out.println("Age : "+age+"<br>");
				out.println("First name : "+fname+"<br>");
				out.println("Last name : "+lname+"<br>");
			}
			out.println("</body></html>");
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
