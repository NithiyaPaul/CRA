package com.zoomcarseller.ZoomCarSeller.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "car")
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Brand;
    private String Modal;
    @Column(nullable = false, unique = true)
    private String car_number;
    @Column(nullable = false)
    private int no_of_seats;
    private String type;
    private Double rate;
    private String location;
    @OneToOne
    private Owner owner;
    private Boolean active_state;
}
