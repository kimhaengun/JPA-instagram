package com.cos.costagram.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cos.costagram.domain.image.Image;
import com.cos.costagram.domain.image.ImageRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImageService {

	private final ImageRepository imageRepository;
	
	public List<Image> 피드이미지(int principalId){
		//1.principalId로 내가 팔로우하고 있는 사용자를 찾아야함. (1개 이거나 여러명(컬렉션))
		//2.select * from image where userId in (select toUserId from follow where fromUserId=로그인Id);
		return imageRepository.mFeed(principalId);
	}
	
}
