package com.cos.costagram.domain.follow;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.costagram.domain.comment.Comment;
import com.cos.costagram.domain.image.Image;
import com.cos.costagram.domain.likes.Likes;
import com.cos.costagram.domain.tag.Tag;
import com.cos.costagram.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
		name="follow",
		uniqueConstraints={
			@UniqueConstraint(
				name = "follow_uk",
				columnNames={"fromUserId","toUserId"}
			)
		}
	)
public class Follow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnoreProperties({"images"})
	@ManyToOne
	@JoinColumn(name = "fromUserId")
	private User fromUser; //~~로부터 / 팔로우 하는사람
	
	@JsonIgnoreProperties({"images"})
	@ManyToOne
	@JoinColumn(name = "toUserId")
	private User toUser; //~를 / 팔로우 당하는 사람
	
	@CreationTimestamp
	private Timestamp createDate;
}
