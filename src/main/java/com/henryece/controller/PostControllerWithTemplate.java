package com.henryece.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.henryece.repository.PostRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//  todo - create a new class that return string as below to apply thymeleaf
// khi user click vo "click here" tren trang index.html se dieu huong ve /mypost
@RequiredArgsConstructor
@Controller
public class PostControllerWithTemplate {
	@NonNull
	private final PostRepository postRepository;

	@GetMapping("/mypost")
	public String getCurrentPostContent(Model model) {
		model.addAttribute("CurrentPostContent", postRepository.findAll());
		return "posttemplate"; 
	}
}



//

