package com.example.demo.webservice.rest.car;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.CarBL;
import com.example.demo.entity.Car;

@RestController
@RequestMapping("/cars")
public class CarResource {
	
	Logger log = LoggerFactory.getLogger(CarResource.class);
	
	@Autowired
	CarBL carBL;
	
	@GetMapping("/searches")
	public List <Car> getCars()  {
		
		List <Car> cars = carBL.findAllCars();
		
		log.info("{} car(s) returned", cars.size());
		
		return cars;
	}
	
	@GetMapping("")
	public Car getCarById(@RequestParam("carId") Long carId) {
		
		Car car = carBL.findCarById(carId);
		
		return car;
	}
	
	@GetMapping("/searchByBrand")
	public List <Car> getCarById(@RequestParam("brand") String brand) {
		
		List <Car> cars = carBL.findCarByBrand(brand);
		
		return cars;
	}
	
	@GetMapping("/searchByYear")
	public List <Car> getCarByYear(@RequestParam("year") String year) {
		
		List <Car> cars = carBL.findCarByYear(year);
		
		return cars;
	}
	
	@PostMapping("")
	public ResponseEntity createCar(@RequestBody Car car) {
				
		try {
			carBL.saveCar(car);
		} catch (Exception e) {
			
			log.error("{} Car cannot be saved", car.getId());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

		}
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@DeleteMapping("")
	public ResponseEntity deleteCarById(@RequestParam("carId") Long carId) {
		
		try {
			carBL.removeCarById(carId);
		} catch (Exception e) {
			
			log.error("{} Car cannot be deleted", carId);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

		}
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
