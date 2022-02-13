package com.zoomcarseller.ZoomCarSeller.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Location;
    private LocalDate start_date;
    private LocalDate end_date;
    @OneToOne
    private User user;
}
