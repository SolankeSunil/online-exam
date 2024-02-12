package com.ss.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ss.Dao.QuestionDao;
import com.ss.Entity.Questions;

import java.util.List;

@Service
public class QuestionService {
	@Autowired
	QuestionDao dao;

	public String addQuestion(Questions q) {
		return dao.addQuestion(q);
	}
	public int  getLatQno(String subject,String question) {
		List<Questions> list=dao.getLatQno(subject);
		int qno=list.size();
		for(Questions q:list) {
			if(q.getQuestion().equals(question)) {
				qno=-1;
				break;
			}
		}
		return qno;
	}
	
	public Questions getQuestion(int qno, String subject) {
		Questions quen=dao.getQuestion(qno,subject);
		return quen;
	}
}
