package SRSDAO;

public class DataFactory {
	private static String daoName = "sqliteDAOImpl";

	
	
	public static CourseDAO createCourseDAO() {
		CourseDAO result = null;
		try {
			Object o = Class.forName(daoName + "." + "CourseDAOImpl").newInstance();
			result = (CourseDAO)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static ProfessorDAO createProfessorDAO() {
		ProfessorDAO result = null;
		try {
			Object o = Class.forName(daoName + "." + "ProfessorDAOImpl").newInstance();
			result = (ProfessorDAO)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static SectionDAO createSectionDAO() {
		SectionDAO result = null;
		try {
			Object o = Class.forName(daoName + "." + "SectionDAOImpl").newInstance();
			result = (SectionDAO)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static StudentDAO createStudentDAO() {
		StudentDAO result = null;
		try {
			Object o = Class.forName(daoName + "." + "StudentDAOImpl").newInstance();
			result = (StudentDAO)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static TranscriptDAO createTranscriptDAO() {
		TranscriptDAO result = null;
		try {
			Object o = Class.forName(daoName + "." + "TranscriptDAOImpl").newInstance();
			result = (TranscriptDAO)o;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
