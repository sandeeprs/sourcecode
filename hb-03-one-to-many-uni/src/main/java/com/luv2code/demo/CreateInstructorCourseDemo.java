package com.luv2code.demo;

import java.util.List;

import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entity.Course;
import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;
import com.luv2code.entity.Student;

public class CreateInstructorCourseDemo {

public static void main(String[] args) {
		
		System.out.println("** Inside Main Class **");
		
		SessionFactory factory = new Configuration()
				.configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		System.out.println("** Reading student from the database**");
		
		 Query query = session.createQuery("from Instructor");
		 System.out.println("** querying from the database**");
		 List<Instructor> instructorList = query.getResultList();
		 System.out.println("** looping from the database**");
		 
		 for(Instructor temp : instructorList) {
			System.out.println("****"+temp.getInstructorDetail());
		}
		
		session.getTransaction().commit();
		
		System.out.println("** at the end **");

	}


}
