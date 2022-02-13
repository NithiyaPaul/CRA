package com.zoomcarseller.ZoomCarSeller.Service;

import com.zoomcarseller.ZoomCarSeller.ValueObject.BookCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BookCarService {
    @Autowired
    private RestTemplate restTemplate;

    public List getAllBooking(Long owner_id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:8080/get-all-booking/{ownerId}", HttpMethod.GET,
                entity, List.class, owner_id).getBody();

    }

    public List getBookingDetailsById(Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:8080/get-booking-detail/{id}", HttpMethod.GET,
                entity, List.class, id).getBody();
    }

    public List getAllBooking(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:8080/booking-history", HttpMethod.GET,
                entity, List.class).getBody();
    }

    public BookCar getBookingById(Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:8080/get-booking/{id}", HttpMethod.GET,
                entity, BookCar.class,id).getBody();
    }
}
