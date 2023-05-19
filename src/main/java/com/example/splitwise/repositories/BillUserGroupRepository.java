package com.example.splitwise.repositories;

import com.example.splitwise.entities.BillUserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillUserGroupRepository extends CrudRepository<BillUserGroup, Long> {

    @Query("select bug from BillUserGroup bug where bug.bill.id = :billId")
    List<BillUserGroup> findByBillId(Long billId);

    @Query("select bug from BillUserGroup bug where bug.user.id = :userId and bug.bill.status = :status")
    List<BillUserGroup> findByUserId(Long userId, Byte status);
}
