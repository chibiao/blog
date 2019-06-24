package com.itshidu.web.entity;

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
@Table(name="blog_group")
public class Group {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;  //板块名称
	private String code;	//板块标记
	private boolean status; //状态(显示,隐藏)
}
