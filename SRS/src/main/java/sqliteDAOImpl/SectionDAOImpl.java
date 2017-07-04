package sqliteDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import SRSDAO.SectionDAO;
import model.ScheduleOfClasses;
import model.Section;
import util.DBUtil;



public class SectionDAOImpl implements SectionDAO{
	private Connection conn = DBUtil.getSqliteConnection();
	private PreparedStatement stmt=null;
	private SQLException ex=null;
	
	@Override
	public ScheduleOfClasses getScheduleofClasses(String[] selects) {
		// TODO Auto-generated method stub
		ScheduleOfClasses ssnTranscript=new ScheduleOfClasses();
		Section section=new Section();
		try{
			for(int i=0;i<selects.length;i++){
			stmt=conn.prepareStatement("SELECT courseNo,semester,dayOfWeek,timeOfDay,room,seatingCapacity,professorNo FROM Section where sectionNo=?");
			stmt.setString(1, selects[i]);
			/*stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			//ssnTranscript=new ArrayList<String>();
			while(rs.next()){
				//tra.getStudent().setName(n);; TranscriptEntry(rs.getString("ssn"),rs.getString("name"),"", rs.getString("department"));
				section.getRepresentedCourse().setCourseNo(rs.getString("courseNo"));
				section.setDayOfWeek(rs.getString("dayOfWeek"));
				section.getInstructor().setSsn(rs.getString("professorNo"));
				section.setRoom(rs.getString("room"));
				section.setSeatingCapacity(rs.getInt("seatingCapacity"));
				section.setSectionNo(Integer.parseInt(selects[i]));
				section.setTimeOfDay(rs.getString("timeOfDay"));
				section.setSemester(rs.getString("semester"));
				ssnTranscript.addSection(section);
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
		return ssnTranscript;
	}

	@Override
	public ScheduleOfClasses getScheduleofClasses(String semester) {
		// TODO Auto-generated method stub
		ScheduleOfClasses ssnTranscript=new ScheduleOfClasses();
		Section section=new Section();
		try{
			
			stmt=conn.prepareStatement("SELECT courseNo,sectionNo,dayOfWeek,timeOfDay,room,seatingCapacity,professorNo FROM Section where semester=?");
			stmt.setString(1, semester);
			/*stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			//ssnTranscript=new ArrayList<String>();
			while(rs.next()){
				section=new Section();
				section.getRepresentedCourse().setCourseNo(rs.getString("courseNo"));
				section.setDayOfWeek(rs.getString("dayOfWeek"));
				section.getInstructor().setSsn(rs.getString("professorNo"));
				section.setRoom(rs.getString("room"));
				section.setSeatingCapacity(rs.getInt("seatingCapacity"));
				section.setSectionNo(rs.getInt("sectionNo"));
				section.setTimeOfDay(rs.getString("timeOfDay"));
				section.setSemester(semester);
				ssnTranscript.addSection(section);
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
		return ssnTranscript;
	}

	@Override
	public ScheduleOfClasses getProfessorScheduleOfClasses(String ssn) {
		// TODO Auto-generated method stub
		ScheduleOfClasses ssnTranscript=new ScheduleOfClasses();
		Section section=null;
		try{
			
			stmt=conn.prepareStatement("SELECT courseNo,sectionNo,dayOfWeek,timeOfDay,room,seatingCapacity,semester FROM Section where professorNo=?");
			stmt.setString(1, ssn);
			/*stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			//ssnTranscript=new ArrayList<String>();
			while(rs.next()){
				section=new Section();
				section.getRepresentedCourse().setCourseNo(rs.getString("courseNo"));
				section.setDayOfWeek(rs.getString("dayOfWeek"));
				section.setSemester(rs.getString("semester"));
				section.setRoom(rs.getString("room"));
				section.setSeatingCapacity(rs.getInt("seatingCapacity"));
				section.getInstructor().setSsn(ssn);
				section.setSectionNo(rs.getInt("sectionNo"));
				section.setTimeOfDay(rs.getString("timeOfDay"));
				ssnTranscript.addSection(section);
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
		return ssnTranscript;
	}
	
	
	
	
	
}
