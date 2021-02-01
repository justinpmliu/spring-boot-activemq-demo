package com.example.springboot.activemq.demo;

import com.example.springboot.activemq.demo.jms.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootActivemqDemoApplication implements CommandLineRunner {

	@Autowired
	private Producer producer;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootActivemqDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 1; i <= 10; i++) {
			producer.sendMessage("msg-" + i);
		}
	}
}
