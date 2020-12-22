package com.luv2code.demo;

import java.util.List;

import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entity.Course;
import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;
import com.luv2code.entity.Review;
import com.luv2code.entity.Student;

public class CreateCourseAndReviewDemo {

public static void main(String[] args) {
		
		System.out.println("** Inside Main Class **");
		
		SessionFactory factory = new Configuration()
				.configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		System.out.println("** Reading student from the database**");
		
		 Course course = new Course("Python");
		 Review review1 = new Review("Needed for Machine Learning");
		 Review review2 = new Review("Needed for Automation");
		 
		 course.add(review1);
		 course.add(review2);
		 
		 session.persist(course);
		
		session.getTransaction().commit();
		
		System.out.println("** at the end **");

	}


}
