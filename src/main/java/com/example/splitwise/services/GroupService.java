package com.example.splitwise.services;


import com.example.splitwise.dto.GroupRequestDto;
import com.example.splitwise.dto.GroupResponseDto;

import java.util.List;

/**
 * Created by samarth
 */
public interface GroupService {

    GroupResponseDto addNewGroup(GroupRequestDto groupRequestDto);

    List<GroupResponseDto> getAllGroups();

    void addUserToGroup(GroupRequestDto groupRequestDto);
}
