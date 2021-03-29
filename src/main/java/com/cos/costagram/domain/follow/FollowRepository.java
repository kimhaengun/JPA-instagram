package com.cos.costagram.domain.follow;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FollowRepository extends JpaRepository<Follow, Integer>{
	
	//insert, delete (@Transaction)
	//update(@Modifying)
	
	@Modifying
	@Query(value = "INSERT INTO follow(fromUserId,toUserId,createDate) VALUES(:fromUserId,:toUserId,now())",nativeQuery = true)
	//  : = 변수명 바인딩
	int mFollow(int fromUserId, int toUserId); //prepareStatement updateQuery()

	@Modifying
	@Query(value = "DELETE FROM follow WHERE fromUserId = :fromUserId AND toUserId = :toUserId",nativeQuery = true)
	//  : = 변수명 바인딩
	int mUnFollow(int fromUserId, int toUserId);
	
	@Query(value = "select count(*) from follow where fromUserId = :principalId AND toUserId = :userId", nativeQuery = true)
	int mFollowState(int principalId, int userId);

	@Query(value = "select count(*) from follow where fromUserId = :userId", nativeQuery = true)
	int mFollowCount(int userId);
}
