package com.zoomcarseller.ZoomCarSeller.Service;


import com.zoomcarseller.ZoomCarSeller.Entity.MyUserDetails;
import com.zoomcarseller.ZoomCarSeller.Entity.User;
import com.zoomcarseller.ZoomCarSeller.Repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private AuthRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findUserByEmail(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found:" + username));

        return user.map(MyUserDetails::new).get();

    }
}
