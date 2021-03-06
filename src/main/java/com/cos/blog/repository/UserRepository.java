package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cos.blog.model.User;

//DAO
//자동으로 Bean 등록이 된다.
//@Repository  //생략가능하다
public interface UserRepository extends JpaRepository<User,Integer> {

	//JPA Naming 쿼리전력
	//select * from user where username=? and password=?
	User findByUsernameAndPassword(String username, String password);
	
//	@Query(value="select * from user where username=?1 and password=?2",nativeQuery=true)
//	User login(String username, String password);
	
}
