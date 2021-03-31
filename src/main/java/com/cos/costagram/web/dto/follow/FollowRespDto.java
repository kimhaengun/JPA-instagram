package com.cos.costagram.web.dto.follow;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FollowRespDto {
	private int userId;
	private String username;
	private String profileImageUrl;
	private BigInteger followState; //boolean 값은 BigInteger로 받아야한다. /결과 값이 1,0으로 넘어옴.
	private BigInteger equalState;
}
