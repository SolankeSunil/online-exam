package com.ss.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ss.Entity.Questions;

@Repository
public class ExameDao { 
	@Autowired
	SessionFactory factory;
  
	public List<Questions> getList(String subject) {

		Session session = factory.openSession();
		Query<Questions> query = session.createQuery("from Questions where subject=:subject");
		List<Questions> list = query.setParameter("subject", subject).list();

		return list;
	}
	
	public List<String> getSubjects(){
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(Questions.class);
		cr.setProjection(Projections.property("subject"));
		return cr.list();
	}
	

}
