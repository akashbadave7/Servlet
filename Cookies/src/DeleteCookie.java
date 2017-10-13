

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
//@WebServlet("/Servlet2")
public class DeleteCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			Cookie cookie = null;
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			Cookie cookies[] = request.getCookies();
			if(cookies!=null)
			{
				  out.println("<h2> Cookies Name and Value</h2>");

		         for (int i = 0; i < cookies.length; i++) {
		            cookie = cookies[i];

		            if((cookie.getName( )).compareTo("Firstname") == 0 ) 
		            {
		               cookie.setMaxAge(0);
		               response.addCookie(cookie);
		               out.print("Deleted cookie : " + cookie.getName( ) +" : "+cookie.getValue());
		            }
		            /*out.print("Name : " + cookie.getName( ) + " ");
		            out.print("Value: " + cookie.getValue( )+" <br/>");*/
		         }
			}
			else
			{
		         out.println("<h2>No cookies founds</h2>");
		    }
			out.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
