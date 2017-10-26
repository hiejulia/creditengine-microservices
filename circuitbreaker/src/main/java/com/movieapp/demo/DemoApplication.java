package com.movieapp.demo;

import com.movieapp.demo.service.ConsumingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableCircuitBreaker
public class DemoApplication {
    @Autowired
    private ConsumingService consumingService;

    @RequestMapping(method = RequestMethod.POST,value = "/book/{movieId}",produces = "application/json")
    public String book ticket(@PathVariable("userId") String userId,@PathVariable("movieId") String movieId){
        return  consumingService.bookAndRespond(userId,movieId);
    }


    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
