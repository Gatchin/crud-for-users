package com.ramesh.fadatare_crud.service.impl;

import com.ramesh.fadatare_crud.dto.UserDTO;
import com.ramesh.fadatare_crud.entity.User;
import com.ramesh.fadatare_crud.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private ModelMapper modelMapper = new ModelMapper();


    @Test
    void createUser() {
        // Arrange

        UserDTO userDTO = new UserDTO(3L,"sdddq","edwd","ww@mail.com");
        Mockito.when(userRepository.save(modelMapper.map(userDTO,User.class))).thenReturn(modelMapper.map(userDTO,User.class));
        // Act
        UserDTO createdUserDto = userService.createUser(userDTO);
        // Assert
        assertNotNull(createdUserDto);
        assertEquals(userDTO.getFirstName(), createdUserDto.getLastName());
        // TODO you should add more getters of UserDTO

    }

}