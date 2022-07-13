package controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dao.StudentDao;
import dao.StudentDaoImplDatabase;
import exception.PhoneException;
import model.Course;
import model.Student;

public class StudentController {
	StudentDao dao=new StudentDaoImplDatabase();
	public String addNewStudent(Student student) {
		
  if(student.getPhoneNo().length()!=10) {
	  try {
		  throw new PhoneException("Invalid phone number");
	  } catch(PhoneException e) {
		  return e.getMessage();
	  }
  }
  dao.addNewStudent(student);
  return "New student added successfully";
	}
	public void updateStudentProfile(Student student) {
		

	}

	public void registration(Student student, Course course) {
		

	}
	public Map<Student, Course> viewAllRegistrations() {
		
		return null;
	}

	public Student findStudentByRollNo(int rollNo) {
		return dao.findStudentByRollNo(rollNo);
	}

	public List<Student> viewAllStudents() {
		
		return dao.viewAllStudents();
	}

	public String addNewCourse(Course course) {
		 return dao.addNewCourse(course);
	}

	public Course findCourseById(int courseId) {
	
		return null;
	}

	public List<Course> viewAllCourses() {
		
		return null;
	}
}
