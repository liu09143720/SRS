package servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.WebService;


/**
 * Servlet implementation class GuitarDelete
 */
@WebServlet("/DeleteTeachers")
public class DeleteTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTeachers() {
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
		
		String[] deletes=request.getParameterValues("delete");
		
		WebService service = new WebService();
		
		service.deleteTeachers(deletes);//�����section��ѧ���ĳɼ�����ɾ��������ֻɾ����û�п����εĽ�ʦ����Ϣ
		
		
		//response.sendRedirect("index.jsp");
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
