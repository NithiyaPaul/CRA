package com.zoomcarseller.ZoomCarSeller.Controller;

import com.zoomcarseller.ZoomCarSeller.Service.BookCarService;
import com.zoomcarseller.ZoomCarSeller.ValueObject.BookCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class EnquiryController {
    @Autowired
    private BookCarService bookCarService;
    @Autowired
    private CarController controller;

    @RequestMapping("/my-enquires")
    public String listMyEnquires(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Long ownerId = Long.parseLong((String) session.getAttribute("ownerId"));
        model.addAttribute("history",bookCarService.getAllBooking(ownerId));
        model.addAttribute("userName",controller.getSessionUserName(request));
        return "EnquiryPage";
    }

    @RequestMapping("/my-enquiry/{id}")
    public String getBookingDetailsById(@PathVariable Long id,Model model,HttpServletRequest request){
        model.addAttribute("bookingDetail",bookCarService.getBookingDetailsById(id));
        model.addAttribute("userName",controller.getSessionUserName(request));
        return "EnquiryResponsePage";
    }
}
