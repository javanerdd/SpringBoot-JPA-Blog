package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//ORM->Java(다른언어 포함) Object-> 테이블로 매핑해주는 기술
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더 패턴
@DynamicInsert //insert시 null인 필드를 제외시켜준다.
@Entity //User 클래스가 자동으로 Mysql에 테이블이 생성이 된다.
public class User {
	
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //프로젝트에서 연결된 db의 넘버링 전략을 따라간다.
	private int id; // 스퀀스 auto_increment , 비워놓아도 자동입력됨
	
	@Column(nullable=false, length=30,unique=true) //null이 들어갈수 없고, 30줄
	private String username; //아이디
	
	@Column(nullable=false,length=100) // 해쉬(비밀번호암호화)할거기 때문에 100자로 넉넉하게
	private String password;
	
	@Column(nullable=false,length=50)
	private String email;
	
//	@ColumnDefault("'user'")
	//DB는 RoleType이라는것이 없다	
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum을 쓰는게 좋다. // ADMIN,USER
	
	@CreationTimestamp // 시간이 자동 입력 , 비워놓아도 자동입력
	private Timestamp createDate;
	
	
}
