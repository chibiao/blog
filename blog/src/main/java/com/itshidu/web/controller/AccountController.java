package com.itshidu.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itshidu.web.entity.User;
import com.itshidu.web.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	/**
	 * 登录
	 * @param name
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public Object index(@PathVariable String name, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginInfo");
		if (user == null) {
			return "redirect:/login.html";
		}
		ModelAndView mv = new ModelAndView("/account/" + name);
		return mv;
	}
	/**
	 * 修改密码
	 * @param oldPassword 原始密码
	 * @param password	新密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/password/change")
	public Object changePassword(String oldPassword, String password) {
		return accountService.updatePassword(oldPassword, password);
	}
	/**
	 * 更新昵称和个性签名
	 * @param nickname
	 * @param sign
	 * @return
	 */
	@RequestMapping("/profile/change")
	public Object changeProfile(String nickname, String sign) {
		accountService.updateProfile(nickname, sign);
		return "redirect:/account/profile";

	}

}
