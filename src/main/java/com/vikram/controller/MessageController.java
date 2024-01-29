package com.vikram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.vikram.models.Message;
import com.vikram.models.User;
import com.vikram.service.MessageService;
import com.vikram.service.UserService;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/messages/chat/{chatId}")
	public Message createMessage(@RequestBody Message req, @PathVariable Integer chatId, @RequestHeader("Authorization") String jwt ) throws Exception {
		
		User reqUser = userService.findUserByJwt(jwt);
		
		Message message = messageService.createMessage(reqUser, chatId, req);
		
		return message;
	}
	
	@GetMapping("/api/messages/chat/{chatId}")
	public List<Message> findChatsMessages( @PathVariable Integer chatId, @RequestHeader("Authorization") String jwt ) throws Exception {
		
		User reqUser = userService.findUserByJwt(jwt);
		
		List<Message> messages = messageService.findChatsMessages(chatId);
		
		return messages;
	}
	
	
}
