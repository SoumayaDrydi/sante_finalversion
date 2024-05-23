package com.iset.sante.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iset.sante.entities.Activite;

public interface ActiviteRepository  extends JpaRepository<Activite, Integer>  {

}
