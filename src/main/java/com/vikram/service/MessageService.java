package com.vikram.service;

import java.util.List;

import com.vikram.Repository.MessageRepository;
import com.vikram.models.Chat;
import com.vikram.models.Message;
import com.vikram.models.User;

public interface MessageService {
	

	public Message createMessage(User user, Integer chatId, Message req) throws Exception;
	
	public List<Message> findChatsMessages(Integer chatId) throws Exception;
}
