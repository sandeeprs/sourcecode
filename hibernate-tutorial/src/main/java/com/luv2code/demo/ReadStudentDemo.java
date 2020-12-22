package com.luv2code.demo;

import java.util.List;

import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entity.Student;

public class ReadStudentDemo {

public static void main(String[] args) {
		
		System.out.println("** Inside Main Class **");
		
		Student student = new Student();
		
		SessionFactory factory = new Configuration()
				.configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		System.out.println("** Reading student from the database**");
		
		Query query = session.createQuery("from Student s where s.firstName in (:name,:name2) or s.lastName like '%Dhoni%'");
		query.setParameter("name", "Amala");
		query.setParameter("name2", "sandeep");
		
		List<Student> list = query.getResultList();
		
		for(Student temp : list) {
			System.out.println("** Student  **"+temp.toString());
		}
		
		//Student resultStudent = (Student) list.get(0);
		
		
		
		session.getTransaction().commit();
		
		System.out.println("** at the end **");

	}


}
