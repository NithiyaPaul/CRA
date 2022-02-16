package com.zoomcarseller.ZoomCarSeller.Controller;

import com.zoomcarseller.ZoomCarSeller.Entity.Owner;
import com.zoomcarseller.ZoomCarSeller.Entity.User;
import com.zoomcarseller.ZoomCarSeller.Service.*;
import com.zoomcarseller.ZoomCarSeller.ValueObject.BookCar;
import com.zoomcarseller.ZoomCarSeller.ValueObject.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private CarService carService;
    @Autowired
    private BookCarService bookCarService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/customers")
    public String listAllCustomers(Model model){
        model.addAttribute("customer",customerService.getAllCustomers());
        return "AdminCustomerPage";
    }

    @PostMapping("/customer")
    public String editCustomerDetail(HttpServletRequest request){
        Customer customer = new Customer();
        customer.setName(request.getParameter("userName"));
        customer.setAddress(request.getParameter("userAddress"));
        customer.setLocation(request.getParameter("userPlace"));
        customer.setPhone_number(request.getParameter("userPhoneNumber"));
        customer.setEmail(request.getParameter("userEmail"));
        customerService.saveCustomer(customer,Long.parseLong(request.getParameter("userId")));
        return "redirect:/customers";

    }

    @RequestMapping("/car-owners")
    public String listAllOwners(Model model){
        System.out.println(ownerService.listAllOwners());
        model.addAttribute("owner",ownerService.listAllOwners());
        return "AdminOwnerPage";
    }

    @PostMapping("/car-owners")
    public String editOwner(HttpServletRequest request){
        Owner owner = ownerService.findOwnerById(Long.parseLong(request.getParameter("ownerId")));
        System.out.println(owner);
        owner.setAddress(request.getParameter("ownerAddress"));
        owner.setEmail(request.getParameter("ownerEmail"));
        owner.setPhone_number(request.getParameter("ownerPhoneNumber"));
        owner.setBusiness_name(request.getParameter("owner_business_name"));
        owner.setContact_name(request.getParameter("ownerName"));
        ownerService.saveOwner(owner);
        return "redirect:/car-owners";
    }

    @RequestMapping("/cars")
    public String listAllCars(Model model){
        model.addAttribute("car",carService.listAllCars());
        return "AdminCarPage";
    }

    @RequestMapping("/booking-history")
    public String listAllBooking(Model model){
        System.out.println(bookCarService.getAllBooking());
        model.addAttribute("booking",bookCarService.getAllBooking());
        return "AdminSearchHistroyPage";
    }

    @RequestMapping("/admin-register")
    public String register(){
        return "AdminRegisterPage";
    }

    @PostMapping("/register")
    public String saveAdmin(HttpServletRequest request,Model model){
        if(!(request.getParameter("password").equals(request.getParameter("confirmPassword")))){
            model.addAttribute("message","Password doesn't match");
            return "AdminRegisterPage";
        }
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setType("ADMIN");
        adminService.saveAdmin(user);
        return "LoginPage";
    }

    @RequestMapping("/update-booking-status/{id}")
    public String updateBookingStatus(@PathVariable Long id,Model model,HttpServletRequest request) {
        BookCar bookCar = bookCarService.getBookingById(id);
        model.addAttribute("status",bookCarService.getBookingById(id));
        return "AdminUpdateStatusPage";
    }

    @PostMapping("/update-booking-status")
    public String updateBookingStatus(HttpServletRequest request){
        BookCar bookCar = new BookCar();
        bookCar.setStatus(Integer.parseInt(request.getParameter("bookingStatus")));
        bookCarService.saveStatus(bookCar,Long.parseLong(request.getParameter("bookingId")));
        return "redirect:/booking-history";
    }
}
