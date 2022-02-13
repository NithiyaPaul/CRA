package com.zoomcarseller.ZoomCarSeller.Controller;

import com.zoomcarseller.ZoomCarSeller.Entity.Car;
import com.zoomcarseller.ZoomCarSeller.Entity.Owner;
import com.zoomcarseller.ZoomCarSeller.Service.CarService;
import com.zoomcarseller.ZoomCarSeller.Service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MicroServiceController {
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private CarService carService;

    @PostMapping("/join-as-partner/register")
    public Owner saveOwner(@RequestBody Owner owner) {
        return ownerService.saveOwner(owner);
    }

    @GetMapping("/get-all-cars/{location}")
    public List findCarsByLocation(@PathVariable String location) {
        return carService.findCarsByLocation(location);
    }

    @GetMapping("/get-car/{id}")
    public Car findCarById(@PathVariable Long id){
        return carService.findCarById(id);
    }
}

