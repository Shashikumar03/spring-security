package org.example.securiry.serviceImplementation;

import org.example.securiry.entities.User;


import org.example.securiry.exceptions.ApiException;
import org.example.securiry.exceptions.ResourceNotFoundException;
import org.example.securiry.payload.UserDto;
import org.example.securiry.repositries.UserRepositry;
import org.example.securiry.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepositry userRepositry;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDto createUser(UserDto userDto) {



       try {
           User user= this.modelMapper.map(userDto, User.class);

           user.setPassword(passwordEncoder.encode(user.getPassword()));
           User userSaved=  this.userRepositry.save(user);
           return this.modelMapper.map(userSaved,UserDto.class);


       }catch (Exception e){

           throw  new ApiException("email is not unique") ;

       }
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {
        return null;
    }

    @Override
    public UserDto getUserById(Integer userId) {

        User user = this.userRepositry.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

        return this.modelMapper.map(user,UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {

      List<User> users=  userRepositry.findAll();
      List<UserDto> postDtos = users.stream().map((user) -> this.modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public void deleteUser(Integer id) {

    }

}
