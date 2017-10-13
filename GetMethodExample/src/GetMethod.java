

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetMethod
 */
@WebServlet("/form")
public class GetMethod extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
	    String title = "Using GET Method to Read Form Data";
	    String docType ="<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">";
		out.println(title+"<br>");
		out.println("First Name: "+request.getParameter("fname")+"<br>");
		out.println("Last name: "+request.getParameter("lname"));
	}

}
