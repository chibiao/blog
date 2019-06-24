package com.itshidu.web.service.impl;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.itshidu.web.dao.UserDao;
import com.itshidu.web.entity.User;
import com.itshidu.web.service.RegisterService;
import com.itshidu.web.util.DigestHelper;
import com.itshidu.web.vo.Result;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private UserDao userDao;

	@Override
	public Map<String, Object> register(User user) {
		User t = userDao.findByUsername(user.getUsername());
		if (t != null) {
			return Result.of(100, "用户名已经存在，请更换");
		}
		if (userDao.findByEmail(user.getEmail()) != null) {
			return Result.of(101, "邮箱已经存在，请更换");
		}
		user.setAvatar("default.jpg");
		user.setCreateTime(new Date());
		user.setStatus(0); // 设置状态为未激活
		// 对明文密码进行加密
		user.setSalt(UUID.randomUUID().toString());
		String m = user.getPassword();
		String s = user.getSalt();
		String r = md5(sha512(m) + md5(s) + sha512(m + s));
		user.setPassword(r);
		userDao.save(user);
		return Result.of(200, "注册成功");
	}

	private String md5(String text) {
		return DigestHelper.md5(text);
	}

	private String sha512(String text) {
		return DigestHelper.sha512(text);
	}

	@Override
	public Result login(String username, String password) {
		User user = userDao.findByUsername(username);
		if (user == null) {
			return Result.of(100, "用户名不存在");
		}
		if (user.getStatus() == 0) {
			return Result.of(100, "账号未激活，请在邮箱中激活账号");
		}
		if (user.getStatus() == 2) {
			return Result.of(100, "账号被封禁，请联系工作人员");
		}
		String m = password; // 明文密码
		String s = user.getSalt(); // 密码盐值
		String r = md5(sha512(m) + md5(s) + sha512(m + s));
		if (r.equals(user.getPassword())) {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("loginInfo", user);
			return Result.of(200, "登录成功");
		}
		return Result.of(100, "密码不正确");
	}

}
