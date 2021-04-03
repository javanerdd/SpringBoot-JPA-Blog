package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 ->응답(HTML파일)
//@Controller

//사용자가 요정 ->응답(Data)
@RestController
public class HttpControllerTest {
	
	private static final String TAG="HttpControllerTest";
	
	// http://localhost:8000/blog/http/lombok
	@GetMapping("/http/lombok")
	public String lombokTest() {
		
		Member m = Member.builder().username("ss").password("1234").email("111").build();
		System.out.println(TAG+"getter :"+m.getUsername());
		m.setUsername("coo");
		System.out.println(TAG+"setter :"+m.getUsername());
		return "lombok test 완료";
	}
	
	
	//인터넷 브라우저 요청은 무조건 get요청 밖에 할 수 없다
	//http://localhost:8181/http/get
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get요청" +m.getId()+m.getPassword()+m.getUsername()+m.getEmail();
	}
	
}
