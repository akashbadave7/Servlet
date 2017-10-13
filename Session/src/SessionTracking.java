

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SeesionTracking
 */
//@WebServlet("/SeesionTracking")
public class SessionTracking extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    String string = request.getParameter("userName");  
	    //out.println("Welcome "+string);
	    
		HttpSession session = request.getSession();
		
		
		//Get session creation time
		
		Date createTime = new Date(session.getCreationTime());
		//Get last access time of this page
		Date lastAccessTime = new Date(session.getLastAccessedTime());
		String title = "Welcome back to my website";
		Integer visitCount = new Integer(0);
		String visitCountKey = new String("visitCount");
		String userIDKey = new String("userID");
		
		//Check if this is new comer on your web page.
		
		if(session.isNew())
		{
	      //   title = "Welcome to my website";
	         session.setAttribute("Name", string);
	        
		}
		else
		{
			session.setAttribute("Name", string);
			visitCount = (Integer)session.getAttribute(visitCountKey);
	     	string = (String) session.getAttribute("Name");
		}
		
		 
	    out.println("<html><head><title>"+title+"</title></head>"
	     		+ "<body>"+title+"<br>"+"Session Information"
	     		+"<br>"	+ "<p>id : "+session.getId()
	     		+"<br>"	+ "Creation time : "+createTime
	     		+"<br>"	+ "Last access time : "+lastAccessTime
	     		+"<br> UserID : "+string+"</p>"
	     						+ "<body></html>");
	    session.invalidate();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
