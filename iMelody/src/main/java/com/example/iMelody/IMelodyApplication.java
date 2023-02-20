package com.example.iMelody;

import com.example.iMelody.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IMelodyApplication implements ApplicationRunner {
	@Autowired
	CustomerRepositoryImpl customerRepositoryNew;

	public static void main(String[] args) {
		SpringApplication.run(IMelodyApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		customerRepositoryNew.getCustomersByOffsetAndLimit(10, 10);
	}
}
