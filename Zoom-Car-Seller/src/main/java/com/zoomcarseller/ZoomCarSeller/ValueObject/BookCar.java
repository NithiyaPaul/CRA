package com.zoomcarseller.ZoomCarSeller.ValueObject;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class BookCar {

    private Long id;
    private double total_amount;
    private int status;
    private Long no_of_days;
    private Long owner_id;
}
