package com.luv2code.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomGenerationStrategy implements IdentifierGenerator{

	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		Date date = Calendar.getInstance().getTime();
		
		String epochTime = String.valueOf(date.getTime());
		
		String StringId = epochTime.substring(6);
		int generatedId = Integer.parseInt(StringId);
		
		return generatedId;
	}
	
	

}
