package com.itshidu.web.service.impl;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.itshidu.web.dao.UserDao;
import com.itshidu.web.entity.User;
import com.itshidu.web.service.AccountService;
import com.itshidu.web.util.DigestHelper;
import com.itshidu.web.vo.Result;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired UserDao userDao;
	@Override
	public Result updatePassword(String oldPassword, String password) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginInfo");
		User user = userDao.findByUsername(loginUser.getUsername());
		String m = oldPassword;		//明文密码
		String s = user.getSalt(); 	//密码盐值
		String r = DigestHelper.md5( DigestHelper.sha512(m)+DigestHelper.md5(s)+DigestHelper.sha512(m+s) );
		if(r.equals(user.getPassword())) {
			user.setSalt(UUID.randomUUID().toString());//改个新的盐，更加安全，不改也可以
			String m1 = password;
			String s1 = user.getSalt();
			String r1 = DigestHelper.md5( DigestHelper.sha512(m1)+DigestHelper.md5(s1)+DigestHelper.sha512(m1+s1) );
			user.setPassword(r1);
			userDao.save(user);
			return Result.of(200);
		}else {
			return Result.of(300);
		}
	}
	@Override
	public void updateProfile(String nickname, String sign) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginInfo");
		loginUser.setNickname(nickname);
		loginUser.setSign(sign);
		userDao.save(loginUser);
		session.setAttribute("loginInfo", loginUser);
	}

}
