package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.CarBL;
import com.example.demo.entity.Car;

@RestController
public class CarResource {
	
	@Autowired
	CarBL carBL;
	
	@GetMapping("/cars")
	public List <Car> getCar()  {
		
		List <Car> cars = carBL.getAllCar();
		
		return cars;
	}

}
