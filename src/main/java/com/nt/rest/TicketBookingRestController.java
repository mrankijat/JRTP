package com.nt.rest;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/ticket")
public class TicketBookingRestController {
 int  dummyCount=0;
	@GetMapping("/book")
	@HystrixCommand(fallbackMethod = "dummyTicketBook",
	                                         commandProperties = {
	                                        		 @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
	                                        		 @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
	                                                 @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000")  }
	                                        )
	public String bookTicket() {
		System.out.println("TicketBookingRestController.bookTicket()");
		if (new Random().nextInt(10)<8) {
			throw new RuntimeException("Problem in b.logic execution");
		}
		return "Your Ticket is booked successfully";
	}
	
	public String dummyTicketBook(){
		dummyCount++;
		System.out.println("TicketBookingRestController.dummyBookTicket()::"+dummyCount);
		return "Problem accured";
	}
}
