package com.itshidu.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.web.entity.User;
import com.itshidu.web.service.RegisterService;

@Controller
public class PublicController {
	@Autowired
	private RegisterService registerService;
	@RequestMapping("register.html")
	public Object register(ModelAndView mv){
		mv.setViewName("register");
		return mv;
	}
	@RequestMapping("/public/register")
	@ResponseBody
	public Object register(User user){
		Map<String, Object> result=registerService.register(user);
		return result;
	}
	@RequestMapping("/public/login")
	@ResponseBody
	public Object login(String username,String password){
		return registerService.login(username,password);
	}
	@RequestMapping("/public/logout")
	public Object logout(HttpServletRequest request){
		//request.getSession().removeAttribute("loginInfo");
		//设置过期时间为1秒
		//request.getSession().setMaxInactiveInterval(1);
		request.getSession().invalidate();
		return "redirect:/login.html";
	}
}
