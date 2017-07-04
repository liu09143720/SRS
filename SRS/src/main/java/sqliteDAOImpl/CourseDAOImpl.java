package sqliteDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SRSDAO.CourseDAO;
import model.Course;
import model.ScheduleOfClasses;
import util.DBUtil;


//import java.util.Map;




public class CourseDAOImpl implements CourseDAO{
	private Connection conn = DBUtil.getSqliteConnection();
	private PreparedStatement stmt=null;
	private SQLException ex=null;
	

	@Override
	public void deleteCourses(String[] deletes) {
		// TODO Auto-generated method stub
		try{
			
				for(int i=0;i<deletes.length;i++){
					stmt=conn.prepareStatement("DELETE FROM Course WHERE courseNo=?");
					stmt.setString(1,deletes[i]);
					//stmt.setString(2, administrator.getPassword());
					stmt.executeUpdate();
				}
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
	}

	@Override
	public void addCourse(Course add1,String addPres) {
		// TODO Auto-generated method stub
		
		
		try{
			stmt=conn.prepareStatement("INSERT INTO Course(courseNo,courseName,credits,preCourseNos) VALUES(?,?,?,?)");
			stmt.setString(1, add1.getCourseNo());
			stmt.setString(2,add1.getCourseName());
			stmt.setDouble(3, add1.getCredits());
			stmt.setString(4, addPres);
			
			
			stmt.executeUpdate();
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		
		
		List<Course> courses=null;
		Course course=null;
		Course preCourse=null;
		try{
			
			stmt=conn.prepareStatement("SELECT courseNo,courseName,credits,preCourseNos FROM Course");
			/*stmt.setString(1, admin.getCname());
			stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			courses=new ArrayList<Course>();
			while(rs.next()){
				course=new Course(rs.getString("courseNo"),rs.getString("courseName"), Double.valueOf(rs.getString("credits")));
				if(rs.getString("preCourseNos")!=null){//是否有选修课
					String[] pres=rs.getString("preCourseNos").split(",");
					for(int i=0;i<pres.length;i++){
						   
							preCourse=new Course(pres[i],"", 0);
							course.addPrerequisite(preCourse);
						
				}	}
				courses.add(course);
			}
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
		return courses;
	}

	@Override
	public void updateCourses(Course ud, String changePres) {
		// TODO Auto-generated method stub
		try{                                                        
			
			stmt = conn.prepareStatement("update Course set courseName=?,credits=?,preCourseNos=? where courseNo=?");
			stmt.setString(1, ud.getCourseName());
			stmt.setDouble(2, ud.getCredits());
			stmt.setString(3, changePres);
			stmt.setString(4, ud.getCourseNo());
			
			stmt.executeUpdate();
		}catch(SQLException e){
			ex=e;
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
					if(ex==null){
						ex=e;
					}
				}
			}
		if(ex!=null){
			throw new RuntimeException(ex);
		}
		}
	}

	@Override
	public Course getCoursesByCourseNo(String courseNo) {
		// TODO Auto-generated method stub
		Course course=null;
		Course preCourse=null;
		try{
			
			stmt=conn.prepareStatement("SELECT courseName,credits,preCourseNos FROM Course where courseNo=?");
			stmt.setString(1, courseNo);
			/*stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()){
				course=new Course(courseNo,rs.getString("courseName"), Double.valueOf(rs.getString("credits")));
				if(rs.getString("preCourseNos")!=null){//是否有选修课
					String[] pres=rs.getString("preCourseNos").split(",");
					for(int i=0;i<pres.length;i++){
						while(rs.next()){    //遍历添加先修课
							preCourse=new Course(pres[i],"", 0);
							course.addPrerequisite(preCourse);
						}
				}	}
				
			}
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
		return course;
	}

	@Override
	public List<Course> getCoursesByCourseNo(ScheduleOfClasses scs) {
		// TODO Auto-generated method stub
		List<Course> courses=new ArrayList<Course>();
		Course course=null;
		//Course preCourse=null;
		try{
			for(String key : scs.getSectionsOffered().keySet()){
			stmt=conn.prepareStatement("SELECT courseNo,courseName,credits FROM Course where courseNo=?");
			stmt.setString(1, scs.getSectionsOffered().get(key).getRepresentedCourse().getCourseNo());
			/*stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()){
				course=new Course(rs.getString("courseNo"),rs.getString("courseName"), Double.valueOf(rs.getString("credits")));
				
				courses.add(course);
			}}
			}catch(SQLException e){
				ex=e;
			}finally{
				if(conn!=null){
					try{
						conn.close();
					}catch(SQLException e){
						if(ex==null){
							ex=e;
						}
					}
				}
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
		return courses;
	}
	
	
	
	
	
}
