package com.cos.costagram.web;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.costagram.config.auth.PrincipalDetails;
import com.cos.costagram.domain.follow.Follow;
import com.cos.costagram.domain.user.User;
import com.cos.costagram.service.FollowService;
import com.cos.costagram.service.UserService;
import com.cos.costagram.web.dto.CMRespDto;
import com.cos.costagram.web.dto.follow.FollowRespDto;
import com.cos.costagram.web.dto.user.UserProfileRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
	
	private final UserService userService;
	private final FollowService followService;
	
	@GetMapping("/user/{pageUserId}/follow")//data리턴
	public @ResponseBody CMRespDto<?> followList(@AuthenticationPrincipal PrincipalDetails principalDetails,@PathVariable int pageUserId){
		System.out.println("리스트들어옴?");
		List<FollowRespDto> follows = followService.팔로우리스트(principalDetails.getUser().getId(),pageUserId);
		System.out.println(follows);
		return new CMRespDto<>(1,follows);
	}
	
	@GetMapping("/user/{id}")
	public String profile(@PathVariable int id,Model model,@AuthenticationPrincipal PrincipalDetails principalDetails) throws IllegalAccessException {
		UserProfileRespDto userProfileRespDto = userService.회원프로필(id,principalDetails.getUser().getId());
		model.addAttribute("dto",userProfileRespDto);
		return "user/profile";
	}
	
	@GetMapping("/user/{id}/profileSetting")
	public String profileSetting(@PathVariable int id) {
		return "user/profileSetting";
	}
	
	@PutMapping("/user/{id}")
	public @ResponseBody CMRespDto<?> profileUpdate(@PathVariable int id, User user,@AuthenticationPrincipal PrincipalDetails principalDetails){
		User userEntity = userService.회원수정(id,user);
		//변경된 유저정보
		principalDetails.setUser(userEntity);
		return new CMRespDto<>(1,null);
	}
	
}
