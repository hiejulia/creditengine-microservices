package com.financialservice.demo.repo;

import com.financialservice.demo.entity.ObligationDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObligationRepository extends JpaRepository<ObligationDetails, Integer> {

    ObligationDetails findByUserId(String userId);
}
