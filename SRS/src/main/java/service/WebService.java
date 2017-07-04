package service;


import java.util.HashMap;
import java.util.List;


import SRSDAO.*;
import model.Person;
import model.Professor;
import model.ScheduleOfClasses;

import model.Student;
import model.Transcript;
import model.TranscriptEntry;
import model.Course;

//import java.util.List;


public class WebService {
	private CourseDAO courseDAO=DataFactory.createCourseDAO();
	private ProfessorDAO professorDAO=DataFactory.createProfessorDAO();
	private SectionDAO sectionDAO=DataFactory.createSectionDAO();
	private StudentDAO studentDAO=DataFactory.createStudentDAO();
	private TranscriptDAO transcriptDAO=DataFactory.createTranscriptDAO();

	public Person signInProfessor(Person admin) {
		// TODO Auto-generated method stub
		return professorDAO.signInProfessor(admin);
	}
	
	public Person signInStudent(Person admin) {
		// TODO Auto-generated method stub
		return studentDAO.signInStudent(admin);
	}

	public ScheduleOfClasses getScheduleOfClasses(String semester) {
		// TODO Auto-generated method stub
		return sectionDAO.getScheduleofClasses(semester);
	}

	public List<Integer> getTranscript(String ssn, ScheduleOfClasses scs) {
		// TODO Auto-generated method stub
		return transcriptDAO.getTranscript(ssn,scs);
	}

	public void deleteTranscript(String[] drops, String ssn) {
		// TODO Auto-generated method stub
		transcriptDAO.deleteTranscript(drops,ssn);
	}

	public ScheduleOfClasses getScheduleOfClasses(String[] selects) {
		// TODO Auto-generated method stub
		return sectionDAO.getScheduleofClasses(selects);
	}

	public Student getStudent(String ssn) {
		// TODO Auto-generated method stub
		return studentDAO.getStudent(ssn);
	}

	public Transcript getTranscript(String ssn) {
		// TODO Auto-generated method stub
		return transcriptDAO.getTranscript(ssn);
	}

	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDAO.getCourses();
	}

	public List<Professor> getProfessors() {
		// TODO Auto-generated method stub
		return professorDAO.getProfessors();
	}

	public void addProfessor(Professor add1) {
		// TODO Auto-generated method stub
		professorDAO.addProfessor(add1);
	}

	public void addCourse(Course add1, String addPres) {
		// TODO Auto-generated method stub
		courseDAO.addCourse(add1,addPres);
	}

	public void deleteTeachers(String[] deletes) {
		// TODO Auto-generated method stub
		professorDAO.deleteTeachers(deletes);
	}

	public void deleteCourses(String[] deletes) {
		// TODO Auto-generated method stub
		courseDAO.deleteCourses(deletes);
	}

	public ScheduleOfClasses getProfessorScheduleOfClasses(String ssn) {
		// TODO Auto-generated method stub
		return sectionDAO.getProfessorScheduleOfClasses(ssn);
	}

	public List<TranscriptEntry> getStudentSsnfromTranscript(ScheduleOfClasses professorClass) {
		// TODO Auto-generated method stub
		return transcriptDAO.getStudentSsnfromTranscript(professorClass);
	}

	public void updateTeachers(Professor ud) {
		// TODO Auto-generated method stub
		professorDAO.updateTeachers(ud);
	}

	public void updateCourses(Course ud, String changeCredits) {
		// TODO Auto-generated method stub
		courseDAO.updateCourses(ud,changeCredits);
	}

	public Course getCoursesByCourseNo(String courseNo) {
		// TODO Auto-generated method stub
		return courseDAO.getCoursesByCourseNo(courseNo);
	}

	public void addEnolledCourses(String ssn, int sectionNo, String courseName) {
		// TODO Auto-generated method stub
		transcriptDAO.addEnolledCourses(ssn,sectionNo,courseName);
	}

	public List<Course> getCoursesForSection(ScheduleOfClasses scs) {
		// TODO Auto-generated method stub
		return courseDAO.getCoursesByCourseNo(scs);
	}

	public HashMap<Integer, HashMap<String, Student>> getEnrolledStudents(String[] selects) {
		// TODO Auto-generated method stub
		return transcriptDAO.getEnrolledStudents(selects);
	}

	public List<Student> getStudentsOfProfessor(List<TranscriptEntry> tstSsn) {
		// TODO Auto-generated method stub
		return studentDAO.getStudentsOfProfessor(tstSsn);
	}
	
    
}
