package servlet;


import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import model.EnrollmentStatus;
import model.ScheduleOfClasses;
import model.Student;
import model.Transcript;
import service.WebService;
import util.DBUtil;



/*import com.google.gson.Gson;

import service.dto.AjaxResult;*/

/**
 * Servlet implementation class enrollCourseServlet
 */
@WebServlet("/enrollCourseServlet")
public class enrollCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enrollCourseServlet() {
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

		String[] selects=request.getParameterValues("select");
		String[] drops=request.getParameterValues("drop");
		String page="false.jsp";
		WebService service = new WebService();
		String ssn= (String) request.getSession().getAttribute("ssn");
		Student whoWantToEnroll=service.getStudent(ssn);
		Transcript tst=service.getTranscript(ssn);
		whoWantToEnroll.setTranscript(tst);
		
		List<EnrollmentStatus> allResult=new ArrayList<EnrollmentStatus>();
		//EnrollmentStatus result=new EnrollmentStatus();
		
		if(drops!=null)
		service.deleteTranscript(drops,ssn);//退选
		
		ScheduleOfClasses scs=service.getScheduleOfClasses(selects);
		HashMap<Integer,HashMap<String,Student>> enrolledStudents=service.getEnrolledStudents(selects);
		
		for(String key : scs.getSectionsOffered().keySet()){
			for(Integer ekey : enrolledStudents.keySet()){
				if(ekey==scs.getSectionsOffered().get(key).getSectionNo()){
					scs.getSectionsOffered().get(key).setEnrolledStudents(enrolledStudents.get(ekey));
				}
			}
		}
		
		List<Course> getFullCourses=new ArrayList<Course>();
		getFullCourses=service.getCoursesForSection(scs);
		
		for(String key : scs.getSectionsOffered().keySet()){
			for(int i=0;i<getFullCourses.size();i++){
				if(getFullCourses.get(i).getCourseNo().equals(String.valueOf(scs.getSectionsOffered().get(key).getRepresentedCourse().getCourseNo())))
				scs.getSectionsOffered().get(key).setRepresentedCourse(getFullCourses.get(i));//找出该section对应的课程名称
		}
			}
		
		for(String key : scs.getSectionsOffered().keySet()){
			EnrollmentStatus enroll=scs.getSectionsOffered().get(key).enroll(whoWantToEnroll);
			if(enroll.value().equals("Enrollment successful!  :o)")){
				//Course course=service.getCoursesByCourseNo(scs.getSectionsOffered().get(key).getRepresentedCourse().getCourseNo());
				service.addEnolledCourses(ssn,scs.getSectionsOffered().get(key).getSectionNo(),scs.getSectionsOffered().get(key).getRepresentedCourse().getCourseName());
			}else{
				allResult.add(enroll);
			}
				
			/*Course course=service.getCoursesByCourseNo(scs.getSectionsOffered().get(key).getRepresentedCourse().getCourseNo());
				service.addEnolledCourses(ssn,scs.getSectionsOffered().get(key).getSectionNo(),course.getCourseName());*/
		}
		
		DBUtil.closeConnection();
		
		if(!allResult.isEmpty()){
			request.setAttribute("falseResult", allResult);
			request.getRequestDispatcher(page).forward(request, response);
		}else{
			//request.setAttribute("result", result);
			
			request.getRequestDispatcher("enrollCourse.jsp").forward(request, response);
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
