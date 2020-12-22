package com.luv2code.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entity.Course;
import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;
import com.luv2code.entity.Student;

public class ReadInstructorDetailDemo {

public static void main(String[] args) {
		
		System.out.println("** Inside Main Class **");
		
		SessionFactory factory = new Configuration()
				.configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		System.out.println("** Creating/Inerting into the database**");
		
		Instructor instructorForCourse = new Instructor("Hardik","Pandya","pandya@sharma.com");
		
		Course course1 = new Course("Smashing Batsman");
		Course course2 = new Course("Handy Bowler");
		Course course3 = new Course("Super Lightning Fielder");
		
		instructorForCourse.add(course1);
		instructorForCourse.add(course2);
		instructorForCourse.add(course3);
		
		
		
		//course.setInstructorCourse(instructorForCourse);
		
		session.persist(instructorForCourse);
		
		System.out.println("** Exiting into the database**");
		
		session.getTransaction().commit();
		
		System.out.println("** at the end **");

	}


}
