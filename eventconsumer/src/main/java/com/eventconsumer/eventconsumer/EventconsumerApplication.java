package com.eventconsumer.eventconsumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.LinkedList;

@SpringBootApplication
@RabbitListener(queues = "productOrder")
@EnableAutoConfiguration

public class EventconsumerApplication {

    @Bean
    Queue queue() {
        return new Queue("productOrder", false);
    }


    @RabbitHandler
    public void process(@Payload ProductOrder order) {
        StringBuffer SB = new StringBuffer();
        SB.append("New Order Received : \n");
        SB.append("OrderId : " + order.getOrderId());
        SB.append("\nItemId : " + order.getItemId());
        SB.append("\nUserName : " + order.getUserName());
        SB.append("\nDate : " + order.getOrderPlacedTime());
        System.out.println(SB.toString());
    }


    public static void main(String[] args) {
		SpringApplication.run(EventconsumerApplication.class, args);
	}
}
