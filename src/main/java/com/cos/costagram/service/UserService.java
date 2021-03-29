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
		
		int followState = followRepository.mFollowState(principalId, userId);
		int followCount = followRepository.mFollowCount(userId);
		
		
		userProfileRespDto.setFollowState(followState==1);
		userProfileRespDto.setFollowCount(followCount);
		userProfileRespDto.setImageCount(userEntity.getImages().size());
		userProfileRespDto.setUser(userEntity);
		
		
		userProfileRespDto.setUser(userEntity);
		return userProfileRespDto;
	}
}
