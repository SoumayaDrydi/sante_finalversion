package com.iset.sante.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.iset.sante.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
