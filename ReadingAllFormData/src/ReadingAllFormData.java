

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadingAllFormData
 */
@WebServlet("/ReadParams")
public class ReadingAllFormData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadingAllFormData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

	      PrintWriter out = response.getWriter();
	      String title = "Reading All Form Parameters";
	      out.println(title+"<br>");
	      Enumeration paramNames = request.getParameterNames();
	      
	      while(paramNames.hasMoreElements()) 
	      {
	          String paramName = (String)paramNames.nextElement();
	          out.print(paramName+" ");
	          String[] paramValues = request.getParameterValues(paramName);

	          // Read single valued data
	          if (paramValues.length == 1) 
	          {
	             String paramValue = paramValues[0];
	             if (paramValue.length() == 0)
	                out.println("<i>No Value</i>");
	                else
	                out.println(paramValue+" "+ "<br>");
	          } 
	          else 
	          {
	        	 for(int i = 0; i < paramValues.length; i++) 
	        	 {
	                out.println(" "+ paramValues[i]);
	                
	             }
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
