package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entity.Student;

public class CreateStudentDemo {

public static void main(String[] args) {
		
		System.out.println("** Inside Main Class **");
		
		SessionFactory factory = new Configuration()
				.configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Student student1 = new Student("Sachin","Tendulkar","tendulkar@sharma.com");
		Student student2 = new Student("Rahul","Dravid","dravid@sharma.com");
		Student student3 = new Student("Mahendra","Singh Dhoni","dhoni@sharma.com");
		
		session.beginTransaction();
		
		System.out.println("** Saving the student **");
		
		//insert into the database
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		session.getTransaction().commit();
		
		System.out.println("** at the end **");

	}


}
