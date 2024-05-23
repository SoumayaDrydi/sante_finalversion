package com.iset.sante.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.iset.sante.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
