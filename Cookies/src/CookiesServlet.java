

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesServlet
 */
//@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			
			//out.println("Welcome "+fname+" "+lname);
		      
			// Create cookies for first and last names.      
			Cookie firstName = new Cookie("Firstname", fname);
			Cookie lastName = new Cookie("Lastname",lname);
			
			//Set expiry date after 24 Hrs for both the cookies.
			firstName.setMaxAge(60*60*24);
			lastName.setMaxAge(60*60*24);
			
			Cookie cookies[] = request.getCookies();
			 // Add both the cookies in the response header.
		    response.addCookie(firstName);
			response.addCookie(lastName);
			
			out.println("<html><head><title></title>"
					+"</head><p>cookies added</p>");
			out.println("<p> Previous cookies<P>");
			for(int i=0;i<cookies.length;i++)
			{
				Cookie cookie = cookies[i];
				out.println(cookie.getName()+" : "+ cookie.getValue()+"<br>");
			}
			
			out.println("<form action ='servlet2'>");
			out.print("<input type='submit' value='Delete cookies'>");  
			out.print("</form>");
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
