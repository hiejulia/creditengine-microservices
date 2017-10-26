package com.userservice.demo.repo;


import com.userservice.demo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.Date;


/**
 * ADDRESS REPOSITORY
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {
    //FIND ADDRESS BY USERID
    Address findByUserId(String userId);

    //
}