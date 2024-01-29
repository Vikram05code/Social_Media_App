package com.vikram.service;

import java.util.List;

import com.vikram.models.Chat;
import com.vikram.models.User;

public interface ChatService {
	
	public Chat createChat(User reqUser, User user2);
	
	public Chat findChatById(Integer chatId) throws Exception;
	
	public List<Chat> findUsersChat(Integer userId);
    
}
