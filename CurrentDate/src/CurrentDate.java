

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CurrentDate
 */
//@WebServlet("/CurrentDate")
public class CurrentDate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//set response type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Display current date and time";
		Date date = new Date();
	    SimpleDateFormat ft = new SimpleDateFormat ("E dd/MM/yyyy 'at' hh:mm:ss a zzz");
	    
		 out.println("<html><head><title>" + title + "</title></head>\n" +
		            "<body><h1 align = \"center\">" + title + "</h1>\n" +
		               "<h2 align = \"center\">" + ft.format(date) + "</h2>\n" +
		            "</body></html>" );
	}

}
