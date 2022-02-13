package com.zoomcarseller.ZoomCarSeller.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "book_car")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @OneToOne
    private User user;
    @OneToOne
    private SearchCar searchCar;
    private double total_amount;
    private int status;
    private Long no_of_days;
    @OneToOne
    private Car car;
}
