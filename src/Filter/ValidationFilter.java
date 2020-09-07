package Filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ValidationFilter
 */

public class ValidationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidationFilter() {}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		response.setContentType("text/html");
		if(name.isEmpty() || email.isEmpty() || password.isEmpty() || role.isEmpty()) {
			response.getWriter().println("<h3>None of the field should be empty!</h3>");
		}
		else if(name.length()< 8) {
			response.getWriter().println("</h3>Username must contain atleast 8 characters</h3>");
		}else if(!(Pattern.matches("[a-zA-Z0-9]+(.+)@(.+)", email))) {
			response.getWriter().println("</h3>Invalid Email</h3>");
		}else if(password.length() < 8) {
			response.getWriter().println("<h3> Weak Password</h3>");
		
		}else {
				chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
