package com.zoomcarseller.ZoomCarSeller.Controller;

import com.zoomcarseller.ZoomCarSeller.Entity.Car;
import com.zoomcarseller.ZoomCarSeller.Entity.Owner;
import com.zoomcarseller.ZoomCarSeller.Service.CarService;
import com.zoomcarseller.ZoomCarSeller.Service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private OwnerService ownerService;


    @PostMapping("/add-car")
    public String saveCare(HttpServletRequest request){
        HttpSession session = request.getSession();
        Car car = new Car();
        car.setCar_number(request.getParameter("car_number"));
        car.setBrand(request.getParameter("company"));
        car.setModal(request.getParameter("modal"));
        car.setNo_of_seats(Integer.parseInt(request.getParameter("no_of_seats")));
        car.setType(request.getParameter("fuel_type"));
        car.setLocation(request.getParameter("location"));
        Long ownerId = Long.parseLong((String) session.getAttribute("ownerId"));
        Owner owner = ownerService.findOwnerById(ownerId);
        car.setOwner(owner);

        if(Integer.parseInt(request.getParameter("no_of_seats")) <=5){
            if(request.getParameter("fuel_type").equals("petrol")){
                car.setRate(350.0);
            } else {
                car.setRate(450.0);
            }
        } else {
            if(request.getParameter("fuel_type").equals("diesel")){
                car.setRate(600.0);
            } else {
                car.setRate(800.0);
            }
        }
        carService.saveCare(car);
        return "redirect:/car/";
    }
    @RequestMapping("/")
    public String listAllMyRegisteredCars(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        Long ownerId = Long.parseLong((String) session.getAttribute("ownerId"));
        Owner owner = ownerService.findOwnerById(ownerId);
        model.addAttribute("carList",carService.listAllMyRegisteredCars(owner.getId()));
        model.addAttribute("userName",getSessionUserName(request));
        return "MyCarPage";
    }

    @RequestMapping("/edit-car/{id}")
    public String editCarPage(@PathVariable Long id,Model model,HttpServletRequest request) {
        model.addAttribute("car",carService.findCarById(id));
        model.addAttribute("userName",getSessionUserName(request));
        return "EditCarDetails";
    }

    @PostMapping("/edit-car")
    public String editCar(HttpServletRequest request) {
        Car car = carService.findCarById(Long.parseLong(request.getParameter("carId")));
        car.setCar_number(request.getParameter("car_number"));
        car.setBrand(request.getParameter("company"));
        car.setModal(request.getParameter("modal"));
        car.setNo_of_seats(Integer.parseInt(request.getParameter("no_of_seats")));
        car.setType(request.getParameter("fuel_type"));
        car.setLocation(request.getParameter("location"));
        if(Integer.parseInt(request.getParameter("no_of_seats")) <=5){
            if(request.getParameter("fuel_type").equals("petrol")){
                car.setRate(350.0);
            } else {
                car.setRate(450.0);
            }
        } else {
            if(request.getParameter("fuel_type").equals("diesel")){
                car.setRate(600.0);
            } else {
                car.setRate(800.0);
            }
        }
        carService.saveCare(car);
        return "redirect:/car/";
    }

    public String getSessionUserName(HttpServletRequest request){
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("businessName");
        return userName;
    }

    public Long getSessionUserId(HttpServletRequest request){
        HttpSession session = request.getSession();
        Long userId = Long.parseLong((String) session.getAttribute("userId"));
        return userId;
    }
}
