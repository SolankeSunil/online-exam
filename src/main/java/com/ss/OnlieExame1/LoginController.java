package com.ss.OnlieExame1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ss.Entity.Users;
import com.ss.Service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService service;

	@RequestMapping("register")
	public ModelAndView register(Users user) {
		ModelAndView mv = new ModelAndView();
		String pass = user.getPassword();
		String pass1 = user.getPassword1();

		System.out.println(user);
		if (!pass.equals(pass1)) {
			mv.addObject("msg", "please currect password");
			mv.setViewName("register");
		} else {
			service.register(user);
			mv.setViewName("login");
			mv.addObject("smg", "Now login");
		}

		return mv;
	}

	@RequestMapping("/")
	public String showlogin() {

		return "login";
	}

	@RequestMapping("showregister")
	public String showregister() {

		return "register";
	}

	@RequestMapping("login")
	public ModelAndView userLogin(String username, String password,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		int n = service.getUser(username,password);
		if (username.equals("admin") && password.equals("admin123")) {
			mv.setViewName("addquestion");

		} else if (n == -1) {
			mv.addObject("error", "wrong username");
			mv.setViewName("login");
		} else if (n == 0) {
			mv.addObject("error", "wrong password");
			mv.setViewName("login");
		}
		else if(n==1 ) {
			mv.setViewName("wellcome");
			mv.addObject("msg","welcome "+username);
			HttpSession session = request.getSession();
			session.setAttribute("username",username );
			session.setAttribute("password",password );
		}
		return mv;
	}

}
