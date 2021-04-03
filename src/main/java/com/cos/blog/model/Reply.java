package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reply { //답변테이블
	
	@Id //primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다
	private int id;
	
	@Column(nullable=false,length=200)
	private String content;
	
	@ManyToOne //여러개의 답변(reply)는 하나의 게시글에 존재
	@JoinColumn(name="boardId")
	private Board board;  //어느 테이블 댓글인지
	
	@ManyToOne //여러개의 답변은 하나의 user가 쓸 수 있다.
	@JoinColumn(name="userId")
	private User user;
	
	@CreationTimestamp
	private Timestamp createDate;
}
