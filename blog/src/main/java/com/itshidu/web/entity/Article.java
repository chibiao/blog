package com.itshidu.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 帖子,文章
 * @author 迟彪
 *
 */
@Getter@Setter@ToString
@Entity
@Table(name="blog_article")
public class Article {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name="user_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	private User user;  //发帖人
	private String title;	//文章标题
	private Date creatTime;	//发布时间
	private long hits;	//点击率	
	@Column(columnDefinition="TEXT")
	private String content; //文章内容
	@ManyToOne
	@JoinColumn(name="group_id")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Group group;
}
