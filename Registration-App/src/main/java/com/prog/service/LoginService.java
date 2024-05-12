package com.prog.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entity.UserDtls;
import com.prog.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository repo;
	
	public UserDtls login(String email,String password) {
		UserDtls user=repo.findByEmailAndPassword(email, password);
		return user;
		
	}

	public static User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
