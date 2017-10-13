

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Refresh
 */
//@WebServlet("/Refresh")
public class RefreshTime extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Set refresh, autoload time as 5 seconds
		response.setIntHeader("Refresh", 5);
		// Set response content type
		response.setContentType("text/html");
		
		//Get current time
		Calendar calendar = new GregorianCalendar();
		String am_pm;
		int hour = calendar.get(calendar.HOUR);
		int min = calendar.get(calendar.MINUTE);
		int sec = calendar.get(calendar.SECOND);

		if(calendar.get(calendar.AM_PM)==0)
		{
			am_pm = "AM";
		}
		else
		{
			am_pm = "PM";
		}

		String currentTime = hour+" : "+ min+" : "+sec+" "+am_pm;
		
		PrintWriter out = response.getWriter();
		String title = "Auto Refresh Header Setting";
		out.println();
		out.println("<html>"
				+ "<head><title>"+title+"</title></head>"
						+ "<body><center>"
						+ "<h1>"+title+"</h1>"
								+ "<p>Current time is : "+currentTime+"</p>"
										+ "</body>"
										+ "</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
