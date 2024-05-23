package com.iset.sante.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iset.sante.entities.Message;

@Service
public interface ChatService {
	 List<Message> getUserMessages(String username);
		void sendMessage(Long id, String sender, String recipient, String content);
		
		 List<Message> getAllMessages();
		    Message getMessageById(Long id);
		    void sendMessage(Message message);
		    void deleteMessage(Long id);
		    void updateMessage(Long id, String newText);
		    void editMessageByAdmin(Long id, String newText);
		    void deleteMessageByAdmin(Long id);
}
