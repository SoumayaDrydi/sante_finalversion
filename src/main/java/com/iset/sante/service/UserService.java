package com.iset.sante.service;



import java.util.List;

import com.iset.sante.dto.UserDto;
import com.iset.sante.entities.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
