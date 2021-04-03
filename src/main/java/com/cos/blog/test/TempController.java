package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {

	//http://localhost:8000/blog/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("temphome");
		
		//파일 리턴 경로: src/main.resources/static
		//리턴명: /home.html
		//풀경로 :src/main/resources/static/home.html
		return "home.html";
	}
	
	@GetMapping("/temp/img")
	public String tempImg() {
		return "/pang02.jpg";
	}
	
	@GetMapping("/temp/jsp")
	public String jsp() {
		
		// prefix:/WEB-INF/views/
		// suffix:.jsp
		return "/test";
	}
}
