package model;

import java.time.LocalDate;

public class Registration {
   private int registrationNo;
   private LocalDate Registrationdate;
   private int courseId;
   private int rollNo;
   
   public Registration() {
	// TODO Auto-generated constructor stub
}

public Registration(LocalDate registrationdate, int courseId, int rollNo) {
	super();
	Registrationdate = registrationdate;
	this.courseId = courseId;
	this.rollNo = rollNo;
}

public LocalDate getRegistrationdate() {
	return Registrationdate;
}

public void setRegistrationdate(LocalDate registrationdate) {
	Registrationdate = registrationdate;
}

public int getRegistrationNo() {
	return registrationNo;
}

public int getCourseId() {
	return courseId;
}

public int getRollNo() {
	return rollNo;
}
	
}
   
