package com.car_rental_application.CarRentalApplication.Controller;

import com.car_rental_application.CarRentalApplication.Entity.BookCar;
import com.car_rental_application.CarRentalApplication.Entity.User;
import com.car_rental_application.CarRentalApplication.Service.AuthService;
import com.car_rental_application.CarRentalApplication.Service.BookCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MicroServiceController {

    @Autowired
    BookCarService bookCarService;
    @Autowired
    private AuthService authService;

    @GetMapping("/get-all-booking/{ownerId}")
    public List getAllBookingByOwnerId(@PathVariable Long ownerId){
        return bookCarService.listAllBookingByOwnerId(ownerId);
    }

    @GetMapping("/get-booking-detail/{id}")
    public List getBookingByOwnerId(@PathVariable Long id){
        return bookCarService.getBookingByOwnerId(id);
    }

    @GetMapping("/get-all-customers")
    public List listAllCustomers(){
        return authService.listAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public User getCustomer(@PathVariable Long id){
        return authService.findUserById(id);
    }

    @PostMapping("/customer/{id}")
    public User editCustomer(@PathVariable Long id, @RequestBody User user){
        User user1 = authService.findUserById(id);
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setLocation(user.getLocation());
        user1.setAddress(user.getAddress());
        user1.setPhone_number(user.getPhone_number());
        return authService.saveUser(user1);
    }

    @GetMapping("/booking-history")
    public List listAllBooking(){
        return bookCarService.listAllBooking();
    }

    @GetMapping("/get-booking/{id}")
    public BookCar getBookingById(@PathVariable Long id){
        return bookCarService.findBookingById(id);
    }
}
