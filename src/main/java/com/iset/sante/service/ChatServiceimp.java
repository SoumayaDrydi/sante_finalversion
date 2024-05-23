package com.iset.sante.service;
//ChatServiceImpl.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iset.sante.dao.MessageRepository;
import com.iset.sante.entities.Message;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceimp implements ChatService {

 @Autowired
 private MessageRepository messageRepository;
 private List<Message> messages = new ArrayList<>();

 @Override
 public List<Message> getUserMessages(String username) {
     List<Message> userMessages = new ArrayList<>();
     for (Message message : messages) {
         if (message.getRecipient().equals(username) || message.getSender().equals(username)) {
             userMessages.add(message);
         }
     }
     return userMessages;
 }

 @Override
 public void sendMessage(Long id,String sender, String recipient, String content) {
     Message message = new Message(id,sender, recipient, content);
     messages.add(message);
 }
 @Override
 public List<Message> getAllMessages() {
     return messageRepository.findAll();
 }

 @Override
 public Message getMessageById(Long id) {
     return messageRepository.findById(id).orElse(null);
 }

 @Override
 public void sendMessage(Message message) {
     messageRepository.save(message);
 }

 @Override
 public void deleteMessage(Long id) {
     messageRepository.deleteById(id);
 }

 @Override
 public void updateMessage(Long id, String newText) {
     Message message = messageRepository.findById(id).orElse(null);
     if (message != null) {
         message.setContent(newText);
         messageRepository.save(message);
     }
 }

 @Override
 public void editMessageByAdmin(Long id, String newText) {
     updateMessage(id, newText);
 }

 @Override
 public void deleteMessageByAdmin(Long id) {
     messageRepository.deleteById(id);
 }

 
}