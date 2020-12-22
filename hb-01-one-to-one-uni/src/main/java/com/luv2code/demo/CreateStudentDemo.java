package com.luv2code.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;

public class CreateStudentDemo {

public static void main(String[] args) {
		
		System.out.println("** Inside Main Class **");
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Instructor.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		/*
		 * Instructor instructor = new
		 * Instructor("Sandeep","Sharma","sharma@sharma.com"); InstructorDetail
		 * instructorDetail = new InstructorDetail("sharma@youtube.com","BodyBuilding");
		 */
		
		
		Instructor instructor = new Instructor("Rohit","Sharma","rohit@sharma.com");
		InstructorDetail instructorDetail = new InstructorDetail("RoHit@youtube.com","Hitting Big Hundreds");
		  		
		instructor.setInstructorDetail(instructorDetail);
		  //instructorDetail.setInstructor(instructor);
		
		session.beginTransaction();
		
		System.out.println("** Saving the Instructor **");
		
		//insert into the database
		session.persist(instructor);
		/*
		 * session.persist(instructor2); session.persist(instructor3);
		 * session.persist(instructor4); session.persist(instructor5);
		 */
		
		session.getTransaction().commit();
		
		System.out.println("** at the end **");

	}


}
