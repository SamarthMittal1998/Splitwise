package com.example.splitwise.services;

import com.example.splitwise.dto.UserNetWorthDto;
import com.example.splitwise.dto.UsersAllGangsDto;
import org.springframework.stereotype.Component;

@Component
public interface UserAssetLiabilitiesService {

    UserNetWorthDto getMyNetWorth(Long userId);

    UsersAllGangsDto getMyGroupwiseNetWorth(Long userId);

}
