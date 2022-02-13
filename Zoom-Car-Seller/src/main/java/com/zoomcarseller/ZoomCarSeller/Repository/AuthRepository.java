package com.zoomcarseller.ZoomCarSeller.Repository;

import com.zoomcarseller.ZoomCarSeller.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByEmail(String email);

    User findUserById(Long userId);

    User findOwnerByEmail(String email);

}
