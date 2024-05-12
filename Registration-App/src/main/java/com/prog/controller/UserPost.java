package com.prog.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prog.entity.Post;
import com.prog.entity.UserDtls;
import com.prog.repository.UserRepository;
import com.prog.service.LoginService;
import com.prog.service.PostService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserPost {
	

	private final PostService postService;
	@Autowired
	private UserRepository repo;
	
   
	
	@Autowired
	public UserPost(PostService postService) {
		this.postService=postService;
	}
	
	@GetMapping("/sabiha")
	public String getPosts(Model model) {
		List<Post> sabiha =PostService.getAllBlogPosts();
		model.addAttribute("Post", sabiha);
		return "sabiha";
	}
	
	
	 @GetMapping("/s1")
	    public String newPostForm(Model model) {
	        model.addAttribute("post", new Post());
	        return "s1";
	 }
	
	 @PostMapping("/s1")
	    public String createPost(@RequestParam("title") String title,
	                             @RequestParam("information") String content,
	                             HttpSession session) {
	        // Retrieve the current user's email from the session
	        String Email = (String) session.getAttribute("Email");

	        // Find the user by email
	        UserDtls user =UserRepository.findByEmail(Email);

	        // Create a new Post object
	        Post newPost = new Post();
	        newPost.setTitle(title);
	        newPost.setInformation(content);
	        newPost.setUserDtls(user); // Associate the post with the user
	      
	        repo.save(newPost);

	        // Redirect to a success page or the user's homepage
	        return "redirect:/s1";
	    }
	   @GetMapping("/createPost")
	    public String displaySearchForm() {
	        return "createPost";
	    }
	   @GetMapping("/display")
	   public String display() {
	        return "display";
	   }

	    @PostMapping("display")
	    public String searchPost(@RequestParam Long postId, Model model) {
	        Optional<Post> postOptional = UserRepository.findById(postId);
	        if (postOptional.isPresent()) { 
	            model.addAttribute("post", postOptional.get());
	            return "display";
	        }
	    
	        
	    return "display";
	    }
	    @GetMapping("/back")
		   public String back() {
		        return "s1";
		   }

}

