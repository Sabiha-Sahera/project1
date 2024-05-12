package com.prog.repository;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.Post;
import com.prog.entity.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls,Integer>{
	UserDtls findByEmailAndPassword(String email,String password);

	
	Post save(Post p);


	static UserDtls findByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}


	static Optional<Post> findById(long PostId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	
	

}
