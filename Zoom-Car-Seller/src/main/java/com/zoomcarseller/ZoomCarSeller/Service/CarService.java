package com.zoomcarseller.ZoomCarSeller.Service;

import com.zoomcarseller.ZoomCarSeller.Entity.Car;
import com.zoomcarseller.ZoomCarSeller.Entity.Owner;
import com.zoomcarseller.ZoomCarSeller.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository repository;

    public Car saveCare(Car car) {
        return repository.save(car);
    }

    public List<Car> listAllMyRegisteredCars(long ownerId) {
        return repository.listAllMyRegisteredCars(ownerId);
    }

    public Car findCarById(Long id) {
        return repository.findCarById(id);
    }

    public List<Car> findCarsByLocation(String location) {
        return repository.findCarsByLocation(location);
    }

    public List<Car> listAllCars(){
        return repository.findAll();
    }
}
