package com.cos.costagram.domain.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@Column(length = 30, unique = true)
	private String username;
	
	@JsonIgnore //JSON으로 파싱 못하게 막기
	private String password;
	
	private String name; //이름
	private String website; // 자기 홈페이지
	private String bio;//자기 소개
	private String email;
	private String phone;
	private String gender;
	private String profileImage;
	private String provider; // 제공자 Google, Facebook, Naver
	
	private String role; //USER,ADMIN
	
	@CreationTimestamp  //시간이 자동으로 들어감.
	private Timestamp createDate;
}
