package com.example.demo;

import java.util.List;

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
	
	@Autowired
	CarBL carBL;
	
	@GetMapping("/searches")
	public List <Car> getCars()  {
		
		List <Car> cars = carBL.findAllCars();
		
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
	
	@PostMapping("")
	public ResponseEntity createCar(@RequestBody Car car) {
				
		try {
			carBL.saveCar(car);
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

		}
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@DeleteMapping("")
	public ResponseEntity deleteCarById(@RequestParam("carId") Long carId) {
		
		try {
			carBL.removeCarById(carId);
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

		}
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
