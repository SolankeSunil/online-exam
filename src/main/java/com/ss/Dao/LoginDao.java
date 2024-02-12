package com.ss.Dao;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ss.Entity.Users;

@Repository
public class LoginDao {

	@Autowired
	SessionFactory factory;

	public String register(Users user) {
		Session session = factory.openSession();
		session.save(user);
		session.beginTransaction().commit();
		session.close();
		return "registration successfully...";
	}

	public Users getUser(String username) {
		Users user = null;
		Session session = factory.openSession();
		user = session.get(Users.class, username);
		System.out.println(user);
		session.close();
		return user;
	}

}
