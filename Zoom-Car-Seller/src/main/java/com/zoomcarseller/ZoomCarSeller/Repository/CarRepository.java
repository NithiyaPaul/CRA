package com.zoomcarseller.ZoomCarSeller.Repository;

import com.zoomcarseller.ZoomCarSeller.Entity.Car;
import com.zoomcarseller.ZoomCarSeller.Entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long>{
    @Query("SELECT car FROM Car car WHERE car.owner.id = :id")
    List<Car> listAllMyRegisteredCars(@Param("id") Long Id);

    Car findCarById(Long id);

    @Query("SELECT car FROM Car car WHERE car.location = :location AND car.active_state = false")
    List<Car> findCarsByLocation(@Param("location") String location);
}
