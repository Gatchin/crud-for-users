package com.ramesh.fadatare_crud.service;

import com.ramesh.fadatare_crud.dto.UserDTO;
import com.ramesh.fadatare_crud.entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();
    UserDTO updateUser(UserDTO userDTO);
    void deleteUser(Long id);
}
