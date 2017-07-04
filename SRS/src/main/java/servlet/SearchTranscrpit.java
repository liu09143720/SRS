package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Transcript;
import service.WebService;





/**
 * Servlet implementation class GuitarSearch
 */
@WebServlet("/SearchTranscript")
public class SearchTranscrpit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTranscrpit() {
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
		
		String page="false.jsp";
		WebService service = new WebService();
		String ssn= (String) request.getSession().getAttribute("ssn");
		Transcript tst=service.getTranscript(ssn);
		
		if(tst.hashCode()==0){
			request.setAttribute("falseResult", "没有找到成绩信息！");
			request.getRequestDispatcher(page).forward(request, response);
		}else{
			request.setAttribute("result",tst.getTranscriptEntries());
			request.getRequestDispatcher("Transcript.jsp").forward(request, response);
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
