package com.iset.sante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.iset.sante.dao.CommunicationRepository;
import com.iset.sante.entities.Communication;


@Service
public class CommunicationServiceImp  implements  CommunicationService{

	@Autowired
    private CommunicationRepository communicationRepository;
	@Override
	public  Communication saveCommunication( Communication communication) {
		return communicationRepository.save(communication);
	}

   
    @Override
    public List<Communication> getAllCommunications() {
        return communicationRepository.findAll();
    }
    @Override
	public Communication updateCommunication(Communication p) { 
	 return communicationRepository.save(p); 
	 } 
	@Override
	public void deleteCommunication(Communication p) { 
		communicationRepository.delete(p); 
	 
	 } 
	@Override
	public void deleteCommunicationById(int id) { 
		communicationRepository.deleteById(id);}

	@Override
	public Communication getCommunication(int id) { 
	 return communicationRepository.findById(id).get(); 
	 } 
	 @Override
	    public Communication findById(int id) {
	        return communicationRepository.findById(id).orElse(null);
	    }

  
}
