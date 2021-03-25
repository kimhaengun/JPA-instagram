package com.cos.costagram.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.costagram.domain.follow.FollowRepository;
import com.cos.costagram.domain.user.User;
import com.cos.costagram.domain.user.UserRepository;
import com.cos.costagram.web.dto.user.UserProfileRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final FollowRepository followRepository;
	
	@Transactional(readOnly = true)
	public UserProfileRespDto 회원프로필(int userId,int principalId) throws IllegalAccessException {
		UserProfileRespDto userProfileRespDto = new UserProfileRespDto();
		
		User userEntity = userRepository.findById(userId).orElseThrow(()->{
			return new IllegalAccessException();
		});
		
		userProfileRespDto.setFollowState(true);
		userProfileRespDto.setFollowCount(100);
		userProfileRespDto.setImageCount(10);
		
		
		userProfileRespDto.setUser(userEntity);
		return userProfileRespDto;
	}
}
