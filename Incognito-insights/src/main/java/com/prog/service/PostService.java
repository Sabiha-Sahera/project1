package com.prog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entity.Post;
import com.prog.repository.PostRepository;

@Service
public class PostService {

	

    private static PostRepository prepo;
	private PostRepository PostRepository;

    @Autowired
    public PostService(PostRepository prepo) {
        this.prepo = prepo;
    }

    public static List<Post> getAllBlogPosts() {
        return prepo.findAll();
    }

	}
