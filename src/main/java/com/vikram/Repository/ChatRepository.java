package com.vikram.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vikram.models.Chat;
import com.vikram.models.User;

public interface ChatRepository extends JpaRepository<Chat, Integer>{

	public List<Chat> findByUsersId(Integer userId);
	
	@Query("select c from Chat c WHERE :user Member of c.users AND :reqUser Member of c.users")
	public Chat findChatByUsersId(@Param("user") User user, @Param("reqUser") User reqUser);
	
	
	
}
