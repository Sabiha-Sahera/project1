package com.prog.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import org.apache.catalina.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="POST")
public class Post {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long postId;
	
	private String title;
	
	@Column(length=1000)
	private String information;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserDtls user; 

		public long getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
	



	

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", information=" + information + "]";
	}

	public void setUserDtls(UserDtls user2) {
		// TODO Auto-generated method stub
		
	}


	
	
	

}
