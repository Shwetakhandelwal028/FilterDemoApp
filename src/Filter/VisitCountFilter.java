package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class VisitCountFilter
 */

public class VisitCountFilter implements Filter {
	public static int count;

    /**
     * Default constructor. 
     */
    public VisitCountFilter() {}
    

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}
	

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html");
		count++;
		response.getWriter().println("<h3> Total Visits : "+count+"</h3>");
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {}
		

}
