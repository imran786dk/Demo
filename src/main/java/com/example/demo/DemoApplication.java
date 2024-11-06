package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.repository.CarRepository;

@SpringBootApplication
public class DemoApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner applicationRunner(CarRepository carRepository) {
		
		return args -> {
			
//			Car car1 = new Car("BMW", "325i", "1988");
//			
//			carRepository.save(car1);
			
//			carRepository.findById(Long.valueOf(1)).ifPresent(System.out::println);
			
			
		};
		
	}

}
