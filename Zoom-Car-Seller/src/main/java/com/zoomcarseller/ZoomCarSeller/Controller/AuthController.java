package com.zoomcarseller.ZoomCarSeller.Controller;

import com.zoomcarseller.ZoomCarSeller.Entity.Owner;
import com.zoomcarseller.ZoomCarSeller.Entity.User;
import com.zoomcarseller.ZoomCarSeller.Repository.AuthRepository;
import com.zoomcarseller.ZoomCarSeller.Service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Objects;

@Controller
public class AuthController {
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private CarController controller;
    @Autowired
    private AuthRepository repository;
    @Autowired
    private AdminController adminController;


    @RequestMapping("/login")
    public String index(){
        return "LoginPage";
    }

    @RequestMapping("/partner-portal/dashboard")
    public String dashboard(HttpServletRequest request,Model model){
        return controller.listAllMyRegisteredCars(request,model);
    }

    @PostMapping("/owner-login")
    public String login(HttpServletRequest req,Model model){
        User user = repository.findOwnerByEmail(req.getParameter("email"));
        Owner owner = ownerService.findOwnerByEmail(req.getParameter("email"));
        if(!(Objects.isNull(user))){
            if(user.getPassword().equals(req.getParameter("password")) && user.getType().equals("OWNER")){
                HttpSession session = req.getSession();
                session.setAttribute("businessName",owner.getBusiness_name());
                session.setAttribute("ownerId",String.valueOf(owner.getId()));
                return "redirect:/partner-portal/dashboard";
            } else if(user.getPassword().equals(req.getParameter("password")) && user.getType().equals("ADMIN")){
                return "redirect:/customers";
            }
            else {
                model.addAttribute("message","Invalid Credentials");
                return "redirect:/login";
            }
        }
        else {
            model.addAttribute("message","Invalid Credentials");
            return "redirect:/login";
        }
    }
    @GetMapping("/owner/{id}")
    public Owner findOwnerById(@PathVariable("id") Long ownerId){
        return ownerService.findOwnerById(ownerId);
    }

    @RequestMapping("/profile")
    public String getProfile(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        Long ownerId = Long.parseLong((String) session.getAttribute("ownerId"));
        model.addAttribute("profile",ownerService.findOwnerById(ownerId));
        return "ProfilePage";
    }


}
