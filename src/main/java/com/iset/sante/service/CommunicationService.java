package com.iset.sante.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iset.sante.entities.Communication;

@Service
public interface CommunicationService {
	Communication saveCommunication(Communication communication);
	  
	   
    List<Communication> getAllCommunications();
    Communication updateCommunication(Communication p); 
	void deleteCommunication(Communication p); 
	void deleteCommunicationById(int id); 
	Communication getCommunication(int id); 
	 
	Communication findById(int id);
}
