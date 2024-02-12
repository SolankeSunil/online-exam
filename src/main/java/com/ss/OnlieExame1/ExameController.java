package com.ss.OnlieExame1;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ss.Entity.Answers;
import com.ss.Entity.Questions;
import com.ss.Service.ExameService;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Controller
public class ExameController {

	@Autowired
	ExameService service;

	@RequestMapping("startexame")
	public ModelAndView startExame(HttpServletRequest request, String subject) {

		ModelAndView mv = new ModelAndView();

		List<Questions> list = service.getList(subject);

		HttpSession session = request.getSession();
		session.setAttribute("qno", 0);
		session.setAttribute("questionList", list);
		session.setAttribute("answerList", new HashMap<Integer, Answers>());
		session.setAttribute("remeningTime", 121);

		mv.addObject("question", list.get(0));
		mv.setViewName("question");
		return mv;

	}

	@RequestMapping("next")
	public ModelAndView next(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		List<Questions> list = (List) session.getAttribute("questionList");

//		System.out.println(list);
		mv.setViewName("question");
		int qno = (int) session.getAttribute("qno");
		if (qno < list.size() - 1) {
			session.setAttribute("qno", qno + 1);
			Questions question = list.get((int) session.getAttribute("qno"));
			request.setAttribute("question", question);
			String priviousAnswer = "";
			HashMap<Integer, Answers> map = (HashMap) session.getAttribute("answerList");
//			System.out.println(map);
			Answers answer = map.get(question.getQno());
//			System.out.println(answer);
			if (answer != null) {
				priviousAnswer = answer.getYourAnswer();
				mv.addObject("priviousAnswer", priviousAnswer);
			}
//			System.out.println(priviousAnswer);

		} else {
			request.setAttribute("error", "question is end");
			request.setAttribute("question", list.get(qno));
		}

		return mv;
	}

	@RequestMapping("previous")
	public ModelAndView previous(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		List<Questions> list = (List) session.getAttribute("questionList");
		int qno = (Integer) session.getAttribute("qno");
		if (qno > 0) {
			session.setAttribute("qno", qno - 1);
			Questions question = list.get((Integer) session.getAttribute("qno"));

			mv.addObject("question", question);

			HashMap<Integer, Answers> answerList = (HashMap) session.getAttribute("answerList");
			Answers answer = answerList.get(question.getQno());
			String pirviousAnswer = "";
			if (answer != null) {
				pirviousAnswer = answer.getYourAnswer();
				session.setAttribute("priviousAnswer", pirviousAnswer);
			}
		} else {
			mv.addObject("question", list.get(qno));
		}

		mv.setViewName("question");

		return mv;
	}

	@RequestMapping("saveResponse")
	public void saveResponse(Answers answer, HttpServletRequest request) {

		HttpSession session = request.getSession();
		List<Questions> list = (List) session.getAttribute("questionList");

		for (Questions question : list) {
			if (answer.getQno() == question.getQno()) {
				answer.setCurrectAnswer(question.getAnswer());
				break;
			}
		}
		HashMap<Integer, Answers> answerList = (HashMap<Integer, Answers>) session.getAttribute("answerList");
		answerList.put(answer.getQno(), answer);
//		System.out.println(answerList);
		session.setAttribute("answerList", answerList);

	}

	@RequestMapping("endeexame")
	public ModelAndView endExame(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("score");
		HttpSession session = request.getSession();
		HashMap<Integer, Answers> answerList = (HashMap<Integer, Answers>) session.getAttribute("answerList");
		Collection<Answers> answers = answerList.values();
		int score = 0;
		for (Answers a : answers) {
			if (a.getCurrectAnswer().equals(a.getYourAnswer())) {
				score++;
			}
		}

		mv.addObject("score", score);
		mv.addObject("username", session.getAttribute("username"));
		mv.addObject("password", session.getAttribute("password"));
		mv.addObject("answerList", answers);

		return mv;
	}

	@RequestMapping("logOut")
	public ModelAndView logOut(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		request.getSession().invalidate();
		return mv;
	}

}
