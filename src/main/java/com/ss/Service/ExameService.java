package com.ss.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.Dao.ExameDao;
import com.ss.Entity.Questions;

@Service
public class ExameService {
	@Autowired
	ExameDao dao;

	public List<Questions> getList(String subject) {
          return dao.getList(subject);
	}
	public Set<String> getSubjects(){
		Set<String> set=new HashSet<>(dao.getSubjects());
		return set;
	}

}
