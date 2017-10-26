package com.userservice.demo.service;

import com.userservice.demo.entity.Address;
import com.userservice.demo.repo.AddressRepository;
import com.userservice.demo.entity.UserDetail;
import com.userservice.demo.repo.UserDetailRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

/**
 * USER DETAIL SERVICE
 */


@Service
@Transactional
public class UserDetailService {

    @Resource
    AddressRepository addressRepo;

    @Resource
    UserDetailRepository userRepo;

    //SAVE ADDRESS
    public void saveAddress(Address address) {
        addressRepo.save(address);


    }

    //SAVE USER
    public void saveUser(UserDetail userDetail) {
        userRepo.save(userDetail);


    }

    //GET ADD BY USER ID
    public Address getAddress(UUID userId) {
        Address returnAddressObject = addressRepo.findByUserId(userId.toString());
        return returnAddressObject;



    }

    //GET USER DETAIL BY USER ID
    public UserDetail getUser(UUID userId) {
        UserDetail userObjectToRetrun = userRepo.findByUserId(userId.toString());

        return userObjectToRetrun;

    }

    //DELETE USER BY USER ID
    public void deleteUser(UUID userId) {

        Address addressObject = addressRepo.findByUserId(userId.toString());//GET ADDRESS BY USERID
        addressObject.setDeletedOn(new Date());//DELETE ADDRESS WITH THE USERID
        addressRepo.saveAndFlush(addressObject);//SAVE AND FLUSH
        //GER USER DETAIL BY USER ID
        UserDetail userObject = userRepo.findByUserId(userId.toString());
        //DELETE USER DETAIL
        userObject.setDeletedOn(new Date());
        userRepo.saveAndFlush(userObject);//SAVE AND FLUSH



    }
}