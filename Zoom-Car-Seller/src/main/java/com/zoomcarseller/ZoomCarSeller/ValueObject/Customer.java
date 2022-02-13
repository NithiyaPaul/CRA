package com.zoomcarseller.ZoomCarSeller.ValueObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private String address;
    private String location;
    private String type;
}
