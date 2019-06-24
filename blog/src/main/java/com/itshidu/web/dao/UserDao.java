package com.itshidu.web.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.itshidu.web.entity.User;
public interface UserDao extends JpaRepository<User,Long>{
	User findByUsername(String username);

	User findByEmail(String email);

}
