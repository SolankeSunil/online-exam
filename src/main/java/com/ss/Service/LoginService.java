package com.ss.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ss.Dao.LoginDao;
import com.ss.Entity.Users;

@Service
public class LoginService {
	@Autowired
	LoginDao dao;

	public String register(Users user) {
		user.setUsername( user.getLname());
		return dao.register(user);

	}

	public int  getUser(String username,String pass) {
		int  n=0;
		Users user = dao.getUser(username);
		if(user==null) {
			n=-1;
		}
		else if( user.getPassword().equals(pass)) {
			
			n=1;
		}
		return n;

	}

}
