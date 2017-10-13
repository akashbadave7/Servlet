

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorHandle
 */

public class ErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			Integer status_code = (Integer) request.getAttribute("javax.servlet.error.status_code");
			String name = request.getParameter("name");
			if(status_code != null)
			{
				out.println("Status code : "+status_code);
			}
			else 
			{
				out.println("<h3>Hello "+name+"</h3>");	
		    }
	   }
	   

}
