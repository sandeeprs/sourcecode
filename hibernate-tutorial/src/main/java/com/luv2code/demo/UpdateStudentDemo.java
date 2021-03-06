package com.luv2code.demo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entity.Student;

public class UpdateStudentDemo {

public static void main(String[] args) {
		
		System.out.println("** Inside Main Class **");
		
		Student student = new Student();
		
		SessionFactory factory = new Configuration()
				.configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		System.out.println("** Reading student from the database**");
		
		Query query = session.createQuery("update Student set id=:id where firstName = 'sonali'");
		query.setParameter("id", generateId());
		
		int returnIndex = query.executeUpdate();
		
		if(returnIndex >= 1)
			System.out.println("** Updation done successfully  **");
		else
			System.out.println("** Updation unsuccessful  **");
			
		session.getTransaction().commit();
		
		System.out.println("** at the end **");

	}

public static int generateId() {
	
	Date date = Calendar.getInstance().getTime();
	String idTemp = String.valueOf(date.getTime());
	
	return Integer.parseInt(idTemp.substring(6)); 
}


}
