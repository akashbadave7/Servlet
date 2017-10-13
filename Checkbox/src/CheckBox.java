

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckBox
 */
@WebServlet("/box")
public class CheckBox extends HttpServlet {
	private static final long serialVersionUID = 1L;
  



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

	      PrintWriter out = response.getWriter();
	      String title = "Reading Checkbox Data";
	      out.println("<br>"+title +"<br>");
	      out.println("Maths Flag : "+request.getParameter("maths")+"<br>");
	      out.println("Physics Flag : "+request.getParameter("physics")+"<br>");
	      out.println("Chemistry Flag : "+request.getParameter("chemistry")+"<br>");
	}

}
