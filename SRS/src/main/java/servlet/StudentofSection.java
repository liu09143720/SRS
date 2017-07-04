package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.ScheduleOfClasses;

import model.Student;
import model.TranscriptEntry;
import service.WebService;





/**
 * Servlet implementation class GuitarSearch
 */
@WebServlet("/StudentofSection")
public class StudentofSection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentofSection() {
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
		List<TranscriptEntry> tstSsn=new ArrayList<TranscriptEntry>();
		List<Student> enolledStudent=new ArrayList<Student>();
		Map<String,String> result=new HashMap<String,String>();
		
		String ssn= (String) request.getSession().getAttribute("ssn");
		ScheduleOfClasses professorClass=service.getProfessorScheduleOfClasses(ssn);
		
			tstSsn=service.getStudentSsnfromTranscript(professorClass);
		
			/*List<Course> getFullCourses=new ArrayList<Course>();
			getFullCourses=service.getCoursesForSection(professorClass);
			
			for(String key : professorClass.getSectionsOffered().keySet()){
				for(int i=0;i<getFullCourses.size();i++){
					if(getFullCourses.get(i).getCourseNo().equals(String.valueOf(professorClass.getSectionsOffered().get(key).getRepresentedCourse().getCourseNo())))
						professorClass.getSectionsOffered().get(key).setRepresentedCourse(getFullCourses.get(i));//找出该section对应的课程名称
			}
				}*/
		
			enolledStudent=service.getStudentsOfProfessor(tstSsn);
			
			for(int i=0;i<tstSsn.size();i++){
				for(int j=0;j<enolledStudent.size();j++){
					if(tstSsn.get(i).getStudent().getSsn().equals(enolledStudent.get(j).getSsn())){
						result.put(tstSsn.get(i).getCourseName(), enolledStudent.get(j).getName());
					}
			
				}
			}
		
		if(enolledStudent.size()==0){
			request.setAttribute("falseResult", "没有学生选课的信息！");
			request.getRequestDispatcher(page).forward(request, response);
		}else{
			request.setAttribute("result",result);
			/*request.setAttribute("resultStudent",enolledStudent);//注意
			request.setAttribute("resultTranscriptEntry",tstSsn);*/
			request.getRequestDispatcher("studentChoose.jsp").forward(request, response);
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
