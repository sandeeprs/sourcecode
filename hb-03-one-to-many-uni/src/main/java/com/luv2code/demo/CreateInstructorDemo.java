package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entity.Course;
import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;

public class CreateInstructorDemo {

public static void main(String[] args) {
		
		System.out.println("** Inside Main Class **");
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();		
		
		Instructor instructor = new Instructor("Sonali","gupta","gupta@sharma.com");
		InstructorDetail instructorDetail = new InstructorDetail("gupta@youtube.com","bill desk");
		  		
		//instructor.setInstructorDetail(instructorDetail);
		instructorDetail.setInstructor(instructor);
		
		try {
		session.beginTransaction();
		
		System.out.println("** Saving the Instructor **");
		
		//insert into the database
		session.persist(instructorDetail);
		
		session.getTransaction().commit();
		
		System.out.println("** at the end **");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			session.close();
			factory.close();
		}

	}


}
