package servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Professor;
import service.WebService;


/**
 * Servlet implementation class GuitarDelete
 */
@WebServlet("/UpdateTeachers")
public class UpdateTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTeachers() {
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
		
		String change=request.getParameter("change");
		String[] changeNos=request.getParameterValues("changeNo");
		String[] changeNames=request.getParameterValues("changeName");
		String[] changeDepartments=request.getParameterValues("changeDepartment");
		
		WebService service = new WebService();
		Professor updateP=null;
		
		for(int i=0;i<changeNos.length;i++){
			
				if(change.equals(changeNos[i])){
					updateP=new Professor(changeNames[i],changeNos[i],"",changeDepartments[i]);
					service.updateTeachers(updateP);
				}
			
		}
		
		
		
		//response.sendRedirect("SearchTeachers");
		request.getRequestDispatcher("SearchTeachers").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	 

	
}
