package SRSDAO;


import model.ScheduleOfClasses;


public interface SectionDAO {

	ScheduleOfClasses getScheduleofClasses(String[] selects);

	ScheduleOfClasses getScheduleofClasses(String semester);


	ScheduleOfClasses getProfessorScheduleOfClasses(String ssn);

}
