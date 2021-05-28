package com.example.bugtrackerconsumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class BugTrackerConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackerConsumerApplication.class, args);
	}

}
