package SRSDAO;

import java.util.List;

import model.Course;
import model.ScheduleOfClasses;

public interface CourseDAO {

	void updateCourses(Course ud, String changeCredits);

	void deleteCourses(String[] deletes);

	void addCourse(Course add1, String addPres);

	List<Course> getCourses();

	Course getCoursesByCourseNo(String courseNo);

	List<Course> getCoursesByCourseNo(ScheduleOfClasses scs);

}
