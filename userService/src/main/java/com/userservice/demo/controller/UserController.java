package com.userservice.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userservice.demo.entity.Address;
import com.userservice.demo.entity.UserDetail;
import com.userservice.demo.repo.UserDetailRepository;
import com.userservice.demo.service.AddressService;
import com.userservice.demo.service.UserDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.annotation.Resource;
import java.util.UUID;

/**
 * USER CONTROLLER
 */
@RestController
@RequestMapping("/PM/user/")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserDetailService userService;

    @Resource
    AddressService addressService;

    @Resource
    ObjectMapper mapper;
    /**
     * Method is responsible for ADD A NEW ADDRESS
     *
     * @param address
     * @param userId
     * @return
     */
    public static final String createUserAddress = "createUserAddress(): ";

    @RequestMapping(method = RequestMethod.POST, value = "{userId}/address", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> createUserAddress(@RequestBody Address address, @PathVariable("userId") UUID userId) {
//        logger.debug(createUserAddress + " Address for user Id " + userId + " is updated as " + address);
        address.setUserId(userId.toString());//add user id to the address class
        userService.saveAddress(address);//userService.saveAddress> address
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Method is responsible for CREATE A NEW USER
     *
     * @param userDetail
     * @param userId
     * @return
     */

    public static final String createUser = "createUser(): ";

    @RequestMapping(method = RequestMethod.POST, value = "users/{userId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> createUser(@RequestBody UserDetail userDetail, @PathVariable("userId") UUID userId) {
        logger.debug(createUser + " creating user with Id " + userId + " and details : " + userDetail);
        userDetail.setUserId(userId.toString());
        userService.saveUser(userDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     *
     * @param userDetail
     * @param userId
     * @return
     */

    public static final String deleteUser = "deleteUser(): ";

    @RequestMapping(method = RequestMethod.DELETE, value = "{userId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") UUID userId) {
        logger.debug(deleteUser + " deleting user with Id " + userId);
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Method is responsible for GETTING USER DETAIL BY USER ID
     *
     * @param userId
     * @return
     */
    public static final String getUser = "getUser(): ";

    @RequestMapping(method = RequestMethod.GET, value = "{userId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<UserDetail> getUser(@PathVariable("userId") UUID userId) {
        logger.debug(getUser + " getting information for userId " + userId);
        UserDetail objectToReturn = userService.getUser(userId);
        if (objectToReturn == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(objectToReturn, HttpStatus.OK);
    }

    /**
     * Method is responsible GETTING ADDRESS BY USER ID
     *
     * @param userId
     * @return
     */
    public static final String getAddress = "getAddress(): ";

    @RequestMapping(method = RequestMethod.GET, value = "{userId}/address", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Address> getAddress(@PathVariable("userId") UUID userId) {
        logger.debug(getAddress + " getting address for user Id: " + userId);
        Address objectToReturn = userService.getAddress(userId);//GET ADD WITH USERSERVICE
        Address returnedAddress = addressService.getAddress(userId);
        if (objectToReturn == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//if null > not found
        else
            return new ResponseEntity<>(objectToReturn, HttpStatus.OK);
    }
}
