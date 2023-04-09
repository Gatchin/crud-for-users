package com.ramesh.fadatare_crud.controllers;

import com.ramesh.fadatare_crud.dto.UserDTO;
import com.ramesh.fadatare_crud.service.UserService;
import com.ramesh.fadatare_crud.exceptions.ResourceNotFoundException;
import com.ramesh.fadatare_crud.exceptions.ResourceNotFoundResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User"
)
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save user in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDTO){
        UserDTO savedUser = userService.createUser(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get User By ID REST API",
            description = "Get User By ID REST API is used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }
    @Operation(
            summary = "Get All Users REST API",
            description = "Get All Users REST API is used to get a all the users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update a particular user in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") @Valid Long id,@RequestBody UserDTO userDTO){
        userDTO.setId(id);
        return new ResponseEntity<>(userService.updateUser(userDTO),HttpStatus.OK);
    }
    @Operation(
            summary = "Delete User REST API",
            description = "Delete User REST API is used to delete a particular user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id")Long id){
        return new ResponseEntity<>("User successfully deleted",HttpStatus.OK);
    }

}
