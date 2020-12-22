package com.luv2code.demo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;
import com.luv2code.entity.Student;

public class DeleteStudentDemo {

public static void main(String[] args) {
		
		System.out.println("** Inside Main Class **");
		
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		System.out.println("**Deleting Instructor from the database**");
		
		int id = 5837687;
		
		InstructorDetail inst = session.get(InstructorDetail.class, id);
		
		session.delete(inst);
			
		session.getTransaction().commit();
		
		System.out.println("** at the end **");

	}

public static int generateId() {
	
	Date date = Calendar.getInstance().getTime();
	String idTemp = String.valueOf(date.getTime());
	
	return Integer.parseInt(idTemp.substring(6)); 
}


}
