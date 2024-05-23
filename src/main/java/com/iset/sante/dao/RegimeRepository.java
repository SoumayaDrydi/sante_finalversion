package com.iset.sante.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iset.sante.entities.Regime;
import com.iset.sante.entities.TypeRegime;

public interface RegimeRepository extends JpaRepository<Regime, Integer> {

	List<Regime> findByTyperegime(TypeRegime type);

}
