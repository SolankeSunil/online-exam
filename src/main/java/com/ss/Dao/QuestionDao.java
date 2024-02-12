package com.ss.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ss.Entity.Questions;

@Repository
public class QuestionDao {

	@Autowired
	SessionFactory factory;

	public String addQuestion(Questions q) {
		Session session = factory.openSession();
		String s = null;
		try {
			session.save(q);
			session.beginTransaction().commit();
			s = "question added successfully...";
		} catch (Exception e) {
			e.printStackTrace();
			s = "question can't added";
		} finally {
			session.close();
		}
		return s;
	}
	
	public List<Questions>  getLatQno(String subject) {
		Session session = factory.openSession();
		
		Query query = session.createQuery("from Questions where subject=:subject");
		query.setParameter("subject", subject);
		List<Questions> list=query.list();
		session.close();
		return list;
	}
	public Questions getQuestion(int qno, String subject) {
		Session session = factory.openSession();
		Query query = session.createQuery("from Questions where subject=:subject & qno=:qno");
		query.setParameter("qno", qno);
	    query.setParameter("subject", subject);
	   Questions question= (Questions)query.list().get(0);
		return question;
	} 
}
