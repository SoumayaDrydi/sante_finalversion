package com.iset.sante.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iset.sante.entities.Communication;

public interface CommunicationRepository  extends JpaRepository<Communication,Integer>{

}
