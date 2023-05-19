package com.example.splitwise.services;

import com.example.splitwise.dto.AssetLiabilitiesDto;
import com.example.splitwise.dto.GroupExpensesDto;
import com.example.splitwise.dto.UserNetWorthDto;
import com.example.splitwise.dto.UsersAllGangsDto;
import com.example.splitwise.entities.BillUserGroup;
import com.example.splitwise.enums.BillStatus;
import com.example.splitwise.repositories.BillUserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAssetLiabilitiesSarviceImpl implements UserAssetLiabilitiesService {

    @Autowired
    private BillUserGroupRepository billUserGroupRepository;

    @Transactional(readOnly = true)
    @Override
    public UserNetWorthDto getMyNetWorth(Long userId) {

        List<AssetLiabilitiesDto> assets = new ArrayList<>();
        List<AssetLiabilitiesDto> liabilities = new ArrayList<>();
        Double netWorth = 0.0;
        List<BillUserGroup> billUserGroupList = billUserGroupRepository.findByUserId(userId, Byte.valueOf(BillStatus.ACTIVE.getId().toString()));
        for (BillUserGroup billUserGroup : billUserGroupList) {

            netWorth = Double.sum(netWorth, billUserGroup.getShare());
            AssetLiabilitiesDto assetLiabilitiesDto = AssetLiabilitiesDto.builder()
                    .billName(billUserGroup.getBill().getName())
                    .share(billUserGroup.getShare())
                    .build();
            if (billUserGroup.getShare() < 0) {
                liabilities.add(assetLiabilitiesDto);
            } else {
                assets.add(assetLiabilitiesDto);
            }
        }

        UserNetWorthDto userNetWorthDto = UserNetWorthDto.builder()
                .assets(assets)
                .liabilities(liabilities)
                .netWorth(netWorth)
                .id(userId)
                .build();
        return userNetWorthDto;
    }

    @Transactional(readOnly = true)
    @Override
    public UsersAllGangsDto getMyGroupwiseNetWorth(Long userId) {

        List<GroupExpensesDto> expensesDtos = new ArrayList<>();
        List<BillUserGroup> billUserGroupList = billUserGroupRepository.findByUserId(userId, Byte.valueOf(BillStatus.ACTIVE.getId().toString()));
        for (BillUserGroup billUserGroup : billUserGroupList) {

            GroupExpensesDto groupExpensesDto = GroupExpensesDto.builder()
                    .groupName(billUserGroup.getBill().getGang().getName())
                    .share(billUserGroup.getShare())
                    .build();
            expensesDtos.add(groupExpensesDto);
        }

        UsersAllGangsDto usersAllGangsDto = UsersAllGangsDto.builder()
                .id(userId)
                .name(billUserGroupList.get(0).getUser().getName())
                .groupExpenses(expensesDtos)
                .build();
        return usersAllGangsDto;
    }
}
