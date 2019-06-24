package com.itshidu.web.service;

import com.itshidu.web.vo.Result;

public interface AccountService {

	Result updatePassword(String oldPassword, String password);

	void updateProfile(String nickname, String sign);

}
