package com.prog.repository;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.Post;

public interface PostRepository extends JpaRepository<Post,Long>{
	//void save(Post p);


	/*static User findByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}


	static Optional<Post> findById(int postid) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
