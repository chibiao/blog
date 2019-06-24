package com.itshidu.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.web.entity.User;

@Controller
@RequestMapping("/home")
public class HomeController {
	@RequestMapping(value = { "/", "", "index" })
	public Object index(HttpServletRequest request) {
		// 如果未登录，跳转到登录页面
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginInfo");
		if (user == null) {
			return "redirect:/login.html";
		}
		ModelAndView mv = new ModelAndView("/home/index");
		return mv;
	}

}
