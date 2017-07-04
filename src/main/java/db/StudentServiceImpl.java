package db;

import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentServiceImpl implements StudentService{
	
	private ArrayList<Student> students;
	
	public StudentServiceImpl() {
		students = new ArrayList<Student>();
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public boolean AddStudent(Student student) {
		this.students.add(student);
		return true;
	}

}
