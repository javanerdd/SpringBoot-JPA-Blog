package com.cos.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class BoardController {

	@GetMapping({"","/"})
	public String index() {
		
		//prefix: /WEB-INF/views/  접두사
		//suffix: .jsp  접미사
		return "index";  
	}

}
