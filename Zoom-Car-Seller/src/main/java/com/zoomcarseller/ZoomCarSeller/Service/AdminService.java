package com.zoomcarseller.ZoomCarSeller.Service;

import com.zoomcarseller.ZoomCarSeller.Entity.User;
import com.zoomcarseller.ZoomCarSeller.Repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AuthRepository repository;

    public User saveAdmin(User user){
        return repository.save(user);
    }
}
