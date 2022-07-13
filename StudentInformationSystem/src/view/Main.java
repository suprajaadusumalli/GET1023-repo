package view;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import dao.StudentDao;
import dao.StudentDaoImplInMemory;
import model.Course;
import model.Qualification;
import model.Student;

public class Main {
 
	public static void main(String[] args) {
		//Student student=new Student();
		StudentDao dao=new StudentDaoImplInMemory();
	
		Student student1=new Student("sup",LocalDate.of(2001,8, 6),Qualification.Graduate,"9381416341","sup@lti.com","mumbai");
		Student student2=new Student("water",LocalDate.of(2001,7, 6),Qualification.Graduate,"8378416341","water@lti.com","mumbai");
		Student student3=new Student("John",LocalDate.of(2001,9, 6),Qualification.Intermediate,"9381436341","john@lti.com","hyderabad");
		dao.addNewStudent(student1);
		dao.addNewStudent(student2);
		dao.addNewStudent(student3);
		
		Course course1=new Course("java",6,4000,Qualification.Graduate);
		Course course2=new Course("python",3,2000,Qualification.Master);
		Course course3=new Course("azure",8,8000,Qualification.Graduate);
		dao.addNewCourse(course1);
		dao.addNewCourse(course2);
		dao.addNewCourse(course3);
		
		List<Course> courses=dao.viewAllCourses();
		Iterator<Course> iteratorcourse=courses.iterator();
		while(iteratorcourse.hasNext()) {
			Course course=iteratorcourse.next();
			System.out.println(course.getCourseId()+" "+course.getCourseName()+" "+course.getDurationInMonths()+" "+course.getFee());
		}
		
		
		List<Student> students=dao.viewAllStudents();
		Iterator<Student> iterator=students.iterator();
		while(iterator.hasNext()) {
			Student student=iterator.next();
			System.out.println(student.getRollNo()+" "+student.getName()+" "+student.getEmail());
		}
		/*
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter rollNo:");
		int rollNo=scanner.nextInt();
		
		Student student=dao.findStudentByRollNo(rollNo);
		if(student!=null) {
			System.out.println(student.getRollNo()+" "+student.getName()+" "+student.getEmail());
		}
		else {
			System.out.println("Student not found");
		}
		
		System.out.println("Enter rolNo:");
		int rollNo=scanner.nextInt();
		Student student=dao.findStudentByRollNo(rollNo);
		if(student!=null) {
			System.out.println("Enter phone no:");
			String phoneNo=scanner.next();
			student.setPhoneNo(phoneNo);
			dao.updateStudentProfile(student);
		}else {
			System.out.println("Student not found");
		}
		students=dao.viewAllStudents();
		iterator=students.iterator();
		while(iterator.hasNext()) {
			student=iterator.next();
			System.out.println(student.getRollNo()+" "+student.getName()+" "+student.getEmail()+" "+student.getPhoneNo());
		}
		*/
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter student rollNo and course applying for");
		int rollNo=scanner.nextInt();
		int courseId=scanner.nextInt();
		
		Student stud1=dao.findStudentByRollNo(rollNo);
		Course c1=dao.findCourseById(courseId);
		
		if(stud1!=null) {
			if(c1!=null) {
				dao.registration(stud1, c1);
				System.out.println("Registration successful");
			}
			else {
				System.out.println("Course not found");
			}
		}else {
			System.out.println("Student not found");
		}
		System.out.println("View All registrations:");
		
		Map<Student,Course> registrations=dao.viewAllRegistrations();
		Set<Map.Entry<Student,Course>> regs=registrations.entrySet();
		for(Map.Entry<Student,Course> r:regs) {
		Student s=r.getKey();
		Course c=r.getValue();
		System.out.println(s.getRollNo()+" "+s.getName()+" "+c.getCourseId()+" "+c.getCourseName());
	}
	}
}
