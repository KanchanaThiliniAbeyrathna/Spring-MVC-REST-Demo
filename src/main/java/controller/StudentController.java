package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import db.StudentServiceImpl;
import model.Student;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentServiceImpl service;

	// get all students
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAll() {

		List<Student> students = service.getStudents();

		if (students.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	// add a student
	@RequestMapping(value = "new", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> AddStudent(@RequestBody Student student) {

		if (service.AddStudent(student)) {
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
