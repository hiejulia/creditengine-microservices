package com.userservice.demo.service;


import com.userservice.demo.entity.Address;
import com.userservice.demo.repo.AddressRepository;
import com.userservice.demo.repo.UserDetailRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class AddressService {
    @Resource
    AddressRepository addressRepo;

    @Resource
    UserDetailRepository userRepo;

    //GET ADDRESS BY USER ID
    public Address getAddress(UUID userId) {
        Address returnAddressObject = addressRepo.findByUserId(userId.toString());
        return returnAddressObject;



    }





}
