package com.userservice.demo.repo;


import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.userservice.demo.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * USER DETAIL REPOSITORY
 */

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {

    //FIND BY USERID
    UserDetail findByUserId(String userId);

    //FIND BY SSN


    UserDetail findBySsn(String ssn);
}

