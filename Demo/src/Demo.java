

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo
 */
//@WebServlet("/Demo")
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter pw=response.getWriter();  
		String par = request.getParameter("name");  
		//response.sendRedirect("http://www.google.com");  
		ServletContext context = getServletContext();
		if(par == null || par =="")
		{
			context.log("No message received : ",new IllegalStateException("Missing parameter"));
		}
		else
		{
			context.log("Here is the visitor : "+par);
		}
		pw.close();  
	}


}
