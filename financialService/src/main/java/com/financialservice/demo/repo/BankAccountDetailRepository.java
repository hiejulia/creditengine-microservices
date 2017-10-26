package com.financialservice.demo.repo;

import com.financialservice.demo.entity.BankAccountDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountDetailRepository extends JpaRepository<BankAccountDetail, Integer> {
    BankAccountDetail findByUserId(String userId);
}
