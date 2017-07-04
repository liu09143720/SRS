package SRSDAO;


import java.util.HashMap;
import java.util.List;


import model.ScheduleOfClasses;

import model.Student;
import model.Transcript;
import model.TranscriptEntry;

public interface TranscriptDAO {

	List<TranscriptEntry> getStudentSsnfromTranscript(ScheduleOfClasses professorClass);

	Transcript getTranscript(String ssn);

	void deleteTranscript(String[] drops, String ssn);

	List<Integer> getTranscript(String ssn, ScheduleOfClasses scs);

	void addEnolledCourses(String ssn, int sectionNo, String courseName);

	HashMap<Integer, HashMap<String, Student>> getEnrolledStudents(String[] selects);

}
