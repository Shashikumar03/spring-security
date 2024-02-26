package org.example.securiry.controller;

import org.example.securiry.payload.UserDto;
import org.example.securiry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserDto> getUser(@Validated  @RequestBody UserDto userDto){

       UserDto createUserDto= this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }
    public  String getCurrentUserLogger(Principal principal){
        return principal.getName();

    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId) {

        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
    @GetMapping("/allUser")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        ;
      return  ResponseEntity.ok(this.userService.getAllUsers())   ;
    }
}
