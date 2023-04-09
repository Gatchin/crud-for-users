package com.ramesh.fadatare_crud.mapper;

import com.ramesh.fadatare_crud.dto.UserDTO;
import com.ramesh.fadatare_crud.entity.User;

public class UserMapper {
    public static UserDTO mapToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setId(user.getId());
        userDTO.setLastName(user.getLastName());
        return userDTO;
    }
    public static User mapToUser(UserDTO userDTO){
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setId(userDTO.getId());
        user.setLastName(userDTO.getLastName());
        return user;
    }
}
