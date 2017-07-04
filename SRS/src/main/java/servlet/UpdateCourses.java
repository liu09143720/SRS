package servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import service.WebService;


/**
 * Servlet implementation class GuitarDelete
 */
@WebServlet("/UpdateCourses")
public class UpdateCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourses() {
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
		
		String[] changes=request.getParameterValues("change");
		String[] changeNos=request.getParameterValues("changeNo");
		String[] changeNames=request.getParameterValues("changeName");
		String[] changeCredits=request.getParameterValues("changeCredits");
		String[] changePres=request.getParameterValues("changePre");
		Course updateC=null;
		
		WebService service = new WebService();
		for(int i=0;i<changeNos.length;i++){
			for(int j=0;j<changes.length;j++){
				if(changes[j].equals(changeNos[i])){
					updateC=new Course(changeNos[i],changeNames[i],Double.valueOf(changeCredits[i]));
					service.updateCourses(updateC,changePres[i]);
				}
			}
		}
		//response.sendRedirect("index.jsp");
		request.getRequestDispatcher("SearchCourses").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	 

	
}
