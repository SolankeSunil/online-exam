package com.ss.OnlieExame1;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.Service.ExameService;

@RestController
public class MyRestController {
	
	@Autowired
	ExameService service;
	
	@GetMapping("getRemeningTime")
	public int getRemeningTime(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int remeningTime=(Integer)session.getAttribute("remeningTime")-1;
		session.setAttribute("remeningTime", remeningTime);
		System.out.println(remeningTime);
		return remeningTime;
	}

	@GetMapping("getSubjects")
	public Set<String> getSubjects() {
		return service.getSubjects();

	}
	
}
