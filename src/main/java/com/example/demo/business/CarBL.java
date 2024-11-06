package com.example.demo.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Car;
import com.example.demo.repository.car.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarBL {
	
	@Autowired
	CarRepository carRepository;

	public List <Car> findAllCars()  {
		
		Iterable<Car> cars = carRepository.findAll();
		
		List <Car> carList = new ArrayList <Car>();
		
		for(Car carObject: cars) {
		
			carList.add(carObject);
		}
		
		return carList;
		
	}
	
	public Car findCarById(Long id)  {
		
		Optional <Car> car = carRepository.findById(id);
		
		if(car.isPresent()) {
			
			return car.get();
		} else  {
			
			return null;
		}
				
		
	}
	
	public void saveCar(Car car)  {
		
		carRepository.save(car);
						
	}
	
	public void removeCarById(Long id)  {
		
		carRepository.deleteById(id);
						
	}
	
	public List <Car> findCarByBrand(String brand)  {	
		
		List <Car> carList = carRepository.findCarByBrand(brand);
			
		return carList;
		
	}
	
	public List <Car> findCarByYear(String year)  {	
		
		List <Car> carList = carRepository.findCarByYear(year);
			
		return carList;
		
	}
	
}
