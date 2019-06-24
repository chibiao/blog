package com.itshidu.web.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
@Entity
@Table(name="blog_user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String username;//用户名
	private String password;//数据库中存密文密码
	private String salt;	//密码盐值，佐料
	private String email;
	private String phone;
	private String sex;		//性别
	private String nickname;	//昵称
	private String sign;		//个性签名
	private String avatar;		//头像
	private Date createTime;	//创建时间
	private int status; //状态
}
