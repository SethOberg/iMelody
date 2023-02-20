package com.example.iMelody;

import com.example.iMelody.models.Customer;
import com.example.iMelody.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IMelodyApplication implements ApplicationRunner {
	@Autowired
	CustomerRepositoryImpl customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(IMelodyApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//customerRepository.getCustomersByOffsetAndLimit(10, 10);
		//Customer customer = new Customer( 0, "Jane", "Doe", "Sweden", "12345", "0709374826", "jane.doe@mail.com");
		//System.out.println(customerRepository.getByName("Astrid", "Gruber"));
		//System.out.println(customerRepository.getById(7));
		//System.out.println(customerRepository.getAll());
		//customerRepository.insert(customer);
	}
}
