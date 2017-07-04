package SRSDAO;

import java.util.List;

import model.Person;
import model.Student;
import model.TranscriptEntry;

public interface StudentDAO {

	Student getStudent(String ssn);

	Person signInStudent(Person admin);

	List<Student> getStudentsOfProfessor(List<TranscriptEntry> tstSsn);
}
