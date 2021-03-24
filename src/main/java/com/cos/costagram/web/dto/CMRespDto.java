package com.cos.costagram.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CMRespDto<T> {
	private int statusCode;
	private T data;
}
