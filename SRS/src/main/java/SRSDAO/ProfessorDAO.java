package SRSDAO;

import java.util.List;

import model.Person;
import model.Professor;

public interface ProfessorDAO {

	void updateTeachers(Professor ud);

	void deleteTeachers(String[] deletes);

	void addProfessor(Professor add1);

	List<Professor> getProfessors();

	Person signInProfessor(Person admin);

}
