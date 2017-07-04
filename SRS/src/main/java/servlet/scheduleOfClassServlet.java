package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import model.ScheduleOfClasses;

import service.WebService;
import util.org.json.JSONArray;
import util.org.json.JSONObject;




/**
 * Servlet implementation class scheduleOfClassServlet
 */
@WebServlet("/scheduleOfClassServlet")
public class scheduleOfClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public scheduleOfClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }   
	
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		response.setContentType("application/json");  
	    response.setCharacterEncoding("UTF-8");  
	    response.setHeader("Cache-Control", "no-cache");  
		PrintWriter out=response.getWriter();
		
		WebService service = new WebService();
		 String ssn= (String) request.getSession().getAttribute("ssn");
		 //String username = (String) request.getSession().getAttribute("userName");
		String semeter="2014-2015--1";
		ScheduleOfClasses scs=service.getScheduleOfClasses(semeter); 
		List<Integer> selectedSectionNo=service.getTranscript(ssn,scs);// �ҳ�ѧ����ѧ����ѡ�γ�sectionNo
		List<Course> getCourseName=new ArrayList<Course>();
		
		getCourseName=service.getCoursesForSection(scs);
		
		for(String key : scs.getSectionsOffered().keySet()){
			for(int i=0;i<getCourseName.size();i++){
				if(getCourseName.get(i).getCourseNo().equals(String.valueOf(scs.getSectionsOffered().get(key).getRepresentedCourse().getCourseNo())))
				scs.getSectionsOffered().get(key).setRepresentedCourse(getCourseName.get(i));//�ҳ���section��Ӧ�Ŀγ�����
		}
			}
		
		if(!scs.isEmpty()){
			JSONArray ja=new JSONArray();
			JSONObject jo=new JSONObject();
		
			for(String key : scs.getSectionsOffered().keySet()){
				jo=new JSONObject();
				jo.put("sid",scs.getSectionsOffered().get(key).getSectionNo() );
				jo.put("option",scs.getSectionsOffered().get(key).getFullSectionInfo());
				ja.put(jo);
				
				for(int i=0;i<selectedSectionNo.size();i++){
					if(selectedSectionNo.get(i)==scs.getSectionsOffered().get(key).getSectionNo()){//���ѧ����ѡ����ʾ����һ�ű�
						jo=new JSONObject();
						jo.put("tid",scs.getSectionsOffered().get(key).getSectionNo() );
						jo.put("enrolled",scs.getSectionsOffered().get(key).getFullSectionInfo());
						ja.put(jo);
					}
				}
			}
		
			
		
		out.print(ja.toString());
		out.close();
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
