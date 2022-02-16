package com.zoomcarseller.ZoomCarSeller.ValueObject;

import com.zoomcarseller.ZoomCarSeller.Entity.Car;
import com.zoomcarseller.ZoomCarSeller.Entity.SearchCar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCar {
    private Long id;
    private double total_amount;
    private int status;
    private Long no_of_days;
    private Long owner_id;
    private Car car;
    private SearchCar searchCar;
}
