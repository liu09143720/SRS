package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.WebService;
import model.Person;
import model.Professor;
import model.Student;



/**
 * Servlet implementation class AdminSignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String userSSn=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		String auto=request.getParameter("auto");
		String kind=request.getParameter("kind");
		String page="SignIn.jsp";
		
		WebService service = new WebService();
		
		Person admin;
		Person through=null;
		
		if(kind.equals("Student")){
			kind=null;//为过滤器做设置
			admin=new Student(0,userSSn,userPassword);
			through=service.signInStudent(admin);
			
		}else if(kind.equals("Professor")){
			admin=new Professor(0,userSSn,userPassword);
			through=service.signInProfessor(admin);
		}
		
		if(through!=null){
			page="index.jsp";
			request.getSession().setAttribute("personType", kind);       
	        request.getSession().setAttribute("ssn", userSSn);
	        request.getSession().setAttribute("userName", through.getName());
	        if("auto".equals(auto)){//记住密码
	        	
	        	Cookie namecookie=new Cookie("name",userSSn);		//浏览器是否支持cookie	
	        	namecookie.setMaxAge(7*24*60*60);
	        	response.addCookie(namecookie);
	        	
	        	Cookie pswcookie=new Cookie("psw",userPassword);			
	        	pswcookie.setMaxAge(7*24*60*60);
	        	response.addCookie(pswcookie);
	        }
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
