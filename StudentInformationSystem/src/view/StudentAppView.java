package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import controller.StudentController;
import model.Course;
import model.Qualification;
import model.Student;

public class StudentAppView {
   public static void main(String[] args) {
	   StudentController controller=new StudentController();
	   Scanner sc=new Scanner(System.in);
	   while(true) {
	   System.out.println(" 1. Student \n 2. Admin\n 3.Exit");
	   int userType=sc.nextInt();
	   if(userType==1) {
		   String choice="y";
		   do {
			   System.out.println(" 1. Sign Up\n 2. Update phone number \n 3. View all courses"
			   		+ "\n 4. Register for a course \n 5. Sign out");
			   int option=sc.nextInt();
			   switch(option) {
			   case 1:
				   System.out.println("Enter name,dob,phone no, email and address:");
				   String name=sc.next();
				   String dateOfBirth= sc.next();
				   DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
				   LocalDate dob=LocalDate.parse(dateOfBirth,formatter);
				   
			   String phoneNumber=sc.next();
			   String email=sc.next();
			   String address=sc.next();
			   System.out.println("1. Master 2.Graduate 3.Intermediate 4. Matric");
			   int q=sc.nextInt();
			   Qualification qualification=null;
			   if(q==1) qualification=Qualification.Master;
			   else if(q==2) qualification=Qualification.Graduate;
			   else if(q==3) qualification=Qualification.Intermediate;
			   else if(q==4) qualification=Qualification.Matric;
			   
			   Student student=new Student(name,dob,qualification,phoneNumber,email,address);
			   String message=controller.addNewStudent(student);
			   System.out.println(message);
			   }
			   System.out.println("Continue?(y/n)");
			   choice=sc.next();
		   }while(choice.equalsIgnoreCase("y"));
	   }else if(userType==2) {
		   System.out.println(" 1.View All Users\n 2. Find Student");
		   int option =sc.nextInt();
		   switch(option) {
		   case 1:
			   List<Student> students =controller.viewAllStudents();
			   Iterator<Student> iterator=students.iterator();
			   while(iterator.hasNext()) {
				   Student st=iterator.next();
				   System.out.println(st.getRollNo()+" "+st.getName()+" "+st.getQualification());
			   }
			   break;
		   case 2:
			   System.out.println("Enter rollNo:");
			   int rollNo=sc.nextInt();
			   Student st= controller.findStudentByRollNo(rollNo);
			   if(st!=null) {
				   System.out.println(st.getRollNo()+" "+st.getName()+" "+st.getQualification());
			   }
			   else {
				   System.out.println("Roll no not found");
			   }
		   case 3:
			   System.out.println("Enter course name,duration,fee");
			   String courseName=sc.next();
			   int duration=sc.nextInt();
			   double fee=sc.nextDouble();
			   Qualification eligibility=null;
			   System.out.println("1. Master 2.Graduate 3.Intermediate 4. Matric");
			   int q=sc.nextInt();
			   if(q==1) eligibility=Qualification.Master;
			   else if(q==2) eligibility=Qualification.Graduate;
			   else if(q==3) eligibility=Qualification.Intermediate;
			   else if(q==4) eligibility=Qualification.Matric;
			   Course course=new Course(courseName,duration,fee,eligibility);
			   String message=controller.addNewCourse(course);
			   System.out.println(message);
			   break;
		   }
	   }else {
		   //System.out.println("Invalid choice");
		   System.exit(0);
	   }
   }
   }
}
