package com.gamze.kafkaDemo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}
	@Bean
	public ApplicationRunner runner(Publisher p){
		return args -> {
			p.sendMessage("Gamze TEST");
		};
	}
}
