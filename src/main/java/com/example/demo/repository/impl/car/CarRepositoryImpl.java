package com.example.demo.repository.impl.car;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Car;
import com.example.demo.repository.car.CarRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public abstract class CarRepositoryImpl implements CarRepository  {
	
	@PersistenceContext
	protected EntityManager em;

	public CarRepositoryImpl() {
		// empty
	}

	@Transactional
	public void create(Car car) {
		em.persist(car);
		em.flush();
		em.refresh(car);
	}

	@Transactional
	public void edit(Car car) {
		em.merge(car);
		em.flush();
	}

	@Transactional
	public void remove(Car car) {
		em.remove(em.merge(car));
	}

	@Override
	public Car findFlush(Object id) {
		em.flush();
		Car entity = find(id);
		em.refresh(entity);
		return entity;
	}

	@Override
	public Car find(Object id) {
		return em.find(Car.class, id);
	}
	
	@Override
	public List<Car> findAll() {
		return em.createQuery("select object(o) from car as o").getResultList();
	}
	
	@Override
	public List<Car> findCarByBrand(String brand) {
		return em.createNativeQuery("select * from car c where c.BRAND =" + brand + "';")
				.getResultList();

	}

}