package sqliteDAOImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import SRSDAO.TranscriptDAO;

import model.ScheduleOfClasses;
import model.Section;
import model.Student;
import model.Transcript;
import model.TranscriptEntry;
import util.DBUtil;



public class TranscriptDAOImpl implements TranscriptDAO{
	private Connection conn = DBUtil.getSqliteConnection();
	private PreparedStatement stmt=null;
	private SQLException ex=null;
	public static Connection conn2 = DBUtil.getSqliteConnection();
	
	@Override
	public List<TranscriptEntry>  getStudentSsnfromTranscript(ScheduleOfClasses professorClass) {
		// TODO Auto-generated method stub
		List<TranscriptEntry> tstSsn=new ArrayList<TranscriptEntry>();
		TranscriptEntry ssnTranscript=new TranscriptEntry();
		
		try{
			for (Section s : professorClass.getSectionsOffered().values()) {
			stmt=conn.prepareStatement("SELECT studentNo,courseName FROM Transcript where sectionNo=?");
			stmt.setInt(1, s.getSectionNo());
			/*stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			//ssnTranscript=new ArrayList<String>();
			while(rs.next()){
				//tra.getStudent().setName(n);; TranscriptEntry(rs.getString("ssn"),rs.getString("name"),"", rs.getString("department"));
				ssnTranscript.setCourseName(rs.getString("courseName"));
				ssnTranscript.getStudent().setSsn(rs.getString("studentNo"));
				tstSsn.add(ssnTranscript);
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
		return tstSsn;
	}

	@Override
	public Transcript getTranscript(String ssn) {
		// TODO Auto-generated method stub
		Transcript transcript=new Transcript();
		TranscriptEntry transcriptEntry=null;
		
		try{
			
			stmt=conn.prepareStatement("SELECT sectionNo,grade,courseName FROM Transcript where studentNo=?");
			stmt.setString(1, ssn);
			/*stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			//ssnTranscript=new ArrayList<String>();
			while(rs.next()){
				transcriptEntry=new TranscriptEntry();
				transcriptEntry.setCourseName(rs.getString("courseName"));
				transcriptEntry.setGrade(rs.getString("grade"));
				transcriptEntry.getSection().setSectionNo(rs.getInt("sectionNo"));
				//transcriptEntry.getStudent().setSsn(ssn);
				transcript.addTranscriptEntry(transcriptEntry);
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
		return transcript;
	}

	@Override
	public void deleteTranscript(String[] drops,String ssn) {
		// TODO Auto-generated method stub
		try{
			
			for(int i=0;i<drops.length;i++){
				stmt=conn.prepareStatement("DELETE FROM Transcript WHERE sectionNo=? and studentNo=?");
				stmt.setString(1,drops[i]);
				stmt.setString(2, ssn);
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
	public List<Integer> getTranscript(String ssn, ScheduleOfClasses scs) {
		// TODO Auto-generated method stub
		List<Integer> pros=new ArrayList<Integer>();
		
		
		try{
			for(String key : scs.getSectionsOffered().keySet()){
			stmt=conn.prepareStatement("SELECT sectionNo FROM Transcript where sectionNo=? and studentNo=?");
			stmt.setInt(1, scs.getSectionsOffered().get(key).getSectionNo());
			stmt.setString(2, ssn);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				//pro=new Professor(rs.getString("ssn"),rs.getString("name"),"", rs.getString("department"));
				
				pros.add(rs.getInt("sectionNo"));
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
		return pros;
	}

	@Override
	public void addEnolledCourses(String ssn, int sectionNo, String courseName) {
		// TODO Auto-generated method stub
		
		
		try{
			stmt=conn2.prepareStatement("INSERT INTO Transcript(studentNo,sectionNo,courseName) VALUES(?,?,?)");
			stmt.setString(1, ssn);
			stmt.setInt(2,sectionNo);
			stmt.setString(3, courseName);
			
			
			
			stmt.executeUpdate();
			}catch(SQLException e){
				ex=e;
			}finally{
				
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
	}

	@Override
	public HashMap<Integer, HashMap<String, Student>> getEnrolledStudents(String[] selects) {
		// TODO Auto-generated method stub
		HashMap<Integer, HashMap<String, Student>> AllSectionsEnrolledStudents=null;
		HashMap<String, Student> enrolledStudents=null;
		Student student=new Student(0,"","");
		enrolledStudents=new HashMap<String, Student>();
		AllSectionsEnrolledStudents=new HashMap<Integer, HashMap<String, Student>>();
		try{
			for(int i=0;i<selects.length;i++){
			stmt=conn2.prepareStatement("SELECT studentNo FROM Transcript where sectionNo=?");
			stmt.setInt(1, Integer.parseInt(selects[i]));
			/*stmt.setString(2, admin.getCplace());*/
			ResultSet rs=stmt.executeQuery();
			
				while(rs.next()){
					student.setSsn(rs.getString("studentNo"));
					enrolledStudents.put(rs.getString("studentNo"),student);				
				}
				
				//enrolledStudents.put(Integer.parseInt(selects[i]),student);
				AllSectionsEnrolledStudents.put(Integer.parseInt(selects[i]), enrolledStudents);
			}
			}catch(SQLException e){
				ex=e;
			}finally{
				
			if(ex!=null){
				throw new RuntimeException(ex);
			}
			}
		return AllSectionsEnrolledStudents;
	}
	
	
	
	
	
}
