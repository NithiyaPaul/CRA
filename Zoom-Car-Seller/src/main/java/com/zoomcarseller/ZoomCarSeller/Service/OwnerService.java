package com.zoomcarseller.ZoomCarSeller.Service;

import com.zoomcarseller.ZoomCarSeller.Entity.Owner;
import com.zoomcarseller.ZoomCarSeller.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository repository;

    public Owner saveOwner(Owner owner) {

        return repository.save(owner);
    }

    public Owner findOwnerById(Long ownerId) {
        return repository.findOwnerById(ownerId);
    }

    public Owner findOwnerByEmail(String email) {
        return repository.findOwnerByEmail(email);
    }

    public List<Owner> listAllOwners(){
        return repository.findAll();
    }
}
