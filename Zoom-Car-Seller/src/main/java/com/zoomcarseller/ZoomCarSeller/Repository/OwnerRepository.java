package com.zoomcarseller.ZoomCarSeller.Repository;

import com.zoomcarseller.ZoomCarSeller.Entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {
    Owner findOwnerById(Long ownerId);
    Owner findOwnerByEmail(String email);
}
