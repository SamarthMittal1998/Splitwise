package com.example.splitwise.services;


import com.example.splitwise.dto.BillRequestDto;

/**
 * Created by samarthMittal
 */

public interface BillService {

    void addBill(BillRequestDto billRequestDto);

    void addBillToGroup(BillRequestDto billRequestDto);

    BillRequestDto getBillDetails(Long billId);

}
