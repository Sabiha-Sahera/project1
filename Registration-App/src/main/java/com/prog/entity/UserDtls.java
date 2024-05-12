package com.prog.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "USER_DTLS")
public class UserDtls {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name ="Name")
	
	private String fullname;
	private String gender;
	private String dob;
	private String address;
	private String email;
	private String password;
		
	
	
	
	
	
	public UserDtls(int id, String fullname, String email, String password) {
		
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserDtls() {
		
	}
	
	
	@Override
	public String toString() {
		return "UserDtls [id=" + id + ", fullname=" + fullname + ", gender=" + gender + ", dob=" + dob + ", address="
				+ address + ", email=" + email + ", password=" + password + "]";
	}
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	private List<Post> posts =new ArrayList<>();
	
	
	
	
	
	

}
