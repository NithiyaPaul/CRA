package com.zoomcarseller.ZoomCarSeller.ValueObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private BookCar bookCar;
    private Customer customer;
}