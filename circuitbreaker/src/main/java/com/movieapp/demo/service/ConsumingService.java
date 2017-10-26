package com.movieapp.demo.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class ConsumingService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getAnotherCurentlyShowingMovie")
    public String bookAndRespond() {
        URI uri = URI.create("http://<application Ip:port>/bookingapplication/{userId}/{movieId}");

        return this.restTemplate.getForObject(uri, String.class);
    }

    public String getAnotherCurentlyShwoingMovie() {
        return "We are experiencing heavy load on booking of your movie. There are some other movies are running on same time, please check if you are interested in any one. " + getSameShowtimeMovieList() ;
    }

    public String getSameShowtimeMovieList() {
        return "fast and Furious 8, The Wolverine3";
    }
}
