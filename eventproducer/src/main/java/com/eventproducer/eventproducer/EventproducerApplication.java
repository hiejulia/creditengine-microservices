package com.eventproducer.eventproducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableBinding
@RestController
public class EventproducerApplication {

	private final String Queue = "productOrder";
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(EventproducerApplication.class, args);
	}


    /**
     * CREATEORDER
     * @param orderId
     * @param itemId
     * @param userName
     */
	@RequestMapping(method = RequestMethod.POST, value = "/orders/{orderId}")
	public void placeOrder(@PathVariable("orderId") UUID orderId, @RequestParam("itemId") Integer itemId, @RequestParam("userName") String userName) {
		ProductOrder orderObject = createOrder(orderId,itemId,userName);
		rabbitTemplate.convertAndSend(Queue,orderObject);//send the productorder object
	}


	//createOrder
	private ProductOrder createOrder(UUID orderId,Integer itemId, String userName){
		ProductOrder order = new ProductOrder();
		order.setItemId(itemId);
		order.setOrderId(orderId);
		order.setUserName(userName);
		order.setOrderPlacedTime(new Date());
		return order;//return order
	}
}
