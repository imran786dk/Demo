package com.example.demo.repository.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Car;


@SuppressWarnings("null")
public interface CarRepository extends JpaRepository<Car, Long> {


	public List<Car> findAll();
	
	public List<Car> findCarByBrand(String brand);
	
	public List<Car> findCarByYear(String year);

}
