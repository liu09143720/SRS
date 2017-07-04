package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet Filter implementation class SignInFilter
 */
@WebFilter(urlPatterns = { "/course.jsp","/studentChoose.jsp","/teachers.jsp"}, //学生不能访问的页面
initParams = { @WebInitParam(name = "Right_VIEW", value = "false.jsp") })
public class AdminFilter implements Filter {
	private String Right_VIEW;
    
    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request; 
        if(req.getSession().getAttribute("personType")!= null) {
            chain.doFilter(request, response);
        }
        else {
        	HttpServletResponse resp = (HttpServletResponse) response;
            
        	
        	request.setAttribute("falseResult", "学生不能访问该页面！");
			//request.getRequestDispatcher(Right_VIEW).forward(request, response);
           resp.sendRedirect(Right_VIEW);
        }
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
        this.Right_VIEW = config.getInitParameter("Right_VIEW");							
    }

}
