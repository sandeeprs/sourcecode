package com.luv2code.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.entity.Course;
import com.luv2code.entity.Instructor;
import com.luv2code.entity.InstructorDetail;
import com.luv2code.entity.Review;
import com.luv2code.entity.Student;

public class DeleteCourseAndReviewDemo {

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
		
		int theId=10;
		
		Course c = session.get(Course.class, theId);
		
		System.out.println("Course :"+c);
		
		System.out.println("Reviews are :"+c.getReviews());
		
		session.delete(c);
		
		session.getTransaction().commit();
		
		System.out.println("** at the end **");

	}


}
