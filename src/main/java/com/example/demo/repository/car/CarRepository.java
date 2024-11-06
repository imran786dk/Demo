package com.example.demo.repository.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Car;

@SuppressWarnings("null")
public interface CarRepository extends JpaRepository<Car, Long> {

	public List<Car> findAll();
	
	public List<Car> findCarByBrand(String brand);
	
	public Car findFlush(Object id);
	
	public Car find(Object id);

}
