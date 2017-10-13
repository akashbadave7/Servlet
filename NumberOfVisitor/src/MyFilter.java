import java.io.*;  
import javax.servlet.*;  
  
public class MyFilter implements Filter
{  
    int count=0;  
    public void init(FilterConfig arg0) throws ServletException {
    	
    }  
  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {  
      
        PrintWriter out=response.getWriter();  
        chain.doFilter(request,response);  
          
        out.print("Total visitors "+(++count));  
        out.close();  
          
    }  
    public void destroy() {}  
}  