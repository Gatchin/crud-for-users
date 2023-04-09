package com.ramesh.fadatare_crud.service.impl;

import com.ramesh.fadatare_crud.dto.UserDTO;
import com.ramesh.fadatare_crud.entity.User;
import com.ramesh.fadatare_crud.exceptions.EmailAlreadyExistsException;
import com.ramesh.fadatare_crud.repository.UserRepository;
import com.ramesh.fadatare_crud.service.UserService;
import com.ramesh.fadatare_crud.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());
        if(optionalUser.isPresent())
            throw new EmailAlreadyExistsException("Such email already exists");
        User savedUser = userRepository.save(modelMapper.map(userDTO, User.class));
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));

        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> listOfUsers = userRepository.findAll();
        return listOfUsers.stream().map(element -> modelMapper.map(element, UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User existingUser = userRepository.findById(userDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("user", "id", userDTO.getId()));
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());
        if(optionalUser.isPresent())
            throw new EmailAlreadyExistsException("Such email already exists, you should change it");
        return modelMapper.map(userRepository.save(existingUser), UserDTO.class);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
        userRepository.deleteById(id);
    }


}
