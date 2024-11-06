package com.example.demo.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CarBL {
	
	@Autowired
	CarRepository carRepository;

	public List <Car> getAllCar()  {
		
		Iterable<Car> cars = carRepository.findAll();
		
		List <Car> carList = new ArrayList <Car>();
		
		for(Car carObject: cars) {
		
			carList.add(carObject);
		}
		
		return carList;
		
	}
}
