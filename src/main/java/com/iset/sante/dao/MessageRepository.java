package com.iset.sante.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iset.sante.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySender(String sender);

	List<Message> findByRecipient(String username);

	List<Message> findBySenderAndRecipient(String sender, String recipient);
	
    void deleteById(Long id);
}