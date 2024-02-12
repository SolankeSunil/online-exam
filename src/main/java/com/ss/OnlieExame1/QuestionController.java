package com.ss.OnlieExame1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ss.Entity.Questions;
import com.ss.Service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	QuestionService service;

	@RequestMapping("getQuestion")
	public Questions getQuestion(int qno, String subject) {
		Questions	question=service.getQuestion(qno,subject);
		
		return question;
	}

	@RequestMapping("addquestion")
	public ModelAndView addQuestion(Questions q) {
		ModelAndView mv = new ModelAndView();
		String s = null;
		mv.setViewName("addquestion");
		int qno=service.getLatQno(q.getSubject(),q.getQuestion());
	    if(qno==-1) {
	    	mv.addObject("smg","question is alrady present");
	    }
	    else {
		q.setQno(qno+1);
		System.out.println(q);
		s = service.addQuestion(q);
		System.out.println(s);
		if (s != null) {
			mv.addObject("smg", s);

		} 
		else {
			mv.addObject("smg", "rewrite");
		}
	    }

		return mv;
	}
	
	
	
}
