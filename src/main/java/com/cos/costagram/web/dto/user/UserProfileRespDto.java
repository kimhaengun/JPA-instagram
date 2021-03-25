package com.cos.costagram.web.dto.user;

import com.cos.costagram.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfileRespDto {
	private boolean followState;
	private int followCount; //구독된 유저 수
	private int imageCount; //게시물 수
	private User user;
	
}
