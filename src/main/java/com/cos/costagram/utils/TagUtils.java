package com.cos.costagram.utils;

import java.util.ArrayList;
import java.util.List;

import com.cos.costagram.domain.image.Image;
import com.cos.costagram.domain.tag.Tag;

public class TagUtils {

	public static List<Tag> parsingToTagObject(String tags,Image imageEntity){
		String temp[]=tags.split("#");
		List<Tag> list = new ArrayList<>();
		
		//1.파싱할때 0번지에 공백이 들어오기 때문에 시작번지를 1로한다.
		for (int i=1;i<temp.length;i++) {
			Tag tag = Tag.builder()
					.name(temp[i].trim())
					.image(imageEntity)
					.build();
			list.add(tag);
		}
		return list;
		
	}
}
