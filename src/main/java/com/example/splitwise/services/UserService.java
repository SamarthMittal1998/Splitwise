package com.example.splitwise.services;


import com.example.splitwise.dto.UserNetWorthDto;
import com.example.splitwise.dto.UserRequestDto;
import com.example.splitwise.dto.UserResponseDto;
import com.example.splitwise.entities.User;

import java.util.List;

public interface UserService {

    User addNewUser(UserRequestDto userRequestDto);

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUser(Long userId);

    UserResponseDto getUserByEmailId(String emailId);

}
