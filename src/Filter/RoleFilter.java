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
 * Servlet Filter implementation class RoleFilter
 */

public class RoleFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RoleFilter() {}
       
    

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}
		

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String role = request.getParameter("role");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		response.setContentType("text/html");
		
			if(email.equals("admin@gmail.com") &&  password.equals("admin1234") && role.equals("admin")) {
				response.getWriter().println("<h3>Welcome Admin </h3>");
			}else {
				response.getWriter().println("<h3>Welcome User </h3>");
			}
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {}
		

}
