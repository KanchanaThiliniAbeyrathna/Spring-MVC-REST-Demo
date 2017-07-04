package db;

import java.util.List;
import model.Student;

public interface StudentService {
	
	public List<Student> getStudents();
	
	public boolean AddStudent(Student student);
}
